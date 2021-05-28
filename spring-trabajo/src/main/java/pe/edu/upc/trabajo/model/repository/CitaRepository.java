package pe.edu.upc.trabajo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.trabajo.model.entity.Cita;
import pe.edu.upc.trabajo.model.entity.CitaId;

@Repository
public interface CitaRepository extends JpaRepository<Cita, CitaId> {

}
