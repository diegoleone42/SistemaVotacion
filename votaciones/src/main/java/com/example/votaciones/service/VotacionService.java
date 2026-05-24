package com.example.votaciones.service;

import com.example.votaciones.dto.JuradosMesa.JuradosMesaDTO;
import com.example.votaciones.dto.Votante.VotanteDTO;
import com.example.votaciones.model.JuradosMesa.JuradosMesaModel;
import com.example.votaciones.model.Mesa.MesaModel;
import com.example.votaciones.model.Votante.VotanteModel;
import com.example.votaciones.repository.JuradosMesa.JuradosMesaRepository;
import com.example.votaciones.repository.Mesa.MesaRepository;
import com.example.votaciones.repository.Votante.VotanteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VotacionService {
    private final VotanteRepository votanteRepo;
    private final MesaRepository mesaRepo;
    private final JuradosMesaRepository juradosMesaRepo;

    public VotanteModel getVotante(long idVotante){
        return votanteRepo.findById(idVotante).orElse(null);
    }
    public VotanteModel registerVotante(VotanteDTO dto_Votante){
        VotanteModel newVotante = buildVotante(dto_Votante);
        votanteRepo.save(newVotante);
        return getVotante(newVotante.getId());
    }
    public MesaModel assignMesa(){
        MesaModel addVotante = mesaRepo.findAll().getLast();
        addVotante.setNumeroVotantesAsignados(addVotante.getNumeroVotantesAsignados()+1);
        mesaRepo.save(addVotante);
        return mesaRepo.findById(addVotante.getId()).orElse(null);
    }

    public MesaModel assignMesa(long juradoID){
        VotanteModel jurado = votanteRepo.findById(juradoID).orElse(null);
        return mesaRepo.findById(jurado.getMesa().getId()).orElse(null);
    }

    public JuradosMesaModel createJuradosMesa(JuradosMesaDTO dto_JuradosMesa){
        JuradosMesaModel newJurado = buildJurado(dto_JuradosMesa);
        juradosMesaRepo.save(new JuradosMesaModel());
        return newJurado;
    }

    public String attendanceJuradosMesa(long juradoID){
        JuradosMesaModel jurado = juradosMesaRepo.findById(juradoID).orElse(null);
        jurado.setFlagAsistencia(true);
        juradosMesaRepo.save(jurado);
        return String.valueOf(jurado.getId()) + " attendance registered";
    }
    public String attendanceVotante(long votanteID, String firstName,String LastName,String document){
        VotanteModel votante = votanteRepo.findById(votanteID).orElse(null);
        if(votante != null){
            String storedDocument = votante.getDocument();
            if (document.equals(storedDocument)) return String.valueOf(votante.getId()) + " attendance registered";
        }
        return String.valueOf(votante.getId()) + " Votante no encontrado";

    }

    private VotanteModel buildVotante(VotanteDTO dtoVotante){
        VotanteModel newVotante = new VotanteModel();
        newVotante.setId(dtoVotante.getId());
        newVotante.setNombre(dtoVotante.getNombre());
        newVotante.setApellido(dtoVotante.getApellido());
        newVotante.setMesa(assignMesa());
        newVotante.setDocument(dtoVotante.getDocument());
        return newVotante;
    }

    private JuradosMesaModel buildJurado(JuradosMesaDTO dtoJuradosMesa){
        JuradosMesaModel newJurado = new JuradosMesaModel();
        newJurado.setId(dtoJuradosMesa.getId());
        newJurado.setMesa(assignMesa(dtoJuradosMesa.getId()));
        newJurado.setFlagSuplente(dtoJuradosMesa.getFlagSuplente());
        newJurado.setFlagAsistencia(Boolean.FALSE);
        return newJurado;
    }
}
