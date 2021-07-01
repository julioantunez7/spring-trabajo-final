package pe.edu.upc.trabajo.service.crud;

import java.util.List;

import pe.edu.upc.trabajo.model.entity.Cliente;

public interface ClienteService extends CrudService<Cliente, Integer> {
	List<Cliente> findByNombre(String nombre) throws Exception;
}
