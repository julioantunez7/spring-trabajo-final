package pe.edu.upc.trabajo.model.entity;

import java.io.Serializable;
import java.util.Objects;

public class CompraId implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer boleta;
	private Integer producto;
	
	
	public CompraId(Integer boleta, Integer producto) {
		super();
		this.boleta = boleta;
		this.producto = producto;
	}

	
	public CompraId() {
		super();
	}

	public Integer getBoleta() {
		return boleta;
	}


	public void setBoleta(Integer boleta) {
		this.boleta = boleta;
	}


	public Integer getProducto() {
		return producto;
	}


	public void setProducto(Integer producto) {
		this.producto = producto;
	}


	@Override
	public int hashCode() {
		return Objects.hash(boleta , producto);
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null || this.getClass() != obj.getClass())
			return false;
		CompraId compraId = (CompraId)obj;
		
		if(this.boleta != compraId.boleta)
			return false;
		if(this.producto != compraId.producto)
			return false;
		return true;
	}
	
}