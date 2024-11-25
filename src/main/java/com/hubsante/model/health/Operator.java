/**
 * Copyright © 2023-2024 Agence du Numerique en Sante (ANS)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/*
 *
 *
 *
 *
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator
 * (https://openapi-generator.tech). https://openapi-generator.tech Do not edit
 * the class manually.
 */

package com.hubsante.model.health;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import java.util.Arrays;
import java.util.Arrays;
import java.util.Objects;

/**
 * Operator
 */
@JsonPropertyOrder({Operator.JSON_PROPERTY_LABEL, Operator.JSON_PROPERTY_ROLE})
@JsonTypeName("operator")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class Operator {
  public static final String JSON_PROPERTY_LABEL = "label";
  private String label;

  /**
   * A valoriser avec le rôle de l&#39;opérateur au sein de l&#39;entité
   * émettrice du message :
   */
  public enum RoleEnum {
    AMBULANCIER("AMBULANCIER"),

    ARM("ARM"),

    INFIRMIER("INFIRMIER"),

    MEDECIN("MEDECIN"),

    PILOTE("PILOTE"),

    TCM("TCM"),

    AUTRE("AUTRE"),

    INCONNU("INCONNU");

    private String value;

    RoleEnum(String value) { this.value = value; }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static RoleEnum fromValue(String value) {
      for (RoleEnum b : RoleEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_ROLE = "role";
  private RoleEnum role;

  public Operator() {}

  public Operator label(String label) {

    this.label = label;
    return this;
  }

  /**
   * A valoriser si besoin avec la valeur souhaitée, en fonction des préférences
   *de chaque partenaire : cela peut être le nom et prénom de l&#39;opérateur,
   *ou un identifiant.
   * @return label
   **/
  @JsonProperty(JSON_PROPERTY_LABEL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getLabel() {
    return label;
  }

  @JsonProperty(JSON_PROPERTY_LABEL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLabel(String label) {
    this.label = label;
  }

  public Operator role(RoleEnum role) {

    this.role = role;
    return this;
  }

  /**
   * A valoriser avec le rôle de l&#39;opérateur au sein de l&#39;entité
   *émettrice du message :
   * @return role
   **/
  @JsonProperty(JSON_PROPERTY_ROLE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public RoleEnum getRole() {
    return role;
  }

  @JsonProperty(JSON_PROPERTY_ROLE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRole(RoleEnum role) {
    this.role = role;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Operator operator = (Operator)o;
    return Objects.equals(this.label, operator.label) &&
        Objects.equals(this.role, operator.role);
  }

  @Override
  public int hashCode() {
    return Objects.hash(label, role);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Operator {\n");
    sb.append("    label: ").append(toIndentedString(label)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
