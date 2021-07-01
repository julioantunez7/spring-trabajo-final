package pe.edu.upc.trabajo.service.crud;

import java.util.Date;
import java.util.List;

import pe.edu.upc.trabajo.model.entity.Cita;

public interface CitaService extends CrudService<Cita, Integer> {
	List<Cita> findByFecha(Date fecha) throws Exception;
}