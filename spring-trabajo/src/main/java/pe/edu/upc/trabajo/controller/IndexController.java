package pe.edu.upc.trabajo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {
	@GetMapping
	public String indexGet(Model model) {
		return "index";
	}

	@GetMapping("login")
	public String login() {
		return "login";
	}
}
