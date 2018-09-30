package mj.gob.sisadmrh.controller.idioma;

import mj.gob.sisadmrh.controller.idioma.*;
import mj.gob.sisadmrh.controller.idioma.*;
import mj.gob.sisadmrh.controller.idioma.*;
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
import mj.gob.sisadmrh.model.Idioma;
import mj.gob.sisadmrh.model.Idioma;
import mj.gob.sisadmrh.model.Empleadoidioma;
import mj.gob.sisadmrh.model.EmpleadoidiomaPK;
import mj.gob.sisadmrh.service.IdiomaService;
import mj.gob.sisadmrh.service.IdiomaService;
//import mj.gob.sisadmrh.service.EmpleadoIdiomaService;
//import mj.gob.sisadmrh.service.IdiomaIdiomaService;
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
@RequestMapping(value = "idiomas")
public class IdiomaController extends UtilsController{
    
    private IdiomaService idiomaService;
//    private IdiomaIdiomaService idiomaIdiomaService;
    
//     private EmpleadoIdiomaService  empleadoidioma ;
//    @Autowired
//    public void setEmpleadoIdiomaService(EmpleadoIdiomaService empleadoidioma){
//    this.empleadoidioma=empleadoidioma;
//    }
    


    
    @Autowired
    public void setIdiomaService(IdiomaService idiomaService) {
        this.idiomaService = idiomaService;
    }
    
    private final String PREFIX = "fragments/idioma/";
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("idiomas", idiomaService.listAllIdioma());
        return PREFIX + "idiomas";
    }
    
    @RequestMapping("edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("idioma", idiomaService.getIdiomaById(id));
        return PREFIX + "idiomaform";
    }

    @RequestMapping("new/{id}") 
    public String newIdioma(Model model,@PathVariable Integer id) {
//        EmpleadoidiomaPK empCto = new EmpleadoidiomaPK();
//        empCto.setCodigoempleado(id);
//        model.addAttribute("empleadoIdioma", empCto );
        model.addAttribute("idioma", new Idioma());
        return PREFIX + "idiomaform";
    }

    @RequestMapping(value = "idioma")
<<<<<<< HEAD
    public String saveIdioma(Idioma idioma,Model model) {
       try{
            idiomaService.saveIdioma(idioma);
            model.addAttribute("msg", 0);
        }
        catch(Exception e){
            model.addAttribute("msg", 1);
        }
        
=======
    public String saveIdioma(Idioma idioma) {
       
        idiomaService.saveIdioma(idioma);
>>>>>>> eceb235497f17a196ae6f76834129201b8cae4ad
//        emp.setCodigoidioma(idioma.getCodigoidioma()); 
//        emp.setCodigoempleado(idioma.getCodigoidioma());
//        empleadoidiomaPK.saveEmpleadoIdioma(emp);
        return "redirect:./show/" + idioma.getCodigoidioma();
    }
    
    @RequestMapping("show/{id}")    
    public String showIdioma(@PathVariable Integer id, Model model) {
        model.addAttribute("idioma", idiomaService.getIdiomaById(id).get());
        return PREFIX +"idiomashow";
    }

    @RequestMapping("delete/{id}")
<<<<<<< HEAD
    public String delete(@PathVariable Integer id,Model model) {
        try{
          idiomaService.deleteIdioma(id);
            model.addAttribute("msg", 3);
        }
        catch(Exception e){
            model.addAttribute("msg", 4);
        }
        
=======
    public String delete(@PathVariable Integer id) {
        idiomaService.deleteIdioma(id);
>>>>>>> eceb235497f17a196ae6f76834129201b8cae4ad
        return "redirect:/idiomas/";
    }
    
 
//    @RequestMapping("empleado/idioma/{id}")
//        public String findIdiomaByEmpladoId(@PathVariable Integer id, Model model) {
//        model.addAttribute("costocapacitacion", idiomaService.findByDato(id));
//        return "redirect:/idioma/";
//    }
}
