package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Beneficio;

/**
 *
 * @author dialv
 */
public interface BeneficioService {
    Iterable <Beneficio> listAllBeneficios();
    
    Iterable <Beneficio> listAllActivos();
    
    Optional<Beneficio> getBeneficioById(Integer id);

    Beneficio saveBeneficio(Beneficio beneficio);

    void deleteBeneficio(Integer id);
    
//    void delete2(Integer id);
    
    Iterable<Beneficio> findByDato(int id) ;
}
