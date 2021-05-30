package pe.edu.upc.trabajo.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "Boletas")
public class Boleta {
	@Id
	@Column(name = "boleta_id")
	private Integer id;

	@ManyToOne
	@JoinColumn(name= "cliente_id")
	private Cliente cliente;
	
	@Column(name = "boleta_precioTotal")
	private Integer precioTotal;

	@OneToMany(mappedBy = "boleta", fetch = FetchType.LAZY)
	private List<Compra> compras;

	//Constructor
	public Boleta(Integer id, Cliente cliente, Integer precioTotal, List<Compra> compras) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.precioTotal = precioTotal;
		this.compras = compras;
	}

	
	public Boleta() {
		super();
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Integer getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(Integer precioTotal) {
		this.precioTotal = precioTotal;
	}

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}
	
	
}
