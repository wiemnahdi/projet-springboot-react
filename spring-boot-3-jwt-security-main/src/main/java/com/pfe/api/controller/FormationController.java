package com.pfe.api.controller;

import com.pfe.api.entities.Formation;
import com.pfe.api.service.FormationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/formation")
@PreAuthorize("hasRole('TEAM_LEADER')")
public class FormationController {
    @Autowired
    FormationService formationService;


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
    @PreAuthorize("hasAuthority('formation:read')")
    public String GetAllFormation(){
        return formationService.GetAllFormations();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('formation:create')")
    public Formation AjouterFormation (@RequestBody Formation formation){
        return formationService.AjouterFormation(formation);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('formation:read')")
    public Formation updateFormation(@RequestBody Formation formation){
        return formationService.updateFormation(formation);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('formation:delete')")
    public void DeleteFormation (@PathVariable ("id") Integer id){
        formationService.DeleteById(id);
    }
}
