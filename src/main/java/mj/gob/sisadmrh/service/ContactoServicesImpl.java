/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Contacto;
import mj.gob.sisadmrh.repository.ContactoRepository;
import mj.gob.sisadmrh.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author IPalacios
 */
public class ContactoServicesImpl implements ContactoService {
    private ContactoRepository contactoRep;
    
        @Autowired
    public void setContactoRepository(ContactoRepository contactoRepository) {
        this.contactoRep = contactoRepository;
    }

    @Override
    public Iterable<Contacto> listAllContacto() {
        return contactoRep.findAll();
    }

    @Override
    public Optional<Contacto> getContactoById(Integer id) {
         return contactoRep.findById(id);
    }

    @Override
    public Contacto saveContacto(Contacto contacto) {
        return contactoRep.save(contacto);
    }

    @Override
    public void deleteContacto(Integer id) {
        contactoRep.deleteById(id);
    }
    
}
