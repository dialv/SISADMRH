package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Beneficio;

/**
 *
 * @author dialv
 */
public interface BeneficioService {
    Iterable <Beneficio> listAllBeneficios();
    
    Optional<Beneficio> getBeneficioById(Integer id);

    Beneficio saveBeneficio(Beneficio beneficio);

    void deleteBeneficio(Integer id);
}
