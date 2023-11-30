import os
import pandas as pd
import datetime
import docx
from xhtml2pdf import pisa


#___UTILS___
# treat empty datetime
def to_string_custom(date_in):
    if date_in :
        date_string = date_in.strftime('%d-%m-%Y')
    else:
        date_string = "Non renseignée"
    return date_string


#___EXPORT___

# export .csv from a dataframe and some params
# key needed for param object
# - ["nomenclature_ref"]
# - ["nomenclature_name"]
# - ["docs"]
# - ["redacteur"]
# - ["date_validation"]
# - ["date_expiration"]
# - ["levels"]
def export_csv_nomenclature(params_in, df_nomenclature_in, release="v1.1", folder_output="out") :
    df_export = df_nomenclature_in.copy()
    df_export.rename(columns={"Code": "code", "Description": "description", "Commentaire" : "commentaire"}, inplace=True)
    for level in range(1,params_in["levels"] + 1) :
        df_export.rename(columns={"Libellé niveau " + str(level): "label_n" + str(level)}, inplace=True)
    # release is not taken into account for Excel
    file_out = params_in["nomenclature_ref"] + "-" +  params_in["nomenclature_name"] + ".csv"
    path_out = os.path.join(folder_output,"release_" + release)
    # create dir if not exist
    try :
        os.mkdir(path_out)
        print("Creating folder " + path_out + " ...")
    except FileExistsError :
        pass
    try :
        os.mkdir(os.path.join(path_out,"csv"))
        print("Creating folder " + str(os.path.join(path_out,"csv")) + " ...")
    except FileExistsError :
        pass
    # export
    df_export.to_csv(os.path.join(path_out,"csv",file_out),
        sep=";",na_rep="",encoding="utf-8", index = False)
    return

def export_html_nomenclature(params_in, df_nomenclature_in, release="v1.1", folder_output="out"):
    df_export = df_nomenclature_in.copy()
    html_start = f"""
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        """
    html_style = """
    <style>.dataframe 
    th{
        background: linear-gradient(71deg, rgb(20, 0, 94) 0%, rgb(25, 18, 126) 100%);
        padding: 10px;
        font-family: Arial;
        color: #ffffff;
        border:1px;
        text-align:left !important;
        margin-top:1px;
        margin-bottom:1px;
        padding-top:1px;
        padding-bottom:1px;
        }
    td{
        border:1px;
        font-family: Arial;
        margin-top:1px;
        margin-bottom:1px;
        margin-left:2px;
        padding-top:2px;
        padding-bottom:1px;
    }
    </style>
    </head>
    <body>
    """
    html_end = """</body>"""
    html_corps = df_export.to_html(index=False,na_rep="")

    # concatenate html parts
    html = html_start + html_style + html_corps + html_end

    file_out = params_in["nomenclature_ref"] + "-" +  params_in["nomenclature_name"] + "-" + release + ".pdf"
    path_out = os.path.join(folder_output,"release_" + release)
    # create dir if not exist
    try :
        os.mkdir(path_out)
        print("Creating folder " + path_out + " ...")
    except FileExistsError :
        pass
    try :
        os.mkdir(os.path.join(path_out,"pdf"))
        print("Creating folder " + str(os.path.join(path_out,"pdf")) + " ...")
    except FileExistsError :
        pass
    #export
    # open output file for writing (truncated binary)
    pdf_file = open(os.path.join(path_out,"pdf",file_out), "w+b")
    # convert HTML to PDF
    pisa_status = pisa.CreatePDF(
            html,               # the HTML to convert
            dest=pdf_file)     # file handle to recieve result
    # close output file
    pdf_file.close()
    return

# transform df dataframe to a doc objet
def df_nomenclature_to_doc(params_in, df_nomenclature_in, doc=None, style='Medium Shading 1 Accent 1'):
    if doc is None:
        doc = docx.Document()

    # Add header
    doc.add_heading(params_in["nomenclature_ref"] + "-" + params_in["nomenclature_name"], level=1)
    doc.add_paragraph()

    # Add table
    table_date = doc.add_table(rows=2, cols=2, style=style)

    # table data
    table_date.rows[0].cells[0].text = "Date de validation"
    table_date.rows[1].cells[0].text = to_string_custom(params_in["date_validation"])
    
    table_date.rows[0].cells[1].text = "Date d'expiration"
    table_date.rows[1].cells[1].text = to_string_custom(params_in["date_expiration"])

    # table style
    table_date.rows[1].cells[0].paragraphs[0].runs[0].font.bold = True
    table_date.rows[1].cells[1].paragraphs[0].runs[0].font.bold = True

    doc.add_paragraph()
    doc.add_paragraph("Rédacteur(s) : " + params_in["redacteur"])
    doc.add_paragraph("Description : " + params_in["nomenclature_description"])

    # Add paragraph
    # doc.add_paragraph('This table represents the fields and types defined in the JSON schema.')

    n_cols_tot = df_nomenclature_in.shape[1]
    # extra row is so we can add the header row
    table = doc.add_table(df_nomenclature_in.shape[0]+1, cols=n_cols_tot, style=style)

    # add the header rows.
    for j in range(df_nomenclature_in.shape[-1]):
        table.cell(0,j).text = df_nomenclature_in.columns[j]

    # add the rest of the data frame
    for i in range(df_nomenclature_in.shape[0]):
        for j in range(df_nomenclature_in.shape[-1]):
            table.cell(i+1,j).text = str(df_nomenclature_in.fillna("").values[i,j])

    # Specify the column widths (has to be on cells for Word) | Ref.: https://stackoverflow.com/a/43053996
    table.autofit = False
    table.allow_autofit = False
    #column_widths = (3, 3.5, 2, 2.5, 8, 3)  # Widths in centimeters
    #set_col_widths(table, column_widths)

    return doc

# export .pdf and .docx
def export_docx_nomenclature(params_in, df_nomenclature_in, release="v1.1", folder_output="out") :
    path_out = os.path.join(folder_output,"release_" + release)

    #generate docx
    doc_export = df_nomenclature_to_doc(params_in, df_nomenclature_in)
    
    # .docx
    # create dir if not exist
    file_out_docx = params_in["nomenclature_ref"] + "-" +  params_in["nomenclature_name"] + "-" + release + ".docx"
    
    try :
        os.mkdir(path_out)
        print("Creating folder " + path_out + " ...")
    except FileExistsError :
        pass
    try :
        os.mkdir(os.path.join(path_out,"word"))
        print("Creating folder " + str(os.path.join(path_out,"word")) + " ...")
    except FileExistsError :
        pass
    # export
    doc_export.save(os.path.join(path_out,"word",file_out_docx))
    return


# transform sommaire dataframe to a doc
def df_sommaire_to_doc(df_sommaire_in, doc=None, style='Medium Shading 1 Accent 1', release="v1.1", folder_output="out"):
    if doc is None:
        doc = docx.Document()

    # Add header
    doc.add_heading("Nomenclature Hub Santé", level=1)
    doc.add_heading("N° de version " + release, level=2)
    doc.add_paragraph()
    
    df_sommaire_in.rename(columns={"nomenclature_name": "Nomenclature", 
                                   "file_name": "Nom de fichier",
                                   "referentiel" : "Référentiel d'origine de la norme"}, inplace=True)

    table = doc.add_table(df_sommaire_in.shape[0]+1, cols=df_sommaire_in.shape[1], style=style)

    # add the header rows.
    for j in range(df_sommaire_in.shape[-1]):
        table.cell(0,j).text = df_sommaire_in.columns[j]

    # add the rest of the data frame
    for i in range(df_sommaire_in.shape[0]):
        for j in range(df_sommaire_in.shape[-1]):
            table.cell(i+1,j).text = str(df_sommaire_in.fillna("").values[i,j])
    
    return doc

def export_sommaire(df_sommaire_in, release="v1.1", folder_output="out") :
    path_out = os.path.join(folder_output,"release_" + release)
    #generate docx
    doc_export = df_sommaire_to_doc(df_sommaire_in, release=release)

    # .docx
    file_out_docx = "Sommaire Nomenclature Hub" + "-" + release + ".docx"

    # export
    doc_export.save(os.path.join(path_out,file_out_docx))
    return


#___PARSING SHEET___
def parse_sheet(filename_in, sheet_name_in) :
    # reading 6 first rows to get params
    df_params = pd.read_excel(filename_in, sheet_name=sheet_name_in, 
                              nrows=8, header=None, index_col=0, 
                              dtype={"levels": int, "date_validation": datetime, "date_expiration": datetime})
    df_params.fillna("",inplace=True)
    params = {}
    params["nomenclature_ref"] = df_params.iloc[0][1]
    params["nomenclature_name"] = df_params.iloc[1][1]
    params["docs"] = df_params.iloc[2][1]
    params["redacteur"] = df_params.iloc[3][1]
    params["date_validation"] = df_params.iloc[4][1]
    params["date_expiration"] = df_params.iloc[5][1]
    params["levels"] = df_params.iloc[6][1]
    # parsing levels as int
    try :
        params["levels"] = int(params["levels"])
    except ValueError :
        print("Field 'Nombre de niveau' shall be an integer")
        raise
    params["nomenclature_description"] = df_params.iloc[7][1]
    #print(params)
    # skipping six first rows
    df_nomenclature = pd.read_excel(filename_in, sheet_name=sheet_name_in, skiprows=8)
    # checking levels
    for level in range(1,params["levels"] + 1) :
        if ("Libellé niveau " + str(level)) not in df_nomenclature.columns :
            print("Colonne de niveau manquante ou libellé de niveau de colonne incorrect")
            raise ValueError
    # checking columns name minimal
    if not all(item in df_nomenclature.columns for item in ["Code", "Description", "Commentaire"]) :
        print("Libellé de colonne manquant")
        raise ValueError
    #return
    return params, df_nomenclature

#___PARSING A FILE THEN A FOLDER___

def parse_excel(filename_in, df_sommaire_in, release="v1.1", folder_output="out") :
    sheet_names = pd.ExcelFile(filename_in).sheet_names
    # iterate over sheets
    for sheet_i in sheet_names :
        print("Processing " + filename_in + " : sheet " + sheet_i + " ...")
        params_i, df_nomenclature_i = parse_sheet(filename_in, sheet_i)
        nom_fichier_i = params_i["nomenclature_ref"] + "-" +  params_i["nomenclature_name"] + "-" + release

        # complete sommaire
        df_i = pd.DataFrame({"nomenclature_name" : params_i["nomenclature_name"],
            "file_name" : nom_fichier_i,
            "referentiel" : params_i["nomenclature_ref"]},
            index=[0])
        df_sommaire_in = pd.concat([df_i,df_sommaire_in.loc[:]]).reset_index(drop=True)

        # generate export
        # for csv version not taken into account in filename
        export_csv_nomenclature(params_i,df_nomenclature_i, release=release, folder_output=folder_output)
        export_html_nomenclature(params_i,df_nomenclature_i, release=release, folder_output=folder_output)
        export_docx_nomenclature(params_i,df_nomenclature_i, release=release, folder_output=folder_output)
    return df_sommaire_in


def parse_folder(folder_in, release="v1.1", folder_output="out") :
    # initialize empty df for summary
    df_sommaire = pd.DataFrame(data={},
                   columns=["nomenclature_name",
                            "file_name",
                            "referentiel"],
                    dtype=str)
    
    for filename in os.listdir(folder_in):
        # check extension 
        if filename.endswith('.xlsx') :
            print("Processing " + filename + " ...")
            # processing
            df_sommaire = parse_excel(os.path.join(folder_in,filename), df_sommaire, release=release, folder_output=folder_output)
        else :
            print(filename + " is not a valid nomenclature file.")
    print("Processing summary ...")
    export_sommaire(df_sommaire, release=release, folder_output=folder_output)
    print("Job done.")
    return
