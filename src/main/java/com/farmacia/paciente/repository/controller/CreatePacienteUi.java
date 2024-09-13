package com.farmacia.paciente.repository.controller;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.farmacia.paciente.application.CreatePacienteUseCase;
import com.farmacia.paciente.domain.entity.Paciente;
import com.farmacia.paciente.repository.PacienteRepository;

public class CreatePacienteUi extends JFrame implements ActionListener {
    private final CreatePacienteUseCase useCase;

    private final JLabel title, nombreL, apellidoL, fechaNacimientoL, direccionL, telefonoL, emailL;
    private final JTextField nombreF, apellidoF, fechaNacimientoF, direccionF, telefonoF, emailF;
    private final JButton register, cancel;
    
    public CreatePacienteUi() {
        setLayout(null);
        setBounds(0, 0, 640, 480);

        useCase = new CreatePacienteUseCase(new PacienteRepository());

        Integer quarterScreen = getWidth() >> 2;
        
        title = new JLabel("Crear cliente");
        title.setFont(new Font("arial", ABORT, 24));
        title.setBounds((quarterScreen * 2) - 75, 10, 200, 40);
        add(title);

        nombreL = new JLabel("Nombre:");
        nombreL.setBounds(quarterScreen, 80, 200, 30);
        add(nombreL);

        nombreF = new JTextField();
        nombreF.setBounds(quarterScreen * 2, 80, 200, 30);
        add(nombreF);

        apellidoL = new JLabel("Apellido:");
        apellidoL.setBounds(quarterScreen, 120, 200, 30);
        add(apellidoL);

        apellidoF = new JTextField();
        apellidoF.setBounds(quarterScreen * 2, 120, 200, 30);
        add(apellidoF);

        fechaNacimientoL = new JLabel("Fecha nacimiento:");
        fechaNacimientoL.setBounds(quarterScreen, 160, 200, 30);
        add(fechaNacimientoL);

        fechaNacimientoF = new JTextField();
        fechaNacimientoF.setBounds(quarterScreen * 2, 160, 200, 30);
        add(fechaNacimientoF);

        direccionL = new JLabel("Direccion:");
        direccionL.setBounds(quarterScreen, 200, 200, 30);
        add(direccionL);

        direccionF = new JTextField();
        direccionF.setBounds(quarterScreen * 2, 200, 200, 30);
        add(direccionF);

        telefonoL = new JLabel("Telefono:");
        telefonoL.setBounds(quarterScreen, 240, 200, 30);
        add(telefonoL);

        telefonoF = new JTextField();
        telefonoF.setBounds(quarterScreen * 2, 240, 200, 30);
        add(telefonoF);

        emailL = new JLabel("Email:");
        emailL.setBounds(quarterScreen, 280, 200, 30);
        add(emailL);

        emailF = new JTextField();
        emailF.setBounds(quarterScreen * 2, 280, 200, 30);
        add(emailF);

        register = new JButton("Registrar");
        register.setBounds(quarterScreen, 340, 160, 40);
        register.addActionListener(this);
        add(register);

        cancel = new JButton("Cancelar");
        cancel.setBounds(quarterScreen, 340, 160, 40);
        cancel.addActionListener(this);
        add(cancel);

        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == register) {
            register.removeActionListener(this);

            String nombre = nombreF.getText();
            String apellido = apellidoF.getText();
            Date fechaNacimiento = new Date(Long.parseLong(fechaNacimientoF.getText())); 
            String direccion = direccionF.getText();
            String telefono = telefonoF.getText();
            String email = emailF.getText();
            Paciente paciente = new Paciente(nombre, apellido, fechaNacimiento, direccion, telefono, email);

            useCase.execute(paciente);
        }
    }

    
}
