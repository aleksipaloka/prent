package gr.hua.dit.ds.prent.Entities;

import jakarta.persistence.*;
import org.springframework.data.annotation.Reference;

@Entity
public class Building {

    @Id
    @Column
    private Integer BuildingID;


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

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PropertyId")
    private Property property;



    public Building() {
        super();
    }

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
}
