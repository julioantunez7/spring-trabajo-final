package pe.edu.upc.trabajo.service.crud;

import java.util.List;

import pe.edu.upc.trabajo.model.entity.Compra;

public interface CompraService extends CrudService<Compra, Integer> {
	List<Compra> findByIdCompra(Integer idCompra) throws Exception;
}
