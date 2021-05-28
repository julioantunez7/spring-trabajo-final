package pe.edu.upc.trabajo.service.crud.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajo.model.entity.Veterinaria;
import pe.edu.upc.trabajo.model.repository.VeterinariaRepository;
import pe.edu.upc.trabajo.service.crud.VeterinariaService;

@Service
public class VeterinariaServiceImpl implements VeterinariaService{


	@Autowired
	private VeterinariaRepository veterinariaRepository;
	
	@Override
	public JpaRepository<Veterinaria, Integer> getRepository() {
		return veterinariaRepository;
	}

}
