package com.example.votaciones.dto.ResultadoMesa;

import lombok.Data;

@Data
public class ResultadoMesaDTO {
    private Integer id;
    private Integer mesa;
    private String observacionSufragio;
    private String firmas;
}
