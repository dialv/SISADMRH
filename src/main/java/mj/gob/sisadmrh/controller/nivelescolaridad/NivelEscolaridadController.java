package mj.gob.sisadmrh.controller.nivelescolaridad;

import mj.gob.sisadmrh.controller.UtilsController;
import mj.gob.sisadmrh.model.Empleado;
import mj.gob.sisadmrh.model.NivelEscolaridad;
import mj.gob.sisadmrh.service.EmpleadoService;

import mj.gob.sisadmrh.service.NivelEscolaridadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("nivelescolaridad")
@RequestMapping(value = "nivelescolaridades")
public class NivelEscolaridadController extends UtilsController {
    
    private NivelEscolaridadService nivelEscolaridadService;
    @Autowired
    private EmpleadoService empleadoService;
    
    @Autowired
    public void setNivelEscolaridadService(NivelEscolaridadService nivelEscolaridadService) {
        this.nivelEscolaridadService = nivelEscolaridadService;
    }
    
    private final String PREFIX = "fragments/nivelescolaridad/";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("nivelescolaridades", nivelEscolaridadService.listAllActivos());
        return PREFIX + "nivelescolaridades";
    }
    
    @RequestMapping("edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("nivelescolaridad", nivelEscolaridadService.getNivelEscolaridadById(id));
        Iterable<Empleado> empleados = empleadoService.listAllEmpleado();
//         
        model.addAttribute("empleados", empleados);
        return PREFIX + "nivelescolaridadform";
    }
    
    @RequestMapping("new/nivelescolaridad")
    public String newNivelEscolaridad(Model model) {
        
        model.addAttribute("nivelescolaridad", new NivelEscolaridad());
        model.addAttribute("empleados", empleadoService.listAllEmpleado());
        return PREFIX + "nivelescolaridadform";
    }
    
    @RequestMapping(value = "nivelescolaridad")
    public String saveNivelEscolaridad(NivelEscolaridad nivelEscolaridad, Model model, SessionStatus status) {
        try {
            nivelEscolaridadService.saveNivelEscolaridad(nivelEscolaridad);
            status.setComplete();
            bitacoraService.BitacoraRegistry("se guardo un nivel escolaridad", getRequest().getRemoteAddr(),
                    getRequest().getUserPrincipal().getName());
            model.addAttribute("msg", 0);
            model.addAttribute("nivelescolaridades", nivelEscolaridadService.listAllActivos());
            Iterable<Empleado> empleados = empleadoService.listAllEmpleado();
//         
            model.addAttribute("empleados", empleados);
            //   return PREFIX + "nivelescolaridades";

        } catch (Exception e) {
            model.addAttribute("msg", 1);
        }
        return PREFIX + "nivelescolaridades";//
        // return "redirect:/nivelescolaridades/"; 
        // return PREFIX + "nivelescolaridades";
        //return "redirect:./show/" + nivelEscolaridad.getCodigonivelnivelescolaridad();
    }
    
    @RequestMapping("show/{id}")
    public String showNivelEscolaridad(@PathVariable Integer id, Model model) {
        model.addAttribute("nivelescolaridad", nivelEscolaridadService.getNivelEscolaridadById(id).get());
        return PREFIX + "nivelescolaridadshow";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        try {
            NivelEscolaridad nivelescolaridad = nivelEscolaridadService.getNivelEscolaridadById(id).get();
            nivelescolaridad.setEstadonivelescolaridad(0);
            nivelEscolaridadService.saveNivelEscolaridad(nivelescolaridad);
            bitacoraService.BitacoraRegistry("se elimino un un Nivel Escolar", getRequest().getRemoteAddr(),
                    getRequest().getUserPrincipal().getName());//COBTROLARA EVENTO DE LA BITACORA
            model.addAttribute("msg", 3);
        } catch (Exception e) {
            model.addAttribute("msg", 4);
        }
        
        return "redirect:/nivelescolaridades/";
    }
}
