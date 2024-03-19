package com.pfe.api.service;

import com.pfe.api.entities.Competence;
import com.pfe.api.entities.Departement;

public interface CompetenceService {

    Competence AjouterCompetence(Competence competence);
    void DeleteCompetence(Competence competence);
    void DeleteById(Integer id);
    String GetAllCompetences();
    Competence updateCompetence(Competence competence);
}
