# Messages Sample Topology

Several test messages are provided to test the library (use of [EdxlHandler](../../java/com/hubsante/model/EdxlHandler.java) for serialization and deserialization, use of [Validator](../../java/com/hubsante/model/Validator.java) for validation against json-schemas / xsd).

The sample folder is organized as follows:
- two subdirectories, to separate compliant ([valid](valid)) and non-compliant ([failing](failing)) messages.
- in each subdirectory, a subdirectory for each use case (RC-EDA, RC-REF, RS-INFO) and a subdirectory for EDXL-DE messages.
- the EDXL-DE subdirectory contains message embedding a CustomContent use cas message, as its only purpose is to test the EDXL-DE wrapper.
- each use case subdirectory contains two messages, one in json format and one in xml format.

All messages share the same EDXL-DE properties except for the "content", which is specific to each use case, and the sender/recipient direction.

The json ones basically emulate a message sent by a samuA to a samuB, and the xml ones a message sent by a samuB to a samuA.
This is useful because we also use this sample library to test the Dispatcher component, which is responsible for routing the messages, and we want to simulate the proper conversion based on the client configured language.

We use this sample library to handle technical tests, so we do not plan to ensure that the content of the messages is absolutely consistent with the EDXL-DE envelope properties on the semantic level : for example, we do not check if the use case content could contain organization ids or else inconsistent with the EDXL-DE sender we set, as samuA or samuB.
Although, the use case contents can be deemed to be compliant themselves.


## Valid messages
These messages are used for passing tests on (de)serialization ops ([EdxlHandlerTest](../../../test/java/com/hubsante/model/EdxlHandlerTest.java)) and validation ([ValidatorTest](../../../test/java/com/hubsante/model/ValidatorTest.java)).

They also could be used to easily import a message for testing purposes in projects importing this library as a dependency : the [TestMessagesHelper](../../java/com/hubsante/model/TestMessagesHelper.java) comes with methods to load them as a String.

## Failing messages
These messages are mainly used for failing tests on validation ([ValidatorTest](../../../test/java/com/hubsante/model/ValidatorTest.java)).

They also could be imported as a String, but it probably may not be useful for projects importing this library as a dependency, which could rather construct their own failing messages based on the specific errors they want to test, and then calling the [Validator](../../java/com/hubsante/model/Validator.java) methods on them.


There are also some failing messages for specific cases:
<u>*Failing deserialization*:</u>
[unparsable-content.json](failing/EDXL-DE/unparsable-content.json) - A passing EDXL-DE message with malformed content: an unknown property has been added.
Deserialization should fail.

<u>*Failing validation at EDXL-DE level*:</u>
[invalid-RC-EDA-valid-EDXL.json](failing/RC-EDA/invalid-RC-EDA-valid-EDXL.json) - An invalid RC-EDA message, with a valid EDXL-DE envelope. Used to test the validation against the partial schema.