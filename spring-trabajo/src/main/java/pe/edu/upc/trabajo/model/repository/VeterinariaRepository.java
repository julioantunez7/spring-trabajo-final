package pe.edu.upc.trabajo.model.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.trabajo.model.entity.Veterinaria;

@Repository
public interface VeterinariaRepository extends JpaRepository<Veterinaria, Integer> {
	//List<Veterinaria> findByVeterinaria(String veterinaria);
}
