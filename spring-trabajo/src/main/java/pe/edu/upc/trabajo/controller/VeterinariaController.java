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
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.trabajo.model.entity.Veterinaria;
import pe.edu.upc.trabajo.service.crud.VeterinariaService;

@Controller
@RequestMapping("/vets")
@SessionAttributes("vetEdit")
public class VeterinariaController {

	@Autowired
	private VeterinariaService veterinariaService;

	@GetMapping("details")	
	public String details(Model model) {
		try {
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "vets/details-vet";
	}
	
	@GetMapping("search1")	
	public String mostrar(Model model) {
		try {
			Veterinaria vetSearch = new Veterinaria();
			model.addAttribute("vetSearch", vetSearch);
			Veterinaria vetDistritSearch = new Veterinaria();
			model.addAttribute("vetDistritSearch", vetDistritSearch);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "vets/search-vet";
	}
	
	@GetMapping
	public String listar(Model model) {
		try {
			List<Veterinaria> veterinarias = veterinariaService.getAll();
			model.addAttribute("veterinarias", veterinarias);
			
			//Veterinaria vetSearch = new Veterinaria();
			//model.addAttribute("vetSearch", vetSearch);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "vets/lista";
	}
	
	@GetMapping("{idVeterinaria}")		// GET: /v/{id}
	public String findById(Model model, @PathVariable("idVeterinaria") Integer id) {
		try {
			Optional<Veterinaria> optional = veterinariaService.findById(id);
			if(optional.isPresent()) {
				model.addAttribute("vet", optional.get());
				return "vets/details-vet"; // Archivo Html
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/vets";	// url
	}
	
	@GetMapping("{id}/edit")		// GET: /regions/{id}/edit
	public String findById2(Model model, @PathVariable("id") Integer id) {
		try {
			Optional<Veterinaria> optional = veterinariaService.findById(id);
			if(optional.isPresent()) {
				model.addAttribute("vetEdit", optional.get());
				return "vets/edit";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/vets";	// url
	}
	
	@PostMapping("save")	// POST: /regions/save
	public String saveEdit(Model model, @ModelAttribute("vetEdit") Veterinaria vet) {
		try {
			Veterinaria vetReturn = veterinariaService.update(vet);
			model.addAttribute("vet", vetReturn);
			return "vets/view"; // Archivo Html
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/vets";
	}
	
	@GetMapping("new")		// GET: /regions/{id}/edit
	public String newItem(Model model) {
		try {
			Veterinaria vet = new Veterinaria();
			model.addAttribute("vetNew", vet);
			return "vets/new";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/vets";	// url
	}
	
	@PostMapping("savenew")	// POST: /regions/savenew
	public String saveNew(Model model, @ModelAttribute("vetNew") Veterinaria vet) {
		try {
			Veterinaria vetReturn = veterinariaService.create(vet);
			model.addAttribute("vet", vetReturn);
			return "vets/view"; // Archivo Html
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/vets";
	}
	
	
	
}
