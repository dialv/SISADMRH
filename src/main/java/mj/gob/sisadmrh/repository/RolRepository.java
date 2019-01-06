package mj.gob.sisadmrh.repository;

import mj.gob.sisadmrh.model.Rol;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RolRepository extends CrudRepository<Rol, Integer>{
    
    
    @Query("SELECT o FROM Rol o WHERE o.estadorol != 0")
    public Iterable<Rol> listAllActivos(); 
}
