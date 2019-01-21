package mj.gob.sisadmrh.controller.experiencialaboral;

import mj.gob.sisadmrh.controller.UtilsController;
import mj.gob.sisadmrh.model.Empleado;
import mj.gob.sisadmrh.model.Empleadoexperiencialaboral;
import mj.gob.sisadmrh.model.EmpleadoexperiencialaboralPK;
import mj.gob.sisadmrh.model.Experiencialaboral;
import mj.gob.sisadmrh.service.EmpleadoExperiencialaboralService;
import mj.gob.sisadmrh.service.EmpleadoService;
import mj.gob.sisadmrh.service.ExperiencialaboralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    private EmpleadoExperiencialaboralService empleadoExperiencialaboralService;
    @Autowired
    private EmpleadoService empleadoService;


    
    @Autowired
    public void setExperiencialaboralService(ExperiencialaboralService experiencialaboralService) {
        this.experiencialaboralService = experiencialaboralService;
    }
    
    private final String PREFIX = "fragments/experiencialaboral/";
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("experiencialaborales", experiencialaboralService.listAllActivos());
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

    @RequestMapping(value = "experiencialaboral/{id}")
    public String saveExperiencialaboral(Experiencialaboral experiencialaboral,Model model,@PathVariable Integer id) {
         try{
             experiencialaboral.setEstadoexp(1);
             experiencialaboralService.saveExperiencialaboral(experiencialaboral);
            Empleadoexperiencialaboral emcon = new  Empleadoexperiencialaboral();
            emcon.setExperiencialaboral(experiencialaboral);
            Empleado em = empleadoService.getEmpleadoById(id).get();
            EmpleadoexperiencialaboralPK emconpk = new EmpleadoexperiencialaboralPK();
            emconpk.setCodigoexperiencialaboral(experiencialaboral.getCodigoexperiencialaboral());
            emconpk.setCodigoempleado(em.getCodigoempleado());
            emcon.setEmpleadoexperiencialaboralPK(emconpk);
            empleadoExperiencialaboralService.saveEmpleadoexperiencialaboral(emcon);
            model.addAttribute("msg", 0);
        }
        catch(Exception e){
            model.addAttribute("msg", 1);
        }
       
//        return "redirect:./show/" + experiencialaboral.getCodigoexperiencialaboral();
 return PREFIX + "experienciaform";
    }
    
    @RequestMapping("show/{id}")    
    public String showExperiencialaboral(@PathVariable Integer id, Model model) {
        model.addAttribute("experiencialaboral", experiencialaboralService.getExperiencialaboralById(id).get());
        return PREFIX +"experienciashow";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable Integer id,Model model) {
         try{
             Experiencialaboral experiencialaboral = experiencialaboralService.getExperiencialaboralById(id).get();
             experiencialaboral.setEstadoexp(0);
            experiencialaboralService.saveExperiencialaboral(experiencialaboral);
            model.addAttribute("msg", 3);
        model.addAttribute("experiencialaboral", experiencialaboral);
         }
        catch(Exception e){
            model.addAttribute("msg", 4);
        }
       
//        return "redirect:/experiencialaborales/";
        return PREFIX +"experienciashow";
    }
    
    
    
}
