package com.farmacia.paciente.application;

import java.util.Optional;

import com.farmacia.paciente.domain.entity.Paciente;
import com.farmacia.paciente.domain.service.PacienteService;

public class GetPacienteByIdUseCase {
    private final PacienteService pacienteService;
    
    public GetPacienteByIdUseCase(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    public Optional<Paciente> execute(Long id) {
        return this.pacienteService.getPacienteById(id);
    }
}
