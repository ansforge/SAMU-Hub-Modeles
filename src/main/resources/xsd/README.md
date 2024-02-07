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


**For now I have some issues:**
- I can't import RC-EDA, RS-EDA and EMSI because they share some element names. It is not possible within the same namespace.
For now I can't figure out how to import properly elements from another namespace in the main one.

It may help to use specific namespaces for the use cases xsd
So there will be:
<edxlDistribution> -> urn:EDXL
<message> -> urn:emeregency:cisu:2.0
<createCase> -> urn:emergency:cisu:2.0:createCase
<emsi> -> urn:emergency:cisu:2.0:emsi

etc