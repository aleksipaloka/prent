package gr.hua.dit.ds.prent.Entities;

import jakarta.persistence.*;
import org.springframework.data.annotation.Reference;

@Entity
public class Building {

    @Id
    @Column
    private Long BuildingID;


    @Column
    private Integer Floor;

    @Column
    private Integer Construction_Year;

    @Column
    private Integer Renovation_Year;

    @Column
    private Integer Layers;

    @Column
    private Integer Kitchens;

    @Column
    private Integer Bathrooms;

    @Column
    private Integer Living_Rooms;

    @Column
    private Integer Bedrooms;

    @Column
    private String Heat_System;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PropertyId")
    private Property property;

    public Building(Integer floor, Integer construction_Year, Integer renovation_Year, Integer layers, Integer kitchens, Integer bathrooms, Integer living_Rooms, Integer bedrooms, String heat_System) {
        Floor = floor;
        Construction_Year = construction_Year;
        Renovation_Year = renovation_Year;
        Layers = layers;
        Kitchens = kitchens;
        Bathrooms = bathrooms;
        Living_Rooms = living_Rooms;
        Bedrooms = bedrooms;
        Heat_System = heat_System;
    }

    public Building() {

    }

    public Long getBuildingID() {
        return BuildingID;
    }

    public void setBuildingID(Long buildingID) {
        BuildingID = buildingID;
    }

    public Integer getFloor() {
        return Floor;
    }

    public void setFloor(Integer floor) {
        Floor = floor;
    }

    public Integer getConstruction_Year() {
        return Construction_Year;
    }

    public void setConstruction_Year(Integer construction_Year) {
        Construction_Year = construction_Year;
    }

    public Integer getRenovation_Year() {
        return Renovation_Year;
    }

    public void setRenovation_Year(Integer renovation_Year) {
        Renovation_Year = renovation_Year;
    }

    public Integer getLayers() {
        return Layers;
    }

    public void setLayers(Integer layers) {
        Layers = layers;
    }

    public Integer getKitchens() {
        return Kitchens;
    }

    public void setKitchens(Integer kitchens) {
        Kitchens = kitchens;
    }

    public Integer getBathrooms() {
        return Bathrooms;
    }

    public void setBathrooms(Integer bathrooms) {
        Bathrooms = bathrooms;
    }

    public Integer getLiving_Rooms() {
        return Living_Rooms;
    }

    public void setLiving_Rooms(Integer living_Rooms) {
        Living_Rooms = living_Rooms;
    }

    public Integer getBedrooms() {
        return Bedrooms;
    }

    public void setBedrooms(Integer bedrooms) {
        Bedrooms = bedrooms;
    }

    public String getHeat_System() {
        return Heat_System;
    }

    public void setHeat_System(String heat_System) {
        Heat_System = heat_System;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    @Override
    public String toString() {
        return "Building{" +
                "Floor=" + Floor +
                ", Construction_Year=" + Construction_Year +
                ", Renovation_Year=" + Renovation_Year +
                ", Layers=" + Layers +
                ", Kitchens=" + Kitchens +
                ", Bathrooms=" + Bathrooms +
                ", Living_Rooms=" + Living_Rooms +
                ", Bedrooms=" + Bedrooms +
                ", Heat_System='" + Heat_System + '\'' +
                ", property=" + property +
                '}';
    }
}

