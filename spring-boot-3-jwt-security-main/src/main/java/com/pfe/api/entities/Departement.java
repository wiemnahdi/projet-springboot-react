package com.pfe.api.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Departement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nomDepart;
    @OneToOne
    private User chefDepart;
    @OneToMany(mappedBy = "departement")
    List<Team> teams;


    public Departement(Integer id, String nomDepart) {
        this.id=id;
        this.nomDepart=nomDepart;
    }
}
