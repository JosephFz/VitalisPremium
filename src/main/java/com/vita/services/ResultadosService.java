package com.vita.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vita.entity.Resultados;
import com.vita.repository.ResultadosRepository;

@Service
public class ResultadosService {
	@Autowired
	private ResultadosRepository repo;
	
	public List<Resultados> listarTodos(){
		return repo.findAll();
	}
	
	public void registrar(Resultados b) {
		repo.save(b);
	}
	
	public void actualizar(Resultados b) {
		repo.save(b);
	}
	
	public void eliminarPorId(Integer cod) {
		repo.deleteById(cod);
	}
	
	public Resultados buscarPorId(Integer cod){
		return repo.findById(cod).orElse(null);
	}

}
