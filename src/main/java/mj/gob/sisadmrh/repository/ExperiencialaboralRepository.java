/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.repository;

import java.util.Optional;
import mj.gob.sisadmrh.model.Experiencialaboral;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author IPalacios
 */
public interface ExperiencialaboralRepository extends CrudRepository<Experiencialaboral, Integer>{
     @Query(value = "SELECT d.* FROM experiencialaboral d , empleadoexperiencialaboral ed WHERE d.estadoexp != 0 and d.codigoexperiencialaboral = ed.codigoexperiencialaboral and ed.codigoempleado= :id ", nativeQuery = true)
    Iterable<Experiencialaboral> findByDato(@Param("id") int dato);

    @Query(value = "SELECT  d.* FROM experiencialaboral d WHERE d.estadoexp!=0 and "
            + " d.sectorexperiencialaboral=:sector "
            + "and d.nombreinstitucion=:nomb"
            + " and d.cargo=:cargo", nativeQuery = true)
    Iterable<Experiencialaboral> findIntegrity(@Param("sector") String sector, @Param("nomb") String nomb, @Param("cargo") String cargo);

    @Query("SELECT o FROM Experiencialaboral o WHERE o.estadoexp != 0")
            public Iterable<Experiencialaboral> listAllActivos(); 
     
    @Query(value = "SELECT d.* FROM experiencialaboral d  WHERE d.estadoexp != 0 and d.codigocontrato=:id ", nativeQuery = true)
    Experiencialaboral findByExperienciaBycodigoContrato(@Param("id") int dato);
}
