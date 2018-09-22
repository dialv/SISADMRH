/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Ubicacionfisica;

/**
 *
 * @author jorge
 */
public interface UbicacionFisicaService {
    Iterable <Ubicacionfisica> listAllUbicacionFisica();
    
    Optional<Ubicacionfisica> getUbicacionFisicaById(Integer id);

    Ubicacionfisica saveUbicacionFisica(Ubicacionfisica ubicacionFisica);

    void deleteUbicacionFisica(Integer id);
   Iterable<Ubicacionfisica> findByUbicacion(String dato);
   
   Iterable<Ubicacionfisica> findByDato(int id) ;
}
