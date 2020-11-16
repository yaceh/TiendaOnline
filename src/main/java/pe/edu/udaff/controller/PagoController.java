package pe.edu.udaff.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.edu.udaff.entities.Item;

@Controller
@RequestMapping("/pagar")
public class PagoController {
	
	@GetMapping("/1")
	public String pago(Model model) {
		model.addAttribute("title", "Pagar");
		return "views/public/pagar/index";
	}

	@ResponseBody
	@PostMapping("/2")
	public List<Item> finalizar(Model model, HttpSession session) {
		model.addAttribute("title", "Pagar");
		List<Item> cart =(List<Item>) session.getAttribute("cart");
		for(Item i:cart) {
			i.getProducto().setCategoria(null);
			i.getProducto().setPartner(null);
			i.getProducto().setMarca(null);
		}
		session.removeAttribute("cart");
		session.removeAttribute("total");
		return cart;
	}
	
}

