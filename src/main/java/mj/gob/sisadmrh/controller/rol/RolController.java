package mj.gob.sisadmrh.controller.rol;

import mj.gob.sisadmrh.controller.UtilsController;
import mj.gob.sisadmrh.model.Rol;
import mj.gob.sisadmrh.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/**
 *
 * @author dialv
 * 
 */
@Controller
@SessionAttributes("rol")
@RequestMapping(value = "roles")
public class RolController  extends UtilsController{
    
    private RolService rolService;
    
    @Autowired
    public void setRolService(RolService rolService) {
        this.rolService = rolService;
    }
    
    private final String PREFIX = "fragments/rol/";
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("roles", rolService.listAllActivos());
        return PREFIX + "roles";
    }
    
    @RequestMapping("edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("rol", rolService.getRolById(id));
        return PREFIX + "rolform";
    }

    @RequestMapping("new/rol")
    public String newRol(Model model) {
        model.addAttribute("rol", new Rol());
        return PREFIX + "rolform";
    }

    @RequestMapping(value = "rol")
    public String saveRol(Rol rol, Model model, SessionStatus status) {
        try{
        rol.setEstadorol(1);
        rolService.saveRol(rol);
        status.setComplete();
         bitacoraService.BitacoraRegistry("se Creo un Rol",getRequest().getRemoteAddr(), 
                getRequest().getUserPrincipal().getName());//COBTROLARA EVENTO DE LA BITACORA
        model.addAttribute("msg", 0);
        }
        catch(Exception e){
        model.addAttribute("msg", 1);
        }
        return PREFIX+"rolform";
//        return "redirect:./show/" + rol.getCodigorol();
    }
    
    @RequestMapping("show/{id}")
    public String showRol(@PathVariable Integer id, Model model) {
        model.addAttribute("rol", rolService.getRolById(id).get());
        return PREFIX +"rolshow";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
         try{
        Rol rol =rolService.getRolById(id).get();
        rol.setEstadorol(0);
        rolService.saveRol(rol);
             
        bitacoraService.BitacoraRegistry("se elimino un Rol",getRequest().getRemoteAddr(), 
                getRequest().getUserPrincipal().getName());//COBTROLARA EVENTO DE LA BITACORA
        model.addAttribute("msg", 3);
        }
        catch(Exception e){
        model.addAttribute("msg", 4);
        }
        return PREFIX + "roles";
//        return "redirect:/roles/";
    }
}
