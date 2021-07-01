package pe.edu.upc.trabajo.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Citas",
		indexes= {@Index( columnList = "cita_fecha", name = "citas_index_cita_fecha")})
public class Cita {
	
	@Id
	private Integer id;

	@ManyToOne
	@JoinColumn(name= "veterinario_id")
	private Veterinario veterinario;

	@ManyToOne
	@JoinColumn(name= "mascota_id")
	private Mascota mascota;
	
	@Column(name = "cita_fecha", length = 10)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date fecha;
	@Column(name = "cita_razon", length = 20)
	private String razon;
	@Column(name = "cita_precio", columnDefinition = "DECIMAL(5,2)")
	private Float precio;
	
	@OneToOne(mappedBy = "cita", fetch = FetchType.LAZY)
	private Consulta consulta;
	
	//Constructor

	public Cita(Integer id, Veterinario veterinario, Mascota mascota, Date fecha, String razon, Float precio,
			Consulta consulta) {
		super();
		this.id = id;
		this.veterinario = veterinario;
		this.mascota = mascota;
		this.fecha = fecha;
		this.razon = razon;
		this.precio = precio;
		this.consulta = consulta;
	}

	
	public Cita() {
		super();
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Veterinario getVeterinario() {
		return veterinario;
	}

	public void setVeterinario(Veterinario veterinario) {
		this.veterinario = veterinario;
	}

	public Mascota getMascota() {
		return mascota;
	}

	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getRazon() {
		return razon;
	}

	public void setRazon(String razon) {
		this.razon = razon;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}
	
	
}