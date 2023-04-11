package com.hubsante.message;
              
import java.util.Objects;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.*;
              
public class LocationType {
  @JsonProperty("locId")
  private String locId;
  @JsonProperty("name")
  private String name;
  @JsonProperty("type")
  private Type type;
  @JsonProperty("coordsys")
  private String coordsys;
  @JsonProperty("heightRole")
  private HeightRole heightRole;
  @JsonProperty("coord")
  @Size(min=0)
  private Object[] coord;
  @JsonProperty("address")
  @Size(min=0)
  private Object[] address;
  @JsonProperty("commune")
  private String commune;
  @JsonProperty("civicAddress")
  private CivicAddressType civicAddress;

  public LocationType(){
  }

  public LocationType(
    String locId, String name, Type type, String coordsys, HeightRole heightRole, Object[] coord, Object[] address, String commune, CivicAddressType civicAddress
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

  public Object[] getCoord() { return this.coord; }
  public void setCoord(Object[] coord) { this.coord = coord; }

  public Object[] getAddress() { return this.address; }
  public void setAddress(Object[] address) { this.address = address; }

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
        Objects.equals(this.coord, self.coord) &&
        Objects.equals(this.address, self.address) &&
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