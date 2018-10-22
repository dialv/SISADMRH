/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.controller.UbicacionFisica;

import mj.gob.sisadmrh.controller.UtilsController;
import mj.gob.sisadmrh.model.Empleado;
import mj.gob.sisadmrh.model.Empleadoubicacionfisica;
import mj.gob.sisadmrh.model.EmpleadoubicacionfisicaPK;


import mj.gob.sisadmrh.model.Ubicacionfisica;
import mj.gob.sisadmrh.service.EmpleadoService;
import mj.gob.sisadmrh.service.EmpleadoUbicacionfisicaService;


import mj.gob.sisadmrh.service.UbicacionFisicaService;
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
@RequestMapping(value = "ubicacionfisicas")
public class UbicacionFisicaController extends UtilsController{
    
    @Autowired
    private UbicacionFisicaService ubicacionFisicaService;
     @Autowired
    private EmpleadoUbicacionfisicaService empleadoUbicacionfisicaService;
    @Autowired
    private EmpleadoService empleadoService;

  
    private final String PREFIX = "fragments/ubicacionfisica/";
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("ubicacionfisicas", ubicacionFisicaService.listAllUbicacionFisica());
        return PREFIX + "ubicacionfisicas";
    }
    
     @RequestMapping("edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("ubicacionfisica", ubicacionFisicaService.getUbicacionFisicaById(id));
        return PREFIX + "ubicacionfisicaform";
    }
    
    @RequestMapping("new/{id}")
    public String newUbicacionFisica(Model model) {
        model.addAttribute("ubicacionfisica", new Ubicacionfisica());
        
         
        return PREFIX + "ubicacionfisicaform";
    }
    
    @RequestMapping(value = "ubicacionfisica/{id}")
    public String saveUbicacionFisica(Ubicacionfisica ubicacionFisica,Model model,@PathVariable Integer id) {
        try{
           ubicacionFisicaService.saveUbicacionFisica(ubicacionFisica);
           Empleadoubicacionfisica emcon = new  Empleadoubicacionfisica();
        emcon.setUbicacionfisica(ubicacionFisica);
        Empleado em = empleadoService.getEmpleadoById(id).get();
        EmpleadoubicacionfisicaPK emconpk = new EmpleadoubicacionfisicaPK();
        emconpk.setCodigoubicacion(ubicacionFisica.getCodigoubicacion());
        emconpk.setCodigoempleado(em.getCodigoempleado());
        emcon.setEmpleadoubicacionfisicaPK(emconpk);
        empleadoUbicacionfisicaService.saveEmpleadoubicacionfisica(emcon);
           model.addAttribute("msg", 0);
        }
        catch(Exception e){
           model.addAttribute("msg", 1);
        }
       return PREFIX + "ubicacionfisicashow";
       
        //return "redirect:./show/" + capacitacion.getCodigocapacitacion();
    }
    
     @RequestMapping("show/{id}")
    public String showUbicacionFisica(@PathVariable Integer id, Model model) {
        
        model.addAttribute("ubicacionfisica", ubicacionFisicaService.getUbicacionFisicaById(id).get());
        
        return PREFIX +"ubicacionfisicashow";
    }
     @RequestMapping("delete/{id}")
    public String delete(@PathVariable Integer id,Model model) {
        try{
       
        ubicacionFisicaService.deleteUbicacionFisica(id);
         model.addAttribute("msg", 3);
        }
        catch(Exception e)
        {
        model.addAttribute("msg", 4);
        }
   
//        return "redirect:/ubicacionfisicas/";
        return PREFIX +"ubicacionfisicas";
    }
    
}
