package com.pfe.api.service;

import com.pfe.api.dao.FormationDao;
import com.pfe.api.entities.Formation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormationServiceImpl implements FormationService{

    @Autowired
    FormationDao formationDao;

    @Override
    public Formation AjouterFormation(Formation formation) {
        formationDao.save(formation);
        return formation;
    }

    @Override
    public void DeleteFormation(Formation formation) {
        formationDao.delete(formation);
    }

    @Override
    public void DeleteById(Integer id) {
        formationDao.deleteById(id);
    }

    @Override
    public String GetAllFormations() {
       List<Formation> formations = formationDao.findAll();
        return "Liste des formations";
    }

    @Override
    public Formation updateFormation(Formation formation) {
        return formation;
    }
}
