package com.pfe.api.service;

import com.pfe.api.entities.Team;

import java.util.List;

public interface TeamService {
    Team AjouterEquipe(Team team);
    void DeleteEquipe(Team team);

    void DeleteById(Integer id);

    List<Team> GetAllEquipes();
    Team updateEquipe(Integer id, Team team);
}
