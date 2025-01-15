package gr.hua.dit.ds.prent.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;

@Entity
@Inheritance
public class Building extends Property {

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

    public Building(Integer propertyId, Float price, Float price_per_m2, String additional_info, String location, Float size, String type) {
        super(propertyId, price, price_per_m2, additional_info, location, size, type);
    }

    public Building() {
        super();
    }
}
