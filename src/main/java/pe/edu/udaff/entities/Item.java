package pe.edu.udaff.entities;

public class Item {

	private Producto producto;
	private int quantity;
	public Item() {
		super();
	}
	public Item(Producto producto, int quantity) {
		super();
		this.producto = producto;
		this.quantity = quantity;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
