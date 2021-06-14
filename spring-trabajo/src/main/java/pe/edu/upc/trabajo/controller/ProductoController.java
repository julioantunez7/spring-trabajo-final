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

import pe.edu.upc.trabajo.service.crud.ProductoService;

@Controller
@RequestMapping("/products")
@SessionAttributes("productEdit")
public class ProductoController {
	
    @Autowired
	private ProductoService productoService;
	
    @GetMapping("search2")	
	public String mostrar(Model model) {
		try {
			Producto proSearch = new Producto();
			model.addAttribute("proSearch", proSearch);
			Producto proDescripcionSearch = new Producto();
			model.addAttribute("proDescripcionSearch", proDescripcionSearch);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "products/search-product";
	}
    
    @GetMapping
	public String listar(Model model) {
		try {
			List<Producto> productos = productoService.getAll();
			model.addAttribute("productos", productos);			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "products/lista-productos";
	
	
    }
    
    @GetMapping("{idProducto}")		// GET: /v/{id}
	public String findById(Model model, @PathVariable("idProducto") Integer id) {
		try {
			Optional<Producto> optional = productoService.findById(id);
			if(optional.isPresent()) {
				model.addAttribute("pro", optional.get());
				return "products/details-product"; // Archivo Html
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/products";	// url
    }
    
    
    @GetMapping("{id}/edit")		// GET: /products/{id}/edit
	public String findById2(Model model, @PathVariable("id") Integer id) {
		try {
			Optional<Producto> optional = productoService.findById(id);
			if(optional.isPresent()) {
				model.addAttribute("productEdit", optional.get());
				return "products/edit";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/products";	// url
	}
	@PostMapping("save")	// POST: /products/save
	public String saveEdit(Model model, @ModelAttribute("productEdit") Producto product) {
		try {
			Producto productReturn = productoService.update(product);
			model.addAttribute("product", productReturn);
			return "products/view"; // Archivo Html
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/products";
	}
	
	@GetMapping("new")		// GET: /products/{id}/edit
	public String newItem(Model model) {
		try {
			Producto product = new Producto();
			model.addAttribute("productNew", product);
			return "products/new";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/products";	// url
	}
    
	
	@PostMapping("savenew")	// POST: /products/savenew
	public String saveNew(Model model, @ModelAttribute("productNew") Producto product) {
		try {
			Producto productReturn = productoService.create(product);
			model.addAttribute("product", productReturn);
			return "products/view"; // Archivo Html
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/products";
	}
	
}
