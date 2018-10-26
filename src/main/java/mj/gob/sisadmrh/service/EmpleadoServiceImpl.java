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
    @Autowired
    private EmpleadoRepository empleadoRep;
//    @Autowired
//    public void setEmpleadoRepository(EmpleadoRepository empleadoRepository) {
//        this.empleadoRep = empleadoRepository;
//    }

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
    public Iterable<Empleado> findabogados(String finicial, String ffinal, Integer tipo) {
        return empleadoRep.findabogados(finicial, ffinal, tipo);
    }

    @Override
    public List<Object[]> renuncias(String finicial, String ffinal) {
        return empleadoRep.renuncias(finicial, ffinal);
    }

    @Override
    public List<Object[]> findBycumples(String finicial, String ffinal) {
return empleadoRep.findByCumples(finicial,ffinal)   ;
        }

    @Override
    public List<Object[]> findByNivelEscolar(String finicial, String ffinal) {
return empleadoRep.findByNivelEscolar(finicial,ffinal);
    }

    @Override
    public List<Object[]> findByPlazasOcupadas(String finicial, String ffinal) {
   return empleadoRep.findByPlazasOcupadas(finicial, ffinal);
    }


  @Override
    public List<Object[]> ContratacionesExcel(String finicial, String ffinal) {
   return empleadoRep.ContratacionesExcel(finicial, ffinal);
    }
     
    @Override
    public List<Object[]> DespidosExcel(String finicial, String ffinal) {
   return empleadoRep.DespidosExcel(finicial, ffinal);
    }
    
    @Override
    public List<Object[]> PseronalActivoExcel(String finicial, String ffinal) {
   return empleadoRep.PseronalActivoExcel(finicial, ffinal);
   
    }
    
    @Override
    public List<Object[]> EstadisticocapacitadoExcel(String finicial, String ffinal) {
   return empleadoRep.EstadisticocapacitadoExcel(finicial, ffinal);
    }
    @Override
    public List<Object[]> PersonalIndemnizadooExcel(String finicial, String ffinal) {
   return empleadoRep.PersonalIndemnizadooExcel(finicial, ffinal);
    }

    @Override
    public List<Object[]> findByExoneradoMarcacion(String finicial, String ffinal) {
return empleadoRep.findByExoneradoMarcacion(finicial, ffinal);
    }

    @Override
    public List<Object[]> findByPensionados(String finicial, String ffinal) {
      return  empleadoRep.findByPensionados(finicial, ffinal);
    }

    @Override
    public List<Object[]> findByPuestosCaducar(String finicial, String ffinal) {
return  empleadoRep.findByPuestosCaducar(finicial, ffinal);
    }

    @Override
    public List<Object[]> findByPuestosEmpleados(String codigo) {
return  empleadoRep.findByPuestosEmpleados(codigo);
    }

    @Override
    public List<Object[]> findByIncapacidad(String finicial, String ffinal) {
return empleadoRep.findByIncapacidad(finicial, ffinal);
    }

  

    
}
