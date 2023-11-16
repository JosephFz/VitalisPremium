package com.vita.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vita.entity.Citas;
import com.vita.repository.CitasRepository;

@Service
public class CitasService {
	@Autowired
	private CitasRepository repo;
	
	public List<Citas> listarTodos(){
		return repo.findAll();
	}
	
	public void registrar(Citas b) {
		repo.save(b);
	}
	
	public void actualizar(Citas b) {
		repo.save(b);
	}
	
	public void eliminarPorId(Integer cod) {
		repo.deleteById(cod);
	}
	
	public Citas buscarPorId(Integer cod){
		return repo.findById(cod).orElse(null);
	}

}
