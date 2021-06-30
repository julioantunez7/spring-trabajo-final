package pe.edu.upc.trabajo.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Consultas")
public class Consulta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "consulta_id")
	private Integer id;
	
	@Column(name = "consulta_receta", length = 30)
	private String receta;
	@Column(name = "link_whats", length = 30)
	private String linkwhats;
	@OneToOne()
	private Cita cita;

	
	
	
	public String getLinkwhats() {
		return linkwhats;
	}

	public void setLinkwhats(String linkwhats) {
		this.linkwhats = linkwhats;
	}



	public Consulta(Integer id, String receta, Cita cita) {
		super();
		this.id = id;
		this.receta = receta;
		this.cita = cita;
	}
	
	

	public Consulta() {
		super();
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getReceta() {
		return receta;
	}

	public void setReceta(String receta) {
		this.receta = receta;
	}

	public Cita getCita() {
		return cita;
	}

	public void setCita(Cita cita) {
		this.cita = cita;
	}
	
	
}

