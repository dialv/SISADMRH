/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Ubicacionfisica;
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
    public Iterable<Ubicacionfisica> listAllUbicacionFisica() {
       return ubicacionFisicaRep.findAll();
        
    }
    @Override
    public Iterable<Ubicacionfisica> listAllActivos() {
       return ubicacionFisicaRep.listAllActivos();
        
    }

    @Override
    public Optional<Ubicacionfisica> getUbicacionFisicaById(Integer id) {
        return ubicacionFisicaRep.findById(id);
    }

    @Override
    public Ubicacionfisica saveUbicacionFisica(Ubicacionfisica ubicacionFisica) {
        return ubicacionFisicaRep.save(ubicacionFisica);
    }

    @Override
    public void deleteUbicacionFisica(Integer id) {
        ubicacionFisicaRep.deleteById(id);
    }
    @Override
    public Iterable<Ubicacionfisica> findByUbicacion(String dato) {
        return ubicacionFisicaRep.findByUbicacion("%"+dato+"%");
    } 
    
     @Override
    public Iterable<Ubicacionfisica> findByDato(int id) {
        return ubicacionFisicaRep.findByDato(id);
        
    }
    
    
    @Override
    public void findIntegrity(Ubicacionfisica ubicacionfisica) {
        Iterable<Ubicacionfisica> lista = ubicacionFisicaRep.findIntegrity(
                ubicacionfisica.getNombreubicacion(),
                ubicacionfisica.getJefeinmediato(),
                ubicacionfisica.getCargofuncional());
        if (lista.spliterator().getExactSizeIfKnown() > 1) {
            lista.iterator().next().setEstadoubicacion(0);
            ubicacionFisicaRep.save(lista.iterator().next());
            findIntegrity(lista.iterator().next());
        }
    }
}
