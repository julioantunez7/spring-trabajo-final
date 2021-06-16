package pe.edu.upc.trabajo.service.crud;

import java.util.List;

import pe.edu.upc.trabajo.model.entity.Producto;

public interface ProductoService extends CrudService<Producto, Integer> {
	List<Producto> findByNombreProducto(String nombreProducto) throws Exception;
	List<Producto> findByDescripcionProducto(String descripcionProducto) throws Exception;
	public void saveFoundProduct(Producto producto);
	public void saveProduct(Producto producto);
	public void deleteAllProducts();
}
