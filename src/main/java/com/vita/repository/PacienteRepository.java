package com.vita.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vita.entity.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Integer>{

}
