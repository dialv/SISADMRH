package mj.gob.sisadmrh.repository;

import mj.gob.sisadmrh.model.NivelEscolaridad;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;



public interface NivelEscolaridadRepository extends CrudRepository<NivelEscolaridad, Integer>{
     
    @Query("SELECT o FROM NivelEscolaridad o WHERE o.estadonivelescolaridad!= 0")
    public Iterable<NivelEscolaridad> listAllActivos(); 
}
