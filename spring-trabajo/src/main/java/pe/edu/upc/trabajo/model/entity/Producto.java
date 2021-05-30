package pe.edu.upc.trabajo.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Productos")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idProducto")
	private Integer idProducto;
	
	@Column(name = "nombreProducto", length = 15)
	private String nombreProducto;
	@Column(name = "descripcionProducto", length = 100)
	private String descripcionProducto;
	@Column(name = "precioProducto")
	private Integer precioProducto;
	
	@OneToMany(mappedBy = "producto", fetch = FetchType.LAZY)
	private List<ListaProducto> listaProductos;
	
	@OneToMany(mappedBy = "producto", fetch = FetchType.LAZY)
	private List<Compra> compras;
	
	public Producto() {
		super();
	}

	public Producto(Integer idProducto, String nombreProducto, String descripcionProducto, Integer precioProducto) {
		super();
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.descripcionProducto = descripcionProducto;
		this.precioProducto = precioProducto;
	}
	
	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getDescripcionProducto() {
		return descripcionProducto;
	}

	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}

	public Integer getPrecioProducto() {
		return precioProducto;
	}

	public void setPrecioProducto(Integer precioProducto) {
		this.precioProducto = precioProducto;
	}

	public List<ListaProducto> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<ListaProducto> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

	
}