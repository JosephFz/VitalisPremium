package com.vita.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vita.entity.Estado;
import com.vita.repository.EstadoRepository;
@Service
public class EstadoService {
	@Autowired
	private EstadoRepository repo;
	
	public List<Estado> listarTodos(){
		return repo.findAll();
	}
	
	public void registrar(Estado b) {
		repo.save(b);
	}
	
	public void actualizar(Estado b) {
		repo.save(b);
	}
	
	public void eliminarPorId(Integer cod) {
		repo.deleteById(cod);
	}
	
	public Estado buscarPorId(Integer cod){
		return repo.findById(cod).orElse(null);
	}
}
