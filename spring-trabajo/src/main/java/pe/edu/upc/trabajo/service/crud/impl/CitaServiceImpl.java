package pe.edu.upc.trabajo.service.crud.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.trabajo.model.entity.Cita;
import pe.edu.upc.trabajo.model.repository.CitaRepository;
import pe.edu.upc.trabajo.service.crud.CitaService;

@Service
public class CitaServiceImpl implements CitaService {

	@Autowired
	private CitaRepository citaRepository;
	
	@Override
	public JpaRepository<Cita, Integer> getRepository() {
		return citaRepository;
	}

	@Transactional(readOnly=true)
	@Override
	public List<Cita> findByFecha(Date fecha) throws Exception {
		return citaRepository.findByFecha(fecha);
	}

}