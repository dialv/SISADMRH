/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.service;

import java.util.List;
import java.util.Optional;
import mj.gob.sisadmrh.model.Capacitacion;



public interface CapacitacionService {
 
    Iterable<Capacitacion> listAllCapacitacion();
    
    Iterable<Capacitacion> listAllActivos();

    Optional<Capacitacion> getCapacitacionById(Integer id);

    Capacitacion saveCapacitacion(Capacitacion capacitacion);

    void deleteCapacitacion(Integer id);
    
       Iterable<Capacitacion> findByDato(String dato);
     public  List <Object[]> findByCapacitacionesR(String finicial, String ffinal);//metood para generar el exel
    
      List <Object[]> CostoCapacitacionExcel(String finicial, String ffinal);
      public  List <Object[]> EvaluacionCapacitacionesExcel(String finicial, String ffinal, String codigo);//metood para generar el exel
    
      
      
}
