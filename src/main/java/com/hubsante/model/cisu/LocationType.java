package com.hubsante.model.cisu;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import javax.validation.constraints.Size;
import java.util.Arrays;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class LocationType {
  @JsonProperty("locId")
  @JacksonXmlProperty(localName = "loc_Id")
  private String locId;
  @JsonProperty("name")
  private String name;
  @JsonProperty("type")
  private Type type;
  @JsonProperty("coordsys")
  private String coordsys;
  @JsonProperty("heightRole")
  @JacksonXmlProperty(localName = "height_role")
  private HeightRole heightRole;
  @JsonProperty("coord")
  @Size(min=0)
  @JacksonXmlProperty(localName = "coord")
  @JacksonXmlElementWrapper(useWrapping = false)
  private CoordType[] coord;
  @JsonProperty("address")
  @Size(min=0)
  @JacksonXmlProperty(localName = "address")
  @JacksonXmlElementWrapper(useWrapping = false)
  private String[] address;
  @JsonProperty("commune")
  private String commune;
  @JsonProperty("civicAddress")
  private CivicAddressType civicAddress;

  public LocationType(){
  }

  public LocationType(
    String locId, String name, Type type, String coordsys, HeightRole heightRole, CoordType[] coord, String[] address, String commune, CivicAddressType civicAddress
  ) {
  	this.locId = locId;
  	this.name = name;
  	this.type = type;
  	this.coordsys = coordsys;
  	this.heightRole = heightRole;
  	this.coord = coord;
  	this.address = address;
  	this.commune = commune;
  	this.civicAddress = civicAddress;
  }

  public String getLocId() { return this.locId; }
  public void setLocId(String locId) { this.locId = locId; }

  public String getName() { return this.name; }
  public void setName(String name) { this.name = name; }

  public Type getType() { return this.type; }
  public void setType(Type type) { this.type = type; }

  public String getCoordsys() { return this.coordsys; }
  public void setCoordsys(String coordsys) { this.coordsys = coordsys; }

  public HeightRole getHeightRole() { return this.heightRole; }
  public void setHeightRole(HeightRole heightRole) { this.heightRole = heightRole; }

  public CoordType[] getCoord() { return this.coord; }
  public void setCoord(CoordType[] coord) { this.coord = coord; }

  public String[] getAddress() { return this.address; }
  public void setAddress(String[] address) { this.address = address; }

  public String getCommune() { return this.commune; }
  public void setCommune(String commune) { this.commune = commune; }

  public CivicAddressType getCivicAddress() { return this.civicAddress; }
  public void setCivicAddress(CivicAddressType civicAddress) { this.civicAddress = civicAddress; }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LocationType self = (LocationType) o;
      return 
        Objects.equals(this.locId, self.locId) &&
        Objects.equals(this.name, self.name) &&
        Objects.equals(this.type, self.type) &&
        Objects.equals(this.coordsys, self.coordsys) &&
        Objects.equals(this.heightRole, self.heightRole) &&
                Arrays.equals(this.coord, self.coord) &&
                Arrays.equals(this.address, self.address) &&
        Objects.equals(this.commune, self.commune) &&
        Objects.equals(this.civicAddress, self.civicAddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash((Object)locId, (Object)name, (Object)type, (Object)coordsys, (Object)heightRole, (Object)coord, (Object)address, (Object)commune, (Object)civicAddress);
  }

  @Override
  public String toString() {
    return "class LocationType {\n" +   
      "    locId: " + toIndentedString(locId) + "\n" +
      "    name: " + toIndentedString(name) + "\n" +
      "    type: " + toIndentedString(type) + "\n" +
      "    coordsys: " + toIndentedString(coordsys) + "\n" +
      "    heightRole: " + toIndentedString(heightRole) + "\n" +
      "    coord: " + toIndentedString(coord) + "\n" +
      "    address: " + toIndentedString(address) + "\n" +
      "    commune: " + toIndentedString(commune) + "\n" +
      "    civicAddress: " + toIndentedString(civicAddress) + "\n" +
    "}";
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