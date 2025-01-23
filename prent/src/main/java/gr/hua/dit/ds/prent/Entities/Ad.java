package gr.hua.dit.ds.prent.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.sql.Date;
import java.time.LocalDate;

@Entity
public class  Ad {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long AdID;

    @NotBlank
    @Column
    private Date Release_Date;

    @NotBlank
    @Column
    private Date Last_Update;

    @Column
    private String Availability;

    @Column
    private String Comments;

    @NotBlank
    @Column
    private String Contact_Number;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "PropertyID")
    private Property property;


    public Ad(Date release_Date, Date last_Update, String availability, String comments, String contact_Number) {
        Release_Date = Date.valueOf(LocalDate.now());
        Last_Update = Date.valueOf(LocalDate.now());
        Availability = availability;
        Comments = comments;
        Contact_Number = contact_Number;
    }

    public Ad() {

    }

    public Long getAdID() {
        return AdID;
    }

    public void setAdID(Long adID) {
        AdID = adID;
    }

    public Date getRelease_Date() {
        return Release_Date;
    }

    public void setRelease_Date(Date release_Date) {
        Release_Date = release_Date;
    }

    public Date getLast_Update() {
        return Last_Update;
    }

    public void setLast_Update(Date last_Update) {
        Last_Update = last_Update;
    }

    public String getAvailability() {
        return Availability;
    }

    public void setAvailability(String availability) {
        Availability = availability;
    }

    public String getComments() {
        return Comments;
    }

    public void setComments(String comments) {
        Comments = comments;
    }

    public String getContact_Number() {
        return Contact_Number;
    }

    public void setContact_Number(String contact_Number) {
        Contact_Number = contact_Number;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    @Override
    public String toString() {
        return "Ad{" +
                "AdId=" + AdID +
                ", Release_Date=" + Release_Date +
                ", Last_Update=" + Last_Update +
                ", Availability='" + Availability + '\'' +
                ", Comments='" + Comments + '\'' +
                ", Contact_Number=" + Contact_Number +
                ", property=" + property +
                '}';
    }
}



