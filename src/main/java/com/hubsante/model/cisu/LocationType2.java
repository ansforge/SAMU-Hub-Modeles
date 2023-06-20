package com.hubsante.model.cisu;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.Objects;
              
public class LocationType2 {
  @JsonProperty("aircraft")
  private Map<String, Object> aircraft;
  @JsonProperty("airport")
  private Map<String, Object> airport;
  @JsonProperty("arena")
  private Map<String, Object> arena;
  @JsonProperty("automobile")
  private Map<String, Object> automobile;
  @JsonProperty("bank")
  private Map<String, Object> bank;
  @JsonProperty("bar")
  private Map<String, Object> bar;
  @JsonProperty("bicyle")
  private Map<String, Object> bicyle;
  @JsonProperty("bus")
  private Map<String, Object> bus;
  @JsonProperty("busStation")
  private Map<String, Object> busStation;
  @JsonProperty("cafe")
  private Map<String, Object> cafe;
  @JsonProperty("classroom")
  private Map<String, Object> classroom;
  @JsonProperty("club")
  private Map<String, Object> club;
  @JsonProperty("construction")
  private Map<String, Object> construction;
  @JsonProperty("conventionCenter")
  private Map<String, Object> conventionCenter;
  @JsonProperty("government")
  private Map<String, Object> government;
  @JsonProperty("hospital")
  private Map<String, Object> hospital;
  @JsonProperty("hotel")
  private Map<String, Object> hotel;
  @JsonProperty("industrial")
  private Map<String, Object> industrial;
  @JsonProperty("library")
  private Map<String, Object> library;
  @JsonProperty("motorcycle")
  private Map<String, Object> motorcycle;
  @JsonProperty("office")
  private Map<String, Object> office;
  @JsonProperty("other")
  private String other;
  @JsonProperty("outdoors")
  private Map<String, Object> outdoors;
  @JsonProperty("parking")
  private Map<String, Object> parking;
  @JsonProperty("placeOfWorship")
  private Map<String, Object> placeOfWorship;
  @JsonProperty("prison")
  private Map<String, Object> prison;
  @JsonProperty("_public")
  private Map<String, Object> _public;
  @JsonProperty("publicTransport")
  private Map<String, Object> publicTransport;
  @JsonProperty("residence")
  private Map<String, Object> residence;
  @JsonProperty("restaurant")
  private Map<String, Object> restaurant;
  @JsonProperty("school")
  private Map<String, Object> school;
  @JsonProperty("shoppingArea")
  private Map<String, Object> shoppingArea;
  @JsonProperty("stadium")
  private Map<String, Object> stadium;
  @JsonProperty("store")
  private Map<String, Object> store;
  @JsonProperty("street")
  private Map<String, Object> street;
  @JsonProperty("theater")
  private Map<String, Object> theater;
  @JsonProperty("train")
  private Map<String, Object> train;
  @JsonProperty("trainStation")
  private Map<String, Object> trainStation;
  @JsonProperty("truck")
  private Map<String, Object> truck;
  @JsonProperty("underway")
  private Map<String, Object> underway;
  @JsonProperty("unknown")
  private Map<String, Object> unknown;
  @JsonProperty("warehouse")
  private Map<String, Object> warehouse;
  @JsonProperty("water")
  private Map<String, Object> water;
  @JsonProperty("watercraft")
  private Map<String, Object> watercraft;

  public LocationType2(){
  }

  public LocationType2(
    Map<String, Object> aircraft, Map<String, Object> airport, Map<String, Object> arena, Map<String, Object> automobile, Map<String, Object> bank, Map<String, Object> bar, Map<String, Object> bicyle, Map<String, Object> bus, Map<String, Object> busStation, Map<String, Object> cafe, Map<String, Object> classroom, Map<String, Object> club, Map<String, Object> construction, Map<String, Object> conventionCenter, Map<String, Object> government, Map<String, Object> hospital, Map<String, Object> hotel, Map<String, Object> industrial, Map<String, Object> library, Map<String, Object> motorcycle, Map<String, Object> office, String other, Map<String, Object> outdoors, Map<String, Object> parking, Map<String, Object> placeOfWorship, Map<String, Object> prison, Map<String, Object> _public, Map<String, Object> publicTransport, Map<String, Object> residence, Map<String, Object> restaurant, Map<String, Object> school, Map<String, Object> shoppingArea, Map<String, Object> stadium, Map<String, Object> store, Map<String, Object> street, Map<String, Object> theater, Map<String, Object> train, Map<String, Object> trainStation, Map<String, Object> truck, Map<String, Object> underway, Map<String, Object> unknown, Map<String, Object> warehouse, Map<String, Object> water, Map<String, Object> watercraft
  ) {
  	this.aircraft = aircraft;
  	this.airport = airport;
  	this.arena = arena;
  	this.automobile = automobile;
  	this.bank = bank;
  	this.bar = bar;
  	this.bicyle = bicyle;
  	this.bus = bus;
  	this.busStation = busStation;
  	this.cafe = cafe;
  	this.classroom = classroom;
  	this.club = club;
  	this.construction = construction;
  	this.conventionCenter = conventionCenter;
  	this.government = government;
  	this.hospital = hospital;
  	this.hotel = hotel;
  	this.industrial = industrial;
  	this.library = library;
  	this.motorcycle = motorcycle;
  	this.office = office;
  	this.other = other;
  	this.outdoors = outdoors;
  	this.parking = parking;
  	this.placeOfWorship = placeOfWorship;
  	this.prison = prison;
  	this._public = _public;
  	this.publicTransport = publicTransport;
  	this.residence = residence;
  	this.restaurant = restaurant;
  	this.school = school;
  	this.shoppingArea = shoppingArea;
  	this.stadium = stadium;
  	this.store = store;
  	this.street = street;
  	this.theater = theater;
  	this.train = train;
  	this.trainStation = trainStation;
  	this.truck = truck;
  	this.underway = underway;
  	this.unknown = unknown;
  	this.warehouse = warehouse;
  	this.water = water;
  	this.watercraft = watercraft;
  }

  public Map<String, Object> getAircraft() { return this.aircraft; }
  public void setAircraft(Map<String, Object> aircraft) { this.aircraft = aircraft; }

  public Map<String, Object> getAirport() { return this.airport; }
  public void setAirport(Map<String, Object> airport) { this.airport = airport; }

  public Map<String, Object> getArena() { return this.arena; }
  public void setArena(Map<String, Object> arena) { this.arena = arena; }

  public Map<String, Object> getAutomobile() { return this.automobile; }
  public void setAutomobile(Map<String, Object> automobile) { this.automobile = automobile; }

  public Map<String, Object> getBank() { return this.bank; }
  public void setBank(Map<String, Object> bank) { this.bank = bank; }

  public Map<String, Object> getBar() { return this.bar; }
  public void setBar(Map<String, Object> bar) { this.bar = bar; }

  public Map<String, Object> getBicyle() { return this.bicyle; }
  public void setBicyle(Map<String, Object> bicyle) { this.bicyle = bicyle; }

  public Map<String, Object> getBus() { return this.bus; }
  public void setBus(Map<String, Object> bus) { this.bus = bus; }

  public Map<String, Object> getBusStation() { return this.busStation; }
  public void setBusStation(Map<String, Object> busStation) { this.busStation = busStation; }

  public Map<String, Object> getCafe() { return this.cafe; }
  public void setCafe(Map<String, Object> cafe) { this.cafe = cafe; }

  public Map<String, Object> getClassroom() { return this.classroom; }
  public void setClassroom(Map<String, Object> classroom) { this.classroom = classroom; }

  public Map<String, Object> getClub() { return this.club; }
  public void setClub(Map<String, Object> club) { this.club = club; }

  public Map<String, Object> getConstruction() { return this.construction; }
  public void setConstruction(Map<String, Object> construction) { this.construction = construction; }

  public Map<String, Object> getConventionCenter() { return this.conventionCenter; }
  public void setConventionCenter(Map<String, Object> conventionCenter) { this.conventionCenter = conventionCenter; }

  public Map<String, Object> getGovernment() { return this.government; }
  public void setGovernment(Map<String, Object> government) { this.government = government; }

  public Map<String, Object> getHospital() { return this.hospital; }
  public void setHospital(Map<String, Object> hospital) { this.hospital = hospital; }

  public Map<String, Object> getHotel() { return this.hotel; }
  public void setHotel(Map<String, Object> hotel) { this.hotel = hotel; }

  public Map<String, Object> getIndustrial() { return this.industrial; }
  public void setIndustrial(Map<String, Object> industrial) { this.industrial = industrial; }

  public Map<String, Object> getLibrary() { return this.library; }
  public void setLibrary(Map<String, Object> library) { this.library = library; }

  public Map<String, Object> getMotorcycle() { return this.motorcycle; }
  public void setMotorcycle(Map<String, Object> motorcycle) { this.motorcycle = motorcycle; }

  public Map<String, Object> getOffice() { return this.office; }
  public void setOffice(Map<String, Object> office) { this.office = office; }

  public String getOther() { return this.other; }
  public void setOther(String other) { this.other = other; }

  public Map<String, Object> getOutdoors() { return this.outdoors; }
  public void setOutdoors(Map<String, Object> outdoors) { this.outdoors = outdoors; }

  public Map<String, Object> getParking() { return this.parking; }
  public void setParking(Map<String, Object> parking) { this.parking = parking; }

  public Map<String, Object> getPlaceOfWorship() { return this.placeOfWorship; }
  public void setPlaceOfWorship(Map<String, Object> placeOfWorship) { this.placeOfWorship = placeOfWorship; }

  public Map<String, Object> getPrison() { return this.prison; }
  public void setPrison(Map<String, Object> prison) { this.prison = prison; }

  public Map<String, Object> getPublic() { return this._public; }
  public void setPublic(Map<String, Object> _public) { this._public = _public; }

  public Map<String, Object> getPublicTransport() { return this.publicTransport; }
  public void setPublicTransport(Map<String, Object> publicTransport) { this.publicTransport = publicTransport; }

  public Map<String, Object> getResidence() { return this.residence; }
  public void setResidence(Map<String, Object> residence) { this.residence = residence; }

  public Map<String, Object> getRestaurant() { return this.restaurant; }
  public void setRestaurant(Map<String, Object> restaurant) { this.restaurant = restaurant; }

  public Map<String, Object> getSchool() { return this.school; }
  public void setSchool(Map<String, Object> school) { this.school = school; }

  public Map<String, Object> getShoppingArea() { return this.shoppingArea; }
  public void setShoppingArea(Map<String, Object> shoppingArea) { this.shoppingArea = shoppingArea; }

  public Map<String, Object> getStadium() { return this.stadium; }
  public void setStadium(Map<String, Object> stadium) { this.stadium = stadium; }

  public Map<String, Object> getStore() { return this.store; }
  public void setStore(Map<String, Object> store) { this.store = store; }

  public Map<String, Object> getStreet() { return this.street; }
  public void setStreet(Map<String, Object> street) { this.street = street; }

  public Map<String, Object> getTheater() { return this.theater; }
  public void setTheater(Map<String, Object> theater) { this.theater = theater; }

  public Map<String, Object> getTrain() { return this.train; }
  public void setTrain(Map<String, Object> train) { this.train = train; }

  public Map<String, Object> getTrainStation() { return this.trainStation; }
  public void setTrainStation(Map<String, Object> trainStation) { this.trainStation = trainStation; }

  public Map<String, Object> getTruck() { return this.truck; }
  public void setTruck(Map<String, Object> truck) { this.truck = truck; }

  public Map<String, Object> getUnderway() { return this.underway; }
  public void setUnderway(Map<String, Object> underway) { this.underway = underway; }

  public Map<String, Object> getUnknown() { return this.unknown; }
  public void setUnknown(Map<String, Object> unknown) { this.unknown = unknown; }

  public Map<String, Object> getWarehouse() { return this.warehouse; }
  public void setWarehouse(Map<String, Object> warehouse) { this.warehouse = warehouse; }

  public Map<String, Object> getWater() { return this.water; }
  public void setWater(Map<String, Object> water) { this.water = water; }

  public Map<String, Object> getWatercraft() { return this.watercraft; }
  public void setWatercraft(Map<String, Object> watercraft) { this.watercraft = watercraft; }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LocationType2 self = (LocationType2) o;
      return 
        Objects.equals(this.aircraft, self.aircraft) &&
        Objects.equals(this.airport, self.airport) &&
        Objects.equals(this.arena, self.arena) &&
        Objects.equals(this.automobile, self.automobile) &&
        Objects.equals(this.bank, self.bank) &&
        Objects.equals(this.bar, self.bar) &&
        Objects.equals(this.bicyle, self.bicyle) &&
        Objects.equals(this.bus, self.bus) &&
        Objects.equals(this.busStation, self.busStation) &&
        Objects.equals(this.cafe, self.cafe) &&
        Objects.equals(this.classroom, self.classroom) &&
        Objects.equals(this.club, self.club) &&
        Objects.equals(this.construction, self.construction) &&
        Objects.equals(this.conventionCenter, self.conventionCenter) &&
        Objects.equals(this.government, self.government) &&
        Objects.equals(this.hospital, self.hospital) &&
        Objects.equals(this.hotel, self.hotel) &&
        Objects.equals(this.industrial, self.industrial) &&
        Objects.equals(this.library, self.library) &&
        Objects.equals(this.motorcycle, self.motorcycle) &&
        Objects.equals(this.office, self.office) &&
        Objects.equals(this.other, self.other) &&
        Objects.equals(this.outdoors, self.outdoors) &&
        Objects.equals(this.parking, self.parking) &&
        Objects.equals(this.placeOfWorship, self.placeOfWorship) &&
        Objects.equals(this.prison, self.prison) &&
        Objects.equals(this._public, self._public) &&
        Objects.equals(this.publicTransport, self.publicTransport) &&
        Objects.equals(this.residence, self.residence) &&
        Objects.equals(this.restaurant, self.restaurant) &&
        Objects.equals(this.school, self.school) &&
        Objects.equals(this.shoppingArea, self.shoppingArea) &&
        Objects.equals(this.stadium, self.stadium) &&
        Objects.equals(this.store, self.store) &&
        Objects.equals(this.street, self.street) &&
        Objects.equals(this.theater, self.theater) &&
        Objects.equals(this.train, self.train) &&
        Objects.equals(this.trainStation, self.trainStation) &&
        Objects.equals(this.truck, self.truck) &&
        Objects.equals(this.underway, self.underway) &&
        Objects.equals(this.unknown, self.unknown) &&
        Objects.equals(this.warehouse, self.warehouse) &&
        Objects.equals(this.water, self.water) &&
        Objects.equals(this.watercraft, self.watercraft);
  }

  @Override
  public int hashCode() {
    return Objects.hash((Object)aircraft, (Object)airport, (Object)arena, (Object)automobile, (Object)bank, (Object)bar, (Object)bicyle, (Object)bus, (Object)busStation, (Object)cafe, (Object)classroom, (Object)club, (Object)construction, (Object)conventionCenter, (Object)government, (Object)hospital, (Object)hotel, (Object)industrial, (Object)library, (Object)motorcycle, (Object)office, (Object)other, (Object)outdoors, (Object)parking, (Object)placeOfWorship, (Object)prison, (Object)_public, (Object)publicTransport, (Object)residence, (Object)restaurant, (Object)school, (Object)shoppingArea, (Object)stadium, (Object)store, (Object)street, (Object)theater, (Object)train, (Object)trainStation, (Object)truck, (Object)underway, (Object)unknown, (Object)warehouse, (Object)water, (Object)watercraft);
  }

  @Override
  public String toString() {
    return "class LocationType2 {\n" +   
      "    aircraft: " + toIndentedString(aircraft) + "\n" +
      "    airport: " + toIndentedString(airport) + "\n" +
      "    arena: " + toIndentedString(arena) + "\n" +
      "    automobile: " + toIndentedString(automobile) + "\n" +
      "    bank: " + toIndentedString(bank) + "\n" +
      "    bar: " + toIndentedString(bar) + "\n" +
      "    bicyle: " + toIndentedString(bicyle) + "\n" +
      "    bus: " + toIndentedString(bus) + "\n" +
      "    busStation: " + toIndentedString(busStation) + "\n" +
      "    cafe: " + toIndentedString(cafe) + "\n" +
      "    classroom: " + toIndentedString(classroom) + "\n" +
      "    club: " + toIndentedString(club) + "\n" +
      "    construction: " + toIndentedString(construction) + "\n" +
      "    conventionCenter: " + toIndentedString(conventionCenter) + "\n" +
      "    government: " + toIndentedString(government) + "\n" +
      "    hospital: " + toIndentedString(hospital) + "\n" +
      "    hotel: " + toIndentedString(hotel) + "\n" +
      "    industrial: " + toIndentedString(industrial) + "\n" +
      "    library: " + toIndentedString(library) + "\n" +
      "    motorcycle: " + toIndentedString(motorcycle) + "\n" +
      "    office: " + toIndentedString(office) + "\n" +
      "    other: " + toIndentedString(other) + "\n" +
      "    outdoors: " + toIndentedString(outdoors) + "\n" +
      "    parking: " + toIndentedString(parking) + "\n" +
      "    placeOfWorship: " + toIndentedString(placeOfWorship) + "\n" +
      "    prison: " + toIndentedString(prison) + "\n" +
      "    public: " + toIndentedString(_public) + "\n" +
      "    publicTransport: " + toIndentedString(publicTransport) + "\n" +
      "    residence: " + toIndentedString(residence) + "\n" +
      "    restaurant: " + toIndentedString(restaurant) + "\n" +
      "    school: " + toIndentedString(school) + "\n" +
      "    shoppingArea: " + toIndentedString(shoppingArea) + "\n" +
      "    stadium: " + toIndentedString(stadium) + "\n" +
      "    store: " + toIndentedString(store) + "\n" +
      "    street: " + toIndentedString(street) + "\n" +
      "    theater: " + toIndentedString(theater) + "\n" +
      "    train: " + toIndentedString(train) + "\n" +
      "    trainStation: " + toIndentedString(trainStation) + "\n" +
      "    truck: " + toIndentedString(truck) + "\n" +
      "    underway: " + toIndentedString(underway) + "\n" +
      "    unknown: " + toIndentedString(unknown) + "\n" +
      "    warehouse: " + toIndentedString(warehouse) + "\n" +
      "    water: " + toIndentedString(water) + "\n" +
      "    watercraft: " + toIndentedString(watercraft) + "\n" +
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