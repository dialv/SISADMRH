/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.repository;

import java.util.List;
import java.util.Map;
import mj.gob.sisadmrh.bean.ContratoEmpleadoBean;
import mj.gob.sisadmrh.model.Contrato;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author IPalacios
 */
public interface ContratoRepository extends CrudRepository<Contrato, Integer>{
       @Query(value = "SELECT d.* FROM contrato d  WHERE d.estadocontrato != 0 and d.codigoempleado= :id ", nativeQuery = true)
    Iterable<Contrato> findByDato(@Param("id") int dato);
    


     @Query("SELECT o FROM Contrato o WHERE o.estadocontrato != 0")
            public Iterable<Contrato> listAllActivos();
            
            @Query(value ="SELECT o.CODIGOPUESTO,o.SUELDOBASE,o.NOMBREPUESTO,c.fechainiciocontrato ,c.fechafincontrato\n" +
"FROM `puesto` o ,`empleado` e,`contrato` c \n" +
"WHERE \n" +
"o.estadopuesto != 0 and\n" +
"o.codigopuesto=c.codigopuesto and\n" +
"e.codigoempleado=c.codigoempleado and\n" +
"c.codigocontrato=:id and\n" +
"e.codigoempleado=:id2",nativeQuery = true)
     public List<Object[]> getContratoByIdEmpleado(@Param("id") int dato,@Param("id2") int dato2);
     
      @Query(value = "SELECT d.* FROM contrato d  WHERE d.estadocontrato != 0 and d.codigopuesto=:id ", nativeQuery = true)
    Iterable<Contrato>  findContratoByCodigopuesto(@Param("id") int dato);
    
    //para contratos a vencer en un alerta
      @Query(value = "SELECT CONCAT(e.nombreempleado,e.apellidoempleado) as nombreEmpleado, c.fechafincontrato as fechafincontrato, c.codigocontrato as codigocontrato  FROM empleado e, contrato c  WHERE e.codigoempleado = c.codigoempleado and (c.fechafincontrato BETWEEN :start and :end ) ORDER BY c.fechafincontrato ASC", nativeQuery = true)
    List<Object[]> findAlmostExpired(@Param("start") String start, @Param("end") String end);
    
    @Query(value = "SELECT d.*  FROM contrato d  WHERE d.estadocontrato != 0 and d.codigopuesto= :id ", nativeQuery = true)
     Iterable<Contrato>  findContratoByCodigoPuesto(@Param("id") int dato);
    
}
