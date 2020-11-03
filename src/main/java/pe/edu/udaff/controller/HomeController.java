package pe.edu.udaff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pe.edu.udaff.service.ProductoService;

@Controller
public class HomeController {
	
	@Autowired
	private ProductoService productoService;
	
	@GetMapping({"/","/home"})
	public String home(Model model) {
		model.addAttribute("featureProductos", productoService.findByFeature((byte)1, PageRequest.of(0, 8)));
		return "views/public/home/index";
	}

}
