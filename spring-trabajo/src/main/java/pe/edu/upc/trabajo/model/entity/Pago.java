package pe.edu.upc.trabajo.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Pagos")
public class Pago {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pagos_id")
	private Integer id;
	
	@Column(name = "pagos_monto")
	private Integer monto;

	public Pago(Integer id, Integer monto) {
		super();
		this.id = id;
		this.monto = monto;
	}

	
	public Pago() {
		super();
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMonto() {
		return monto;
	}

	public void setMonto(Integer monto) {
		this.monto = monto;
	}
	
	
}
