package mj.gob.sisadmrh.controller.Bitacora;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;
import mj.gob.sisadmrh.controller.UtilsController;
import mj.gob.sisadmrh.model.Bitacora;
import mj.gob.sisadmrh.model.Empleado;
import mj.gob.sisadmrh.service.BitacoraService;
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
 * @author dialv
 * 
 */
@Controller
@RequestMapping(value = "bitacoras")
public class BitacoraController extends UtilsController{
    
    private final String PREFIX = "fragments/bitacora/";
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("bitacoras", bitacoraService.listAllBitacoras());
        return PREFIX + "bitacoras";
    }
    
    
    @RequestMapping("show/{id}")
    public String showBitacora(@PathVariable Integer id, Model model) {
        model.addAttribute("bitacora", bitacoraService.getBitacoraById(id).get());
        return PREFIX +"bitacorashow";
    }

    
    @RequestMapping("asignar/{id}")
    public String newEmpleadoBitacora(Model model) {
        model.addAttribute("bitacora", new Bitacora());
        
        Iterable<Bitacora> bitacora = bitacoraService.listAllBitacoras();       
      model.addAttribute("bitacoras", bitacora);
        return PREFIX + "bitacoraempleadoform";
    }
    
    
    
}
