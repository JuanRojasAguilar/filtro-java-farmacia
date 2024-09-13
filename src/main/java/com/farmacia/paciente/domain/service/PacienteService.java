package com.farmacia.paciente.domain.service;

import java.util.List;
import java.util.Optional;

import com.farmacia.paciente.domain.entity.Paciente;

public interface PacienteService {
    public Optional<Paciente> createPaciente(Paciente paciente);
    public Optional<Paciente> getPacienteById(Long id);
    public List<Paciente> getAllPacientes();
    public Optional<Paciente> updatePaciente(Paciente paciente);
    public Optional<Paciente> deletePaciente(Paciente paciente);
}
