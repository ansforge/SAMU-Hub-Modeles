# 1ère itération :
- [x] Création de de deux répertoires, uniquement pour le périmètre RS-EDA pour commencer : [ruby](../../config/RS-EDA/ruby) et [ruby-on-rails](../../config/RS-EDA/ruby-on-rails)
- [x] Un fichier de configuration minimaliste dans chacun de ces répertoires.

Note : En Java, nous devons appliquer trois configurations successivement, car les templates Java que nous utilisons sont légèrement différents entre le cas général, et deux exceptions :
- les classes "useCase" (CreateCase, CreateCaseHealth, etc.), uniquement pour pouvoir porter du mapping XML spécifique - inutile dans un contexte JSON
- les classes "wrapper" (CreateCaseWrapper, CreateCaseHealthWrapper, etc.), pour pouvoir gérer une logique d'héritage. Celle-ci est totalement adhérente à la librairie Java de (dé)sérialisation que nous utilisons, et pourrait être sans objet pour d'autres langages. A tester probablement en dernier lieu, donc.

### Reste à faire :
- [ ] Contrôler que les classes générées sont conformes
- [ ] Contrôler que les paramètres définis dans les additionalProperties du fichier de config sont conformes aux usages (casse, nom des packages ?)

En l'état, j'ai pu charger le répertoire [ruby_classes](../../ruby/ruby_classes) dans RubyMine; la navigation entre les classes fonctionne bien.

Le répertoire [ruby-on-rails_classes](../../ruby/ruby-on-rails_classes) est lui beaucoup plus réduit; je ne sais pas quoi en conclure. Ci-dessous quelques éléments assez réduits de ChatGPT :
```text
Certainly! The "ruby" and "ruby-on-rails" OpenAPI generators serve different purposes in the context of generating code from OpenAPI specifications. Here's a breakdown of their differences:

### 1. **Purpose and Use Cases**
- **ruby**:
  - **Purpose**: Generates a generic Ruby client library.
  - **Use Case**: Useful when you need to interact with an API from a Ruby application. This generator provides methods and models that allow you to easily make API calls and handle responses.

- **ruby-on-rails**:
  - **Purpose**: Generates a Ruby on Rails server application.
  - **Use Case**: Useful when you want to implement an API server based on the OpenAPI specification. This generator helps in scaffolding a Rails application with controllers, models, and routes that conform to the defined API spec.

### 2. **Generated Code Structure**
- **ruby**:
  - Generates a Ruby gem that includes:
    - API classes for making HTTP requests.
    - Models that map to the data structures defined in the OpenAPI spec.
    - Configuration files to manage settings like base URL and authentication.
  - The structure is designed to be included as a dependency in Ruby applications, allowing developers to call API endpoints with ease.

- **ruby-on-rails**:
  - Generates a Rails application structure that includes:
    - Controllers for handling API endpoints.
    - Models and migrations for database schema based on the OpenAPI definitions.
    - Routes configured to match the paths in the OpenAPI spec.
    - Includes boilerplate code for request handling and response formatting.
  - The structure is meant to kickstart a Rails API server that adheres to the OpenAPI specification, reducing the initial setup time for developers.

### 3. **Configuration and Customization**
- **ruby**:
  - Configuration options focus on client-specific settings such as:
    - HTTP client configuration.
    - API key management.
    - Code generation settings to customize class names, file names, etc.
  - Usually configured via a configuration file or directly in the code where the client is used.

- **ruby-on-rails**:
  - Configuration options are geared towards Rails application settings, including:
    - Database configurations.
    - Middleware settings.
    - Code generation options that affect how controllers, models, and routes are created.
  - Typically configured via Rails configuration files and initializers.

### 4. **Dependencies and Environment**
- **ruby**:
  - Designed to be integrated into any Ruby application.
  - Does not depend on Rails or any specific framework, though it can be used within a Rails application if needed.

- **ruby-on-rails**:
  - Specifically tailored for Rails environments.
  - Generates code that assumes a Rails application structure and relies on Rails-specific conventions and libraries.

### Summary
- Use the **ruby** generator when you need a client library to consume APIs in a Ruby application.
- Use the **ruby-on-rails** generator when you need to create a server-side implementation of an API in a Ruby on Rails application.

Both generators leverage the OpenAPI specification to streamline development, but they target different aspects of API development (client vs. server).
```