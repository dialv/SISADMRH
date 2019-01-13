/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.NivelEscolaridad;

import mj.gob.sisadmrh.repository.NivelEscolaridadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NivelEscolaridadServiceImpl implements NivelEscolaridadService {

    private NivelEscolaridadRepository nivelEscolaridadRep;

    @Autowired
    public void setNivelEscolaridadRepository(NivelEscolaridadRepository nivelEscolaridadRepository) {
        this.nivelEscolaridadRep = nivelEscolaridadRepository;
    }

    @Override
    public Iterable<NivelEscolaridad> listAllNivelEscolaridad() {
        return nivelEscolaridadRep.findAll();
    }

    @Override
    public Optional<NivelEscolaridad> getNivelEscolaridadById(Integer id) {
        return nivelEscolaridadRep.findById(id);

    }

    @Override
    public NivelEscolaridad saveNivelEscolaridad(NivelEscolaridad nivelescolaridad) {
        return nivelEscolaridadRep.save(nivelescolaridad);
    }

    @Override
    public void deleteNivelEscolaridad(Integer id) {
        nivelEscolaridadRep.deleteById(id);
    }

    @Override
    public Iterable<NivelEscolaridad> listAllActivos() {
        return nivelEscolaridadRep.findAll();
    }

}
