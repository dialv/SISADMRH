/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.service;

import java.util.Optional;

import mj.gob.sisadmrh.model.Comite;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author daniel
 */
public interface ComiteService {
          Iterable <Comite> listAllComite();
          Page <Comite> listAllComite(Pageable pePageable);
    
    Optional<Comite> getComiteById(Integer id);

    Comite saveComite(Comite comite);

    void deleteComite(Integer id);
    Iterable<Comite> findByDato(String dato);
    Iterable<Comite> findByComite(String dato);
    
}
