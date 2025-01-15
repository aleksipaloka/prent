package gr.hua.dit.ds.prent;

import jakarta.persistence.*;


public class Person {

    @Column
    private String username;

    @Column
    private String personalPW;

    @Column
    private String e_mail;

    @Column
    private String Name;

    @Column
    private String Surname;
}
