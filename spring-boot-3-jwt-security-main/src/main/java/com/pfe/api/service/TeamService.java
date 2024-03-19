package com.pfe.api.service;

import com.pfe.api.entities.Team;

public interface TeamService {
    Team AjouterEquipe(Team team);
    void DeleteEquipe(Team team);

    void DeleteById(Integer id);

    String GetAllEquipes();
    Team updateEquipe(Team team);
}
