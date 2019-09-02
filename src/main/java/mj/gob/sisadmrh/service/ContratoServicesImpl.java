/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import mj.gob.sisadmrh.bean.ContratoEmpleadoBean;
import mj.gob.sisadmrh.model.Contrato;
import mj.gob.sisadmrh.repository.ContratoRepository;
import mj.gob.sisadmrh.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mmachuca
 */
@Service
public class ContratoServicesImpl implements ContratoService {
    private ContratoRepository contratoRep;
    
        @Autowired
    public void setContratoRepository(ContratoRepository contratoRepository) {
        this.contratoRep = contratoRepository;
    }

    @Override
    public Iterable<Contrato> listAllContrato() {
        return contratoRep.findAll();
    }
    @Override
    public Iterable<Contrato> listAllActivos() {
        return contratoRep.listAllActivos();
    }

    @Override
    public Optional<Contrato> getContratoById(Integer id) {
         return contratoRep.findById(id);
    }

    @Override
    public Contrato saveContrato(Contrato contrato) {
        return contratoRep.save(contrato);
    }

    @Override
    public void deleteContrato(Integer id) {
        contratoRep.deleteById(id);
    }
    
    @Override
    public Iterable<Contrato> findByDato(int id) {
        return contratoRep.findByDato(id);
        
    }
    
    @Override
    public Iterable<Contrato>  findContratoByCodigopuesto(int id) {
        return contratoRep.findContratoByCodigopuesto(id);
        
    }
    
    
    
        
     @Override
     public List<Object[]> getContratoByIdEmpleado(Integer id,Integer id2) {
     return contratoRep.getContratoByIdEmpleado(id,id2);
    }

    @Override
    public List<ContratoEmpleadoBean>findAlmostExpired() {
       
       
        
        
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
       
        Date start = new Date();
        
        
        cal.setTime(start);
         String date1 = format1.format(cal.getTime());
        
        cal.add(Calendar.DATE,30); //minus number would decrement the days
        
        String date2 = format1.format(cal.getTime());
        
        System.out.println("Date1:"+date1+"  Date2:"+date2);
        
       List<Object[]> items = contratoRep.findAlmostExpired(date1, date2);
       List<ContratoEmpleadoBean> contratos = new ArrayList<>();
       
        for (Object[] item : items) {
            
            ContratoEmpleadoBean c = new ContratoEmpleadoBean();
            c.setNombreEmpleado(item[0].toString());
            c.setFechaFinContrato(item[1].toString());
            c.setCodigoContrato(item[2].toString());
            
            contratos.add(c);
        }
               
        
        return contratos;
        
    }
    
}
