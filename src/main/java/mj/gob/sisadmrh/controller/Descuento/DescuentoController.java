package mj.gob.sisadmrh.controller.descuento;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import mj.gob.sisadmrh.controller.UtilsController;
import javax.servlet.http.HttpServletResponse;
import mj.gob.sisadmrh.model.Comite;
import mj.gob.sisadmrh.model.Descuento;
import mj.gob.sisadmrh.model.Empleado;
import mj.gob.sisadmrh.model.Incapacidad;
import mj.gob.sisadmrh.service.DescuentoService;
import mj.gob.sisadmrh.service.EmpleadoService;
import mj.gob.sisadmrh.service.IncapacidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

@Controller
@SessionAttributes("descuento")
@RequestMapping(value = "descuentos")
public class DescuentoController extends UtilsController {
    @Autowired
    private DescuentoService descuentoService;
    @Autowired
    private EmpleadoService empleadoService;

    private final String PREFIX = "fragments/descuento/";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("descuentos", descuentoService.listAllActivos());
        return PREFIX + "descuentos";
    }

    @RequestMapping("edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("descuento", descuentoService.getDescuentoById(id));
         Iterable<Empleado> empleados = empleadoService.listAllActivos();
        model.addAttribute("empleados", empleados);
        return PREFIX + "descuentoform";
    }

    @RequestMapping("new/descuento")
    public String newDescuentos(Model model) {
        model.addAttribute("descuento", new Descuento());

        // -----------Manda a la vista los empleados
        Iterable<Empleado> empleados = empleadoService.listAllActivos();
        model.addAttribute("empleados", empleados);
        return PREFIX + "descuentoform";
    }
 

    @RequestMapping(value = "descuento")
    public String saveDescuentos(Descuento descuento, Model model,SessionStatus status) {
        try {
            descuento.setEstadodescuento(1);
            descuentoService.saveDescuento(descuento);
            status.setComplete();//para controlar la edicion de form
             bitacoraService.BitacoraRegistry("se Creo  un Descuento",getRequest().getRemoteAddr(), 
                getRequest().getUserPrincipal().getName());// para controlar el vento de la bitacora
            model.addAttribute("msg", 0);
        } catch (Exception e) {
            model.addAttribute("msg", 1);
        }
        return PREFIX + "descuentoform";
    }

    @RequestMapping("show/{id}")
    public String showDescuentos(@PathVariable Integer id, Model model) {
        model.addAttribute("descuento", descuentoService.getDescuentoById(id).get());
        return PREFIX + "descuentoshow";
    }

   @RequestMapping("delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        try {
            Descuento descuento=descuentoService.getDescuentoById(id).get();
            descuento.setEstadodescuento(0);
            descuentoService.saveDescuento(descuento);
            bitacoraService.BitacoraRegistry("se elimino un descuento", getRequest().getRemoteAddr(),
            getRequest().getUserPrincipal().getName());//COBTROLARA EVENTO DE LA BITACORA
            model.addAttribute("msg", 3);
        } catch (Exception e) {
            model.addAttribute("msg", 4);
        }
        return "redirect:/descuentos/";
    }

    
   
  

}
