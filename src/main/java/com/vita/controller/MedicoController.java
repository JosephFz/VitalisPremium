package com.vita.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vita.entity.Especialidad;
import com.vita.entity.Horario;
import com.vita.entity.Medico;
import com.vita.services.EspecialidadService;
import com.vita.services.HorarioService;
import com.vita.services.MedicoService;

@Controller
@RequestMapping("/medico")
public class MedicoController {

    @Autowired
    private MedicoService serMedico;
    @Autowired
    private EspecialidadService serEspecial;
    @Autowired
    private HorarioService serHoa;

    @RequestMapping("/lista")
    public String index(Model model) {
        model.addAttribute("listaMedicos",serMedico.listarTodos());
        model.addAttribute("listaHorario",serHoa.listarTodos());
        model.addAttribute("listaEspecialidades",serEspecial.listarTodos());
        return "Medico";
    }
    
	@RequestMapping("/buscar")
	@ResponseBody
	public Medico buscarPorID(@RequestParam("codigo") Integer cod) {
		return serMedico.buscarPorId(cod);
	}
	
	@RequestMapping("/grabar")	
	public String grabar(@RequestParam("codigo") int cod,
						 @RequestParam("nombre") String nom,
						 @RequestParam("apellido") String ape,
						 @RequestParam("correo") String correo,
						 @RequestParam("especialidad") int codEspe,
						 @RequestParam("horario") int codHoa, RedirectAttributes redirect) {
		try {
			Medico med = new Medico();
			med.setNombre(nom);
			med.setApellido(ape);
			med.setEmail(correo);
			
			Especialidad espe = new Especialidad();
			espe.setCodigo(codEspe);
			med.setEspecialidad(espe);
			
			Horario hoa = new Horario();
			hoa.setCodigo(codHoa);
			med.setHorario(hoa);
			
			if(cod==0) {
				serMedico.registrar(med);
				redirect.addFlashAttribute("MENSAJE","Medico registrado");
			}
			else {
				med.setCodigo(cod);
				serMedico.actualizar(med);
				redirect.addFlashAttribute("MENSAJE","Medico actualizado");					
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return  "redirect:/medico/lista";
	}
	
	@RequestMapping("/eliminar")
	public String eliminarPorID(@RequestParam("codigo") Integer cod,
								RedirectAttributes redirect) {
		serMedico.eliminarPorId(cod);
		redirect.addFlashAttribute("MENSAJE","Medico eliminado");
		
		return "redirect:/medico/lista";
	}
	
    
}