package mj.gob.sisadmrh.controller.hijodiscapacidad;

import mj.gob.sisadmrh.controller.hijodiscapacidad.*;
import mj.gob.sisadmrh.controller.hijodiscapacidad.*;
import mj.gob.sisadmrh.controller.hijodiscapacidad.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import mj.gob.sisadmrh.controller.UtilsController;
import mj.gob.sisadmrh.model.Hijodiscapacidad;
import mj.gob.sisadmrh.model.Hijodiscapacidad;
import mj.gob.sisadmrh.service.HijosdiscapacidadService;
import mj.gob.sisadmrh.service.HijosdiscapacidadService;
//import mj.gob.sisadmrh.service.HijodiscapacidadHijodiscapacidadService;
import net.sf.jasperreports.engine.JRException;
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
@RequestMapping(value = "hijodiscapacidades")
public class HijodiscapacidadController extends UtilsController{
    
    private HijosdiscapacidadService hijodiscapacidadService;
//    private HijodiscapacidadHijodiscapacidadService hijodiscapacidadHijodiscapacidadService;
    


    
    @Autowired
    public void setHijodiscapacidadService(HijosdiscapacidadService hijodiscapacidadService) {
        this.hijodiscapacidadService = hijodiscapacidadService;
    }
    
    private final String PREFIX = "fragments/hijodiscapacidad/";
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("hijodiscapacidades", hijodiscapacidadService.listAllHijodiscapacidad());
        return PREFIX + "hijodiscapacidades";
    }
    
    @RequestMapping("edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("hijodiscapacidad", hijodiscapacidadService.getHijodiscapacidadById(id));
        return PREFIX + "hijodiscapacidadform";
    }

    @RequestMapping("new/{id}")
    public String newHijodiscapacidad(Model model) {
        model.addAttribute("hijodiscapacidad", new Hijodiscapacidad());
        return PREFIX + "hijodiscapacidadform";
    }

    @RequestMapping(value = "hijodiscapacidad")
    public String saveHijodiscapacidad(Hijodiscapacidad hijodiscapacidad) {
        hijodiscapacidadService.saveHijodiscapacidad(hijodiscapacidad);
        return "redirect:./show/" + hijodiscapacidad.getCodigohijodiscapacidad();
    }
    
    @RequestMapping("show/{id}")    
    public String showHijodiscapacidad(@PathVariable Integer id, Model model) {
        model.addAttribute("hijodiscapacidad", hijodiscapacidadService.getHijodiscapacidadById(id).get());
        return PREFIX +"hijodiscapacidadshow";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable Integer id) {
        hijodiscapacidadService.deleteHijodiscapacidad(id);
        return "redirect:/hijodiscapacidades/";
    }
    
    
    
}
