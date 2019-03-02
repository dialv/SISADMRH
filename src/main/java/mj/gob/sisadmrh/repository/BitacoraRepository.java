/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.repository;

import java.util.List;
import mj.gob.sisadmrh.model.Bitacora;
import mj.gob.sisadmrh.model.Capacitacion;
import mj.gob.sisadmrh.model.Comite;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author dialv
 */
public interface BitacoraRepository extends CrudRepository<Bitacora, Integer>{
    
//    @Query(value=" select p.nombrepuesto, uf.nombreubicacion from empleadopuesto ep "
//            + " inner join  empleadoubicacionfisica eu "
//            + " on ep.codigoempleado=eu.codigoempleado "
//            + " inner join ubicacionfisica uf "
//            + " on uf.codigoubicacion=eu.codigoubicacion "
//            + " inner join puesto p "
//            + " on p.codigopuesto=ep.codigopuesto "
//            + " where ep.codigoempleado=:p_cemp and ep.activo=1 and eu.b_activo=1", nativeQuery = true)
//	public List<Object[]> findnamesBycemp(@Param("p_cemp")String emp);
//        
//    /* esta query es para jalar de capacitaciones las capacitaciones************** */    
//         @Query(value = "SELECT ac.* FROM Bitacora ac "
//            + "WHERE ac.nombrecapacitacion LIKE :nom ", nativeQuery = true)
//
//    Iterable<Bitacora> findByCapacitacion(@Param("nom") String dato);

}


