package pe.edu.udaff.controller.admin;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import pe.edu.udaff.entities.Categoria;
import pe.edu.udaff.entities.Marca;
import pe.edu.udaff.entities.Partner;
import pe.edu.udaff.entities.Producto;
import pe.edu.udaff.service.CategoriaService;
import pe.edu.udaff.service.MarcaService;
import pe.edu.udaff.service.PartnerService;
import pe.edu.udaff.service.ProductoService;
import pe.edu.udaff.service.UploadFileService;

@Controller
@RequestMapping("/admin/producto")
public class AdminProductoController {

	@Autowired
	private ProductoService productoService;
	@Autowired
	private MarcaService marcaService;
	@Autowired
	private CategoriaService categoriaService;
	@Autowired
	private PartnerService partnerService;
	
	@Autowired
	private UploadFileService uploadFileService;

	@GetMapping()
	public String producto(Model model) {
		model.addAttribute("title", "Admin | Producto");
		model.addAttribute("productos",productoService.getAll());
		model.addAttribute("marcas",marcaService.findAll());
		model.addAttribute("categorias",categoriaService.getAll());
		model.addAttribute("partners",partnerService.findAll());
		return "views/admin/producto/index";
	}
	
	@ResponseBody
	@GetMapping("/{id}")
	public Producto getProducto(@PathVariable("id") Integer id) {
		Producto p=productoService.findByIdproducto(id);
		Marca m= new Marca();
		m.setNombre(p.getMarca().getNombre());
		m.setIdmarca(p.getMarca().getIdmarca());
		p.setMarca(m);
		
		Partner part= new Partner();
		part.setName(p.getPartner().getName());
		part.setIdpartner(p.getPartner().getIdpartner());
		p.setPartner(part);
		
		Categoria c= new Categoria();
		c.setNombre(p.getCategoria().getNombre());
		c.setIdcategoria(p.getCategoria().getIdcategoria());
		p.setCategoria(c);
		return p;
	}
	@ResponseBody
	@PostMapping("editar")
	public boolean editarProducto(@RequestBody Producto producto) {
		Producto prodAnt=productoService.findByIdproducto(producto.getIdproducto());
		prodAnt.setCantidad(producto.getCantidad());
		prodAnt.setCategoria(producto.getCategoria());
		prodAnt.setDescripcion(producto.getDescripcion());
		prodAnt.setMarca(producto.getMarca());
		prodAnt.setNombre(producto.getNombre());
		prodAnt.setPrecio(producto.getPrecio());
		prodAnt.setPartner(producto.getPartner());
		productoService.save(prodAnt);
		
		return true;
	}
	@ResponseBody
	@PostMapping("agregar")
	public boolean agregarProducto(@RequestBody Producto producto) {

		productoService.save(producto);
		return true;
	}
	@ResponseBody
	@PostMapping("eliminar")
	public boolean eliminarProducto(@RequestParam(name="id") Integer id) {
		Producto prodAnt=productoService.findByIdproducto(id);
		productoService.delete(prodAnt);
		return true;
	}
	@ResponseBody
	@PostMapping("cambiarActivo")
	public boolean cambiarActivo(@RequestParam(name="id") Integer id) {
		Producto prodAnt=productoService.findByIdproducto(id);
		prodAnt.setActivo(!prodAnt.getActivo());
		productoService.save(prodAnt);
		return true;
	}
	@ResponseBody
	@PostMapping("/addImagen")
	public boolean addImagen(@RequestBody MultipartFile inputImagen,
			@RequestParam(name = "idproducto") Integer idproducto) {
		if (!inputImagen.isEmpty()) {
			Producto p= productoService.findByIdproducto(idproducto);
			try {
				
				p.setUrlimagen(uploadFileService.saveImagen(inputImagen, idproducto));
				productoService.save(p);
			} catch (IOException e) {
				System.out.println("mensaje error:");
				e.printStackTrace();
			}
			return true;
		} else {
			return false;
		}
	}
}
