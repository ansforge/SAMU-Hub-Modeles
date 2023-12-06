these are the basic templates used to generate the model classes.

It is an override of the default template of the generator, with the following modifications:

- add the following annotation at class level
```java
@JsonInclude(JsonInclude.Include.NON_EMPTY)
```


- collection setter modification :
```java
if (this.{{name}} == null) {
        this.{{name}} = new ArrayList<>();
        }
        this.{{name}}.addAll({{name}});
```