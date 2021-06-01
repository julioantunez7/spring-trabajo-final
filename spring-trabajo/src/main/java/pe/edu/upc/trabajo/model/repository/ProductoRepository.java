package pe.edu.upc.trabajo.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.trabajo.model.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
	//List<Producto> findByProducto(String producto);
}
