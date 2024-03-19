package com.pfe.api.service;

import com.pfe.api.entities.Role;
import com.pfe.api.entities.User;

import java.util.List;

public interface UserService {
    User AjouterUser(User user);


    void DeleteById(Integer id);
    List<User> GetAllUsers();
    List<User> findByRole(Role role);


    User modifierUser(User user, Integer id);
}
