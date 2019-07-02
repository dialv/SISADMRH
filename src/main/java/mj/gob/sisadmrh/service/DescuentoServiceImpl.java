/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Comite;
import mj.gob.sisadmrh.model.Descuento;
import mj.gob.sisadmrh.repository.DescuentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jorge
 */
@Service
public class DescuentoServiceImpl implements DescuentoService{
   @Autowired
private DescuentoRepository descuentoRep;
    
    public Iterable<Descuento> listAllDescuento() {
        return descuentoRep.findAll();
    }

    @Override
    public Iterable<Descuento> listAllActivos() {
        return descuentoRep.findAll();
    }

    @Override
    public Optional<Descuento> getDescuentoById(Integer id) {
        return descuentoRep.findById(id);
    }

    @Override
    public Descuento saveDescuento(Descuento descuento) {
        return descuentoRep.save(descuento);
    }

    @Override
    public void deleteDescuento(Integer id) {
        descuentoRep.deleteById(id);
    }
    
}
