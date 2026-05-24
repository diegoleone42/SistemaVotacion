package com.example.votaciones.model.Votante;
import com.example.votaciones.model.Mesa.MesaModel;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Votante")
public class VotanteModel {

    @Id
    private Long id; // BIGINT

    @Column(name = "Nombre", nullable = false, length = 45)
    private String nombre;

    @Column(name = "Apellido", nullable = false, length = 45)
    private String apellido;

    @Column(name ="Document", nullable = false, unique = true)
    private String document;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_Mesa", nullable = false)
    private MesaModel mesa;
}