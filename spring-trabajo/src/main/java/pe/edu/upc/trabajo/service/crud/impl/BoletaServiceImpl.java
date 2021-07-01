package pe.edu.upc.trabajo.service.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.trabajo.model.entity.Boleta;
import pe.edu.upc.trabajo.model.repository.BoletaRepository;
import pe.edu.upc.trabajo.service.crud.BoletaService;

@Service
public class BoletaServiceImpl implements BoletaService{

	@Autowired
	private BoletaRepository boletaRepository;
	
	@Override
	public JpaRepository<Boleta, Integer> getRepository() {
		return boletaRepository;
	}

}
