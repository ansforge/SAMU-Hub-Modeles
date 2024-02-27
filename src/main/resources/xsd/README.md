Because we want to use the official EDXL-DE xsd, but still handle proper validation on the content of the message,
we want to override the type of the element embeddedXMLContent (used to be AnyXMLType).

```xml
<xs:element name="embeddedXMLContent" type="x:cisuXMLContentType" minOccurs="1" maxOccurs="1"/>
```

To allow it we need to import the namespace where `cisuXMLContentType`lays and declare it in the root element.

```xml
<xs:schema xmlns:x="https://hub.esante.gouv.fr"/>

<xs:import namespace="https://hub.esante.gouv.fr" schemaLocation="./RC-XML-ContentType.xsd"/>
```

As we want to maintain modularity with the xsd, we use an intermediary: cisuXMLContentType, with its own xsd, where all the sub-xsd are
referenced.

The cisuXMLContentType is an element named "message", combining all the attributes of an RC-DE and a specific use case (emsi, createCase, createCaseHealth, etc)
