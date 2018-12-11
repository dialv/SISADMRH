package mj.gob.sisadmrh.controller.miembroscomision;

/**
 *
 * @author root
 */
import mj.gob.sisadmrh.controller.UtilsController;
import mj.gob.sisadmrh.model.Comision;
import mj.gob.sisadmrh.model.Miembroscomision;
import mj.gob.sisadmrh.service.MiembrosComisionService;
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
@RequestMapping(value = "miembrosComisiones")
public class MiembrosComisionController extends UtilsController{
    
    private MiembrosComisionService miembrosComisionService;
    


    
    @Autowired
    public void setMiembrosComisionService(MiembrosComisionService miembrosComisionService) {
        this.miembrosComisionService = miembrosComisionService;
    }
    
    private final String PREFIX = "fragments/miembrosComision/";
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("miembrosComisiones", miembrosComisionService.listAllMiembros());
        return PREFIX + "miembrosComisiones";
    }
    
    @RequestMapping("edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("miembrosComision", miembrosComisionService.getmiembroById(id));
        return PREFIX + "miembrosComisionform";
    }

    @RequestMapping("new/miembrosComision")
    public String newComision(Model model) {
        model.addAttribute("miembrosComision", new Comision());
        return PREFIX + "miembrosComisionform";
    }

    
    @RequestMapping(value = "miembrosComision" )
    public String saveComision(Miembroscomision miembrosComision,Model model) {
        try{
        miembrosComisionService.savemiembros(miembrosComision);
        
        model.addAttribute("msg", 0);
        model.addAttribute("miembrosComisiones", miembrosComisionService.listAllMiembros());
        return PREFIX+"miembrosComisiones";
        }
        catch(Exception e){
          model.addAttribute("msg", 1);
        }
         return PREFIX+"miembrosComisionform";
       // return "redirect:./show/" + miembrosComision.getCodigomiembrosComision();
    }
    
    @RequestMapping("show/{id}")
    public String showMiembroComision(@PathVariable Integer id, Model model) {
        model.addAttribute("miembrosComision", miembrosComisionService.getmiembroById(id).get());
        return PREFIX +"miembrosComisionshow";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable Integer id,Model model) {
        try{
        miembrosComisionService.deleteMiembros(id);
         model.addAttribute("msg", 3);
        }
        catch(Exception e){
        model.addAttribute("msg", 4);
         
        }
         return PREFIX + "miembrosComisiones";
    }
    
}