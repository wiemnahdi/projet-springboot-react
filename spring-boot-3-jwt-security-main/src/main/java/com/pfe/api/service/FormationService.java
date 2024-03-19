package com.pfe.api.service;

import com.pfe.api.entities.Departement;
import com.pfe.api.entities.Formation;

import java.util.List;

public interface FormationService {

    Formation AjouterFormation(Formation formation);
    void DeleteFormation(Formation formation);

    void DeleteById(Integer id);

    String GetAllFormations();
    Formation updateFormation(Formation formation);
}
