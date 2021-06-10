package pe.edu.upc.trabajo.service.crud;

import java.util.List;

import pe.edu.upc.trabajo.model.entity.Veterinaria;

public interface VeterinariaService extends CrudService<Veterinaria, Integer> {
	List<Veterinaria> findByNombreVeterinaria(String nombreVeterinaria) throws Exception;
}
