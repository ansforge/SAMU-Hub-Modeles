this templates are used to generate the model class of the **Use Case** classes (just below the wrappers, such as *Emsi*, *CreateCase*, *CreateCaseHealth*, etc.)

It contains the same annotations as in the child classes, plus:
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