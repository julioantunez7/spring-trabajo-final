package pe.edu.upc.trabajo.service.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.trabajo.model.entity.Consulta;
import pe.edu.upc.trabajo.model.repository.ConsultaRepository;
import pe.edu.upc.trabajo.service.crud.ConsultaService;

@Service
public class ConsultaServiceImpl implements ConsultaService {

	@Autowired
	private ConsultaRepository consultaRepository;
	
	@Override
	public JpaRepository<Consulta, Integer> getRepository() {
		return consultaRepository;
	}

}
