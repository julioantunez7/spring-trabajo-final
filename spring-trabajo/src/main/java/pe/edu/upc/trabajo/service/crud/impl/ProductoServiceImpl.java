package pe.edu.upc.trabajo.service.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.trabajo.model.entity.Producto;
import pe.edu.upc.trabajo.model.repository.ProductoRepository;
import pe.edu.upc.trabajo.service.crud.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService{


	@Autowired
	private ProductoRepository productoRepository;
	
	@Override
	public JpaRepository<Producto, Integer> getRepository() {
		return productoRepository;
	}

}
