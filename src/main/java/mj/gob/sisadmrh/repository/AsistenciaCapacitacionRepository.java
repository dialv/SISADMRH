/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.repository;

import java.util.List;
import mj.gob.sisadmrh.model.Asistenciacapacitacion;
import mj.gob.sisadmrh.model.Capacitacion;
import mj.gob.sisadmrh.model.Comite;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author daniel
 */
public interface AsistenciaCapacitacionRepository extends CrudRepository<Asistenciacapacitacion, Integer>{
    
    @Query(value=" select p.nombrepuesto, uf.nombreubicacion,e.telefonofijoempleado,e.telefonomovilempleado,e.emailempleado from empleadopuesto ep \n" +
                    " inner join  empleadoubicacionfisica eu \n" +
                    "on ep.codigoempleado=eu.codigoempleado \n" +
                    "inner join ubicacionfisica uf \n" +
                    "on uf.codigoubicacion=eu.codigoubicacion \n" +
                    "inner join puesto p \n" +
                    "on p.codigopuesto=ep.codigopuesto \n" +
                    "inner join empleado e\n" +
                    "on e.codigoempleado = ep.codigoempleado\n" +
                    "where ep.codigoempleado=:p_cemp and ep.activo=1 and eu.b_activo=1", nativeQuery = true)
	public List<Object[]> findnamesBycemp(@Param("p_cemp")String emp);
        
    /* esta query es para jalar de capacitaciones las capacitaciones************** */    
         @Query(value = "SELECT ac.* FROM AsistenciaCapacitacion ac "
            + "WHERE ac.nombrecapacitacion LIKE :nom ", nativeQuery = true)

    Iterable<Asistenciacapacitacion> findByCapacitacion(@Param("nom") String dato);

}


