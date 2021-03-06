package pe.edu.udaff.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.edu.udaff.entities.Item;
import pe.edu.udaff.entities.Producto;
import pe.edu.udaff.service.ProductoService;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private ProductoService productoService;

	@GetMapping()
	public String cart(Model model) {
		model.addAttribute("title","Cart");
		return "views/public/cart/index";
	}
	
	@GetMapping("/buy/{id}")
	public String add(@PathVariable("id") int id,@RequestParam(name="cantidad")Integer cantidad, HttpSession session, Model model) {
		model.addAttribute("title", "Cart");
		if (session.getAttribute("cart")== null) {
			List<Item> cart = new ArrayList<Item>();
			Producto p=productoService.findByIdproducto(id);
			cart.add(new Item(p, p.getCantidad()>cantidad? cantidad:p.getCantidad() ));
			session.setAttribute("cart", cart);
			session.setAttribute("total",calcularTotal(cart));
		} else {
			List<Item> cart =(List<Item>) session.getAttribute("cart");
			 int index= isExists(id,session);
			 
			 if (index== -1) {
				 Producto p=productoService.findByIdproducto(id);
				 cart.add(new Item(p, p.getCantidad()>cantidad? cantidad:p.getCantidad() ));
			} else {
				Producto p=productoService.findByIdproducto(id);
				int quantity= cart.get(index).getQuantity() +cantidad;
				quantity= quantity>p.getCantidad()? p.getCantidad():quantity ;
				cart.get(index).setQuantity(quantity);
				session.setAttribute("cart", cart);
				
			}
			 session.setAttribute("cart", cart);
			 session.setAttribute("total",calcularTotal(cart));
		}
		return "views/public/cart/index";
	}

	private int isExists(int id, HttpSession session) {
		// TODO Auto-generated method stub
		List<Item> cart =(List<Item>) session.getAttribute("cart");
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getProducto().getIdproducto() ==id) {
				
				return i;
			}
		}
		return -1;
	}
	
	@GetMapping("/delete/{index}")
	public String delete(@PathVariable("index") int index, HttpSession session) {
		List<Item> cart =(List<Item>) session.getAttribute("cart");
		cart.remove(index);
		session.setAttribute("cart", cart);
		session.setAttribute("total",calcularTotal(cart));
		return "redirect:/cart";
	}
	
	private double calcularTotal(List<Item> cart) {
		double total=0;
		for(Item i :cart) {
			total+=i.getQuantity()*i.getProducto().getPrecio().doubleValue();
		}
		return total;
	}
}
