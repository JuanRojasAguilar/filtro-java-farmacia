package com.farmacia.paciente.application;

import java.util.List;

import com.farmacia.paciente.domain.entity.Paciente;
import com.farmacia.paciente.domain.service.PacienteService;

public class GetAllPacientesUseCase {
    private final PacienteService pacienteService;

    public GetAllPacientesUseCase(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    public List<Paciente> execute() {
        return this.pacienteService.getAllPacientes();
    }
}
