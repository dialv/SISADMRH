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
import mj.gob.sisadmrh.model.Empleado;
import mj.gob.sisadmrh.model.Idioma;
import mj.gob.sisadmrh.model.Idioma;
import mj.gob.sisadmrh.model.Empleadoidioma;
import mj.gob.sisadmrh.model.EmpleadoidiomaPK;
import mj.gob.sisadmrh.service.EmpleadoIdiomaService;
import mj.gob.sisadmrh.service.EmpleadoService;
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
import org.springframework.web.bind.support.SessionStatus;

/**
 *
 * @author dialv
 * 
 */
@Controller
@RequestMapping(value = "idiomas")
public class IdiomaController extends UtilsController{
    
    private IdiomaService idiomaService;
    @Autowired
    private EmpleadoIdiomaService empleadoIdiomaService;
    @Autowired
    private EmpleadoService empleadoService ;
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
        model.addAttribute("idiomas", idiomaService.listAllActivos());
        return PREFIX + "idiomas";
    }
    
    @RequestMapping("edit/{id}/{idemp}")
    public String edit(@PathVariable Integer id,@PathVariable Integer idemp, Model model) {
        model.addAttribute("empleado", empleadoService.getEmpleadoById(idemp).get());
        model.addAttribute("idioma", idiomaService.getIdiomaById(id));
        return PREFIX + "idiomaform";
    }

     @RequestMapping("edit/idioma/{id}")
    public String editcontacto(Idioma idioma,@PathVariable Integer id, Model model,SessionStatus status) {
        idioma.setEstadoidioma(1);
        idiomaService.saveIdioma(idioma);
         status.setComplete();
         bitacoraService.BitacoraRegistry("se Modifico un idioma",getRequest().getRemoteAddr(), 
                getRequest().getUserPrincipal().getName());//COBTROLARA EVENTO DE LA BITACORA
        return "redirect:/empleados/show/"+id;
    }
    
    @RequestMapping("new/{id}") 
    public String newIdioma(Model model,@PathVariable Integer id) {
//        EmpleadoidiomaPK empCto = new EmpleadoidiomaPK();
//        empCto.setCodigoempleado(id);
//        model.addAttribute("empleadoIdioma", empCto );
        model.addAttribute("empleado", empleadoService.getEmpleadoById(id).get());
        model.addAttribute("idioma", new Idioma());
        return PREFIX + "idiomaform";
    }

    
    
    @RequestMapping(value = "idioma/{id}")
    public String saveIdioma(Idioma idioma,Model model,@PathVariable Integer id,SessionStatus status) {
       try{
           idioma.setEstadoidioma(1);
            idiomaService.saveIdioma(idioma);
            status.setComplete();
            Empleadoidioma emcon = new  Empleadoidioma();
        emcon.setIdioma(idioma);
        Empleado em = empleadoService.getEmpleadoById(id).get();
        EmpleadoidiomaPK emconpk = new EmpleadoidiomaPK();
        emconpk.setCodigoidioma(idioma.getCodigoidioma());
        emconpk.setCodigoempleado(em.getCodigoempleado());
        emcon.setEmpleadoidiomaPK(emconpk);
        empleadoIdiomaService.saveEmpleadoidioma(emcon);
            model.addAttribute("msg", 0);
        }
        catch(Exception e){
            model.addAttribute("msg", 1);
        }
        
//        emp.setCodigoidioma(idioma.getCodigoidioma()); 
//        emp.setCodigoempleado(idioma.getCodigoidioma());
//        empleadoidiomaPK.saveEmpleadoIdioma(emp);
//        return "redirect:./show/" + idioma.getCodigoidioma();
    return "redirect:/empleados/show/"+id;
    }
    
   @RequestMapping("show/{id}/{idemp}")    
    public String showIdioma(@PathVariable Integer id,@PathVariable Integer idemp, Model model) {
         model.addAttribute("empleado", empleadoService.getEmpleadoById(idemp).get());
        model.addAttribute("idioma", idiomaService.getIdiomaById(id).get());
        return PREFIX +"idiomashow";
    }

    @RequestMapping("delete/{id}/{idemp}")
    public String delete(@PathVariable Integer id,@PathVariable Integer idemp,Model model) {
        try{
            Idioma idioma = idiomaService.getIdiomaById(id).get();
            idioma.setEstadoidioma(0);
          idiomaService.saveIdioma(idioma);
          Integer cod=empleadoService.getEmpleadoById(idemp).get().getCodigoempleado();
          model.addAttribute("empleado",cod);
//           model.addAttribute("empleado", empleadoService.getEmpleadoById(idemp).get());
           model.addAttribute("msg", 3);
        }
        catch(Exception e){
            model.addAttribute("msg", 4);
        }
        
//        return "redirect:/idiomas/";
//  return "redirect:/empleados/";
        return PREFIX + "idiomas";
    }
    
    
     @RequestMapping(value = "idioma")
    public String saveRol(Idioma idioma, Model model, SessionStatus status) {
        try{
        idiomaService.saveIdioma(idioma);
        status.setComplete();
         bitacoraService.BitacoraRegistry("se cambio registro de idioma ",getRequest().getRemoteAddr(), 
                getRequest().getUserPrincipal().getName());//COBTROLARA EVENTO DE LA BITACORA
        model.addAttribute("msg", 0);
        }
        catch(Exception e){
        model.addAttribute("msg", 1);
        }
          return "redirect:/empleados/";
    }
     

}
