package com.pfe.api.dao;

import com.pfe.api.entities.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormationDao extends JpaRepository<Formation,Integer> {
}
