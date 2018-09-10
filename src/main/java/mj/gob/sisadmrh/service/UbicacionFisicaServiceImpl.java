/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.UbicacionFisica;
import mj.gob.sisadmrh.repository.UbicacionFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jorge
 */
@Service
public class UbicacionFisicaServiceImpl implements UbicacionFisicaService{
    @Autowired
    private UbicacionFisicaRepository ubicacionFisicaRep;

    @Override
    public Iterable<UbicacionFisica> listAllUbicacionFisica() {
       return ubicacionFisicaRep.findAll();
        
    }

    @Override
    public Optional<UbicacionFisica> getUbicacionFisicaById(Integer id) {
        return ubicacionFisicaRep.findById(id);
    }

    @Override
    public UbicacionFisica saveUbicacionFisica(UbicacionFisica ubicacionFisica) {
        return ubicacionFisicaRep.save(ubicacionFisica);
    }

    @Override
    public void deleteUbicacionFisica(Integer id) {
        ubicacionFisicaRep.deleteById(id);
    }
    @Override
    public Iterable<UbicacionFisica> findByUbicacion(String dato) {
        return ubicacionFisicaRep.findByUbicacion("%"+dato+"%");
    } 
}
