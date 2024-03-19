package com.pfe.api.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "competence")
public class Competence {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer idCompetance;
        private String titre;
        private Date dateCreation;
        @ManyToOne
        private User teamleader;
}
