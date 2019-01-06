/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.CostoCapacitacion;


public interface CostoCapacitacionService {
    
              Iterable<CostoCapacitacion> listAllCostoCapacitacion();
              Iterable<CostoCapacitacion> listAllActivos();

    Optional<CostoCapacitacion> getCostoCapacitacionById(Integer id);

    CostoCapacitacion saveCostoCapacitacion(CostoCapacitacion costoCapacitacion);

    void deleteCostoCapacitacion(Integer id);
    
     Iterable<CostoCapacitacion> findByDato(String dato) ;
}
