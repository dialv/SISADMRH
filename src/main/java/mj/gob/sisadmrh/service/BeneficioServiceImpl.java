package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Beneficio;
import mj.gob.sisadmrh.repository.BeneficioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dialv
 */
@Service
public class BeneficioServiceImpl implements BeneficioService {

    
    private BeneficioRepository beneficioRep;

    @Autowired
    public void setBeneficioRepository(BeneficioRepository beneficioRepository) {
        this.beneficioRep = beneficioRepository;
    }

    @Override
    public Iterable<Beneficio> listAllBeneficios() {
        return beneficioRep.findAll();
    }

    @Override
    public Optional<Beneficio> getBeneficioById(Integer id) {
        return beneficioRep.findById(id);
    }

    @Override
    public Beneficio saveBeneficio(Beneficio beneficio) {
        return beneficioRep.save(beneficio);
    }

    @Override
    public void deleteBeneficio(Integer id) {
        beneficioRep.deleteById(id);
    }

}
