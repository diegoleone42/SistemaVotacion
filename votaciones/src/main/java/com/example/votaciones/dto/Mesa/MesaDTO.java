package com.example.votaciones.dto.Mesa;

import lombok.Data;

@Data
public class MesaDTO {
    private Integer id;
    private Integer numeroVotantesAsignados;
    private String ipAddress;
}
