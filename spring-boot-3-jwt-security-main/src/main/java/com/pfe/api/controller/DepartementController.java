package com.pfe.api.controller;

import com.pfe.api.dao.DepartementDao;
import com.pfe.api.entities.Departement;
import com.pfe.api.service.DepartementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/departement")
@PreAuthorize("hasRole('ADMIN')")
public class DepartementController {
    @Autowired
    DepartementService departementService;
    @Autowired
    DepartementDao departementDao;



    @Operation(
            description = "Get endpoint for admin",
            summary = "This is a summary for departement get endpoint",
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
    @PreAuthorize("hasAuthority('departement:read')")
    public List<Departement> GetAllDepartements(){
        List<Departement> departements = departementService.GetAllDeparts();
        return departements;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('departement:create')")
    public Departement AjouterDepartement (@RequestBody Departement departement){
        return departementService.AjouterDepart(departement);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('departement:update')")
    public Departement updateDepartement(@PathVariable("id") Integer id ,@RequestBody Departement departement){

        return departementService.updateDepartement(departement, id);
    }
//    public Departement replaceDepartement (@RequestBody Departement newDepartement, @PathVariable("id") Integer id){
//        return departementDao.findById(id)
//                .map(departement -> {
//                    departement.setNomDepart(newDepartement.getNomDepart());
//                    return departementDao.save(departement);
//                })
//                .orElseGet(() -> {
//                    return departementDao.save(newDepartement);
//                });
//    }

//    public ResponseEntity<DepartementDto> updateDepartement(@PathVariable("id") Integer id, @RequestBody DepartementDto updateDeparetement){
//        DepartementDto departementDto = departementService.updateDepartement(id, updateDeparetement);
//        return ResponseEntity.ok(departementDto);
//    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('departement:delete')")
    public String DeleteDepartemnt (@PathVariable ("id") Integer id){
        departementService.DeleteById(id);
        return "delete with successfully";
    }

}
