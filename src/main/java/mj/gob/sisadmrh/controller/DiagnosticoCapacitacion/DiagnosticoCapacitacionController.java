/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.controller.DiagnosticoCapacitacion;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import mj.gob.sisadmrh.controller.UtilsController;
import mj.gob.sisadmrh.model.Capacitacion;
import mj.gob.sisadmrh.model.Comite;
import mj.gob.sisadmrh.model.DiagnosticoCapacitacion;
import mj.gob.sisadmrh.model.Empleado;
import mj.gob.sisadmrh.model.Estado;
import mj.gob.sisadmrh.model.Ubicacionfisica;
import mj.gob.sisadmrh.service.CapacitacionService;

import mj.gob.sisadmrh.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import mj.gob.sisadmrh.service.DiagnosticoCapacitacionService;
import mj.gob.sisadmrh.service.EstadoService;
import mj.gob.sisadmrh.service.PuestoService;
import mj.gob.sisadmrh.service.UbicacionFisicaService;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/**
 *
 * @author jorge
 */
@Controller
@SessionAttributes("diagnosticocapacitacion")
@RequestMapping(value = "diagnosticocapacitaciones")
public class DiagnosticoCapacitacionController extends UtilsController{
   @Autowired 
 private DiagnosticoCapacitacionService diagnosticoCapacitacionService; 
   @Autowired
   private PuestoService puestoService;
 @Autowired
private EmpleadoService empleadoService; 
 @Autowired
 private UbicacionFisicaService ubicacionFisicaService;
 @Autowired
 private EstadoService estadoService;
 @Autowired
 private CapacitacionService capacitacionService;

// @Autowired
//    public void setDiagnosticoCapacitacionService(DiagnosticoCapacitacionService diagnosticoCapacitacionService) {
//        this.diagnosticoCapacitacionService = diagnosticoCapacitacionService;
//    } 
    
    private final String PREFIX = "fragments/diagnosticocapacitacion/";
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("diagnosticocapacitaciones", diagnosticoCapacitacionService.listAllDiagnosticoCapacitacion());
        return PREFIX + "diagnosticocapacitaciones";
    }
    
     @RequestMapping("edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("diagnosticocapacitacion", diagnosticoCapacitacionService.getDiagnosticoCapacitacionById(id));
         Iterable<Capacitacion> capacitaciones= capacitacionService.listAllCapacitacion();
       model.addAttribute("capacitaciones",capacitaciones);
        
        return PREFIX + "diagnosticocapacitacionform";
    }
    
    @RequestMapping("new/diagnosticocapacitacion")
    public String newDiagnosticoCapacitacion(Model model) {
        model.addAttribute("diagnosticocapacitacion", new DiagnosticoCapacitacion());
        
          Iterable<Ubicacionfisica> ubicacionfisicas= ubicacionFisicaService.listAllUbicacionFisica();
            Iterable<Estado> direccion = estadoService.findBySuperior(1448);
        model.addAttribute("ubicacionfisicas", ubicacionfisicas);
        
         Iterable<Capacitacion> capacitaciones= capacitacionService.listAllCapacitacion();
       model.addAttribute("capacitaciones",capacitaciones);
        model.addAttribute("direccion", direccion);
        return PREFIX + "diagnosticocapacitacionform";
    }
    
    @RequestMapping(value = "diagnosticocapacitacion")
    public String saveDiagnosticoCapacitacion(DiagnosticoCapacitacion diagnosticoCapacitacion,Model model,SessionStatus status) {
        try{
          diagnosticoCapacitacionService.saveDiagnosticoCapacitacion(diagnosticoCapacitacion);
          status.setComplete();
           bitacoraService.BitacoraRegistry("se creo un Diagnostico Capacitacion",getRequest().getRemoteAddr(), 
                getRequest().getUserPrincipal().getName());//COBTROLARA EVENTO DE LA BITACORA
           model.addAttribute("msg", 0);
        }
        catch(Exception e){
           model.addAttribute("msg", 1);
        }
       return PREFIX + "diagnosticocapacitaciones";
       
        //return "redirect:./show/" + capacitacion.getCodigocapacitacion();
    }
    

     @RequestMapping("show/{id}")
    public String showDiagnosticoCapacitacion(@PathVariable Integer id, Model model) {
        
        model.addAttribute("diagnosticocapacitacion", diagnosticoCapacitacionService.getDiagnosticoCapacitacionById(id).get());
        
        return PREFIX +"diagnosticocapacitacionshow";
    }
     @RequestMapping("delete/{id}")
    public String delete(@PathVariable Integer id,Model model) {
        try{
       diagnosticoCapacitacionService.deleteDiagnosticoCapacitacion(id);
        bitacoraService.BitacoraRegistry("Se eliminado un un Diagnostico Capacitacion",getRequest().getRemoteAddr(), 
                getRequest().getUserPrincipal().getName());//COBTROLARA EVENTO DE LA BITACORA
         model.addAttribute("msg", 3);
        }
        catch(Exception e)
        {
        model.addAttribute("msg", 4);
        }
   
        return "redirect:/diagnosticocapacitaciones/";
    }
    
    @RequestMapping("report/")
    public String reporte(Model model) {
        model.addAttribute("diagnosticocapacitaciones", diagnosticoCapacitacionService.listAllDiagnosticoCapacitacion());
        return PREFIX + "diagnosticocapacitacionesreport";
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
        	generatePdf("diagnosticocapacitaciones", "rpt_diagnosticocapacitaciones", params, download,response);
    }
}
