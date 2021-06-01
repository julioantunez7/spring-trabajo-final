package pe.edu.upc.trabajo.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Veterinarias")
//,indexes = { @Index(columnList = "veterinaria_nombre", name = "veterinarias_index_veterinaria_nombre")})
public class Veterinaria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "veterinaria_id")
	private Integer idVeterinaria;
	@Column(name = "veterinaria_nombre", length = 15)
	private String nombreVeterinaria;
	@Column(name = "veterinaria_direccion", length = 50)
	private String direccionVeterinaria;
	@Column(name = "veterinaria_numero", columnDefinition = "NUMERIC(9)")
	private Integer numeroVeterinaria;
	@Column(name = "veterinaria_descripcion", length = 100)
	private String descripcionVeterinaria;
	
	@OneToMany(mappedBy = "veterinaria", fetch = FetchType.LAZY)
	private List<Veterinario> veterinarios;
	
	@OneToMany(mappedBy = "veterinaria", fetch = FetchType.LAZY)
	private List<ListaProducto> listaproductos;
	
	public Integer getIdVeterinaria() {
		return idVeterinaria;
	}
	public void setIdVeterinaria(Integer idVeterinaria) {
		this.idVeterinaria = idVeterinaria;
	}
	public String getNombreVeterinaria() {
		return nombreVeterinaria;
	}
	public void setNombreVeterinaria(String nombreVeterinaria) {
		this.nombreVeterinaria = nombreVeterinaria;
	}
	public String getDireccionVeterinaria() {
		return direccionVeterinaria;
	}
	public void setDireccionVeterinaria(String direccionVeterinaria) {
		this.direccionVeterinaria = direccionVeterinaria;
	}
	public Integer getNumeroVeterinaria() {
		return numeroVeterinaria;
	}
	public void setNumeroVeterinaria(Integer numeroVeterinaria) {
		this.numeroVeterinaria = numeroVeterinaria;
	}
	public String getDescripcionVeterinaria() {
		return descripcionVeterinaria;
	}
	public void setDescripcionVeterinaria(String descripcionVeterinaria) {
		this.descripcionVeterinaria = descripcionVeterinaria;
	}
	
	
	public Veterinaria(Integer idVeterinaria, String nombreVeterinaria, String direccionVeterinaria,
			Integer numeroVeterinaria, String descripcionVeterinaria, List<Veterinario> veterinarios,
			List<ListaProducto> listaproductos) {
		super();
		this.idVeterinaria = idVeterinaria;
		this.nombreVeterinaria = nombreVeterinaria;
		this.direccionVeterinaria = direccionVeterinaria;
		this.numeroVeterinaria = numeroVeterinaria;
		this.descripcionVeterinaria = descripcionVeterinaria;
		this.veterinarios = veterinarios;
		this.listaproductos = listaproductos;
	}
	
	
	public Veterinaria() {
		super();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idVeterinaria == null) ? 0 : idVeterinaria.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veterinaria other = (Veterinaria) obj;
		if (idVeterinaria == null) {
			if (other.idVeterinaria != null)
				return false;
		} else if (!idVeterinaria.equals(other.idVeterinaria))
			return false;
		return true;
	}
	public List<Veterinario> getVeterinarios() {
		return veterinarios;
	}
	public void setVeterinarios(List<Veterinario> veterinarios) {
		this.veterinarios = veterinarios;
	}
	public List<ListaProducto> getListaproductos() {
		return listaproductos;
	}
	public void setListaproductos(List<ListaProducto> listaproductos) {
		this.listaproductos = listaproductos;
	}
	
	
}
