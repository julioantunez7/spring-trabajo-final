package pe.edu.upc.trabajo.model.entity;

import java.io.Serializable;
import java.util.Objects;


public class CitaId implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer veterinario;
	private Integer mascota;
	
	
	public CitaId(Integer id, Integer veterinario, Integer mascota) {
		super();
		this.id = id;
		this.veterinario = veterinario;
		this.mascota = mascota;
	}


	public CitaId() {
		super();
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getVeterinario() {
		return veterinario;
	}

	public void setVeterinario(Integer veterinario) {
		this.veterinario = veterinario;
	}

	public Integer getMascota() {
		return mascota;
	}

	public void setMascota(Integer mascota) {
		this.mascota = mascota;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, veterinario , mascota);
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null || this.getClass() != obj.getClass())
			return false;
		CitaId citaId = (CitaId)obj;
		
		if(this.id != citaId.id)
			return false;
		if(this.veterinario != citaId.veterinario)
			return false;
		if(this.mascota != citaId.mascota)
			return false;
		return true;
	}
	
}
