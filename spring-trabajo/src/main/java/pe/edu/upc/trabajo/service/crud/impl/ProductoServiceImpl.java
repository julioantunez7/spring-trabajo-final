package pe.edu.upc.trabajo.service.crud.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.trabajo.model.entity.Producto;
import pe.edu.upc.trabajo.model.repository.ProductoRepository;
import pe.edu.upc.trabajo.service.crud.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService{


	@Autowired
	private ProductoRepository productoRepository;
	private List<Producto> auxiliarList = new ArrayList<>();
	
	@Override
	public JpaRepository<Producto, Integer> getRepository() {
		return productoRepository;
	}

	@Transactional(readOnly=true)
	@Override
	public List<Producto> findByNombreProducto(String nombreProducto) throws Exception {
		return productoRepository.findByNombreProducto(nombreProducto);
	}

	@Override
	public List<Producto> findByDescripcionProducto(String descripcionProducto) throws Exception {
		
		return productoRepository.findByDescripcionProducto(descripcionProducto);
	}

	@Override
	public void saveFoundProduct(Producto producto) {
		auxiliarList.add(producto);
		
	}

	@Override
	public void saveProduct(Producto producto) {
		productoRepository.save(producto);
		auxiliarList.add(producto);
	}

	@Override
	public void deleteAllProducts() {
		auxiliarList = new ArrayList<>();
	}

	@Override
	public List<Producto> SearchAllProducts() {
		return auxiliarList;
	}

}
