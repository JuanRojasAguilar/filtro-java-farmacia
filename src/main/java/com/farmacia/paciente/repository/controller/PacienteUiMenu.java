package com.farmacia.paciente.repository.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class PacienteUiMenu extends JFrame implements ActionListener {
    private JButton createB, searchB;

    public PacienteUiMenu() {
        setLayout(null);
        setBounds(0, 0, 640, 480);

        Integer buttonHeight = 60;
        Integer buttonWidth = 200;
        Integer buttonX = (getWidth() >> 1) - (buttonWidth >> 1);

        createB = new JButton("Registrar paciente");
        createB.setBounds(buttonX, getButtonY(0), buttonWidth, buttonHeight);
        createB.addActionListener(this);
        add(createB);

        searchB = new JButton("Buscar paciente");
        searchB.setBounds(buttonX, getButtonY(1), buttonWidth, buttonHeight);
        searchB.addActionListener(this);
        add(searchB);

        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private Integer getButtonY(Integer buttonPos) {
        return (buttonPos * 70) + 10;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == createB) {
            this.dispose();
            new CreatePacienteUi();
        }
        if (e.getSource() == searchB) {
            this.dispose();
            new FindPacienteById();
        }
    }
}
