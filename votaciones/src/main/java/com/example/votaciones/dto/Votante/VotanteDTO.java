package com.example.votaciones.dto.Votante;

import lombok.Data;

@Data
public class VotanteDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String Document;
    private Integer mesa;
}
