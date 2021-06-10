package pe.edu.upc.trabajo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.upc.trabajo.model.entity.Veterinaria;
import pe.edu.upc.trabajo.service.crud.VeterinariaService;

@Controller
@RequestMapping("/search")
public class SearchController {
	
	@Autowired
	private VeterinariaService veterinariaService;
	
	@GetMapping("vets")
	public String searchRegionGet(Model model, @ModelAttribute("vetSearch") Veterinaria vetSearch) {
		System.out.println(vetSearch.getNombreVeterinaria());
		try {
			List<Veterinaria> vetsFound = veterinariaService.findByNombreVeterinaria(vetSearch.getNombreVeterinaria());
			model.addAttribute("vetsFound", vetsFound);
			model.addAttribute("vetSearch", vetSearch);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "search/vets-result";
	}

}