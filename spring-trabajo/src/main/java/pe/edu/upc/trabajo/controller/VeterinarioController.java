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

import pe.edu.upc.trabajo.model.entity.Producto;
import pe.edu.upc.trabajo.model.entity.Veterinario;
import pe.edu.upc.trabajo.service.crud.VeterinarioService;

@Controller
@RequestMapping("/veterinarios")
@SessionAttributes("veterinarioEdit")
public class VeterinarioController {

	
	@Autowired
	private VeterinarioService veterinarioService;
	
	@GetMapping("search3")	
	public String mostrar(Model model) {
		try {
			Veterinario veteSearch = new Veterinario();
			model.addAttribute("veteSearch", veteSearch);
						
			List<Veterinario> veterinarios = veterinarioService.getAll();
			model.addAttribute("veterinarios", veterinarios);
						
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "veterinarios/search-veterinario";
	}
    
	@GetMapping
	public String listar(Model model) {
		try {
			List<Veterinario> veterinarios = veterinarioService.getAll();
			model.addAttribute("veterinarios", veterinarios);			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "veterinarios/lista-veterinarios";
	}
	
	@GetMapping("{id}")		// GET: /v/{id}
	public String findById(Model model, @PathVariable("id") Integer id) {
		try {
			Optional<Veterinario> optional = veterinarioService.findById(id);
			if(optional.isPresent()) {
				model.addAttribute("vete", optional.get());
				return "veterinarios/details-veterinarios"; // Archivo Html
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/veterinarios";	// url
    }
	 @GetMapping("{id}/edit")		// GET: /veterinarios/{id}/edit
		public String findById2(Model model, @PathVariable("id") Integer id) {
			try {
				Optional<Veterinario> optional = veterinarioService.findById(id);
				if(optional.isPresent()) {
					model.addAttribute("veterinarioEdit", optional.get());
					return "veterinarios/edit";
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.err.println(e.getMessage());
			}
			return "redirect:/veterinarios";	// url
		}
	 @PostMapping("save")	// POST: /veterinarios/save
		public String saveEdit(Model model, @ModelAttribute("veterinarioEdit") Veterinario veterinario) {
			try {
				Veterinario veteReturn = veterinarioService.update(veterinario);
				model.addAttribute("veterinario", veteReturn);
				return "veterinarios/view"; // Archivo Html
			} catch (Exception e) {
				e.printStackTrace();
				System.err.println(e.getMessage());
			}
			return "redirect:/veterinarios";
		}
	 
		@GetMapping("new")		// GET: /products/{id}/edit
		public String newItem(Model model) {
			try {
				Veterinario veterinario = new Veterinario();
				model.addAttribute("veterinarioNew", veterinario);
				return "veterinarios/new";
			} catch (Exception e) {
				e.printStackTrace();
				System.err.println(e.getMessage());
			}
			return "redirect:/veterinarios";	// url
		}
		@PostMapping("savenew")	// POST: /veterinarios/savenew
		public String saveNew(Model model, @ModelAttribute("productNew") Veterinario veterinario) {
			try {
				Veterinario veterinarioReturn = veterinarioService.create(veterinario);
				model.addAttribute("veterinario", veterinarioReturn);
				return "veterinarios/view"; // Archivo Html
			} catch (Exception e) {
				e.printStackTrace();
				System.err.println(e.getMessage());
			}
			return "redirect:/veterinarios";
		}
}
