package mj.gob.sisadmrh.controller.usuario;

import java.util.Date;
import mj.gob.sisadmrh.controller.UtilsController;
import mj.gob.sisadmrh.model.Usuario;
import mj.gob.sisadmrh.repository.UsuarioRepository;
import mj.gob.sisadmrh.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
public class UsuarioController extends UtilsController{

    private UsuarioService usuarioService;
    
    @Autowired
    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    
    @Autowired
    BCryptPasswordEncoder paswordEnc; 
    
    private final String PREFIX = "fragments/usuario/";
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("usuarios", usuarioService.listAllActivos());
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
        usuario.setControlcontrasenia(1);
        usuario.setContraseniausuario(paswordEnc.encode(usuario.getContraseniausuario()));
        usuario.setNombrecompleto(usuario.getNombrecompleto()+","+usuario.getNombreusuario());
        usuario.setNombreusuario(generaUser(usuario.getNombrecompleto(),usuario.getNombreusuario(), "0"));
        usuarioService.saveUsuario(usuario);
        status.setComplete();
        bitacoraService.BitacoraRegistry("se Creo un Usuario",getRequest().getRemoteAddr(), 
                getRequest().getUserPrincipal().getName());//COBTROLARA EVENTO DE LA BITACORA
         model.addAttribute("msg", 0);
         model.addAttribute("usuarioname", usuario.getNombreusuario());
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
        Usuario usuario =usuarioService.getUsuarioById(id).get();
        usuario.setEstadousuario(0);
        usuarioService.saveUsuario(usuario);
        bitacoraService.BitacoraRegistry("se elimino el Usuario con codigo "+id,getRequest().getRemoteAddr(), 
                getRequest().getUserPrincipal().getName());
         model.addAttribute("msg", 3);}
        
        catch(Exception e){
        model.addAttribute("msg", 4);
        }
        return PREFIX + "usuarios";
       // return "redirect:/usuarios/";
    }
    private String generaUser(String nombre, String apellido, String vez){
            String username = (vez.equals("0"))
                            ?
                    ((nombre.charAt(0)+apellido.split(" ")[0]).length()>15)?
                    (nombre.charAt(0)+apellido.split(" ")[0]).substring(0,15):
                    (nombre.charAt(0)+apellido.split(" ")[0])
                            :  
                    vez.length()>12     ?
                    (vez.substring(0,12)+((int) (Math.random() * 999) + 1)):
                    (vez+((int) (Math.random() * 999) + 1));
            return (usuarioService.findbyUser(username)!=null)?generaUser(nombre, apellido, username): username;            
//            String username = (vez.equals("0"))?(nombre.charAt(0)+apellido.split(" ")[0]).substring(0, 15):vez;
//            return   (usuarioService.findbyUser(username)==null)?username.substring(0, 15):generaUser(nombre, apellido,
//          (Character.isDigit(username.charAt(0)))
//                    ? (Character.getNumericValue(username.charAt(0))+1)+username
//                    :'1'+username).substring(0, 15); 

    }
}