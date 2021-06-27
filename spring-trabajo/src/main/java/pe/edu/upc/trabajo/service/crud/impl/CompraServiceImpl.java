package pe.edu.upc.trabajo.service.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.trabajo.model.entity.Compra;
import pe.edu.upc.trabajo.model.repository.CompraRepository;
import pe.edu.upc.trabajo.service.crud.CompraService;

@Service
public class CompraServiceImpl implements CompraService {


	@Autowired
	private CompraRepository compraRepository;
	
	@Override
	public JpaRepository<Compra, Integer> getRepository() {
		return compraRepository;
	}

	@Override
	public List<Compra> findByIdCompra(Integer idCompra) throws Exception {
		return compraRepository.findByIdCompra(idCompra);
	}

}
