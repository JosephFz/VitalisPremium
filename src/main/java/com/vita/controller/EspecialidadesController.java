package com.vita.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vita.entity.Especialidad;
import com.vita.services.EspecialidadService;

@Controller
@RequestMapping("/especialidades")
public class EspecialidadesController {

	@Autowired
	private EspecialidadService serEspecial;
	
	@RequestMapping("/lista")
	public String index(Model model) {
		model.addAttribute("listaEspecialidades",serEspecial.listarTodos());
		return "Especialidades";
	}
	
	@RequestMapping("/buscar")
	@ResponseBody
	public Especialidad buscarPorID(@RequestParam("codigo") Integer cod) {
		return serEspecial.buscarPorId(cod);
	}
	
	@RequestMapping("/grabar")	
	public String grabar(@RequestParam("codigo") int cod,
						 @RequestParam("especialidad") String espe, RedirectAttributes redirect) {
		try {
			Especialidad esp = new Especialidad();
			esp.setEspecialidad(espe);		
			if(cod==0) {
				serEspecial.registrar(esp);
				redirect.addFlashAttribute("MENSAJE","Especialidad registrada");
			}
			else {
				esp.setCodigo(cod);
				serEspecial.actualizar(esp);
				redirect.addFlashAttribute("MENSAJE","Especialidad actualizada");					
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return  "redirect:/especialidades/lista";
	}
	
	@RequestMapping("/eliminar")
	public String eliminarPorID(@RequestParam("codigo") Integer cod,
								RedirectAttributes redirect) {
		serEspecial.eliminarPorId(cod);
		redirect.addFlashAttribute("MENSAJE","Especialidad eliminada");
		
		return "redirect:/especialidades/lista";
	}
	
}
