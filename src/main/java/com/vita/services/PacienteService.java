package com.vita.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vita.entity.Paciente;
import com.vita.repository.PacienteRepository;

@Service
public class PacienteService {
	@Autowired
	private PacienteRepository repo;
	
	public List<Paciente> listarTodos(){
		return repo.findAll();
	}
	
	public void registrar(Paciente b) {
		repo.save(b);
	}
	
	public void actualizar(Paciente b) {
		repo.save(b);
	}
	
	public void eliminarPorId(Integer cod) {
		repo.deleteById(cod);
	}
	
	public Paciente buscarPorId(Integer cod){
		return repo.findById(cod).orElse(null);
	}

}
