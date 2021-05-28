package pe.edu.upc.trabajo.service.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.trabajo.model.entity.Compra;
import pe.edu.upc.trabajo.model.entity.CompraId;
import pe.edu.upc.trabajo.model.repository.CompraRepository;
import pe.edu.upc.trabajo.service.crud.CompraService;

@Service
public class CompraServiceImpl implements CompraService {


	@Autowired
	private CompraRepository compraRepository;
	
	@Override
	public JpaRepository<Compra, CompraId> getRepository() {
		return compraRepository;
	}

}
