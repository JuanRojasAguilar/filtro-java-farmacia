package com.farmacia.paciente.application;

import java.util.Optional;

import com.farmacia.paciente.domain.entity.Paciente;
import com.farmacia.paciente.domain.service.PacienteService;

public class CreatePacienteUseCase {
    private final PacienteService pacienteService;
    
    public CreatePacienteUseCase(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    public Optional<Paciente> execute(Paciente paciente) {
        return this.pacienteService.createPaciente(paciente);
    }
}
