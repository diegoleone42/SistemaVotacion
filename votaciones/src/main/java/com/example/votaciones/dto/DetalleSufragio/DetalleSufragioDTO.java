package com.example.votaciones.dto.DetalleSufragio;

import lombok.Data;

@Data
public class DetalleSufragioDTO {
    private Long id;
    private Long idCandidato;
    private Integer idResultadoMesa;
    private Integer numeroVotos;
}
