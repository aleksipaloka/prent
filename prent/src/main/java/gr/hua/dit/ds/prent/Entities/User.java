package gr.hua.dit.ds.prent.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = "Username"),
        @UniqueConstraint(columnNames = "e-mail")})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long Id;

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


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "User_Roles",
        joinColumns = @JoinColumn(name = "Id"),
        inverseJoinColumns = @JoinColumn(name = "RoleID"))
    private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Property> property;

    public User(String username, String personalPW, String e_mail, String name, String surname) {
        this.Username = username;
        this.personalPW = personalPW;
        this.e_mail = e_mail;
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
                ", Username='" + Username + '\'' +
                ", personalPW='" + personalPW + '\'' +
                ", e_mail='" + e_mail + '\'' +
                ", Name='" + Name + '\'' +
                ", Surname='" + Surname + '\'' +
                ", property=" + property +
                '}';
    }
}
