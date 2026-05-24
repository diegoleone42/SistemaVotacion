package com.example.votaciones.model.ResultadoMesa;

import com.example.votaciones.model.Mesa.MesaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ResultadoMesa")
public class ResultadoMesaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_Mesa", nullable = false)
    private MesaModel mesa;

    @Column(name = "ObservacionSufragio")
    private String observacionSufragio;

    @Lob
    @Column(name="Firmas",nullable = false)
    private String firmas;
}