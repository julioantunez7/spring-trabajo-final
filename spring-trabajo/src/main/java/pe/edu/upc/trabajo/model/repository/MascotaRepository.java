package pe.edu.upc.trabajo.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.trabajo.model.entity.Mascota;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Integer> {
	//List<Mascota> findByMascota(String mascota);
}
