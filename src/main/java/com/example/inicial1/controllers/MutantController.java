package com.example.inicial1.controllers;

import com.example.inicial1.dtos.MutantRequest;
import com.example.inicial1.dtos.MutantResponse;
import com.example.inicial1.dtos.StatsResponse;
import com.example.inicial1.services.MutantService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mutant")
public class MutantController {

    private final MutantService mutantService;

    // Constructor para inyectar el servicio
    public MutantController(MutantService dnaService) {
        this.mutantService = dnaService;
    }

    @PostMapping
    public ResponseEntity<MutantResponse> checkMutant(@Valid @RequestBody MutantRequest dnaRequest) {
        boolean isMutant = mutantService.analyzeDna(dnaRequest.getDna());
        MutantResponse dnaResponse = new MutantResponse(isMutant);

        if (isMutant) {
            // Devuelve la respuesta con el objeto DnaResponse
            return ResponseEntity.status(HttpStatus.OK).body(dnaResponse);
        } else {
            // Devuelve la respuesta con el objeto DnaResponse
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(dnaResponse);
        }

    }

    @GetMapping
    public ResponseEntity<String> testEndpoint() {
        return ResponseEntity.ok("El endpoint /mutant está funcionando");
    }
}
