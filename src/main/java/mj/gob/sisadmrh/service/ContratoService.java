/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Contrato;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Mmachuca
 */

public interface ContratoService {
    Iterable <Contrato> listAllContrato();
    Iterable <Contrato> listAllActivos();
    
    Optional<Contrato> getContratoById(Integer id);

    Contrato saveContrato(Contrato empleado);

    void deleteContrato(Integer id);

    boolean findIntegry(int dato, String npar, String subpar);

    Iterable<Contrato> findByDato(int id) ;
}
