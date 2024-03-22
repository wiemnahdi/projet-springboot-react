package com.pfe.api.service;

import com.pfe.api.dao.TeamDao;
import com.pfe.api.entities.Team;
import com.pfe.api.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    TeamDao teamDao;


    @Override
    public Team AjouterEquipe(Team team) {
        teamDao.save(team);
        return team;
    }

    @Override
    public void DeleteEquipe(Team team) {
        teamDao.delete(team);
    }

    @Override
    public void DeleteById(Integer id) {
        teamDao.deleteById(id);
    }

    @Override
    public List<Team> GetAllEquipes() {
        List<Team> teams = teamDao.findAll();
        return teams;
    }

    @Override
    public Team updateEquipe(Integer id, Team team) {
        Team existingTeam = teamDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("team introuvable"));
        existingTeam.setNomEquipe(team.getNomEquipe());
        return teamDao.save(existingTeam);
    }
}
