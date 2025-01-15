package gr.hua.dit.ds.prent;

import jakarta.persistence.*;

@Entity
public class Tenant extends Person{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer TenantId;

}
