package pe.edu.upc.trabajo.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Compras")
@IdClass(value = CompraId.class)
public class Compra {
	
	@Id
	@ManyToOne
	@JoinColumn(name= "boleta_id")
	private Boleta boleta;
	
	@Id
	@ManyToOne
	@JoinColumn(name= "producto_id")
	private Producto producto;
	
	
	@Column(name = "compra_cantidad")
	private Integer cantidad;	

	@ManyToOne
	@JoinColumn(name= "cliente_id")
	private Cliente cliente;

	public Boleta getBoleta() {
		return boleta;
	}

	public void setBoleta(Boleta boleta) {
		this.boleta = boleta;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Compra(Boleta boleta, Producto producto, Integer cantidad, Cliente cliente) {
		super();
		this.boleta = boleta;
		this.producto = producto;
		this.cantidad = cantidad;
		this.cliente = cliente;
	}

	public Compra() {
		super();
	}
	
	
}
