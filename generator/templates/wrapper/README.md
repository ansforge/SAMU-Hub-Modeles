this templates are used to generate the model class of the **Wrapper** classes.

It contains the same annotations as in the child classes, plus:
- the import of com.hubsante.model.common.DistributionElement and the *extends* mention on the class declaration.
- the import of jackson xml annotations
- Jackson xml additional annotations to handle root element and namespace

model.mustache:
```java
import com.fasterxml.jackson.dataformat.xml.annotation.*;
```

pojo.mustache:
```java
@JacksonXmlRootElement (localName= "message") // at class level

@JacksonXmlProperty(isAttribute = true) // at property level
String xmlns = "urn:emergency:cisu:2.0";
```