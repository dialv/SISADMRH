/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Comite;
import mj.gob.sisadmrh.model.Descuento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author jorge
 */
public interface DescuentoService {
    
    Iterable<Descuento> listAllDescuento();

    Iterable<Descuento> listAllActivos();

//    Page<Comite> listAllComite(Pageable pePageable);

    Optional<Descuento> getDescuentoById(Integer id);

    Descuento saveDescuento(Descuento descuento);

    void deleteDescuento(Integer id);
    
}
