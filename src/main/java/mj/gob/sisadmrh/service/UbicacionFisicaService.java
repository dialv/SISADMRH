/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.UbicacionFisica;

/**
 *
 * @author jorge
 */
public interface UbicacionFisicaService {
    Iterable <UbicacionFisica> listAllUbicacionFisica();
    
    Optional<UbicacionFisica> getUbicacionFisicaById(Integer id);

    UbicacionFisica saveUbicacionFisica(UbicacionFisica ubicacionFisica);

    void deleteUbicacionFisica(Integer id);
   Iterable<UbicacionFisica> findByUbicacion(String dato);
}
