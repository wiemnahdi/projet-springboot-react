package com.pfe.api.controller;

import com.pfe.api.auth.AuthenticationService;
import com.pfe.api.dao.UserDao;
import com.pfe.api.entities.Role;
import com.pfe.api.entities.User;
import com.pfe.api.exception.ResourceNotFoundException;
import com.pfe.api.service.UserService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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


    @GetMapping
    @PreAuthorize("hasAuthority('departementchef:read')")
    public List<User> get() {
        return userService.findAllByRole(DEPARTEMENT_CHEF);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('departementchef:create')")
    public User post(@RequestBody User user) {
        return userService.AjouterUser(user);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('departementchef:update')")
    public User put(@PathVariable("id") Integer id, @RequestBody User user) {
        return userService.modifierUser(user, id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('departementchef:delete')")
//    public String delete(@PathVariable("id") Integer id) {
//        userService.DeleteById(id);
//        return "ce chef de departement est supprimé";
//    }
    public Role delete(@PathVariable("id") Integer id, @AuthenticationPrincipal User user) {

//        System.out.println("Role of user: " + user.getRole());
        return user.getRole();
    }
//        User user1 = userService.findUserByRole(DEPARTEMENT_CHEF);
//        if (user.getRole().equals(DEPARTEMENT_CHEF)) {
//            userService.DeleteById(id);
//            return "User deleted successfully";
//        }
//        else {
//            return "User not found";
//        }
////        User existintUser = userService.findByRole1(DEPARTEMENT_CHEF);
////        if (existintUser.equals(DEPARTEMENT_CHEF)){
////            return "User deleted successfully";
////        }else{
////            return "User not found";
////        }
//
//
//        }
//}
//        final String DEPARTEMENT_CHEF = "DEPARTEMENT_CHEF";
//
//        // Ajoutez une instruction de débogage pour imprimer le rôle de l'utilisateur
//        System.out.println("Role of user: " + user.getRole());
//
//        if (user != null && user.getRole() != null) {
//            if (user.getRole().equals(DEPARTEMENT_CHEF)) {
//                if (userService != null) {
//                    userService.DeleteById(id);
//                    return "User deleted successfully";
//                } else {
//                    return "UserService is not initialized";
//                }
//            } else {
//                return "User does not have the required role";
//            }
//        } else {
//            return "User not found or role not defined";
//        }


   }
