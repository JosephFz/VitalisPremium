package com.vita.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vita.entity.Especialidad;
import com.vita.repository.EspecialidadRepository;
@Service
public class EspecialidadService {
	@Autowired
	private EspecialidadRepository repo;
	
	public List<Especialidad> listarTodos(){
		return repo.findAll();
	}
	
	public void registrar(Especialidad b) {
		repo.save(b);
	}
	
	public void actualizar(Especialidad b) {
		repo.save(b);
	}
	
	public void eliminarPorId(Integer cod) {
		repo.deleteById(cod);
	}
	
	public Especialidad buscarPorId(Integer cod){
		return repo.findById(cod).orElse(null);
	}
}
