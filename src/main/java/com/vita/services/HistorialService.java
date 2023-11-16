package com.vita.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vita.entity.Historial;
import com.vita.repository.HistorialRepository;
@Service
public class HistorialService {
	@Autowired
	private HistorialRepository repo;
	
	public List<Historial> listarTodos(){
		return repo.findAll();
	}
	
	public void registrar(Historial b) {
		repo.save(b);
	}
	
	public void actualizar(Historial b) {
		repo.save(b);
	}
	
	public void eliminarPorId(Integer cod) {
		repo.deleteById(cod);
	}
	
	public Historial buscarPorId(Integer cod){
		return repo.findById(cod).orElse(null);
	}
}
