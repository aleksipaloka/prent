package gr.hua.dit.ds.prent.Entities;

import jakarta.persistence.*;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer SysPersonId;

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

    public Person(Integer sysPersonId, String username, String personalPW, String e_mail, String name, String surname) {
        SysPersonId = sysPersonId;
        this.username = username;
        this.personalPW = personalPW;
        this.e_mail = e_mail;
        Name = name;
        Surname = surname;
    }

    public Person() {

    }
}
