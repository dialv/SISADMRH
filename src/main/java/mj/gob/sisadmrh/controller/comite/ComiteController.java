/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.controller.comite;


import java.util.HashMap;
import java.util.Map;
import mj.gob.sisadmrh.controller.UtilsController;
import javax.servlet.http.HttpServletResponse;

import javax.validation.Valid;
import mj.gob.sisadmrh.model.Capacitador;

import mj.gob.sisadmrh.model.Comite;
import mj.gob.sisadmrh.model.Empleado;
import mj.gob.sisadmrh.service.ComiteService;
import mj.gob.sisadmrh.service.EmpleadoBeneficioServiceImpl;
import mj.gob.sisadmrh.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = "comites")
public class ComiteController extends UtilsController{
    
    
    private ComiteService comiteService;
     
       @Autowired
    public void setComiteService(ComiteService comiteService) {
        this.comiteService = comiteService;
    }
    
     private EmpleadoService empleadoService;
     
       @Autowired
    public void setEmpleadoService(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }
    
  @RequestMapping("edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("comite", comiteService.getComiteById(id));
        return PREFIX + "comiteform";
    }
    private final String PREFIX = "fragments/comite/";
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("comites", comiteService.listAllComite());
        return PREFIX + "comites";
    }
    
     
    
    @RequestMapping("new/comite")
    public String newComite(Model model) {
        model.addAttribute("comite", new Comite());
        Iterable<Empleado> empleados = empleadoService.listAllEmpleado();
         // System.out.println("numero:"+capacitadores);
        model.addAttribute("empleados", empleados);
       // model.addAttribute("comite", new Comite());
        return PREFIX + "comiteform";
    }
    
    @RequestMapping(value = "comite")
    public String saveComite(Comite comite, Model model) {
        try{
         comiteService.saveComite(comite);
         model.addAttribute("msg", 0);
        }
        catch(Exception e)
        {
        model.addAttribute("msg", 0);
        }
      
        return PREFIX + "comiteform";
        //return "redirect:./show/" + comite.getCodigocomite();
    }
    
//      @RequestMapping(value = "comite",method=RequestMethod.POST)
//    public String saveComite(@Valid @ModelAttribute(name = "comite") Comite comite) {
//        comiteService.saveComite(comite);
//       
//        return "redirect:./show/" + comite.getCodigocomite();
//    }
//    
//    
     @RequestMapping("show/{id}")
    public String showComite(@PathVariable Integer id, Model model) {
        model.addAttribute("comite", comiteService.getComiteById(id).get());
        return PREFIX +"comiteshow";
    }
     @RequestMapping("delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
         try{
           comiteService.deleteComite(id);
        model.addAttribute("msg", 3);
        }
        catch(Exception e){
        model.addAttribute("msg", 4);
        }
        return PREFIX + "comites";
     
       // return "redirect:/comites/";
    }
    
    @RequestMapping("report/")
    public String reporte(Model model) {
        model.addAttribute("comites", comiteService.listAllComite());
        return PREFIX + "comitesreport";
    }
    
    @RequestMapping(value = "pdf/{indice}", method = { RequestMethod.POST, RequestMethod.GET })
    public void pdf(@PathVariable("indice") Long indice, 
            @RequestParam(required = false) Boolean download, 
            @RequestParam(value="fechainicial",required = false) String fechainicio, 
            @RequestParam(value="fechafinal", required = false) String fechafin, 
                HttpServletResponse response) throws Exception {
                Map<String, Object> params = new HashMap<>();
		params.put("CODIGO", indice.toString());
		params.put("FECHAINICIO", fechainicio);
		params.put("FECHAFIN", fechafin);
        	generatePdf("comites", "rpt_comites", params, download,response);
    }
    
}
