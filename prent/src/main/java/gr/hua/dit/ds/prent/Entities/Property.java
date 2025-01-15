package gr.hua.dit.ds.prent.Entities;

import jakarta.persistence.*;

@Entity
public class Property{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer PropertyId;

    @Column
    private Float Price;

    @Column
    private Float Price_per_m2;

    @Column
    private String Additional_info;

    @Column
    private String Location;

    @Column
    private Float Size;

    @Column
    private String Type;

    public Property(Integer propertyId, Float price, Float price_per_m2, String additional_info, String location, Float size, String type) {
        PropertyId = propertyId;
        Price = price;
        Price_per_m2 = price_per_m2;
        Additional_info = additional_info;
        Location = location;
        Size = size;
        Type = type;
    }

    public Property() {

    }
}