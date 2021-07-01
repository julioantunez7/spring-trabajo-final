package pe.edu.upc.trabajo.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Veterinarios"
,indexes = { @Index(columnList = "veterinario_nombre", name = "veterinarios_index_nombre")})
public class Veterinario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "veterinario_id")
	private Integer id;
	@Column(name = "veterinario_nombre", length = 15)
	private String nombre;
	@Column(name = "veterinario_numero", columnDefinition = "NUMERIC(9)")
	private Integer numero;
	
	@ManyToOne
	@JoinColumn(name= "veterinaria_id")
	private Veterinaria veterinaria;
	
	@OneToMany(mappedBy = "veterinario", fetch = FetchType.LAZY)
	private List<Cita> citas;
	
	
	
	
	public Veterinario() {
		super();
	}



	public Veterinario(Integer id, String nombre, Integer numero, Veterinaria veterinaria, List<Cita> citas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.numero = numero;
		this.veterinaria = veterinaria;
		this.citas = citas;
	}



	public List<Cita> getCitas() {
		return citas;
	}



	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public Integer getNumero() {
		return numero;
	}



	public void setNumero(Integer numero) {
		this.numero = numero;
	}



	public Veterinaria getVeterinaria() {
		return veterinaria;
	}



	public void setVeterinaria(Veterinaria veterinaria) {
		this.veterinaria = veterinaria;
	}

}
