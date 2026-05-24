package com.example.votaciones.repository.Votante;


import com.example.votaciones.model.Votante.VotanteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotanteRepository extends JpaRepository<VotanteModel,Long> {
}
