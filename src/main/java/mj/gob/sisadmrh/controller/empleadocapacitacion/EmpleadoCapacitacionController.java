package mj.gob.sisadmrh.controller.empleadocapacitacion;


import mj.gob.sisadmrh.model.Capacitacion;
import mj.gob.sisadmrh.model.Empleadocapacitacion;
import mj.gob.sisadmrh.model.EmpleadocapacitacionPK;
import mj.gob.sisadmrh.model.UsuariorolPK;
import mj.gob.sisadmrh.service.CapacitacionService;
import mj.gob.sisadmrh.service.EmpleadoCapacitacionSevice;
import mj.gob.sisadmrh.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jorge
 */
@Controller
@SessionAttributes("empleadocapacitacion")
@RequestMapping(value = "empleadocapacitaciones")
public class EmpleadoCapacitacionController  {
    @Autowired
    private EmpleadoCapacitacionSevice empleadoCapacitacionSevice;
    @Autowired
    private CapacitacionService capacitacionService;
    @Autowired
    private EmpleadoService empleadoService;
    
  private final String PREFIX = "fragments/empleadocapacitacion/";
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("empleadocapacitaciones", empleadoCapacitacionSevice.listAllEmpleadoCapacitacion());
        return PREFIX + "empleadocapacitaciones";
    }
    @RequestMapping("edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("empleadocapacitacion", empleadoCapacitacionSevice.getEmpleadoCapacitacionById(id));
        return PREFIX + "empleadocapacitacionform";
    }
     @RequestMapping("new/empleadocapacitacion")
    public String newEmpleadoCapacitacion(Model model) {
        EmpleadoCapacitacionForm form = new  EmpleadoCapacitacionForm();
        form.setCapacitaciones(capacitacionService.listAllCapacitacion());
      
      form.setEmpleados(empleadoService.listAllEmpleado());
      form.setEmpleadocapacitacion(new Empleadocapacitacion());
       model.addAttribute("formempleadocapacitacion", form);
       
        return PREFIX + "empleadocapacitacionform";
    }
     @RequestMapping(value = "empleadocapacitacion")
    public String saveEmpleadoCapacitacion(Empleadocapacitacion empleadocapacitacion,Model model) {
        try{
        EmpleadocapacitacionPK llave = new EmpleadocapacitacionPK();
        llave.setCodigocapacitacion(empleadocapacitacion.getCapacitacion().getCodigocapacitacion());
        llave.setCodigoempleado(empleadocapacitacion.getEmpleado().getCodigoempleado());
        
         empleadocapacitacion.setEmpleadocapacitacionPK(llave);//aqui tenia el pedo
        empleadoCapacitacionSevice.saveEmpleadoCapacitacion(empleadocapacitacion);
         model.addAttribute("msg", 0);
        }
        catch(Exception e){
         model.addAttribute("msg", 1);
        }
        return PREFIX+"empleadocapacitaciones";
       // return "redirect:./show/" + usuariorol.getCodigousuariorol();
    }
    
    @RequestMapping("show/{id}")
    public String showEmpleadoCapacitacion(@PathVariable Integer id, Model model) {
        model.addAttribute("empleadocapacitacion", empleadoCapacitacionSevice.getEmpleadoCapacitacionById(id).get());
        return PREFIX +"empleadocapacitacionshow";
    }
     @RequestMapping("delete/{id}")
    public String delete(@PathVariable Integer id,Model model) {
        try{
        empleadoCapacitacionSevice.deleteEmpleadoCapacitacion(id);
         model.addAttribute("msg", 3);}
        
        catch(Exception e){
        model.addAttribute("msg", 4);
        }
        return PREFIX + "empleadocapacitaciones";
       // return "redirect:/usuariorols/";
    }
    
}
