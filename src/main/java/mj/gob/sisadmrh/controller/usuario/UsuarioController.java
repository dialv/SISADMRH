package mj.gob.sisadmrh.controller.usuario;

import java.util.Date;
import mj.gob.sisadmrh.model.Usuario;
import mj.gob.sisadmrh.repository.UsuarioRepository;
import mj.gob.sisadmrh.service.UsuarioService;
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
@SessionAttributes("usuario")
@RequestMapping(value = "usuarios")
public class UsuarioController {
    
    private UsuarioService usuarioService;
    
    @Autowired
    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    
    private final String PREFIX = "fragments/usuario/";
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("usuarios", usuarioService.listAllUsuarios());
        return PREFIX + "usuarios";
    }
    
    @RequestMapping("edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("usuario", usuarioService.getUsuarioById(id));
        return PREFIX + "usuarioform";
    }

    @RequestMapping("new/usuario")
    public String newUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return PREFIX + "usuarioform";
    }

    @RequestMapping(value = "usuario")
    public String saveUsuario(Usuario usuario,Model model, SessionStatus status) {
        try{
            
        Date fecha = new Date();
        usuario.setFechaingreso(fecha);
        usuario.setEstadousuario(1);
        usuarioService.saveUsuario(usuario);
        status.setComplete();
        
         model.addAttribute("msg", 0);
        }
        catch(Exception e){
         model.addAttribute("msg", 1);
        }
        return PREFIX+"usuarioform";
       // return "redirect:./show/" + usuario.getCodigousuario();
    }
    
    @RequestMapping("show/{id}")
    public String showUsuario(@PathVariable Integer id, Model model) {
        model.addAttribute("usuario", usuarioService.getUsuarioById(id).get());
        return PREFIX +"usuarioshow";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable Integer id,Model model) {
        try{
        usuarioService.deleteUsuario(id);
         model.addAttribute("msg", 3);}
        
        catch(Exception e){
        model.addAttribute("msg", 4);
        }
        return PREFIX + "usuarios";
       // return "redirect:/usuarios/";
    }
}
