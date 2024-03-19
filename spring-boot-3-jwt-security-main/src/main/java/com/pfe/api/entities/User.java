package com.pfe.api.entities;

import com.pfe.api.token.Token;
import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_user")
public class User implements UserDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String firstname;
  private String lastname;
  @Column(unique = true)
  private String email;
  private String password;
  private double note;

  public User(String firstname, String lastname, String email, String password, double note, Role role) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.email = email;
    this.password = password;
    this.note = note;
    this.role=role;
  }

  @OneToOne(mappedBy = "chefDepart")
  private Departement departement;


  @OneToMany(mappedBy = "teamleader")
  List<Competence> competences;

  @OneToMany
  List<Formation> formations;

  @OneToOne(mappedBy = "teamleader")
  private Team team;

  @ManyToMany(mappedBy = "employes")
  List<Team> teams;

  @Enumerated(EnumType.STRING)
  private Role role;

  @OneToMany(mappedBy = "user")
  private List<Token> tokens;

//  @Transient
//  private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//
//  public void setPassword(String password) {
//    // Crypter le mot de passe avant de le définir
//    this.password = passwordEncoder.encode(password);
//  }
  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return role.getAuthorities();
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
