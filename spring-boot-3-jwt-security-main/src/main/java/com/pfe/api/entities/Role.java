package com.pfe.api.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public enum Role {

  USER(Collections.emptySet()),
  ADMIN(
          Set.of(
//                  Permission.ADMIN_READ,
//                  Permission.ADMIN_UPDATE,
//                  Permission.ADMIN_DELETE,
//                  Permission.ADMIN_CREATE,
                  Permission.DEPARTEMENT_CHEF_READ,
                  Permission.DEPARTEMENT_CHEF_UPDATE,
                  Permission.DEPARTEMENT_CHEF_CREATE,
                  Permission.DEPARTEMENT_CHEF_DELETE,
                  Permission.DEPARTEMENT_CREATE,
                  Permission.DEPARTEMENT_DELETE,
                  Permission.DEPARTEMENT_READ,
                  Permission.DEPARTEMENT_UPDATE
          )
  ),

  TEAM_LEADER(
          Set.of(
                  Permission.COMPETENCE_READ,
                  Permission.COMPETENCE_UPDATE,
                  Permission.COMPETENCE_CREATE,
                  Permission.COMPETENCE_DELETE,
                  Permission.NOTATION_CREATE,
                  Permission.NOTATION_UPDATE,
                  Permission.NOTATION_READ,
                  Permission.NOTATION_DELETE,
                  Permission.CERTIF_READ,
                  Permission.FORMATION_READ,
                  Permission.FORMATION_CREATE,
                  Permission.FORMATION_UPDATE,
                  Permission.FORMATION_DELETE,
                  Permission.EMPLOYE_CREATE,
                  Permission.EMPLOYE_READ,
                  Permission.EMPLOYE_UPDATE,
                  Permission.EMPLOYE_DELETE

          )
  ),

  DEPARTEMENT_CHEF(
          Set.of(
                  Permission.TEAM_READ,
                  Permission.TEAM_UPDATE,
                  Permission.TEAM_CREATE,
                  Permission.TEAM_DELETE,
                  Permission.TEAMLEADER_READ,
                  Permission.TEAMLEADER_UPDATE,
                  Permission.TEAMLEADER_CREATE,
                  Permission.TEAMLEADER_DELETE
          )
  ),

  EMPLOYE(
          Set.of(
                  Permission.CERTIF_CREATE
          )
  )

  ;

  @Getter
  private final Set<Permission> permissions;

  public List<SimpleGrantedAuthority> getAuthorities() {
    var authorities = getPermissions()
            .stream()
            .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
            .collect(Collectors.toList());
    authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
    return authorities;
  }
//public List<SimpleGrantedAuthority> getAuthorities() {
//  return getPermissions()
//          .stream()
//          .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
//          .collect(Collectors.toList());
//}

}
