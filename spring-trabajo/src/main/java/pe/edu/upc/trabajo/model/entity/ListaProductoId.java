package pe.edu.upc.trabajo.model.entity;

import java.io.Serializable;
import java.util.Objects;

public class ListaProductoId implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer veterinaria;
	private Integer producto;
	
	
	public ListaProductoId(Integer veterinaria, Integer producto) {
		super();
		this.veterinaria = veterinaria;
		this.producto = producto;
	}

	
	public ListaProductoId() {
		super();
	}
	
	
	public Integer getVeterinaria() {
		return veterinaria;
	}


	public void setVeterinaria(Integer veterinaria) {
		this.veterinaria = veterinaria;
	}


	public Integer getProducto() {
		return producto;
	}


	public void setProducto(Integer producto) {
		this.producto = producto;
	}


	@Override
	public int hashCode() {
		return Objects.hash( veterinaria , producto);
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null || this.getClass() != obj.getClass())
			return false;
		ListaProductoId listaProductoId = (ListaProductoId)obj;
		
		
		if(this.veterinaria != listaProductoId.veterinaria)
			return false;
		if(this.producto != listaProductoId.producto)
			return false;
		return true;
	}
}