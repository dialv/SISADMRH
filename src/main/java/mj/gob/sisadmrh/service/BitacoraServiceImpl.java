package mj.gob.sisadmrh.service;

import java.util.Date;
import java.util.Optional;
import mj.gob.sisadmrh.model.Bitacora;
import mj.gob.sisadmrh.repository.BitacoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dialv
 */
@Service
public class BitacoraServiceImpl implements BitacoraService {

    
    private BitacoraRepository bitacoraRep;

    @Autowired
    public void setBitacoraRepository(BitacoraRepository bitacoraRepository) {
        this.bitacoraRep = bitacoraRepository;
    }

    @Override
    public Iterable<Bitacora> listAllBitacoras() {
        return bitacoraRep.findAll();
    }

    @Override
    public Optional<Bitacora> getBitacoraById(Integer id) {
        return bitacoraRep.findById(id);
    }

    @Override
    public Bitacora saveBitacora(Bitacora bitacora) {
        return bitacoraRep.save(bitacora);
    }
    
    @Override
    public Bitacora BitacoraRegistry(String nomevento, String ip, String codusuario) {
        Bitacora bitacora = new Bitacora();
        bitacora.setNombreeventobitacora(nomevento);
        bitacora.setFechabitacora(new Date());
        bitacora.setIp(ip);
        bitacora.setCodigousuariobitacora(codusuario);
        return bitacoraRep.save(bitacora);
    }

    @Override
    public void deleteBitacora(Integer id) {
        bitacoraRep.deleteById(id);
    }
//    
//    @Override
//    public Iterable<Bitacora> findByDato(int id) {
//        return bitacoraRep;
//        
//    }

}
