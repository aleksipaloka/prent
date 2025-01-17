package gr.hua.dit.ds.prent.Entities;

import jakarta.persistence.*;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer RoleId;

    @Column
    private String name;

    public Role(String name) {
        this.name = name;
    }

    public Role() {

    }

    public Integer getRoleId() {
        return RoleId;
    }

    public void setRoleId(Integer RoleId) {
        RoleId = RoleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
