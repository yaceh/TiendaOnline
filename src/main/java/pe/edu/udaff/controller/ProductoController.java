package pe.edu.udaff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.udaff.entities.Categoria;
import pe.edu.udaff.service.CategoriaService;
import pe.edu.udaff.service.ProductoService;

@Controller
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private ProductoService productoService;
	
	@GetMapping("/categoria/{id}")
	public String categoria(@PathVariable("id") Integer id, Model model) {
		
		Categoria categoria=  categoriaService.findByIdCategoria(id);	
		
		model.addAttribute("title", "Categoria");
		
		model.addAttribute("productos",categoria.getProductos());
		return "views/public/producto/categoria";
	}
	
	@GetMapping("/detalle/{id}")
	public String detalle(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("title", "Detalle de Producto");
		model.addAttribute("producto",productoService.findByIdproducto(id));
		model.addAttribute("latestproducto", productoService.findLatest(PageRequest.of(0, 4)));
		return "views/public/producto/detalle";
	}
	
	

}
