package pe.edu.upc.trabajo.service.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.trabajo.model.entity.Mascota;
import pe.edu.upc.trabajo.model.repository.MascotaRepository;
import pe.edu.upc.trabajo.service.crud.MascotaService;

@Service
public class MascotaServiceImpl implements MascotaService{

	@Autowired
	private MascotaRepository mascotaRepository;
	
	@Override
	public JpaRepository<Mascota, Integer> getRepository() {
		return mascotaRepository;
	}

}
