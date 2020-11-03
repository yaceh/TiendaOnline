package pe.edu.udaff.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pe.edu.udaff.service.ProductoService;

@Controller
public class AdminHomeController {
	@Autowired
	private ProductoService productoService;

	@GetMapping({ "/admin"})
	public String home(Model model) {
		return "views/admin/home/index";
	}
}
