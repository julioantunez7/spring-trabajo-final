package pe.edu.upc.trabajo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.trabajo.model.entity.Cliente;
import pe.edu.upc.trabajo.service.crud.ClienteService;

@Controller
@RequestMapping("/customers")
public class ClienteController {
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("search")
	public String buscar(Model model) {
		try {
			List<Cliente> customers = clienteService.getAll();
			model.addAttribute("customers", customers);
			
			Cliente customerSearch = new Cliente();
			model.addAttribute("customerSearch", customerSearch);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "customer/searchCustomer";
	}
	
	@GetMapping("{id}")
	public String findById(Model model, @PathVariable("id") Integer id) {
		try {
			Optional<Cliente> optional = clienteService.findById(id);
			if(optional.isPresent()) {
				model.addAttribute("customer", optional.get());
				return "customer/detailCustomer";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "";
	}
}
