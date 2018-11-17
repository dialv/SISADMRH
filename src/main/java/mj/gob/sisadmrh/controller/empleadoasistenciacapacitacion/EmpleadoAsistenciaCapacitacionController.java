/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.controller.empleadoasistenciacapacitacion;

import mj.gob.sisadmrh.model.AsistenciaCapacitacion;
import mj.gob.sisadmrh.model.Empleado;
import mj.gob.sisadmrh.model.Empleadoasistenciacapacitacion;
import mj.gob.sisadmrh.model.EmpleadoasistenciacapacitacionPK;
import mj.gob.sisadmrh.service.AsistenciaCapacitacionService;
import mj.gob.sisadmrh.service.EmpleadoAsistenciaCapacitacionService;
import mj.gob.sisadmrh.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author jorge
 */
@RequestMapping(value="empleadoasistenciacapacitaciones")
@Controller
public class EmpleadoAsistenciaCapacitacionController {
    @Autowired
    private EmpleadoAsistenciaCapacitacionService empleadoAsistenciaCapacitacionService;
    @Autowired
    private EmpleadoService empleadoService;
    @Autowired
    private AsistenciaCapacitacionService asistenciaCapacitacionService;
    
     
  private final String PREFIX = "fragments/empleadoasistenciacapacitacion/";
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("empleadoasistenciacapacitaciones", empleadoAsistenciaCapacitacionService.listAllEmpleadoAsistenciaCapacitacion());
        return PREFIX + "empleadoasistenciacapacitaciones";
    }
    @RequestMapping("edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("empleadoasistenciacapacitacion", empleadoAsistenciaCapacitacionService.getEmpleadoAsistenciaCapacitacionById(id));
        return PREFIX + "empleadoasistenciacapacitacionform";
    }
     @RequestMapping("new/empleadoasistenciacapacitacion")
    public String newAsistenciaEmpleadoCapacitacion(Model model) {
       EmpleadoAsistenciaCapacitacionForm form = new  EmpleadoAsistenciaCapacitacionForm();
      form.setAsistenciacapacitaciones(asistenciaCapacitacionService.listAllAsistenciacapacitacion());
      form.setEmpleados(empleadoService.listAllEmpleado());
//      form.setEmpleadoasistenciacapacitacion(new Empleadoasistenciacapacitacion());
   
      
       model.addAttribute("formempleadoasistenciacapacitacion", form);
       
        return PREFIX + "empleadoasistenciacapacitacionform";
    }
     @RequestMapping(value = "empleadoasistenciacapacitacion/{idasistencia}/{idempleado}")
//      @RequestMapping(value = "empleadoasistenciacapacitacion", method = { RequestMethod.POST, RequestMethod.GET })
    public String saveEmpleadoAsistenciaCapacitacion(Empleadoasistenciacapacitacion empleadoasistenciacapacitacion,Model model,@PathVariable Integer idasistencia,@PathVariable Integer idempleado) {
        try{
       EmpleadoasistenciacapacitacionPK llave = new EmpleadoasistenciacapacitacionPK();
       
       llave.setCodigoasistenciacapacitacion(idasistencia);
       llave.setCodigoempleado(idempleado);
//        llave.setCodigocapacitacion(empleadocapacitacion.getCapacitacion().getCodigocapacitacion());
//        llave.setCodigoempleado(empleadocapacitacion.getEmpleado().getCodigoempleado());
        empleadoasistenciacapacitacion.setEmpleadoasistenciacapacitacionPK(llave);
        empleadoAsistenciaCapacitacionService.saveEmpleadoAsistenciaCapacitacion(empleadoasistenciacapacitacion);
        
        
//         Empleado em = empleadoService.getEmpleadoById(idempleado);
//         AsistenciaCapacitacion asc = asistenciaCapacitacionService.getAsistenciaCapacitacionById(idasistencia).get();
      
//         empleadoasistenciacapacitacion.setEmpleado(em);
//         empleadoasistenciacapacitacion.setAsistenciaCapacitacion(asc);
         
         model.addAttribute("empleados", empleadoService.getEmpleadoById(idempleado));
         model.addAttribute("asistenciacapcitaciones", asistenciaCapacitacionService.getAsistenciacapacitacionById(idasistencia));
//        llave.setNombreempleado(em.getNombreempleado());
//        llave.setUbicacionasistenciacapacitacion(asc.getUbicacionasistenciacapacitacion());
        
//        empleadoasistenciacapacitacion.getEmpleado().getCodigoempleado();
//        empleadoasistenciacapacitacion.getEmpleado().getCodigoempleado();
//        model.addAttribute("empleadoasistenciacapacitaciones",empleadoasistenciacapacitacion);
         
         model.addAttribute("msg", 0);
        }
        catch(Exception e){
         model.addAttribute("msg", 1);
        }
        return PREFIX+"empleadoasistenciacapacitaciones";
       // return "redirect:./show/" + usuariorol.getCodigousuariorol();
    }
    
    @RequestMapping("show/{id}")
    public String showEmpleadoAsistenciaCapacitacion(@PathVariable Integer id, Model model) {
        model.addAttribute("empleadoasistenciacapacitacion", empleadoAsistenciaCapacitacionService.getEmpleadoAsistenciaCapacitacionById(id).get());
        return PREFIX +"empleadoasistenciacapacitacionshow";
    }
     @RequestMapping("delete/{id}")
    public String delete(@PathVariable Integer id,Model model) {
        try{
        empleadoAsistenciaCapacitacionService.deleteEmpleadoAsistenciaCapacitacion(id);
         model.addAttribute("msg", 3);}
        
        catch(Exception e){
        model.addAttribute("msg", 4);
        }
        return PREFIX + "empleadocapacitaciones";
       // return "redirect:/usuariorols/";
    }
}
