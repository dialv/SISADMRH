package mj.gob.sisadmrh.repository;

import mj.gob.sisadmrh.model.Formacionacademica;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
/**
 *
 * @author IPalacios
 */
public interface FormacionacademicaRepository extends CrudRepository<Formacionacademica, Integer> {

    @Query(value = "SELECT d.* FROM formacionacademica d , empleadoformacion ed WHERE d.estadoformacion and  d.codigoformacionacademica = ed.codigoformacionacademica and ed.codigoempleado= :id ", nativeQuery = true)
    Iterable<Formacionacademica> findByDato(@Param("id") int dato);

    @Query(value = "SELECT d.* FROM formacionacademica d WHERE d.estadoformacion!=0 and  d.estudiosrealizados=:est "
            + " and d.centroeducativo=:cedu and d.tituloobtenido=:titulo", nativeQuery = true)
    Iterable<Formacionacademica> findIntegrity(@Param("est") String estudio, @Param("cedu") String cedu, @Param("titulo") String titulo);

    @Query("SELECT o FROM Formacionacademica o WHERE o.estadoformacion != 0")
    public Iterable<Formacionacademica> listAllActivos();

}
