package com.vita.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vita.entity.Medico;
import com.vita.repository.MedicoRepository;

@Service
public class MedicoService {
	@Autowired
	private MedicoRepository repo;
	
	public List<Medico> listarTodos(){
		return repo.findAll();
	}
	
	public void registrar(Medico b) {
		repo.save(b);
	}
	
	public void actualizar(Medico b) {
		repo.save(b);
	}
	
	public void eliminarPorId(Integer cod) {
		repo.deleteById(cod);
	}
	
	public Medico buscarPorId(Integer cod){
		return repo.findById(cod).orElse(null);
	}
	
	public List<Medico> listarMedicosPorEspecialidades(Integer codEspe){
        return repo.findAllByEspecialidad(codEspe);
    }

}
