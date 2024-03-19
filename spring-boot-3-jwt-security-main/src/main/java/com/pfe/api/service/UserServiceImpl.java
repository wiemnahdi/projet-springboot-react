package com.pfe.api.service;

import com.pfe.api.dao.UserDao;
import com.pfe.api.entities.ChangePasswordRequest;
import com.pfe.api.entities.Role;
import com.pfe.api.entities.User;
import com.pfe.api.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    private final PasswordEncoder passwordEncoder;
    private final UserDao repository;
    public void changePassword(ChangePasswordRequest request, Principal connectedUser) {

        var user = (User) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();

        // check if the current password is correct
        if (!passwordEncoder.matches(request.getCurrentPassword(), user.getPassword())) {
            throw new IllegalStateException("Wrong password");
        }
        // check if the two new passwords are the same
        if (!request.getNewPassword().equals(request.getConfirmationPassword())) {
            throw new IllegalStateException("Password are not the same");
        }

        // update the password
        user.setPassword(passwordEncoder.encode(request.getNewPassword()));

        // save the new password
        repository.save(user);
    }

    @Override
    public User AjouterUser(User user) {
        User savedUser = new User();
        savedUser.setFirstname(user.getFirstname());
        savedUser.setLastname(user.getLastname());
        savedUser.setEmail(user.getEmail());
        savedUser.setPassword(user.getPassword());
        savedUser.setNote(user.getNote());
        savedUser.setRole(user.getRole());
        return userDao.save(savedUser);

    }

 @Override
    public User modifierUser(User user, Integer id) {
        User existingUser = userDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("utilisateur introuvable"));

        existingUser.setFirstname(user.getFirstname());
        existingUser.setLastname(user.getLastname());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        existingUser.setNote(user.getNote());
     if (user.getRole() != null) {
         existingUser.setRole(user.getRole());
     }

     return userDao.save(existingUser);
 }




    @Override
    public void DeleteById(Integer id) {
        User existingUser = userDao.findById(id).orElseThrow(()-> new ResourceNotFoundException("utilisateur introuvable"));
        userDao.delete(existingUser);
    }

    @Override
    public List<User> GetAllUsers() {
        return (List<User>) userDao.findAll();
    }

    @Override
    public List<User> findByRole(Role role) throws ResourceNotFoundException {
        List <User> users = userDao.findByRole(role);
        if (users.isEmpty()){
            throw new ResourceNotFoundException("Aucun utilisateur trouvé par ce role : " + role);
         }
        return users;
    }






}
