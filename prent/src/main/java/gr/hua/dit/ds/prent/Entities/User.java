package gr.hua.dit.ds.prent.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users",
        uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long Id;

    @NotBlank
    private String username;

    @NotBlank
    private String personalPW;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String Name;

    @NotBlank
    private String Surname;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "User_Roles",
        joinColumns = @JoinColumn(name = "UserId"),
        inverseJoinColumns = @JoinColumn(name = "RoleID"))
    private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Property> property;

    public User(String username, String personalPW, String e_mail, String name, String surname) {
        this.username = username;
        this.personalPW = personalPW;
        this.email = e_mail;
        Name = name;
        Surname = surname;
    }

    public User() {

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        Id = Id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPersonalPW() {
        return personalPW;
    }

    public void setPersonalPW(String personalPW) {
        this.personalPW = personalPW;
    }

    public String getE_mail() {
        return email;
    }

    public void setE_mail(String e_mail) {
        this.email = e_mail;
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

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    public Set<Role> getRoles() {
        return roles;
    }
    @Override
    public String toString() {
        return "Person{" +
                "SysPersonId=" + Id +
                ", Username='" + username + '\'' +
                ", e_mail='" + email + '\'' +
                ", Name='" + Name + '\'' +
                ", Surname='" + Surname + '\'' +
                '}';
    }
}
