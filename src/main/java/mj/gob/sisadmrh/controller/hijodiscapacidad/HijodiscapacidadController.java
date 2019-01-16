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
import mj.gob.sisadmrh.model.Empleado;
import mj.gob.sisadmrh.model.Empleadohijodiscapacidad;
import mj.gob.sisadmrh.model.EmpleadohijodiscapacidadPK;
import mj.gob.sisadmrh.model.Hijodiscapacidad;
import mj.gob.sisadmrh.model.Hijodiscapacidad;
import mj.gob.sisadmrh.service.EmpleadoHijosdiscapacidadService;
import mj.gob.sisadmrh.service.EmpleadoService;
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
    private EmpleadoHijosdiscapacidadService empleadoHijosdiscapacidadService;
    @Autowired
    private EmpleadoService empleadoService;


    
    @Autowired
    public void setHijodiscapacidadService(HijosdiscapacidadService hijodiscapacidadService) {
        this.hijodiscapacidadService = hijodiscapacidadService;
    }
    
    private final String PREFIX = "fragments/hijodiscapacidad/";
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("hijodiscapacidades", hijodiscapacidadService.listAllActivos());
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

    @RequestMapping(value = "hijodiscapacidad/{id}")
    public String saveHijodiscapacidad(Hijodiscapacidad hijodiscapacidad,Model model,@PathVariable Integer id) {
        try{
            hijodiscapacidad.setEstadohijos(1);
            hijodiscapacidadService.saveHijodiscapacidad(hijodiscapacidad);
            Empleadohijodiscapacidad emcon = new  Empleadohijodiscapacidad();
        emcon.setHijodiscapacidad(hijodiscapacidad);
        Empleado em = empleadoService.getEmpleadoById(id).get();
        EmpleadohijodiscapacidadPK emconpk = new EmpleadohijodiscapacidadPK();
        emconpk.setCodigohijodiscapacidad(hijodiscapacidad.getCodigohijodiscapacidad());
        emconpk.setCodigoempleado(em.getCodigoempleado());
        emcon.setEmpleadohijodiscapacidadPK(emconpk);
        empleadoHijosdiscapacidadService.saveEmpleadohijodiscapacidad(emcon);
            model.addAttribute("msg", 0);
        }
        catch(Exception e){
            model.addAttribute("msg", 1);
        }
        
//        return "redirect:./show/" + hijodiscapacidad.getCodigohijodiscapacidad();
 return PREFIX + "hijodiscapacidadform";
    }
    
    @RequestMapping("show/{id}")    
    public String showHijodiscapacidad(@PathVariable Integer id, Model model) {
        model.addAttribute("hijodiscapacidad", hijodiscapacidadService.getHijodiscapacidadById(id).get());
        return PREFIX +"hijodiscapacidadshow";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable Integer id,Model model) {
        try{
            Hijodiscapacidad hijodiscapacidad = hijodiscapacidadService.getHijodiscapacidadById(id).get();
            hijodiscapacidad.setEstadohijos(0);
            hijodiscapacidadService.deleteHijodiscapacidad(id);
            model.addAttribute("msg", 3);
        }
        catch(Exception e){
            model.addAttribute("msg", 4);
        }
       
//        return "redirect:/hijodiscapacidades/";
        return PREFIX +"hijodiscapacidades";
    }
    
    
    
}
