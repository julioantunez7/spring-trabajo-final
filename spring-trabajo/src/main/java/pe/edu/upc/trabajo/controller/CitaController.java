package pe.edu.upc.trabajo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.trabajo.model.entity.Cita;
import pe.edu.upc.trabajo.service.crud.CitaService;

@Controller
@RequestMapping("/appointments")

public class CitaController {
	
	@Autowired
	private CitaService citaService;
	
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