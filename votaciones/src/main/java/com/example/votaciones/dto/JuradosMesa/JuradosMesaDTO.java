package com.example.votaciones.dto.JuradosMesa;

import lombok.Data;

@Data
public class JuradosMesaDTO {
    private Long id;
    private Long jurado;
    private Integer mesa;
    private Boolean flagSuplente;
    private Boolean flagAsistencia;
}
