package pe.edu.upc.trabajo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.trabajo.model.entity.Compra;
import pe.edu.upc.trabajo.model.entity.Producto;
import pe.edu.upc.trabajo.service.crud.CompraService;
import pe.edu.upc.trabajo.service.crud.ProductoService;

@Controller
@RequestMapping("/purchases")

public class CompraController {
	@Autowired
	private ProductoService productoService;
	private Compra compra;
	private Producto producto;
	private CompraService compraService;
	
	@GetMapping
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
	
	@GetMapping("/addpurchase")
	public String AgregarCompra(Model model) {
	model.addAttribute("compraDelForm", compra);
	model.addAttribute("productos", productoService.SearchAllProducts());
	model.addAttribute("productoDelForm", producto);
	return "purchases/compraForm";
	}
	
	@PostMapping("/addpurchase")
	public String CrearCompraFinal(@ModelAttribute("compraDelForm") Compra compra, Model model) {
		compra.setProductos(productoService.SearchAllProducts());
		try {
			compraService.create(compra);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		productoService.deleteAllProducts();
		return "redirect:/addpurchase";
	}
	

	
}
