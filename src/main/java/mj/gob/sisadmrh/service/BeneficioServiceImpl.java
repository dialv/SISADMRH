package mj.gob.sisadmrh.service;

import java.util.List;
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
    
    @Override
    public Iterable<Beneficio> findByDato(int id) {
        return beneficioRep.findByDato(id);
        
    }

    @Override
    public Iterable<Beneficio> listAllActivos() {
        return beneficioRep.listAllActivos();
    }
    
     @Override
    public List<Object[]> beneficiosExcel(String finicial, String ffinal,String codigo) {
        return beneficioRep.beneficiosExcel(finicial,ffinal,codigo);      
    }

}
