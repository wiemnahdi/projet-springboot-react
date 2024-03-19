package com.pfe.api.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nomEquipe;
    private Date dateCreation;
    @ManyToOne
    private Departement departement;
    @OneToOne
    private User teamleader;
    @ManyToMany
    List<User> employes;
}
