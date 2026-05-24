package com.example.votaciones.model.DetalleSufragio;

import com.example.votaciones.model.ResultadoMesa.ResultadoMesaModel;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "DetalleSufragio")
public class DetalleSufragioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ID_Candidato", nullable = false)
    private Long idCandidato;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ResultadoMesa", nullable = false)
    private ResultadoMesaModel idResultadoMesa;

    @Column(name = "NumeroVotos",nullable = false)
    private Integer numeroVotos;
}