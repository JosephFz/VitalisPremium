package com.vita.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vita.entity.Horario;
import com.vita.repository.HorarioRepository;
@Service
public class HorarioService {
	@Autowired
	private HorarioRepository repo;
	
	public List<Horario> listarTodos(){
		return repo.findAll();
	}
	
	public void registrar(Horario b) {
		repo.save(b);
	}
	
	public void actualizar(Horario b) {
		repo.save(b);
	}
	
	public void eliminarPorId(Integer cod) {
		repo.deleteById(cod);
	}
	
	public Horario buscarPorId(Integer cod){
		return repo.findById(cod).orElse(null);
	}

}
