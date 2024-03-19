package com.pfe.api.controller;

import com.pfe.api.auth.AuthenticationService;
import com.pfe.api.dao.UserDao;
import com.pfe.api.entities.User;
import com.pfe.api.exception.ResourceNotFoundException;
import com.pfe.api.service.UserService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.pfe.api.entities.Role.DEPARTEMENT_CHEF;

@RestController
@RequestMapping("/api/v1/departementchef")
@PreAuthorize("hasRole('ADMIN')")
public class ChefDepartController {
    @Autowired
    UserService userService;

    @Operation(
            description = "Get endpoint for admin",
            summary = "This is a summary for departement chef get endpoint",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Unauthorized / Invalid Token",
                            responseCode = "403"
                    )
            }

    )


//    @GetMapping
//    @PreAuthorize("hasAuthority('chefdepartement:read')")
//    public String get() {
//        return "GET:: Retrieve all departments chef";
//    }
//    @PostMapping
//    @PreAuthorize("hasAuthority('chefdepartement:create')")
//    public String post() {
//        return "POST::  Create a new department chef";
//    }
    @GetMapping
    @PreAuthorize("hasAuthority('chefdepartement:read')")
//    public List<User> get(){
//        List<User> users = userService.findByRole(DEPARTEMENT_CHEF);
//        return users;
//    }
    public List<User> get(){
        return  userService.findByRole(DEPARTEMENT_CHEF);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('chefdepartement:create')")
    public User post (@RequestBody User user){
        return userService.AjouterUser(user);
    }
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('chefdepartementchef:update')")
    public User put (@PathVariable("id") Integer id, @RequestBody User user){
        return userService.modifierUser(user, id);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('chefdepartementchef:delete')")
//    public String delete(@PathVariable("id") Integer id) {
//        userService.DeleteById(id);
//        return "ce chef de departement est supprimé";
//    }
    public void delete(@PathVariable("id") Integer id){
        userService.DeleteById(id);
//        return "User deleted successfully";
    }





}
