package com.vita.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vita.entity.Enlace;
import com.vita.entity.Usuario;
import com.vita.repository.UsuarioRepository;


@Service
public class UsuarioServices {
	@Autowired
	private UsuarioRepository repo;
	
	public Usuario sesionDelUsuario(String vLogin) {
		return repo.iniciarSesion(vLogin);
	}
	public List<Enlace> enlacesDelUsuario(String desRol){
		return repo.traerEnlacesDelUsuario(desRol);
	}
	
}
