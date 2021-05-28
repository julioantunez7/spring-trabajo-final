package pe.edu.upc.trabajo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.trabajo.model.entity.ListaProducto;
import pe.edu.upc.trabajo.model.entity.ListaProductoId;

@Repository
public interface ListaProductoRepository extends JpaRepository<ListaProducto, ListaProductoId> {

}
