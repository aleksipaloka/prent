package gr.hua.dit.ds.prent.Entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class  Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer AdId;

    @Column
    private Integer PropertyId;

    @Column
    private Date Release_Date;

    @Column
    private Date Last_Update;

    @Column
    private String Availability;

    @Column
    private String Comments;

    @Column
    private Integer Contact_Number;

    @Column
    private Integer OwnerId;

    @Column
    private Integer views;


    public Ad(Integer adId, Integer propertyId, Date release_Date, Date last_Update, String availability, String comments, Integer contact_Number, Integer ownerId, Integer views) {
        AdId = adId;
        PropertyId = propertyId;
        Release_Date = release_Date;
        Last_Update = last_Update;
        Availability = availability;
        Comments = comments;
        Contact_Number = contact_Number;
        OwnerId = ownerId;
        this.views = views;
    }

    public Ad() {

    }
}
