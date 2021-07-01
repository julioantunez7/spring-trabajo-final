package pe.edu.upc.trabajo.service.crud;

import java.util.List;

import pe.edu.upc.trabajo.model.entity.Mascota;

public interface MascotaService extends CrudService<Mascota, Integer> {
	List<Mascota> findByNombre(String nombre) throws Exception;
}
