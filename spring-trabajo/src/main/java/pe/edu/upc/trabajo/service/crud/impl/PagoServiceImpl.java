package pe.edu.upc.trabajo.service.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.trabajo.model.entity.Pago;
import pe.edu.upc.trabajo.model.repository.PagoRepository;
import pe.edu.upc.trabajo.service.crud.PagoService;

@Service
public class PagoServiceImpl implements PagoService{

	@Autowired
	private PagoRepository pagoRepository;
	
	@Override
	public JpaRepository<Pago, Integer> getRepository() {
		return pagoRepository;
	}

}
