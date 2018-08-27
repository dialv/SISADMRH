package mj.gob.sisadmrh.controller.estado;

import mj.gob.sisadmrh.model.Estado;
//import mj.gob.sisadmrh.model.Usuario;
//import mj.gob.sisadmrh.repository.UsuarioRepository;
import mj.gob.sisadmrh.service.EstadoService;
//import mj.gob.sisadmrh.service.UsuarioService;
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
@RequestMapping(value = "estados")
public class EstadoController {
    
    private EstadoService estadoService;
    
    @Autowired
    public void setEstadoService(EstadoService estadoService) {
        this.estadoService = estadoService;
    }
    
    private final String PREFIX = "fragments/estado/";
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("estados", estadoService.listAllEstado());
        return PREFIX + "estados";
    }
    
    @RequestMapping("edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("estado", estadoService.getEstadoById(id));
        return PREFIX + "estadoform";
    }

    @RequestMapping("new/estado")
    public String newEstado(Model model) {
        EstadoForm estadoform = new EstadoForm();
        estadoform.setEstados(estadoService.listAllEstado());
        model.addAttribute("formestado", estadoform);
        return PREFIX + "estadoform";
    }

    @RequestMapping(value = "estado")
    public String saveEstado(EstadoForm estadoform,Model model) {
         try{
        estadoService.saveEstado(estadoform.getEstado());
        
        model.addAttribute("msg", 0);
        model.addAttribute("estados", estadoService.listAllEstado());
        return PREFIX + "estados";
         }
        catch(Exception e){
        model.addAttribute("msg", 1);
         estadoform.setEstados(estadoService.listAllEstado());
        model.addAttribute("formestado", estadoform);
        return PREFIX + "estadoform";
        }
       // return "redirect:./show/" + estado.getCodigoestado();
    }
    
    @RequestMapping("show/{id}")
    public String showEstado(@PathVariable Integer id, Model model) {
        model.addAttribute("estado"+ "", estadoService.getEstadoById(id).get());
        return PREFIX +"estadoshow";
    }

    @RequestMapping("delete/{id}")
    
    public String delete(@PathVariable Integer id,Model model) {
        try{
        estadoService.deleteEstado(id);
        model.addAttribute("msg", 3);
        }
        catch(Exception e)
        {
        model.addAttribute("msg", 4);
        }
        
        return "redirect:/estados/";
    }
}
