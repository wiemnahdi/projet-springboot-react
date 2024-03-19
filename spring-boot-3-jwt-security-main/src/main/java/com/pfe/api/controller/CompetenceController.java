package com.pfe.api.controller;


import com.pfe.api.entities.Competence;
import com.pfe.api.entities.Departement;
import com.pfe.api.service.CompetenceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/competence")
@PreAuthorize("hasRole('TEAM_LEADER')")
public class CompetenceController {

    @Autowired
    CompetenceService competenceService;


    @Operation(
            description = "Get endpoint for teamleader",
            summary = "This is a summary for competence get endpoint",
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
    @PreAuthorize("hasAuthority('competence:read')")
    public String GetAllCompetences(){
        return competenceService.GetAllCompetences();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('competence:create')")
    public Competence AjouterCompetence (@RequestBody Competence competence){
        return competenceService.AjouterCompetence(competence);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('competence:read')")
    public Competence updateCompetence(@RequestBody Competence competence){
        return competenceService.updateCompetence(competence);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('competence:delete')")
    public void DeleteCompetence (@PathVariable ("id") Integer id){
        competenceService.DeleteById(id);
    }






}
