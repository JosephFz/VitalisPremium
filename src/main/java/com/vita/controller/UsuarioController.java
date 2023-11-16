package com.vita.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.vita.entity.Enlace;
import com.vita.entity.Usuario;
import com.vita.services.UsuarioServices;


//definir atributos de tipo sesión
//OBTENER CODIGO USUARIO
@SessionAttributes({"ENLACES","CODIGOUSUARIO"})
@Controller
@RequestMapping("/sesion")
public class UsuarioController {
	@Autowired
	private UsuarioServices servicioUsu;
	
	@RequestMapping("/login")
	public String login() {
		
		return "login";
	}
	@RequestMapping("/intranet")
	public String intranet(Authentication auth,Model model) {
		//obtener nombre del rol del usuario que inicio sesiòn
		String nomRol=auth.getAuthorities().stream()
					      .map(GrantedAuthority::getAuthority)
					      .collect(Collectors.joining(","));
		//obtener los enlaces del usuario según nombre de rol
		List<Enlace> lista=servicioUsu.enlacesDelUsuario(nomRol);
		
		//OBTENER DATOS DEL USUARIO QUE INICIÓ SESIÓN
		Usuario usu = servicioUsu.sesionDelUsuario(auth.getName());
		
		//atributo de tipo sesión
		model.addAttribute("ENLACES",lista);
		//OBTENER CODIGO USUARIO
		//model.addAttribute("CODIGOUSUARIO",usu.getCodigo());
		return "intranet";
	}
	
}







