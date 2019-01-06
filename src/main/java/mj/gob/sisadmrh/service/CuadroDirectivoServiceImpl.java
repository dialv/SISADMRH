/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.CuadroDirectivo;
import mj.gob.sisadmrh.repository.BeneficioRepository;
import mj.gob.sisadmrh.repository.CuadroDirectivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CuadroDirectivoServiceImpl implements CuadroDirectivoService{
    
    private CuadroDirectivoRepository cuadroDirectivoRep;
    
    @Autowired
    public void setCuadroDirectivoRepository(CuadroDirectivoRepository cuadroDirectivoRepository) {
        this.cuadroDirectivoRep = cuadroDirectivoRepository;
    }

    @Override
    public Iterable<CuadroDirectivo> listAllCuadroDirectivo() {
     return cuadroDirectivoRep.findAll();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<CuadroDirectivo> getCuadroDirectivoById(Integer id) {
      return cuadroDirectivoRep.findById(id);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CuadroDirectivo saveCuadroDirectivo(CuadroDirectivo cuadroDirectivo) {
       return cuadroDirectivoRep.save(cuadroDirectivo);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteCuadroDirectivo(Integer id) {
     cuadroDirectivoRep.deleteById(id);
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable<CuadroDirectivo> findByCuadro(String dato) {
    return cuadroDirectivoRep.findByCuadro("%"+dato+"%");
// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    }

    @Override
    public Iterable<CuadroDirectivo> listAllActivos() {
            return cuadroDirectivoRep.listAllActivos();
     }
    
}
