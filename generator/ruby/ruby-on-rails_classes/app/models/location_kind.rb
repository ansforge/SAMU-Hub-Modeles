=begin
Generated by: https://github.com/openapitools/openapi-generator.git

=end


class LocationKind < ApplicationRecord
  validates_presence_of :code
  validates_presence_of :label

end
