package com.example.votaciones.repository.Mesa;

import com.example.votaciones.model.Mesa.MesaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MesaRepository  extends JpaRepository<MesaModel,Integer> {
}