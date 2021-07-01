package pe.edu.upc.trabajo.service.crud.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.trabajo.model.entity.Cliente;
import pe.edu.upc.trabajo.model.repository.ClienteRepository;
import pe.edu.upc.trabajo.service.crud.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {


	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public JpaRepository<Cliente, Integer> getRepository() {
		return clienteRepository;
	}

	@Transactional(readOnly=true)
	@Override
	public List<Cliente> findByNombre(String nombre) throws Exception {
		return clienteRepository.findByNombre(nombre);
	}

}
