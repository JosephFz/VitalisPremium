package com.vita.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vita.entity.Citas;
import com.vita.entity.Estado;
import com.vita.entity.Horario;
import com.vita.entity.Medico;
import com.vita.entity.Paciente;
import com.vita.services.CitasService;
import com.vita.services.EspecialidadService;
import com.vita.services.EstadoService;
import com.vita.services.HorarioService;
import com.vita.services.MedicoService;
import com.vita.services.PacienteService;
@Controller
@RequestMapping("/citas")
public class CitasController {

	@Autowired
    private CitasService serCitas;
    @Autowired
    private MedicoService serMed;
    @Autowired
    private EstadoService serEsta;
    @Autowired
    private HorarioService serHoa;
    @Autowired
    private PacienteService serPac;
    @Autowired
    private EspecialidadService serEspe;


    @RequestMapping("/lista")
    public String index(Model model) {
        model.addAttribute("listaPacientes",serPac.listarTodos());
        model.addAttribute("listaCitas",serCitas.listarTodos());
        model.addAttribute("listaMedicos",serMed.listarTodos());
        model.addAttribute("listaEstado",serEsta.listarTodos());
        model.addAttribute("listaHorarios",serHoa.listarTodos());
        model.addAttribute("listaEspecialidades",serEspe.listarTodos());
        return "Citas";
    }
	
	@RequestMapping("/buscar")
	@ResponseBody
	public Citas buscarPorID(@RequestParam("codigo") Integer cod) {
		return serCitas.buscarPorId(cod);
	}
	
	@RequestMapping("/grabar")	
	public String grabar(@RequestParam("codigo") int cod,
						 @RequestParam("fecha") String nom,
						 @RequestParam("costo") Double cost,
						 @RequestParam("paciente") int codPac,
						 @RequestParam("medico") int codMed,
						 @RequestParam("horario") int codHoa,
						 @RequestParam("estado") int codEst, RedirectAttributes redirect) {
		try {
			Citas cit = new Citas();
			cit.setFecha(nom);
			cit.setCosto(cost);
			
			Paciente pa = new Paciente();
			pa.setCodigo(codPac);
			cit.setPaciente(pa);
			
			Medico med = new Medico();
			med.setCodigo(codMed);
			cit.setMedico(med);
			
			Horario hoa = new Horario();
			hoa.setCodigo(codHoa);
			cit.setHorario(hoa);
			
			Estado est = new Estado();
			est.setCodigo(codEst);
			cit.setEstado(est);
			
			if(cod==0) {
				serCitas.registrar(cit);
				redirect.addFlashAttribute("MENSAJE","Cita registrada");
			}
			else {
				pa.setCodigo(cod);
				serCitas.actualizar(cit);
				redirect.addFlashAttribute("MENSAJE","Cita actualizada");					
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return  "redirect:/citas/lista";
	}
	
	@RequestMapping("/eliminar")
	public String eliminarPorID(@RequestParam("codigo") Integer cod,
								RedirectAttributes redirect) {
		serCitas.eliminarPorId(cod);
		redirect.addFlashAttribute("MENSAJE","Cita eliminada");
		
		return "redirect:/citas/lista";
	}
	
	
	@RequestMapping("/listarPorEspecialidad")
    @ResponseBody
    public List<Medico> listarPorLaboratorio(@RequestParam("codEspe") Integer cod){
        return serMed.listarMedicosPorEspecialidades(cod);
    }
	
}
