package com.example.votaciones.model.Mesa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Mesa")
public class MesaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NumeroVotantesAsignados", nullable = false)
    private Integer numeroVotantesAsignados;

    @Column(name = "IP_Address", nullable = false, unique = true, length = 15)
    private String ipAddress;
}
