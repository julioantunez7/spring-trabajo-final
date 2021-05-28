package pe.edu.upc.trabajo.service.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface CrudService< T, ID> {
	
	JpaRepository<T, ID> getRepository();
	
	@Transactional(readOnly=true)
	default List<T> getAll() throws Exception { //Obtener todos los elementos
		return getRepository().findAll();
	}
	@Transactional(readOnly=true)
	default Optional<T> findById(ID id) throws Exception {	//Buscar por Id
		return getRepository().findById(id);
	}
	@Transactional
	default T create(T entity) throws Exception{	//Graba el entity 
		return getRepository().save(entity);
	}
	@Transactional
	default T update(T entity) throws Exception{	//Actualiza el entity 
		return getRepository().save(entity);
	}
	@Transactional
	default void deteleById(ID id) throws Exception{	//Elimina el entity
		getRepository().deleteById(id);
	}
}
