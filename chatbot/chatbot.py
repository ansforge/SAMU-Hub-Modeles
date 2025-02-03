from slack_bolt import App
from slack_bolt.adapter.socket_mode import SocketModeHandler

from langchain_chroma import Chroma

from langchain_openai import OpenAIEmbeddings
from langchain_text_splitters import RecursiveCharacterTextSplitter

from langchain_community.document_loaders import PyPDFLoader

from langchain.chains import create_retrieval_chain
from langchain.chains.combine_documents import create_stuff_documents_chain
from langchain_core.prompts import ChatPromptTemplate

import os
from dotenv import load_dotenv


from langchain_openai import ChatOpenAI

llm = ChatOpenAI(model="gpt-4o", api_key=os.getenv("OPENAI_API_KEY"), temperature=0)

load_dotenv()
app_token =  os.getenv("SLACK_APP_TOKEN")
bot_token = os.getenv("SLACK_BOT_TOKEN")


DSF = (
    "https://hub.esante.gouv.fr/resources/Accompagnement/DSF/24.10.23_Hub%20Sante_Dossier%20des%20Specifications.pdf"
)
DST = (
    "https://hub.esante.gouv.fr/resources/Accompagnement/tech/23.09%20DST%20v1.2%20-%20Hub%20Sante%20&%20connecteurs.pdf"
)


loader1 = PyPDFLoader(DSF)
doc1 = loader1.load()

loader2 = PyPDFLoader(DST)
doc2 = loader2.load()

docs = doc1 + doc2
print("Documents loaded")

text_splitter = RecursiveCharacterTextSplitter(chunk_size=3000, chunk_overlap=500)
splits = text_splitter.split_documents(docs)
vectorstore = Chroma.from_documents(documents=splits, embedding=OpenAIEmbeddings(model="text-embedding-3-large"))
retriever = vectorstore.as_retriever(search_type="similarity", search_kwargs={"k": 6})
print("Documents stored")


system_prompt = (
    "Tu es un assistant qui répond à des questions posées par les éditeurs souhaitant se raccorder à notre plateforme (le Hub Santé). "
    "Utilise les éléments suivants pour répondre à la question de la manière la plus exhaustive, précise et concise possible. "
    "L'objectif est d'aider à comprendre la documentation. "
    "Si tu ne sais pas, dis-le. "
    "\n\n"
    "{context}"
)

prompt = ChatPromptTemplate.from_messages(
    [
        ("system", system_prompt),
        ("human", "{input}"),
    ]
)

question_answer_chain = create_stuff_documents_chain(llm, prompt)
rag_chain = create_retrieval_chain(retriever, question_answer_chain)
print("RAG created")


app = App(token = bot_token)

@app.event("app_mention")
def answer_question(event, say):
    # Retreive the message without the chatbot mention
    message = event['text'].replace("<@U089QKJ74HM>", "")
    print("Chatbot called", message)
    
    response = rag_chain.invoke({"input": message})
    print("RAG result", response)

    # Extract sources and page numbers
    source_pages = {}
    for doc in response["context"]:
        source = doc.metadata.get("source")
        page = doc.metadata.get("page")
        if source and page:
            if source not in source_pages:
                source_pages[source] = set()
            source_pages[source].add(page)
    
    # Add formatted sources to the answer
    answer_with_sources = response["answer"]
    if source_pages:
        answer_with_sources += "\n\n_Sources_ :\n"
        for source in source_pages:
            source_name = "DSF" if source == DSF else "DST"
            page_links = [f"<{source}#page={page + 1}|{page + 1}>" for page in sorted(source_pages[source])]
            answer_with_sources += f"• {source_name} : pages {', '.join(page_links)}\n"
    
    say(answer_with_sources)
    print("Chatbot answered", answer_with_sources)

 
if __name__ == '__main__':
    handler = SocketModeHandler(app, app_token)
    handler.start()
    print("Chatbot started")
