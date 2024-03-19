package com.pfe.api.dao;

import com.pfe.api.entities.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartementDao extends JpaRepository<Departement,Integer> {
}
