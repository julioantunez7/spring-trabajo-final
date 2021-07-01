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

import pe.edu.upc.trabajo.model.entity.Compra;
import pe.edu.upc.trabajo.model.entity.CompraProducto;
import pe.edu.upc.trabajo.model.entity.Producto;
import pe.edu.upc.trabajo.service.crud.CompraService;
import pe.edu.upc.trabajo.service.crud.ProductoService;

@Controller
@RequestMapping("/purchases")
@SessionAttributes("compra")
public class CompraController {
	@Autowired
	private ProductoService productoService;
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
	
	@GetMapping("buy1")
	public String AddProductosCompra(Model model, @PathVariable("id") Integer id) {
		try {
			Producto producto = new Producto();
			CompraProducto compraProducto = new CompraProducto();
			compraProducto.setId(id);
			compraProducto.setProducto(producto);
			List<Producto> productos = productoService.getAll();
			model.addAttribute("producto", producto);
			model.addAttribute("productos", productos);
			model.addAttribute("compraProducto", compraProducto);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "purchases/listaproductos";
	}
	
	@PostMapping("save-buy1")
	public String SaveProductosCompra(Model model, @ModelAttribute("compraProducto") CompraProducto compraProducto, @ModelAttribute("CompraNew") Compra compra) {
		
		Optional<Compra> optional;
		try {
			optional = compraService.findById(compraProducto.getId());
			if (optional.isEmpty()) {
				compraService.create(compra);
			}
			optional.get().getProductos().add(compraProducto.getProducto());
			compraProducto.getProducto().getCompras().add(optional.get());
			compraService.update(optional.get());
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return "redirect:/purchases";
	}
	
	//---
	
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
		return "redirect:/purchases";
	}
	
}
