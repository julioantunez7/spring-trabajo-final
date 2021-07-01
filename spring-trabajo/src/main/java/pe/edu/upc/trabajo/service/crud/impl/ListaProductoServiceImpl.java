package pe.edu.upc.trabajo.service.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.trabajo.model.entity.ListaProducto;
import pe.edu.upc.trabajo.model.entity.ListaProductoId;
import pe.edu.upc.trabajo.model.repository.ListaProductoRepository;
import pe.edu.upc.trabajo.service.crud.ListaProductoService;

@Service
public class ListaProductoServiceImpl implements ListaProductoService{

	@Autowired
	private ListaProductoRepository listaProductoRepository;
	
	@Override
	public JpaRepository<ListaProducto, ListaProductoId> getRepository() {
		return listaProductoRepository;
	}

}
