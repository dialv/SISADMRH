/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.service;

import java.util.List;
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

    void findIntegry(Contrato contrato);

    Iterable<Contrato> findByDato(int id) ;
     List<Object[]> getContratoByIdEmpleado(Integer id,Integer id2);
}
