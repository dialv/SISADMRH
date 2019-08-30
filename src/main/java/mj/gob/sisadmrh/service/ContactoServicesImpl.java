package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Contacto;
import mj.gob.sisadmrh.repository.ContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mmachuca
 */
@Service
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
    public Iterable<Contacto> listAllActivos() {
        return contactoRep.listAllActivos();
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

    @Override
    public Iterable<Contacto> findByDato(int id) {
        return contactoRep.findByDato(id);

    }

    @Override
    public void findIntegrity(Contacto contacto) {
        Iterable<Contacto> lista = contactoRep.findIntegrity(contacto.getNombrecontacto(), contacto.getApellidocontacto(),
                contacto.getEmailcontacto());
        if (lista.spliterator().getExactSizeIfKnown() > 1) {
            lista.iterator().next().setEstadocontacto("0");
            contactoRep.save(lista.iterator().next());
            findIntegrity(lista.iterator().next());
        }
    }
}
