package com.farmacia.paciente.repository;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.farmacia.paciente.domain.entity.Paciente;
import com.farmacia.paciente.domain.service.PacienteService;

public class PacienteRepository implements PacienteService {
    private Connection connection;

    public PacienteRepository() {
        try {
            Properties props = new Properties();
            props.load(getClass().getClassLoader().getResourceAsStream("db.properties"));
            String url = props.getProperty("url");
            String user = props.getProperty("user");
            String password = props.getProperty("password");
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException | IOException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public Optional<Paciente> deletePaciente(Paciente paciente) {
        return Optional.empty();
    }

    @Override
    public List<Paciente> getAllPacientes() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<Paciente> getPacienteById(Long id) {
        String sql = "SELECT nombre, apellido, fecha_nacimiento, direccion, telefono, email FROM pacientes WHERE id_paciente = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            try (ResultSet result = ps.executeQuery()) {
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");
                Date fechaNacimiento = result.getDate("fecha_nacimiento");
                String direccion = result.getString("direccion");
                String telefono = result.getString("telefono");
                String email = result.getString("email");

                Paciente paciente = new Paciente(id, nombre, apellido, fechaNacimiento, direccion, telefono, email);
                return Optional.of(paciente);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public Optional<Paciente> updatePaciente(Paciente paciente) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public Optional<Paciente> createPaciente(Paciente paciente) {
        String sql = "CALL add_paciente(?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, paciente.getNombre());
            ps.setString(2, paciente.getApellido());
            ps.setDate(3, (java.sql.Date) paciente.getFechaNacimiento());
            ps.setString(4, paciente.getDireccion());
            ps.setString(5, paciente.getTelefono());
            ps.setString(6, paciente.getEmail());
            ps.executeUpdate();
            return Optional.of(paciente);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return Optional.empty();
    }
    
}
