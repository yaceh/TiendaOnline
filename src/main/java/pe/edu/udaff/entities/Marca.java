package pe.edu.udaff.entities;
// Generated 04-nov-2020 10:46:38 by Hibernate Tools 5.2.12.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Marca generated by hbm2java
 */
@Entity
@Table(name = "marca", catalog = "fastmarketbd")
public class Marca implements java.io.Serializable {

	private Integer idmarca;
	private String nombre;
	private Set<Producto> productos = new HashSet<Producto>(0);

	public Marca() {
	}

	public Marca(String nombre, Set<Producto> productos) {
		this.nombre = nombre;
		this.productos = productos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idmarca", unique = true, nullable = false)
	public Integer getIdmarca() {
		return this.idmarca;
	}

	public void setIdmarca(Integer idmarca) {
		this.idmarca = idmarca;
	}

	@Column(name = "nombre", length = 30)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "marca")
	public Set<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}

}
