package pe.edu.upc.trabajo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.trabajo.model.entity.Mascota;
import pe.edu.upc.trabajo.service.crud.MascotaService;

@Controller
@RequestMapping("/pets")
public class MascotaController {

	@Autowired
	private MascotaService mascotaService;
	
	@GetMapping("search")
	public String buscar(Model model) {
		try {
			List<Mascota> pets = mascotaService.getAll();
			model.addAttribute("pets", pets);
			
			Mascota petSearch=new Mascota();
			model.addAttribute("petSearch", petSearch);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "pets/search-pet";
	}
	
	@GetMapping("{id}")
	public String findById(Model model, @PathVariable("id") Integer id) {
		try {
			Optional<Mascota> optional = mascotaService.findById(id);
			if(optional.isPresent()) {
				model.addAttribute("pet", optional.get());
				return "pets/details-pet";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "";
	}
	
	
}
