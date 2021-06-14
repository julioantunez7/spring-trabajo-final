package pe.edu.upc.trabajo.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.trabajo.model.entity.Producto;
import pe.edu.upc.trabajo.model.entity.Veterinaria;
import pe.edu.upc.trabajo.service.crud.ProductoService;
import pe.edu.upc.trabajo.service.crud.VeterinariaService;

@Controller
@RequestMapping("/search")
public class SearchController {
	
	@Autowired
	private VeterinariaService veterinariaService;
	
	@Autowired
	private ProductoService productoService;
	
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
	


}
