package com.farmacia.paciente.repository.controller;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.farmacia.paciente.application.GetPacienteByIdUseCase;
import com.farmacia.paciente.domain.entity.Paciente;
import com.farmacia.paciente.repository.PacienteRepository;

public class FindPacienteById extends JFrame implements ActionListener {
    private JLabel title, idL, nombreL, apellidoL;
    private final JTextField idF;
    private final JButton search, cancel;
    private JLabel nombreTag, apellidoTag;
    private final GetPacienteByIdUseCase useCase;
    private final Integer width = 640;

    public FindPacienteById() {
        setLayout(null);
        setBounds(0, 0, width, 480);   

        useCase = new GetPacienteByIdUseCase(new PacienteRepository());
        Integer quarterScreen = getWidth() >> 2;

        title = new JLabel("Busca tu paciente");
        title.setFont(new Font("arial", ABORT, 24));
        title.setBounds((quarterScreen * 2) - 100, 10, 250, 40);
        add(title);

        idL = new JLabel("Ingresa el Id: ");
        idL.setBounds(quarterScreen, 60, 200, 30);
        add(idL);

        idF = new JTextField();
        idF.setBounds(quarterScreen * 2, 60, 200, 30);
        add(idF);

        search = new JButton("Buscar");
        search.setBounds(quarterScreen, 100, 150, 40);
        search.addActionListener(this);
        add(search);

        cancel = new JButton("cancelar");
        cancel.setBounds(quarterScreen << 1, 100, 150, 40);
        cancel.addActionListener(this);
        add(cancel);

        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == search) {
            Long pacienteId = Long.parseLong(idF.getText());

            Paciente miPaciente = new Paciente();

            useCase.execute(pacienteId).ifPresent(p -> {
                miPaciente.setNombre(p.getNombre());
                miPaciente.setApellido(p.getApellido());
            });
            
            nombreL = new JLabel("Nombre:");
            nombreL.setBounds(width >> 2, 160, 150, 30);
            add(nombreL);

            nombreTag = new JLabel(miPaciente.getNombre());
            nombreTag.setBounds(width >> 1, 160, 150, 30);
            add(nombreTag);

            apellidoL = new JLabel("apellido:");
            apellidoL.setBounds(width >> 2, 200, 150, 30);
            add(apellidoL);

            apellidoTag = new JLabel(miPaciente.getNombre());
            apellidoTag.setBounds(width >> 1, 200, 150, 30);
            add(apellidoTag);

            this.update(getGraphics());
        }
    }
    
}
