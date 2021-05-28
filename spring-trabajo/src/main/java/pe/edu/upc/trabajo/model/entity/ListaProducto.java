package pe.edu.upc.trabajo.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ListaProductos")
@IdClass(value = ListaProductoId.class)
public class ListaProducto {
	@Id
	@ManyToOne
	@JoinColumn(name= "veterinaria_id")
	private Veterinaria veterinaria;
	
	@Id
	@ManyToOne
	@JoinColumn(name= "producto_id")
	private Producto producto;
	
	@Column(name = "pagos_id")
	private Integer precio;
	
	@Column(name = "stock_id")
	private Integer stock;
	
	
	public ListaProducto() {
		super();
	}

	public ListaProducto(Veterinaria veterinaria, Producto producto, Integer precio, Integer stock) {
		super();
		this.veterinaria = veterinaria;
		this.producto = producto;
		this.precio = precio;
		this.stock = stock;
	}

	public Veterinaria getVeterinaria() {
		return veterinaria;
	}

	public void setVeterinaria(Veterinaria veterinaria) {
		this.veterinaria = veterinaria;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
	
	
	
}