package pe.edu.upc.trabajo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.trabajo.model.entity.Producto;
import pe.edu.upc.trabajo.service.crud.ProductoService;

@Controller
@RequestMapping("/purchases")

public class CompraController {
	@Autowired
	private ProductoService productoService;
	
	@GetMapping("buyproducts")
	public String ListarProductos(Model model) {
		try {
			List<Producto> producto = productoService.getAll();
			model.addAttribute("compras", producto);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "purchases/listaproductos";
	}
	
}
