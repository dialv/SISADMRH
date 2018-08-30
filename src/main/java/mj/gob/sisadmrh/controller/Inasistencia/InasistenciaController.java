/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.controller.Inasistencia;

import mj.gob.sisadmrh.controller.UtilsController;
import mj.gob.sisadmrh.model.Empleado;
import mj.gob.sisadmrh.model.Inasistencia;
import mj.gob.sisadmrh.service.EmpleadoService;
import mj.gob.sisadmrh.service.InasistenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author jorge
 */
@Controller
@RequestMapping(value = "inasistencias")
public class InasistenciaController extends UtilsController{
    @Autowired
    private EmpleadoService empleadoService;
    @Autowired
    private InasistenciaService inasistenciaService;
    
    
    private final String PREFIX = "fragments/inasistencia/";
      @RequestMapping(value = "/", method=RequestMethod.GET)
    public String list(Model model){
    model.addAttribute("inasistencias", inasistenciaService.listAllInasistencia());
    return PREFIX + "inasistencias";
    }
       @RequestMapping("edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("inasistencia",inasistenciaService.getInasistenciaById(id));
         return PREFIX + "inasistenciaform";
    }
    
     @RequestMapping("new/inasistencia")
    public String newInasistencia(Model model) {
        model.addAttribute("inasistencia", new Inasistencia());
          Iterable<Empleado> empleados = empleadoService.listAllEmpleado();
//         
      model.addAttribute("empleados", empleados);
       return PREFIX + "inasistenciaform";
                }
    
    
       @RequestMapping(value = "inasistencia")
    public String saveInasistencia(Inasistencia inasistencia,Model model) {
        try{
        inasistenciaService.saveInasistencia(inasistencia);
        
        model.addAttribute("msg", 0);
       // model.addAttribute("inasistencias", inasistenciaService.listAllInasistencia());
      // return PREFIX+"inasistencias";
        }
        catch(Exception e){
          model.addAttribute("msg", 1);
        }
        // return PREFIX+"inasistenciaform";
        return PREFIX+"inasistencias";
       // return "redirect:./show/" + comision.getCodigocomision();
    }
     @RequestMapping("show/{id}")
    public String Inasistencia(@PathVariable Integer id, Model model) {
        model.addAttribute("inasistencia", inasistenciaService.getInasistenciaById(id).get());
        return PREFIX +"inasistenciashow";
    }
    
    @RequestMapping("delete/{id}")
    public String delete(@PathVariable Integer id,Model model) {
        try{
        inasistenciaService.deleteInasistencia(id);
         model.addAttribute("msg", 3);
        }
        catch(Exception e){
        model.addAttribute("msg", 4);
         
        }
         return PREFIX + "inasistencias";
        //return "redirect:/comisiones/";
    }
    
}
