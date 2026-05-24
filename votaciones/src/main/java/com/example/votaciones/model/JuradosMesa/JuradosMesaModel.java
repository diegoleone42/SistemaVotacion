package com.example.votaciones.model.JuradosMesa;

import com.example.votaciones.model.Mesa.MesaModel;
import com.example.votaciones.model.Votante.VotanteModel;
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
@Table(name = "JuradosMesa")
public class JuradosMesaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "ID_Jurado", nullable = false, unique = true)
    private VotanteModel jurado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_Mesa", nullable = false)
    private MesaModel mesa;

    @Column(name="FlagSuplente", nullable = false)
    private Boolean flagSuplente; // BIT mapped to Boolean

    @Column(name="FlagAsistencia",nullable = false)
    private Boolean flagAsistencia;
}