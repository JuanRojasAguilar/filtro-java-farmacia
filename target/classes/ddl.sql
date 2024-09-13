DROP DATABASE IF EXISTS farmaciajdr;
CREATE DATABASE farmaciajdr;
USE farmaciajdr;

CREATE TABLE pacientes (
    id_paciente INT UNSIGNED AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    direccion TEXT,
    telefono VARCHAR(15),
    email VARCHAR(150) UNIQUE,
    CONSTRAINT pk_id_paciente PRIMARY KEY (id_paciente)
);

CREATE TABLE especializaciones (
    id_especializacion INT UNSIGNED AUTO_INCREMENT,
    nombre VARCHAR(100) UNIQUE,
    CONSTRAINT pk_id_especializacion PRIMARY KEY (id_especializacion)
);

CREATE TABLE medicos (
    id_medico INT UNSIGNED AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    id_especializacion INT UNSIGNED,
    hora_inicio TIME(0) DEFAULT "09:00:00",
    hora_final TIME(0) DEFAULT "17:00:00",
    CONSTRAINT pk_id_medico PRIMARY KEY (id_medico),
    CONSTRAINT fk_id_especializacion_medico FOREIGN KEY (id_especializacion)
    REFERENCES especializaciones (id_especializacion)
);

CREATE TABLE citas (
    id_cita INT UNSIGNED AUTO_INCREMENT,
    id_paciente INT UNSIGNED,
    id_medico INT UNSIGNED,
    fecha_hora DATETIME NOT NULL,
    estado ENUM("ACEPTADA", "RECHAZADA", "EN ESPERA") DEFAULT "EN ESPERA",
    CONSTRAINT pk_id_cita PRIMARY KEY (id_cita),
    CONSTRAINT fk_id_paciente_cita FOREIGN KEY (id_paciente)
    REFERENCES pacientes (id_paciente),
    CONSTRAINT fk_id_medico_cita FOREIGN KEY (id_medico)
    REFERENCES medicos (id_medico)
);

DELIMITER //
DROP PROCEDURE IF EXISTS add_paciente;
CREATE PROCEDURE add_paciente(IN nombre_p VARCHAR(50), IN apellido_p VARCHAR(50), IN fecha_nacimiento_p DATE, IN direccion_p TEXT, IN telefono_p VARCHAR(15), IN email_p VARCHAR(150))
BEGIN
INSERT INTO pacientes (nombre, apellido, fecha_nacimiento, direccion, telefono, email)
VALUES (nombre_p, apellido_p, fecha_nacimiento, direccion, telefono, email);
END //
DELIMITER ;