package com.pfe.api.service;

import com.pfe.api.dao.TeamDao;
import com.pfe.api.entities.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    TeamDao equipeDao;


    @Override
    public Team AjouterEquipe(Team team) {
        equipeDao.save(team);
        return team;
    }

    @Override
    public void DeleteEquipe(Team team) {
        equipeDao.delete(team);
    }

    @Override
    public void DeleteById(Integer id) {
        equipeDao.deleteById(id);
    }

    @Override
    public String GetAllEquipes() {
        List<Team> teams = equipeDao.findAll();
        return "Liste des équipes";
    }

    @Override
    public Team updateEquipe(Team team) {
        return team;
    }
}
