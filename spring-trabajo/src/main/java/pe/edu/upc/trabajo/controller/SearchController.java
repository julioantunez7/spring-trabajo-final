package pe.edu.upc.trabajo.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.trabajo.model.entity.Cita;
import pe.edu.upc.trabajo.model.entity.Mascota;
import pe.edu.upc.trabajo.model.entity.Producto;
import pe.edu.upc.trabajo.model.entity.Veterinaria;
import pe.edu.upc.trabajo.model.entity.Veterinario;
import pe.edu.upc.trabajo.service.crud.CitaService;
import pe.edu.upc.trabajo.service.crud.MascotaService;
import pe.edu.upc.trabajo.service.crud.ProductoService;
import pe.edu.upc.trabajo.service.crud.VeterinariaService;
import pe.edu.upc.trabajo.service.crud.VeterinarioService;

@Controller
@RequestMapping("/search")
public class SearchController {
	
	@Autowired
	private VeterinariaService veterinariaService;
	
	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private CitaService citaService;

	@Autowired
	private VeterinarioService veterinarioService;
	
	@Autowired
	private MascotaService mascotaService;
	
	@GetMapping("vets")
	public String searchVetGet(Model model, @ModelAttribute("vetSearch") Veterinaria vetSearch) {
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
	
	@GetMapping("vets/distrit")
	public String searchVetDistritGet(Model model, @ModelAttribute("vetDistritSearch") Veterinaria vetDistritSearch) {
		System.out.println(vetDistritSearch.getDireccionVeterinaria());
		try {
			List<Veterinaria> vetsDistritFound = veterinariaService.findByDireccionVeterinaria(vetDistritSearch.getDireccionVeterinaria());
			model.addAttribute("vetsDistritFound", vetsDistritFound);
			model.addAttribute("vetDistritSearch", vetDistritSearch);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "search/vets-result1";
	}
	
	
	//------------------------
	//------PRODUCTO----
	
	
	@GetMapping("products")
	public String searchpProductoGet(Model model, @ModelAttribute("proSearch") Producto proSearch) {
		System.out.println(proSearch.getNombreProducto());
		try {
			List<Producto> proFound = productoService.findByNombreProducto(proSearch.getNombreProducto());
			model.addAttribute("proFound", proFound);
			model.addAttribute("proSearch", proSearch);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "search/product-result";
	}
	
	@GetMapping("products/descripcion")
	public String searchProductDescripcionGet(Model model, @ModelAttribute("proDescripcionSearch") Producto proDescripcionSearch) {
		System.out.println(proDescripcionSearch.getDescripcionProducto());
		try {
			List<Producto> proDescripcionFound = productoService.findByDescripcionProducto(proDescripcionSearch.getDescripcionProducto());
			model.addAttribute("proDescripcionFound", proDescripcionFound);
			model.addAttribute("proDescripcionSearch", proDescripcionSearch);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "search/product-result1";
	}
	
	
	//------CITA----
	
	@GetMapping("appointments")
	public String searchAppointmentGet(Model model, @ModelAttribute("appointmentSearch") Cita appointmentSearch) {
		System.out.println(appointmentSearch.getFecha());
		try {
			List<Cita> appointmentsFound=citaService.findByFecha(appointmentSearch.getFecha());
			model.addAttribute("appointmentsFound", appointmentsFound);
			model.addAttribute("appointmentSearch", appointmentSearch);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "search/appointments-result";
	}
	
	//------VETERINARIO----
	
	@GetMapping("veterinarios")
	public String searchVeterinarioGet(Model model, @ModelAttribute("veteSearch") Veterinario veteSearch) {
		System.out.println(veteSearch.getNombre());
		try {
			List<Veterinario> veteFound = veterinarioService.findByNombre(veteSearch.getNombre());
			model.addAttribute("veteFound", veteFound);
			model.addAttribute("veteSearch", veteSearch);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "search/veterinario-result";
	}
	
	//------MASCOTA----
	
	@GetMapping("pets")
	public String searchPetGet(Model model, @ModelAttribute("petSearch") Mascota petSearch) {
		System.out.println(petSearch.getNombre());
		try {
			List<Mascota> petsFound=mascotaService.findByNombre(petSearch.getNombre());
			model.addAttribute("petsFound", petsFound);
			model.addAttribute("petSearch", petSearch);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "search/pets-result";
	}
	
}
