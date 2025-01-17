package gr.hua.dit.ds.prent.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Property{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer PropertyID;

    @NotBlank
    @Column
    private Double Price;

    @Column
    private Float Price_per_m2;

    @Column
    private String Additional_info;

    @NotBlank
    @Column
    private String Location;

    @NotBlank
    @Column
    private Double Size;

    @NotBlank
    @Column
    private String Property_Type;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "SysPersonID")
    private Person owner;

    @OneToOne(mappedBy = "property", cascade = CascadeType.ALL)
    private Building building;

    @OneToOne(mappedBy = "property", cascade = CascadeType.ALL)
    private Ad ad;

    public Property() {
    }

    public Property(Double price, Float price_per_m2, String additional_info, String location, Double size, String property_Type) {
        Price = price;
        Price_per_m2 = price_per_m2;
        Additional_info = additional_info;
        Location = location;
        Size = size;
        Property_Type = property_Type;
    }

    public Integer getPropertyID() {
        return PropertyID;
    }

    public void setPropertyID(Integer propertyID) {
        PropertyID = propertyID;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
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

    public Double getSize() {
        return Size;
    }

    public void setSize(Double size) {
        Size = size;
    }

    public String getProperty_Type() {
        return Property_Type;
    }

    public void setProperty_Type(String property_Type) {
        Property_Type = property_Type;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Ad getAd() {
        return ad;
    }

    public void setAd(Ad ad) {
        this.ad = ad;
    }

    @Override
    public String toString() {
        return "Property{" +
                "PropertyID=" + PropertyID +
                ", Price=" + Price +
                ", Price_per_m2=" + Price_per_m2 +
                ", Additional_info='" + Additional_info + '\'' +
                ", Location='" + Location + '\'' +
                ", Size=" + Size +
                ", Property_Type='" + Property_Type + '\'' +
                ", owner=" + owner +
                ", building=" + building +
                ", ad=" + ad +
                '}';
    }
}