package pe.edu.upc.trabajo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.trabajo.model.entity.Boleta;

@Repository
public interface BoletaRepository extends JpaRepository<Boleta, Integer> {

}
