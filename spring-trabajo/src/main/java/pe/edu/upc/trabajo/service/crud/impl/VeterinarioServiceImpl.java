package pe.edu.upc.trabajo.service.crud.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.trabajo.model.entity.Veterinario;
import pe.edu.upc.trabajo.model.repository.VeterinarioRepository;
import pe.edu.upc.trabajo.service.crud.VeterinarioService;

@Service
public class VeterinarioServiceImpl implements VeterinarioService{

	@Autowired
	private VeterinarioRepository veterinarioRepository;
	
	@Override
	public JpaRepository<Veterinario, Integer> getRepository() {
		return veterinarioRepository;
	}

	//@Transactional(readOnly=true)
	//@Override
	//public List<Veterinario> findByVeterinario(String veterinario) throws Exception {
	//	return veterinarioRepository.findByVeterinario(veterinario);
	//}
}
