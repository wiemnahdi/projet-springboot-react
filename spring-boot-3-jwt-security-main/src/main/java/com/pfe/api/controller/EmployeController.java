package com.pfe.api.controller;

import com.pfe.api.entities.User;
import com.pfe.api.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.pfe.api.entities.Role.EMPLOYE;

@RestController
@RequestMapping("/api/v1/employe")
@PreAuthorize("hasRole('TEAM_LEADER')")
public class EmployeController {

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
    @PreAuthorize("hasAuthority('employe:read')")
    public List<User> get() {
        List<User> users = userService.findAllByRole(EMPLOYE);
        return users;
    }
    @PostMapping
    @PreAuthorize("hasAuthority('employe:create')")

    public User post(@RequestBody User user) {
        return userService.AjouterUser(user);
    }
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('employe:update')")
    public User put(@PathVariable("id") Integer id, @RequestBody User user) {
        return userService.modifierUser(user, id);
    }
    @DeleteMapping
    @PreAuthorize("hasAuthority('employe:delete')")
    public String delete() {
        return "DELETE:: Delete a employe";
    }

}
