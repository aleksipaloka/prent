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

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "SysPersonID")
    private Person owner;

    @OneToOne(mappedBy = "property", cascade = CascadeType.ALL)
    private Building building;

    @OneToOne(mappedBy = "property", cascade = CascadeType.ALL)
    private Ad ad;

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

    public Integer getPropertyId() {
        return PropertyId;
    }

    public void setPropertyId(Integer propertyId) {
        PropertyId = propertyId;
    }

    public Float getPrice() {
        return Price;
    }

    public void setPrice(Float price) {
        Price = price;
    }

    public Float getPrice_per_m2() {
        return Price_per_m2;
    }

    public void setPrice_per_m2(Float price_per_m2) {
        Price_per_m2 = price_per_m2;
    }

    public String getAdditional_info() {
        return Additional_info;
    }

    public void setAdditional_info(String additional_info) {
        Additional_info = additional_info;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public Float getSize() {
        return Size;
    }

    public void setSize(Float size) {
        Size = size;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}