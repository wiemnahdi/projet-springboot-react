package com.pfe.api.controller;

import com.pfe.api.entities.Team;
import com.pfe.api.service.TeamService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/team")
@PreAuthorize("hasRole('DEPARTEMENT_CHEF')")
public class TeamController {
    @Autowired
    TeamService teamService;

    @Operation(
            description = "Get endpoint for departement chef",
            summary = "This is a summary for team get endpoint",
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
    @PreAuthorize("hasAuthority('team:read')")
    public List<Team> GetAllEquipes(){
        List<Team> teams = teamService.GetAllEquipes();
        return teams;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('team:create')")
    public Team AjouterEquipe (@RequestBody Team team){
        return teamService.AjouterEquipe(team);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('team:read')")
    public Team updateEquipe(@PathVariable("id") Integer id, @RequestBody Team team){
        return teamService.updateEquipe(id, team);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('team:delete')")
    public String DeleteEquipe (@PathVariable ("id") Integer id){
        teamService.DeleteById(id);
        return "delete with successfully";
    }

}
