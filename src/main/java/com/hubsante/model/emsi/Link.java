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

package com.hubsante.model.emsi;

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
 * Link
 */
@JsonPropertyOrder({Link.JSON_PROPERTY_I_D, Link.JSON_PROPERTY_L_I_N_K_R_O_L_E})
@JsonTypeName("link")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

@JsonIgnoreProperties(ignoreUnknown = true)
public class Link {
  public static final String JSON_PROPERTY_I_D = "ID";
  private String ID;

  /**
   * Optionnel : à valoriser avec la constante \&quot;SPRSDS\&quot; en EMSI-EO
   * et avec le libellé ADDSTO en EMSI-DC  Dans Nexsis; RG 1  – : création du
   * premier message EMSi suite réception Affaire * &lt;LINK&gt;&lt;LINK ID&gt;
   * &#x3D; &lt;Numéro d&#39;affaire initiale&gt; • &lt;LINK&gt;&lt;LINK
   * ROLE&gt; &#x3D; &#39;ADDSTO&#39;, RG 2 : Pour tous les messages créés après
   * le premier, EMSI &lt;LINK&gt; est complété par &lt;LINK&gt;&lt;LINK ID&gt;
   * contenant l&#39;ID de message EMSI précédent créé au sein du SGO rédacteur
   * * &lt;LINK&gt;&lt;LINK ROLE&gt; &#x3D; &#39;SPRSDS&#39;
   */
  public enum LINKROLEEnum {
    ADDSTO("ADDSTO"),

    SPRSDS("SPRSDS");

    private String value;

    LINKROLEEnum(String value) { this.value = value; }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static LINKROLEEnum fromValue(String value) {
      for (LINKROLEEnum b : LINKROLEEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_L_I_N_K_R_O_L_E = "LINK_ROLE";
  private LINKROLEEnum LINK_ROLE;

  public Link() {}

  public Link ID(String ID) {

    this.ID = ID;
    return this;
  }

  /**
   * A renseigner avec l&#39;identifiant local de l&#39;affaire du partenaire
   *requérant Dans NexSIS; RG 1  – : création du premier message EMSi suite
   *réception Affaire • &lt;LINK&gt;&lt;LINK ID&gt; &#x3D; &lt;Numéro
   *d&#39;affaire initiale&gt; • &lt;LINK&gt;&lt;LINK ROLE&gt; &#x3D;
   *&#39;ADDSTO&#39;, RG 2 : Pour tous les messages créés après le premier, EMSI
   *&lt;LINK&gt; est complété par &lt;LINK&gt;&lt;LINK ID&gt; contenant l&#39;ID
   *de message EMSI précédent créé au sein du SGO rédacteur *
   *&lt;LINK&gt;&lt;LINK ROLE&gt; &#x3D; &#39;SPRSDS&#39;
   * @return ID
   **/
  @JsonProperty(JSON_PROPERTY_I_D)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getID() {
    return ID;
  }

  @JsonProperty(JSON_PROPERTY_I_D)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setID(String ID) {
    this.ID = ID;
  }

  public Link LINK_ROLE(LINKROLEEnum LINK_ROLE) {

    this.LINK_ROLE = LINK_ROLE;
    return this;
  }

  /**
   * Optionnel : à valoriser avec la constante \&quot;SPRSDS\&quot; en EMSI-EO
   *et avec le libellé ADDSTO en EMSI-DC  Dans Nexsis; RG 1  – : création du
   *premier message EMSi suite réception Affaire * &lt;LINK&gt;&lt;LINK ID&gt;
   *&#x3D; &lt;Numéro d&#39;affaire initiale&gt; • &lt;LINK&gt;&lt;LINK ROLE&gt;
   *&#x3D; &#39;ADDSTO&#39;, RG 2 : Pour tous les messages créés après le
   *premier, EMSI &lt;LINK&gt; est complété par &lt;LINK&gt;&lt;LINK ID&gt;
   *contenant l&#39;ID de message EMSI précédent créé au sein du SGO rédacteur *
   *&lt;LINK&gt;&lt;LINK ROLE&gt; &#x3D; &#39;SPRSDS&#39;
   * @return LINK_ROLE
   **/
  @JsonProperty(JSON_PROPERTY_L_I_N_K_R_O_L_E)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public LINKROLEEnum getLINKROLE() {
    return LINK_ROLE;
  }

  @JsonProperty(JSON_PROPERTY_L_I_N_K_R_O_L_E)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLINKROLE(LINKROLEEnum LINK_ROLE) {
    this.LINK_ROLE = LINK_ROLE;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Link link = (Link)o;
    return Objects.equals(this.ID, link.ID) &&
        Objects.equals(this.LINK_ROLE, link.LINK_ROLE);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ID, LINK_ROLE);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Link {\n");
    sb.append("    ID: ").append(toIndentedString(ID)).append("\n");
    sb.append("    LINK_ROLE: ")
        .append(toIndentedString(LINK_ROLE))
        .append("\n");
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
