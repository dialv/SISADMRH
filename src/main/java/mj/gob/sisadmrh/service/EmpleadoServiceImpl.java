/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.service;

import java.util.List;
import java.util.Optional;
import mj.gob.sisadmrh.model.Empleado;
import mj.gob.sisadmrh.model.Empleadobeneficio;
import mj.gob.sisadmrh.repository.EmpleadoRepository;
import mj.gob.sisadmrh.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jorge
 */
@Service
public class EmpleadoServiceImpl implements EmpleadoService{
    private EmpleadoRepository empleadoRep;
    @Autowired
    public void setEmpleadoRepository(EmpleadoRepository empleadoRepository) {
        this.empleadoRep = empleadoRepository;
    }

    @Override
    public Iterable<Empleado> listAllEmpleado() {
     return empleadoRep.findAll();
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<Empleado> getEmpleadoById(Integer id) {
        return empleadoRep.findById(id);
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Empleado saveEmpleado(Empleado empleado) {
        return empleadoRep.save(empleado);
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteEmpleado(Integer id) {
        empleadoRep.deleteById(id);
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object[]> findabogados(String finicial, String ffinal) {
        return empleadoRep.findabogados(finicial, ffinal);
    }

   
    
}
