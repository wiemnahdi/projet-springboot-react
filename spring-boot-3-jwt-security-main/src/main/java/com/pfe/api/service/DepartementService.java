package com.pfe.api.service;

import com.pfe.api.entities.Departement;

import java.util.List;

public interface DepartementService {

    Departement AjouterDepart(Departement departement);
    void DeleteDepart(Departement departement);
    void DeleteById(Integer id);
    List<Departement> GetAllDeparts();
    Departement updateDepartement(Departement departement, Integer id);
}
