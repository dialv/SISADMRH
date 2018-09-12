/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Beneficio;
import mj.gob.sisadmrh.model.Capacitador;
import mj.gob.sisadmrh.model.CuadroDirectivo;
import org.springframework.stereotype.Service;

@Service
public interface CuadroDirectivoService {
        Iterable <CuadroDirectivo> listAllCuadroDirectivo();
    
    Optional<CuadroDirectivo> getCuadroDirectivoById(Integer id);

    CuadroDirectivo saveCuadroDirectivo(CuadroDirectivo cuadroDirectivo);

    void deleteCuadroDirectivo(Integer id);
//    Iterable<CuadroDirectivo> findByDato(String dato);
     Iterable<CuadroDirectivo> findByCuadro(String dato);
    
}
