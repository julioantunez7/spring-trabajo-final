package pe.edu.upc.trabajo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.trabajo.model.entity.Cita;
import pe.edu.upc.trabajo.model.entity.Consulta;
import pe.edu.upc.trabajo.model.entity.Mascota;
import pe.edu.upc.trabajo.model.entity.Veterinario;
import pe.edu.upc.trabajo.service.crud.CitaService;
import pe.edu.upc.trabajo.service.crud.ConsultaService;
import pe.edu.upc.trabajo.service.crud.MascotaService;
import pe.edu.upc.trabajo.service.crud.VeterinarioService;

@Controller
@RequestMapping("/appointments")

public class CitaController {
	
	@Autowired
	private CitaService citaService;
	
	@Autowired
	private VeterinarioService veterinarioService;
	
	@Autowired
	private MascotaService mascotaService;
	
	@Autowired
	private ConsultaService consultaService;
	
	//-----------------------------------------------------------------------------------------------
	//--nuevo
	@GetMapping("new")		
	public String newItem(Model model) {
		try {
			Cita cita = new Cita();
			List<Veterinario> veterinarios = veterinarioService.getAll();
			List<Mascota> mascotas = mascotaService.getAll();
			
			model.addAttribute("citaNew", cita);
			model.addAttribute("veterinarioNew", veterinarios);
			model.addAttribute("mascotaNew", mascotas);
			
			return "appointments/new-appointment";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/";	
	}
	
	@PostMapping("savenew")	
	public String saveNew(Model model, @ModelAttribute("citaNew") Cita cita) {
		try {
			Cita citaReturn = citaService.create(cita);
			model.addAttribute("cita", citaReturn);
			return "index"; // Archivo Html
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/";
	}
	
	//-----------------------------------------------------------------------------------------------
	//---Editar
	
	@GetMapping("{id}/edit")	
	public String findById2(Model model, @PathVariable("id") Integer id) {
		try {
			Optional<Cita> optional = citaService.findById(id);
			List<Veterinario> veterinarios1 = veterinarioService.getAll();
			List<Mascota> mascotas1 = mascotaService.getAll();
			
			if(optional.isPresent()) {
				model.addAttribute("citaEdit", optional.get());
				model.addAttribute("veterinarioNew", veterinarios1);
				model.addAttribute("mascotaNew", mascotas1);
				
				return "appointments/edit-appointment";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/";	
	}
	
	@PostMapping("save")	
	public String saveEdit(Model model, @ModelAttribute("citaEdit") Cita cita) {
		try {
			Cita citaReturn = citaService.update(cita);
			model.addAttribute("cita", citaReturn);
			return "index"; 
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/";
	}
	
	//-----------------------------------------------------------------------------------------------
	//---------------------------------Consulta
	@GetMapping("{id}/virtualconsult")	
	public String virtual_consult1(Model model, @PathVariable("id") Integer id) {
		try {
			Consulta consulta=new Consulta();
			Optional<Cita> optional = citaService.findById(id);
			
			model.addAttribute("consultaNew", consulta);
			model.addAttribute("cita", optional.get());
			
			return "appointments/virtualConsultation"; 
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/";
	}
	
	@PostMapping("saveConsulta")	
	public String saveNew(Model model, @ModelAttribute("consultaNew") Consulta consulta) {
		try {
			Consulta consultaReturn=consultaService.create(consulta);
			model.addAttribute("consulta", consultaReturn);
			return "index"; // Archivo Html
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/";
	}
	
	
	
	//-----------------------------------------------------------------------------------------------
	//----------------------------------Busqueda
	@GetMapping("search")
	public String buscar(Model model) {
		try {
			List<Cita> appointments = citaService.getAll();
			model.addAttribute("appointments", appointments);
			
			Cita appointmentSearch = new Cita();
			model.addAttribute("appointmentSearch", appointmentSearch);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "appointments/search-appointment";
	}
	
	@GetMapping("{id}")
	public String findById(Model model, @PathVariable("id") Integer id) {
		try {
			Optional<Cita> optional = citaService.findById(id);
			if(optional.isPresent()) {
				model.addAttribute("appointment", optional.get());
				return "appointments/details-appointment";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "";
	}
	
	
	
}