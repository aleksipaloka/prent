package gr.hua.dit.ds.prent.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = "Username"),
        @UniqueConstraint(columnNames = "e-mail")})
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer SysPersonID;

    @NotBlank
    @Column
    private String Username;

    @NotBlank
    @Column
    private String personalPW;

    @NotBlank
    @Column
    private String e_mail;

    @NotBlank
    @Column
    private String Name;

    @NotBlank
    @Column
    private String Surname;


    @OneToOne
    @JoinTable(name = "Person_Roles",
        joinColumns = @JoinColumn(name = "SysPersonID"),
        inverseJoinColumns = @JoinColumn(name = "RoleID"))
    private Role role;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Property> property;

    public Person(Integer sysPersonID, String username, String personalPW, String e_mail, String name, String surname) {
        SysPersonID = sysPersonID;
        this.Username = username;
        this.personalPW = personalPW;
        this.e_mail = e_mail;
        Name = name;
        Surname = surname;
    }

    public Person() {

    }

    public Integer getSysPersonID() {
        return SysPersonID;
    }

    public void setSysPersonID(Integer sysPersonID) {
        SysPersonID = sysPersonID;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPersonalPW() {
        return personalPW;
    }

    public void setPersonalPW(String personalPW) {
        this.personalPW = personalPW;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public List<Property> getProperty() {
        return property;
    }

    public void setProperty(List<Property> property) {
        this.property = property;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Person{" +
                "SysPersonId=" + SysPersonID +
                ", Username='" + Username + '\'' +
                ", personalPW='" + personalPW + '\'' +
                ", e_mail='" + e_mail + '\'' +
                ", Name='" + Name + '\'' +
                ", Surname='" + Surname + '\'' +
                ", type='" + role + '\'' +
                ", property=" + property +
                '}';
    }
}
