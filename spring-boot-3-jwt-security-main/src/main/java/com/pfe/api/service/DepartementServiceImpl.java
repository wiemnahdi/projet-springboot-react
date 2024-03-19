package com.pfe.api.service;

import com.pfe.api.dao.DepartementDao;
import com.pfe.api.entities.Departement;
import com.pfe.api.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartementServiceImpl implements DepartementService {

    @Autowired
    DepartementDao departementDao;

    @Override
    public Departement AjouterDepart(Departement departement) {
        departementDao.save(departement);
        return departement;
    }

    @Override
    public void DeleteDepart(Departement departement) {
        departementDao.delete(departement);
    }

    @Override
    public void DeleteById(Integer id) {
        departementDao.deleteById(id);
    }

    @Override
    public List<Departement> GetAllDeparts() {
        List<Departement> list = departementDao.findAll();
        return list;
    }


    @Override
    public Departement updateDepartement(Departement departement, Integer id) {
        Departement existingDepartement = departementDao.findById(id).orElseThrow(()-> new ResourceNotFoundException("departement introuvable"));
        existingDepartement.setNomDepart(departement.getNomDepart());
        return departementDao.save(existingDepartement);
    }

}

