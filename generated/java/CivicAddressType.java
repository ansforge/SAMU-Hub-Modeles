package com.hubsante.message;
              
import java.util.Objects;
import java.util.Map;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.*;
              
public class CivicAddressType {
  @JsonProperty("country")
  private String country;
  @JsonProperty("a1")
  private String a1;
  @JsonProperty("a2")
  private String a2;
  @JsonProperty("a3")
  private String a3;
  @JsonProperty("a4")
  private String a4;
  @JsonProperty("a5")
  private String a5;
  @JsonProperty("a6")
  private String a6;
  @JsonProperty("prd")
  private String prd;
  @JsonProperty("pod")
  private String pod;
  @JsonProperty("sts")
  private String sts;
  @JsonProperty("hno")
  private String hno;
  @JsonProperty("hns")
  private String hns;
  @JsonProperty("lmk")
  private String lmk;
  @JsonProperty("loc")
  private String loc;
  @JsonProperty("nam")
  private String nam;
  @JsonProperty("pc")
  private String pc;
  @JsonProperty("bld")
  private String bld;
  @JsonProperty("unit")
  private String unit;
  @JsonProperty("flr")
  private String flr;
  @JsonProperty("room")
  private String room;
  @JsonProperty("plc")
  private LocationType2 plc;
  @JsonProperty("pcn")
  private String pcn;
  @JsonProperty("pobox")
  private String pobox;
  @JsonProperty("addcode")
  private String addcode;
  @JsonProperty("seat")
  private String seat;
  @JsonProperty("rd")
  private String rd;
  @JsonProperty("rdsec")
  private String rdsec;
  @JsonProperty("rdbr")
  private String rdbr;
  @JsonProperty("rdsubbr")
  private String rdsubbr;
  @JsonProperty("prm")
  private String prm;
  @JsonProperty("pom")
  private String pom;
  private Map<String, Object> additionalProperties;

  public CivicAddressType(){
  }

  public CivicAddressType(
    String country, String a1, String a2, String a3, String a4, String a5, String a6, String prd, String pod, String sts, String hno, String hns, String lmk, String loc, String nam, String pc, String bld, String unit, String flr, String room, LocationType2 plc, String pcn, String pobox, String addcode, String seat, String rd, String rdsec, String rdbr, String rdsubbr, String prm, String pom, Map<String, Object> additionalProperties
  ) {
  	this.country = country;
  	this.a1 = a1;
  	this.a2 = a2;
  	this.a3 = a3;
  	this.a4 = a4;
  	this.a5 = a5;
  	this.a6 = a6;
  	this.prd = prd;
  	this.pod = pod;
  	this.sts = sts;
  	this.hno = hno;
  	this.hns = hns;
  	this.lmk = lmk;
  	this.loc = loc;
  	this.nam = nam;
  	this.pc = pc;
  	this.bld = bld;
  	this.unit = unit;
  	this.flr = flr;
  	this.room = room;
  	this.plc = plc;
  	this.pcn = pcn;
  	this.pobox = pobox;
  	this.addcode = addcode;
  	this.seat = seat;
  	this.rd = rd;
  	this.rdsec = rdsec;
  	this.rdbr = rdbr;
  	this.rdsubbr = rdsubbr;
  	this.prm = prm;
  	this.pom = pom;
  	this.additionalProperties = additionalProperties;
  }

  public String getCountry() { return this.country; }
  public void setCountry(String country) { this.country = country; }

  public String getA1() { return this.a1; }
  public void setA1(String a1) { this.a1 = a1; }

  public String getA2() { return this.a2; }
  public void setA2(String a2) { this.a2 = a2; }

  public String getA3() { return this.a3; }
  public void setA3(String a3) { this.a3 = a3; }

  public String getA4() { return this.a4; }
  public void setA4(String a4) { this.a4 = a4; }

  public String getA5() { return this.a5; }
  public void setA5(String a5) { this.a5 = a5; }

  public String getA6() { return this.a6; }
  public void setA6(String a6) { this.a6 = a6; }

  public String getPrd() { return this.prd; }
  public void setPrd(String prd) { this.prd = prd; }

  public String getPod() { return this.pod; }
  public void setPod(String pod) { this.pod = pod; }

  public String getSts() { return this.sts; }
  public void setSts(String sts) { this.sts = sts; }

  public String getHno() { return this.hno; }
  public void setHno(String hno) { this.hno = hno; }

  public String getHns() { return this.hns; }
  public void setHns(String hns) { this.hns = hns; }

  public String getLmk() { return this.lmk; }
  public void setLmk(String lmk) { this.lmk = lmk; }

  public String getLoc() { return this.loc; }
  public void setLoc(String loc) { this.loc = loc; }

  public String getNam() { return this.nam; }
  public void setNam(String nam) { this.nam = nam; }

  public String getPc() { return this.pc; }
  public void setPc(String pc) { this.pc = pc; }

  public String getBld() { return this.bld; }
  public void setBld(String bld) { this.bld = bld; }

  public String getUnit() { return this.unit; }
  public void setUnit(String unit) { this.unit = unit; }

  public String getFlr() { return this.flr; }
  public void setFlr(String flr) { this.flr = flr; }

  public String getRoom() { return this.room; }
  public void setRoom(String room) { this.room = room; }

  public LocationType2 getPlc() { return this.plc; }
  public void setPlc(LocationType2 plc) { this.plc = plc; }

  public String getPcn() { return this.pcn; }
  public void setPcn(String pcn) { this.pcn = pcn; }

  public String getPobox() { return this.pobox; }
  public void setPobox(String pobox) { this.pobox = pobox; }

  public String getAddcode() { return this.addcode; }
  public void setAddcode(String addcode) { this.addcode = addcode; }

  public String getSeat() { return this.seat; }
  public void setSeat(String seat) { this.seat = seat; }

  public String getRd() { return this.rd; }
  public void setRd(String rd) { this.rd = rd; }

  public String getRdsec() { return this.rdsec; }
  public void setRdsec(String rdsec) { this.rdsec = rdsec; }

  public String getRdbr() { return this.rdbr; }
  public void setRdbr(String rdbr) { this.rdbr = rdbr; }

  public String getRdsubbr() { return this.rdsubbr; }
  public void setRdsubbr(String rdsubbr) { this.rdsubbr = rdsubbr; }

  public String getPrm() { return this.prm; }
  public void setPrm(String prm) { this.prm = prm; }

  public String getPom() { return this.pom; }
  public void setPom(String pom) { this.pom = pom; }

  public Map<String, Object> getAdditionalProperties() { return this.additionalProperties; }
  public void setAdditionalProperties(Map<String, Object> additionalProperties) { this.additionalProperties = additionalProperties; }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CivicAddressType self = (CivicAddressType) o;
      return 
        Objects.equals(this.country, self.country) &&
        Objects.equals(this.a1, self.a1) &&
        Objects.equals(this.a2, self.a2) &&
        Objects.equals(this.a3, self.a3) &&
        Objects.equals(this.a4, self.a4) &&
        Objects.equals(this.a5, self.a5) &&
        Objects.equals(this.a6, self.a6) &&
        Objects.equals(this.prd, self.prd) &&
        Objects.equals(this.pod, self.pod) &&
        Objects.equals(this.sts, self.sts) &&
        Objects.equals(this.hno, self.hno) &&
        Objects.equals(this.hns, self.hns) &&
        Objects.equals(this.lmk, self.lmk) &&
        Objects.equals(this.loc, self.loc) &&
        Objects.equals(this.nam, self.nam) &&
        Objects.equals(this.pc, self.pc) &&
        Objects.equals(this.bld, self.bld) &&
        Objects.equals(this.unit, self.unit) &&
        Objects.equals(this.flr, self.flr) &&
        Objects.equals(this.room, self.room) &&
        Objects.equals(this.plc, self.plc) &&
        Objects.equals(this.pcn, self.pcn) &&
        Objects.equals(this.pobox, self.pobox) &&
        Objects.equals(this.addcode, self.addcode) &&
        Objects.equals(this.seat, self.seat) &&
        Objects.equals(this.rd, self.rd) &&
        Objects.equals(this.rdsec, self.rdsec) &&
        Objects.equals(this.rdbr, self.rdbr) &&
        Objects.equals(this.rdsubbr, self.rdsubbr) &&
        Objects.equals(this.prm, self.prm) &&
        Objects.equals(this.pom, self.pom) &&
        Objects.equals(this.additionalProperties, self.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash((Object)country, (Object)a1, (Object)a2, (Object)a3, (Object)a4, (Object)a5, (Object)a6, (Object)prd, (Object)pod, (Object)sts, (Object)hno, (Object)hns, (Object)lmk, (Object)loc, (Object)nam, (Object)pc, (Object)bld, (Object)unit, (Object)flr, (Object)room, (Object)plc, (Object)pcn, (Object)pobox, (Object)addcode, (Object)seat, (Object)rd, (Object)rdsec, (Object)rdbr, (Object)rdsubbr, (Object)prm, (Object)pom, (Object)additionalProperties);
  }

  @Override
  public String toString() {
    return "class CivicAddressType {\n" +   
      "    country: " + toIndentedString(country) + "\n" +
      "    a1: " + toIndentedString(a1) + "\n" +
      "    a2: " + toIndentedString(a2) + "\n" +
      "    a3: " + toIndentedString(a3) + "\n" +
      "    a4: " + toIndentedString(a4) + "\n" +
      "    a5: " + toIndentedString(a5) + "\n" +
      "    a6: " + toIndentedString(a6) + "\n" +
      "    prd: " + toIndentedString(prd) + "\n" +
      "    pod: " + toIndentedString(pod) + "\n" +
      "    sts: " + toIndentedString(sts) + "\n" +
      "    hno: " + toIndentedString(hno) + "\n" +
      "    hns: " + toIndentedString(hns) + "\n" +
      "    lmk: " + toIndentedString(lmk) + "\n" +
      "    loc: " + toIndentedString(loc) + "\n" +
      "    nam: " + toIndentedString(nam) + "\n" +
      "    pc: " + toIndentedString(pc) + "\n" +
      "    bld: " + toIndentedString(bld) + "\n" +
      "    unit: " + toIndentedString(unit) + "\n" +
      "    flr: " + toIndentedString(flr) + "\n" +
      "    room: " + toIndentedString(room) + "\n" +
      "    plc: " + toIndentedString(plc) + "\n" +
      "    pcn: " + toIndentedString(pcn) + "\n" +
      "    pobox: " + toIndentedString(pobox) + "\n" +
      "    addcode: " + toIndentedString(addcode) + "\n" +
      "    seat: " + toIndentedString(seat) + "\n" +
      "    rd: " + toIndentedString(rd) + "\n" +
      "    rdsec: " + toIndentedString(rdsec) + "\n" +
      "    rdbr: " + toIndentedString(rdbr) + "\n" +
      "    rdsubbr: " + toIndentedString(rdsubbr) + "\n" +
      "    prm: " + toIndentedString(prm) + "\n" +
      "    pom: " + toIndentedString(pom) + "\n" +
      "    additionalProperties: " + toIndentedString(additionalProperties) + "\n" +
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