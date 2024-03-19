package com.pfe.api.service;

import com.pfe.api.dao.CompetenceDao;
import com.pfe.api.entities.Competence;
import com.pfe.api.entities.Departement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetenceServiceImpl implements CompetenceService{

    @Autowired
    CompetenceDao competenceDao;

    @Override
    public Competence AjouterCompetence(Competence competence) {
        competenceDao.save(competence);
        return competence;
    }

    @Override
    public void DeleteCompetence(Competence competence) {
        competenceDao.delete(competence);
    }

    @Override
    public void DeleteById(Integer id) {
        competenceDao.deleteById(id);
    }

    @Override
    public String GetAllCompetences() {
        List<Competence> competences = competenceDao.findAll();
        return "Liste des départements";
    }

    @Override
    public Competence updateCompetence(Competence competence) {
        return competence;
    }
}
