package pe.edu.upc.trabajo.model.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.trabajo.model.entity.Cita;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Integer> {
	List<Cita> findByFecha(Date fecha);
}