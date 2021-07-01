package pe.edu.upc.trabajo.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Compras")
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Compra_id")
	private Integer idCompra;

	@ManyToOne
	@JoinColumn(name = "boleta_id")
	private Boleta boleta;

	@Column(name = "compra_cantidad")
	private Integer cantidad;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "compra_producto", joinColumns = @JoinColumn(name = "idProducto"), inverseJoinColumns = @JoinColumn(name = "Compra_id"))
	private List<Producto> productos = new ArrayList<Producto>();

//	@OneToMany(mappedBy = "compra", fetch = FetchType.LAZY)
//	private List<Producto> productos;	

	public Integer getIdCompra() {
		return idCompra;
	}

	public Compra(Integer idCompra, Boleta boleta, Integer cantidad, Cliente cliente, List<Producto> productos) {
		super();
		this.idCompra = idCompra;
		this.boleta = boleta;
		this.cantidad = cantidad;
		this.cliente = cliente;
		this.productos = productos;
	}

	public void setIdCompra(Integer idCompra) {
		this.idCompra = idCompra;
	}

	public Boleta getBoleta() {
		return boleta;
	}

	public void setBoleta(Boleta boleta) {
		this.boleta = boleta;
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

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public Compra() {
		super();
	}

}