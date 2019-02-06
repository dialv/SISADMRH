package mj.gob.sisadmrh.repository;

import mj.gob.sisadmrh.model.Beneficio;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface BeneficioRepository extends CrudRepository<Beneficio, Integer>{
    @Query(value = "SELECT c.* FROM beneficio c, empleadobeneficio ec WHERE c.estadobeneficio != 0 and c.codigobeneficio = ec.codigobeneficio and ec.codigoempleado= :id ", nativeQuery = true)
    Iterable<Beneficio> findByDato(@Param("id") int dato);
    
    @Query("SELECT o FROM Beneficio o WHERE o.estadobeneficio != 0")
    public Iterable<Beneficio> listAllActivos(); 
    
      @Query(value = "delete FROM  empleadobeneficio  WHERE codigobeneficio= :id ", nativeQuery = true)
    Iterable<Beneficio> delete2(@Param("id") int dato);
}
