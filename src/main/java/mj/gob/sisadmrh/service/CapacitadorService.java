/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Capacitacion;
import mj.gob.sisadmrh.model.Capacitador;


public interface CapacitadorService {
     Iterable <Capacitador> listAllCapacitador();
    
    Optional<Capacitador> getCapacitadorById(Integer id);

    Capacitador saveCapacitador(Capacitador capacitador);

    void deleteCapacitador(Integer id);
     Iterable<Capacitador> findByDato(String dato);
       Iterable<Capacitador> findByCapacitador(String dato);
    
    
}
