package pe.edu.upc.trabajo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.trabajo.model.entity.Veterinaria;
import pe.edu.upc.trabajo.service.crud.VeterinariaService;



@Controller
@RequestMapping("/principal")
public class VeterinariaController {

	@Autowired
	private VeterinariaService veterinariaService;
	
	@GetMapping
	public String listar(Model model) {
		try {
			List<Veterinaria> veterinarias = veterinariaService.getAll();
			model.addAttribute("veterinarias", veterinarias);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "principal";
	}
}
