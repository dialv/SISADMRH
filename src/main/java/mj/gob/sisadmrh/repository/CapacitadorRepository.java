/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.repository;

import mj.gob.sisadmrh.model.Capacitacion;
import mj.gob.sisadmrh.model.Capacitador;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author daniel
 */
public interface CapacitadorRepository extends CrudRepository<Capacitador, Integer>{
    //Jala los capacitadores en el form capacitacion 
    @Query(value = "SELECT c.* FROM capacitador c WHERE c.nombrecapacitador LIKE :nom ", nativeQuery = true)
    Iterable<Capacitador> findByDato(@Param("nom") String dato);
    // busca los capacitadores por el nombre en un listcapacitador
     @Query(value = "SELECT c.* FROM capacitador c "
            + "WHERE c.nombrecapacitador LIKE :nom ", nativeQuery = true)
     Iterable<Capacitador> findByCapacitador(@Param("nom") String dato);
    
     
      @Query(value="SELECT\n" +
                    "     capacitador.codigocapacitador ,\n" +
                    "     capacitador.carnetresidencia ,\n" +
                    "     capacitador.duicapacitador,\n" +
                    "     capacitador.emailcapacitador ,\n" +
                    "     capacitador.nitcapacitador ,\n" +
                    "     capacitador.nombrecapacitador ,\n" +
                    "     capacitador.telefonocapacitador ,\n" +
                    "     capacitador.telefonomovilcapacitador ,\n" +
                    "     capacitador.temadominio ,\n" +
                    "     capacitador.tipocapacitador ,\n" +
                    "     capacitador.codigoempleado,\n" +
                    "     capacitador.institucioncapacitador ,\n" +
                    "     capacitador.tipoagrupacion \n" +
                    "FROM\n" +
                    "     capacitador capacitador"
            , nativeQuery = true) 
            Iterable <Capacitador> findCapacitadores(@Param("FINICIAL") String finicial, 
                                             @Param("FFINAL") String ffinal);
}
