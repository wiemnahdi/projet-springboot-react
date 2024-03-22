package com.pfe.api.dao;

import java.util.List;
import java.util.Optional;

import com.pfe.api.entities.Role;
import com.pfe.api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

  Optional<User> findByEmail(String email);
  List<User> findAllByRole(Role role);
//  User findByUser_Role(Role role);
  User findUserByRole(Role role);

}
