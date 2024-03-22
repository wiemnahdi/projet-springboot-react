package com.pfe.api.controller;

import com.pfe.api.entities.Role;
import com.pfe.api.entities.User;
import com.pfe.api.service.UserService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.pfe.api.entities.Role.TEAM_LEADER;

@RestController
@RequestMapping("/api/v1/teamleader")
@PreAuthorize("hasRole('DEPARTEMENT_CHEF')")
public class TeamLeaderController {

    @Autowired
    UserService userService;

    @Operation(
            description = "Get endpoint for departement chef",
            summary = "This is a summary for team leader get endpoint",
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
    @PreAuthorize("hasAuthority('teamleader:read')")
    public List<User> get() {
        List<User> users = userService.findAllByRole(TEAM_LEADER);
        return users;
    }
    @PostMapping
    @PreAuthorize("hasAuthority('teamleader:create')")
    public User post(@RequestBody User user) {
        return userService.AjouterUser(user) ;
    }
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('teamleader:update')")
    public User put(@PathVariable("id") Integer id, @RequestBody User user) {
        return userService.modifierUser(user, id);
    }
    @DeleteMapping
    @PreAuthorize("hasAuthority('teamleader:delete')")
    public String delete() {
        return "DELETE:: Delete a teamleader";
    }



}
