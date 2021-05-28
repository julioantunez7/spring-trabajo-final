package pe.edu.upc.trabajo.service.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.trabajo.model.entity.Cita;
import pe.edu.upc.trabajo.model.entity.CitaId;
import pe.edu.upc.trabajo.model.repository.CitaRepository;
import pe.edu.upc.trabajo.service.crud.CitaService;

@Service
public class CitaServiceImpl implements CitaService {

	@Autowired
	private CitaRepository citaRepository;
	
	@Override
	public JpaRepository<Cita, CitaId> getRepository() {
		return citaRepository;
	}

}
