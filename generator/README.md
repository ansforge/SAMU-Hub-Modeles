### génération des classes
les fichiers [cisu-generator-config.json](cisu-generator-config.json) et [cisu-root-messages-config.json](cisu-root-messages-config.json) contiennent la configuration de la génération des classes Java :
- le chemin du descripteur du modèle : 'inputSpec'
- le chemin de sortie des classes Java : 'outputDir'
- le chemin du répertoire de templates de génération : 'templateDir'
    ces templates peuvent surcharger les templates par défaut de la génération, si leur nom est identique
- le nom du générateur utilisé : 'java'
- des propriétés additionnelles en fonction du générateur utilisé

Il y a deux fichiers car nous voulons implémenter du comportement supplémentaire sur un nombre limité de classes : les classes des messages (CisuCreateMessage, etc),
qui sont des XmlRootElement et qui doivent contenir un setter spécifique pour le namespace.

On utilise donc deux templates pojo.mustache différents pour couvrir les deux cas.
Celui appelé par la config principale a été surchargé pour prendre les éléments suivants :
- ajout de l'annotation
```java
@JsonInclude(JsonInclude.Include.NON_EMPTY)
```
au niveau de la classe
- modification du setter des listes :
```java
if (this.{{name}} == null) {
        this.{{name}} = new ArrayList<>();
        }
        this.{{name}}.addAll({{name}});
```

Il pourra être utile de le retravailler pour l'alléger (le template est celui utilisé par défaut avec les modifications signalées ci-dessus; on doit pouvoir l'expurger de toute la logique ne nous correspondant pas - autres librairies de sérialisation, annotation OpenAPI / swagger, etc).


Le template utilisé pour les classes RootElement ajoute les éléments suivants :
- ajout de l'annotation 
```java
@JacksonXmlRootElement (localName= "message")
```
pour coller au nommage du xsd
- ajout de la propriété
```java
@JacksonXmlProperty(isAttribute = true)
String xmlns = "urn:emergency:cisu:2.0";
```

Les templates model.mustache, qui prennent en charge la génération des imports en tête de fichier, ont été surchargés pour intégrer la ligne suivante :
```java
import com.fasterxml.jackson.dataformat.xml.annotation.*;
```
pour pouvoir utiliser les annotations JacksonXmlRootElement et JacksonXmlProperty ajoutées ci-dessus.

Comme on ne peut passer dans la conf que la liste des classes à traiter, sans pouvoir gérer d'exclusion, on applique la génération en deux temps en appliquant les commandes suivantes :

```bash
npx @openapitools/openapi-generator-cli generate -c .\cisu-generator-config.json --skip-validate-spec

npx @openapitools/openapi-generator-cli generate -c .\cisu-use-case-messages-config.json --skip-validate-spec

npx @openapitools/openapi-generator-cli generate -c .\cisu-root-messages-config.json --skip-validate-spec
```

Le premier appel applique le template principal à toutes les classes, le second écrase les classes XmlRootElement en appliquant le second template. Il est donc crucial de s'assurer d'appliquer les appels au générateur dans le bon ordre.


Il faudrait également disposer de plusieurs configurations, pour isoler la génération du modèle par domaine fonctionnel : EDXL, CISU, EMSI, le 15-15 à venir...

Ainsi on peut ne rebuilder que le modèle concerné, sans avoir à rebuilder tout le projet, au fur et à mesure des itérations.


### Notes :
Le générateur OpenAPI respecte la casse. Il faut donc que le fichier inputSpec utilise la même casse que dans les xsd pour faciliter la double sérialisation XML/JSON
(loc_Id, height_role, URI)
Ce faisant on "économise" une annotation supplémentaire dans les classes.
Il faudra donc bien s'assurer lors de la construction des contrats que la casse est bien la même dans les deux specs. 









