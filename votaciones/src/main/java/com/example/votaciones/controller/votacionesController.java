package com.example.votaciones.controller;

import com.example.votaciones.dto.Votante.VotanteDTO;
import com.example.votaciones.model.Votante.VotanteModel;
import com.example.votaciones.service.VotacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/votacion")
@RequiredArgsConstructor
public class votacionesController {
    private final VotacionService votacionService;

    @GetMapping("/health")
    public ResponseEntity<String> webAlive() {
        return ResponseEntity.ok("Service is up and running");
    }

    @GetMapping("/getVotante")
    public ResponseEntity<Object> getVotante(String id){
        long idVotante = Long.parseLong(id);
        VotanteModel votante = votacionService.getVotante(idVotante);
        return ResponseEntity.ok(votante);
    }
    @PostMapping("/registerVotante")
    public ResponseEntity<Object> resgisterVotante(@RequestBody VotanteDTO dtoVotante){
        VotanteModel newVotante = votacionService.registerVotante(dtoVotante);
        return ResponseEntity.ok("Votante " + String.valueOf(newVotante.getId())+ " registrado exitosamente \n"+ "Su mesa: " + newVotante.getMesa());
    }

    @PatchMapping("/registerSufragio")
    public void resgisterSufragio(String id){
        getVotante(id);
    }
}
