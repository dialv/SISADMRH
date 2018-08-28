package mj.gob.sisadmrh.repository;

import mj.gob.sisadmrh.model.Estado;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface EstadoRepository extends CrudRepository<Estado, Integer>{
         @Query(value = "SELECT e.* FROM Estado e WHERE e.codigoestadosuperior=:est ", nativeQuery = true)
    Iterable<Estado> findBySuperior(@Param("est") Integer est); 
}
