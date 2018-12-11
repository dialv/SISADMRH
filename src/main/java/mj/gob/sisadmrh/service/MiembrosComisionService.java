/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Miembroscomision;

/**
 *
 * @author root
 */
public interface MiembrosComisionService {
    Iterable <Miembroscomision> listAllMiembros();
    
    Optional<Miembroscomision> getmiembroById(Integer id);

    Miembroscomision savemiembros(Miembroscomision usuariorol);

    void deleteMiembros(Integer id);
}

