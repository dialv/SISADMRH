package mj.gob.sisadmrh.controller.experiencialaboral;

import mj.gob.sisadmrh.controller.experiencialaboral.*;
import mj.gob.sisadmrh.controller.experiencialaboral.*;
import mj.gob.sisadmrh.controller.experiencialaboral.*;
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
import mj.gob.sisadmrh.model.Experiencialaboral;
import mj.gob.sisadmrh.model.Experiencialaboral;
import mj.gob.sisadmrh.service.ExperiencialaboralService;
import mj.gob.sisadmrh.service.ExperiencialaboralService;
//import mj.gob.sisadmrh.service.ExperiencialaboralExperiencialaboralService;
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
@RequestMapping(value = "experiencialaborales")
public class ExperiencialaboralController extends UtilsController{
    
    private ExperiencialaboralService experiencialaboralService;
//    private ExperiencialaboralExperiencialaboralService experiencialaboralExperiencialaboralService;
    


    
    @Autowired
    public void setExperiencialaboralService(ExperiencialaboralService experiencialaboralService) {
        this.experiencialaboralService = experiencialaboralService;
    }
    
    private final String PREFIX = "fragments/experiencialaboral/";
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("experiencialaborales", experiencialaboralService.listAllExperiencialaboral());
        return PREFIX + "experiencialaborales";
    }
    
    @RequestMapping("edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("experiencialaboral", experiencialaboralService.getExperiencialaboralById(id));
        return PREFIX + "experienciaform";
    }

    @RequestMapping("new/{id}")
    public String newExperiencialaboral(Model model) {
        model.addAttribute("experiencialaboral", new Experiencialaboral());
        return PREFIX + "experienciaform";
    }

    @RequestMapping(value = "experiencialaboral")
    public String saveExperiencialaboral(Experiencialaboral experiencialaboral) {
        experiencialaboralService.saveExperiencialaboral(experiencialaboral);
        return "redirect:./show/" + experiencialaboral.getCodigoexperiencialaboral();
    }
    
    @RequestMapping("show/{id}")    
    public String showExperiencialaboral(@PathVariable Integer id, Model model) {
        model.addAttribute("experiencialaboral", experiencialaboralService.getExperiencialaboralById(id).get());
        return PREFIX +"experienciashow";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable Integer id) {
        experiencialaboralService.deleteExperiencialaboral(id);
        return "redirect:/experiencialaborales/";
    }
    
    
    
}
