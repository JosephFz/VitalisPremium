package com.vita.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vita.entity.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Integer>{
	
	@Query("select m from Medico m where m.especialidad.codigo=?1")
    public List<Medico> findAllByEspecialidad(Integer codEspe);

}
