package pe.edu.upc.trabajo.service.crud;

import java.util.List;

import pe.edu.upc.trabajo.model.entity.Veterinario;

public interface VeterinarioService extends CrudService<Veterinario, Integer> {
	List<Veterinario> findByNombre(String nombre) throws Exception;
}
