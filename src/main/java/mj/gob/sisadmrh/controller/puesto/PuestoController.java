package mj.gob.sisadmrh.controller.puesto;

import mj.gob.sisadmrh.service.PuestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import mj.gob.sisadmrh.controller.UtilsController;
import mj.gob.sisadmrh.model.Puesto;
import mj.gob.sisadmrh.service.EmpleadoService;

/**
 *
 * @author dialv
 *
 */
@Controller
@RequestMapping(value = "puestos")
public class PuestoController extends UtilsController {
    @Autowired
    private EmpleadoService empleadoService;
    
    private PuestoService puestoService;
    
    @Autowired
    public void setPuestoService(PuestoService puestoService) {
        this.puestoService = puestoService;
    }
    
    private final String PREFIX = "fragments/puesto/";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("puestos", puestoService.listAllActivos());
        return PREFIX + "puestos";
    }
    
    @RequestMapping("edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("puesto", puestoService.getPuestoById(id));
        return PREFIX + "puestoform";
    }
    
    @RequestMapping("new/puesto")
    public String newPuesto(Model model) {
        model.addAttribute("puesto", new Puesto());
        return PREFIX + "puestoform";
    }
    
    @RequestMapping(value = "puesto")
    public String savePuesto(Puesto puesto, Model model) {
        try {
            puesto.setEstadopuesto(1);
            puestoService.savePuesto(puesto);
            bitacoraService.BitacoraRegistry("se  creo un Puesto",getRequest().getRemoteAddr(), 
                getRequest().getUserPrincipal().getName());//COBTROLARA EVENTO DE LA BITACORA
            
            model.addAttribute("msg", 0);
        } catch (Exception ex) {
             System.out.println("Error {");
                     StackTraceElement[] elementRaster3 = ex.getStackTrace();
                     for (int in3=0;in3<elementRaster3.length;in3++) {
                         final StackTraceElement elementSTD=elementRaster3[in3];
                         System.out.println("   "+ in3 +" - getClassName="+elementSTD.getClassName());
                         System.out.println("   getMethodName="+elementSTD.getMethodName());
                         System.out.println("   getLineNumber="+elementSTD.getLineNumber());
                         System.out.println("   errorMSG="+ex.getMessage());
                     }
                     System.out.println("}");
            model.addAttribute("msg", 1);
        }
        return PREFIX + "puestoform";
//        return "redirect:./show/" + puesto.getCodigopuesto();
    }
    
    @RequestMapping("show/{id}")
    public String showPuesto(@PathVariable Integer id, Model model) {
        model.addAttribute("puesto", puestoService.getPuestoById(id).get());
        return PREFIX + "puestoshow";
    }
    
    @RequestMapping("delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        try {
            Puesto puesto = puestoService.getPuestoById(id).get();
            puesto.setEstadopuesto(0);
            if(empleadoService.activosPuestos(puesto.getCodigopuesto())){
            puestoService.savePuesto(puesto);
            bitacoraService.BitacoraRegistry("se elimino un Puesto", getRequest().getRemoteAddr(),
            getRequest().getUserPrincipal().getName());//COBTROLARA EVENTO DE LA BITACORA
            model.addAttribute("msg", 3);
            }
            else{
            model.addAttribute("msg", 5);
            }
            
        } catch (Exception e) {
            model.addAttribute("msg", 4);
        }

        return PREFIX + "puestos";
    }
    
}
