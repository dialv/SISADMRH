package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Bitacora;

/**
 *
 * @author dialv
 */
public interface BitacoraService {
    Iterable <Bitacora> listAllBitacoras();
    
    Optional<Bitacora> getBitacoraById(Integer id);

    Bitacora saveBitacora(Bitacora bitacora);

    void deleteBitacora(Integer id);
    
    public Bitacora BitacoraRegistry(String nomevento, String ip, String codusuario) ;
    
//    Iterable<Bitacora> findByDato(int id) ;
}
