/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.controller.EmpleadoController;

import mj.gob.sisadmrh.controller.UtilsController;
import mj.gob.sisadmrh.model.Empleado;
import mj.gob.sisadmrh.model.Estado;

import mj.gob.sisadmrh.service.EmpleadoService;
import mj.gob.sisadmrh.service.EstadoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author jorge
 */
@RequestMapping(value = "empleados")
public class EmpleadoController  extends UtilsController{
     private EmpleadoService empleadoService;
    
    @Autowired
    public void setEmpleadoService(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }
    
    @Autowired
    private EstadoService estadoService;
    
    private final String PREFIX = "fragments/empleado/";
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("empleados", empleadoService.listAllEmpleado());
        return PREFIX + "empleados";
    }
    
    @RequestMapping("edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("departamento", estadoService.findBySuperior(2562));
        model.addAttribute("empleado", empleadoService.getEmpleadoById(id));
        return PREFIX + "empleadoform";
    }

    @RequestMapping("new/empleado")
    public String newEmpleado(Model model) {
       
        model.addAttribute("empleado", new Empleado());
        model.addAttribute("departamento", estadoService.findBySuperior(2562));
        return PREFIX + "empleadoform";
    }

    @RequestMapping(value = "empleado")
    public String saveEmpleado(Empleado empleado,Model model) {
         try{
             empleadoService.saveEmpleado(empleado);
      
        model.addAttribute("msg", 0);
        }
        catch(Exception e){
        model.addAttribute("msg", 1);
        }
    //    return PREFIX+"empleadoform";
       return PREFIX+"empleadoform";  
      // return "redirect:./show/" + empleado.getCodigoeempleado();
    }
    
    @RequestMapping("show/{id}")
    public String showEmpleado(@PathVariable Integer id, Model model) {
        model.addAttribute("empleado"+ "", empleadoService.getEmpleadoById(id).get());
        return PREFIX +"empleadoshow";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable Integer id) {
        empleadoService.deleteEmpleado(id);
        return "redirect:/empleados/";
    }
    
}
