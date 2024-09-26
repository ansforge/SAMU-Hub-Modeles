Gem::Specification.new do |spec|
  spec.name          = "hubsante_model"
  spec.version       = "1.0"
  spec.authors       = ["Hub Santé"]
  spec.email         = ["hubsante.contact@esante.gouv.fr"]

  spec.summary       = ""
  spec.description   = ""
  spec.homepage    = "https://github.com/ansforge/SAMU-Hub-Modeles"
  spec.metadata    = {
    "source_code_uri" => "https://github.com/ansforge/SAMU-Hub-Modeles"
  }

  spec.files         = Dir["lib/**/*.rb"]
  spec.license       = "MIT"

  spec.required_ruby_version = ">= 3.0.0"

  # Dépendencies
  spec.add_dependency "rails", "~> 7.1"
end