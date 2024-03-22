package com.pfe.api.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {

    TEAMLEADER_READ("teamleader:read"),
    TEAMLEADER_UPDATE("teamleader:update"),
    TEAMLEADER_CREATE("teamleader:create"),
    TEAMLEADER_DELETE("teamleader:delete"),
//    MANAGER_READ("management:read"),
//    MANAGER_UPDATE("management:update"),
//    MANAGER_CREATE("management:create"),
//    MANAGER_DELETE("management:delete"),
    TEAM_READ("team:read"),
    TEAM_UPDATE("team:update"),
    TEAM_CREATE("team:create"),
    TEAM_DELETE("team:delete"),
    EMPLOYE_READ("employe:read"),
    EMPLOYE_UPDATE("employe:update"),
    EMPLOYE_CREATE("employe:create"),
    EMPLOYE_DELETE("employe:delete"),
    DEPARTEMENT_READ("departement:read"),
    DEPARTEMENT_UPDATE("departement:update"),
    DEPARTEMENT_CREATE("departement:create"),
    DEPARTEMENT_DELETE("departement:delete"),
    DEPARTEMENT_CHEF_READ("departementchef:read"),
    DEPARTEMENT_CHEF_UPDATE("departementchef:update"),
    DEPARTEMENT_CHEF_CREATE("departementchef:create"),
    DEPARTEMENT_CHEF_DELETE("departementchef:delete"),
    CERTIF_READ("certif:read"),
    CERTIF_CREATE("certif:create"),
    CERTIF_UPDATE("certif:update"),
    CERTIF_DELETE("certif:delete"),
    NOTATION_CREATE("notation:create"),
    NOTATION_READ("notation:read"),
    NOTATION_UPDATE("notation:update"),
    NOTATION_DELETE("notation:delete"),
    COMPETENCE_CREATE("competence:create"),
    COMPETENCE_READ("competence:read"),
    COMPETENCE_UPDATE("competence:update"),
    COMPETENCE_DELETE("competence:delete"),
    FORMATION_CREATE("formation:create"),
    FORMATION_READ("formation:read"),
    FORMATION_UPDATE("formation:update"),
    FORMATION_DELETE("formation:delete")
;

    @Getter
    private final String permission;
}
