### génération des classes
les fichiers [cisu-generator-config.json](cisu-generator-config.json) et [cisu-root-messages-config.json](cisu-root-messages-config.json) contiennent la configuration de la génération des classes Java :
- le chemin du descripteur du modèle : 'inputSpec'
- le chemin de sortie des classes Java : 'outputDir'
- le chemin du répertoire de templates de génération : 'templateDir'
    ces templates peuvent surcharger les templates par défaut de la génération, si leur nom est identique
- le nom du générateur utilisé : 'java'
- des propriétés additionnelles en fonction du générateur utilisé


```bash
npx @openapitools/openapi-generator-cli generate -c .\cisu-generator-config.json --skip-validate-spec

npx @openapitools/openapi-generator-cli generate -c .\cisu-use-case-messages-config.json --skip-validate-spec

npx @openapitools/openapi-generator-cli generate -c .\cisu-root-messages-config.json --skip-validate-spec
```

Le premier appel applique le template principal à toutes les classes, le second écrase les classes XmlRootElement en appliquant le second template. Il est donc crucial de s'assurer d'appliquer les appels au générateur dans le bon ordre.


Il faudrait également disposer de plusieurs configurations, pour isoler la génération du modèle par domaine fonctionnel : EDXL, CISU, EMSI, le 15-15 à venir...

Ainsi on peut ne rebuilder que le modèle concerné, sans avoir à rebuilder tout le projet, au fur et à mesure des itérations.



```bash
# common
npx @openapitools/openapi-generator-cli generate -c ..\config\common\common.generator-config.json --skip-validate-spec

npx @openapitools/openapi-generator-cli generate -c ..\config\common\common.wrapper.generator-config.json --skip-validate-spec

npx @openapitools/openapi-generator-cli generate -c ..\config\common\common.distributionElement.generator-config.json --skip-validate-spec

# createCase
npx @openapitools/openapi-generator-cli generate -c ..\config\RC-EDA\RC-EDA.generator-config.json --skip-validate-spec

npx @openapitools/openapi-generator-cli generate -c ..\config\RC-EDA\RC-EDA.wrapper.generator-config.json --skip-validate-spec

# emsi
npx @openapitools/openapi-generator-cli generate -c ..\config\EMSI-DC\EMSI-DC.generator-config.json --skip-validate-spec

npx @openapitools/openapi-generator-cli generate -c ..\config\EMSI-DC\EMSI-DC.wrapper.generator-config.json --skip-validate-spec
```