package com.pfe.api.dao;

import com.pfe.api.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamDao extends JpaRepository<Team,Integer> {
}
