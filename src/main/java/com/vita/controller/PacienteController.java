package com.vita.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vita.entity.Paciente;
import com.vita.services.PacienteService;

@Controller
@RequestMapping("/paciente")
public class PacienteController {

	@Autowired
	private PacienteService serPaciente;
	
	@RequestMapping("/lista")
	public String index(Model model) {
		model.addAttribute("listaPacientes",serPaciente.listarTodos());
		return "paciente";
	}
	
	@RequestMapping("/buscar")
	@ResponseBody
	public Paciente buscarPorID(@RequestParam("codigo") Integer cod) {
		return serPaciente.buscarPorId(cod);
	}
	
	@RequestMapping("/grabar")	
	public String grabar(@RequestParam("codigo") int cod,
						 @RequestParam("nombre") String nom,
						 @RequestParam("apellido") String ape,
						 @RequestParam("dni") String dni,
						 @RequestParam("telefono") String telf,
						 @RequestParam("direccion") String dirc,
						 @RequestParam("genero") String gen, RedirectAttributes redirect) {
		try {
			Paciente pa = new Paciente();
			pa.setNombre(nom);
			pa.setApellido(ape);
			pa.setDni(dni);
			pa.setTelefono(telf);
			pa.setDireccion(dirc);
			pa.setGenero(gen);
			
			if(cod==0) {
				serPaciente.registrar(pa);
				redirect.addFlashAttribute("MENSAJE","Paciente registrado");
			}
			else {
				pa.setCodigo(cod);
				serPaciente.actualizar(pa);
				redirect.addFlashAttribute("MENSAJE","Paciente actualizado");					
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return  "redirect:/paciente/lista";
	}
	
	@RequestMapping("/eliminar")
	public String eliminarPorID(@RequestParam("codigo") Integer cod,
								RedirectAttributes redirect) {
		serPaciente.eliminarPorId(cod);
		redirect.addFlashAttribute("MENSAJE","Paciente eliminado");
		
		return "redirect:/paciente/lista";
	}
	
	
}
