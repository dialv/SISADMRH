package mj.gob.sisadmrh.controller.usuario;

import mj.gob.sisadmrh.controller.UtilsController;
import mj.gob.sisadmrh.model.Usuario;
import mj.gob.sisadmrh.model.Usuariorol;
import mj.gob.sisadmrh.model.UsuariorolPK;
import mj.gob.sisadmrh.service.RolService;
import mj.gob.sisadmrh.service.UsuarioRolService;
import mj.gob.sisadmrh.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    private UsuarioRolService usuarioRolService;
    
    @Autowired
    RolService rolService;
    
    @Autowired
    BCryptPasswordEncoder paswordEnc; 
    
    private final String PREFIX = "fragments/usuario/";
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("usuarios", usuarioService.listAllUsuarios());
        return PREFIX + "usuarios";
    }
    
    @RequestMapping("edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("usuario", usuarioService.getUsuarioById(id));
        return PREFIX + "usuarioformedit";
    }

    @RequestMapping("new/usuario")
    public String newUsuario(Model model) {
        
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("roles",rolService.listAllActivos());
        return PREFIX + "usuarioform";
    }

    @RequestMapping(value = "usuario")
    public String saveUsuario(@ModelAttribute("fingreso") String fingreso, 
        @ModelAttribute("rol") String rol, Usuario usuario,Model model, 
        SessionStatus status) {
        Usuario aux=new Usuario();
        aux.setNombrecompleto(usuario.getNombrecompleto());
        aux.setNombreusuario(usuario.getNombreusuario());
        aux.setContraseniausuario(usuario.getContraseniausuario());
        aux.setControlcontrasenia(usuario.getControlcontrasenia());
        aux.setDui(usuario.getDui());
        aux.setFechaingreso(usuario.getFechaingreso());
        try{
        usuario.setEstadousuario(1);
        usuario.setControlcontrasenia("1");
        usuario.setContraseniausuario(paswordEnc.encode(usuario.getContraseniausuario()));
        usuario.setNombrecompleto(usuario.getNombrecompleto()+","+usuario.getNombreusuario());
        usuario.setNombreusuario(generaUser(usuario.getNombrecompleto(),usuario.getNombreusuario(), "0"));
        usuarioService.saveUsuario(usuario);
        
        UsuariorolPK llave = new UsuariorolPK();
        Usuariorol usuariorol = new Usuariorol();
        llave.setCodigorol(Integer.parseInt(rol));
        llave.setCodigousuario(usuarioService.findbyUser(usuario.getNombreusuario()).getCodigousuario());
        usuariorol.setUsuariorolPK(llave);
        usuarioRolService.saveUsuariorol(usuariorol);
        
        status.setComplete();
        bitacoraService.BitacoraRegistry("se Creo un Usuario",getRequest().getRemoteAddr(), 
                getRequest().getUserPrincipal().getName());//COBTROLARA EVENTO DE LA BITACORA
         model.addAttribute("msg", 0);
         model.addAttribute("usuarioname", usuario.getNombreusuario());
        }
        catch(Exception e){
         model.addAttribute("usuario", aux);   
         model.addAttribute("msg", 1);
        }
        return PREFIX+"usuarioform";
    }
    @RequestMapping(value = "usuarioedit")
    public String editUsuario(Usuario usuario,Model model, SessionStatus status) {
        try{
        usuario.setEstadousuario(1);
        usuario.setControlcontrasenia("1");
        usuario.setContraseniausuario((usuario.getContraseniausuario().length()>49)?usuario.getContraseniausuario()
                :paswordEnc.encode(usuario.getContraseniausuario()));
        usuarioService.saveUsuario(usuario);
        status.setComplete();
        bitacoraService.BitacoraRegistry("se modifico Usuario",getRequest().getRemoteAddr(), 
                getRequest().getUserPrincipal().getName());//COBTROLARA EVENTO DE LA BITACORA
         model.addAttribute("msg", 10);
         model.addAttribute("usuarioname", usuario.getNombreusuario());
        }
        catch(Exception e){
         model.addAttribute("msg", 1);
        }
        return PREFIX+"usuarioform";
    }
    
    @RequestMapping("show/{id}")
    public String showUsuario(@PathVariable Integer id, Model model) {
        
        model.addAttribute("usuario", usuarioService.getUsuarioById(id).get());
        model.addAttribute("roleslist", (usuarioRolService.getListroles(id).isEmpty())
                ?"el usuario no tiene roles asignados":usuarioRolService.getListroles(id));
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
    }
    private String generaUser(String nombre, String apellido, String vez){
        String username = (vez.equals("0")) ?
            ((nombre.charAt(0)+apellido.split(" ")[0]).length()>16) ?
                (nombre.charAt(0)+apellido.split(" ")[0]).substring(0,16).toLowerCase() :
                ((nombre.charAt(0)+apellido.split(" ")[0]).length()<8)?
                    aleatory((nombre.charAt(0)+apellido.split(" ")[0]).toLowerCase()) :
                    (nombre.charAt(0)+apellido.split(" ")[0]).toLowerCase()
                :  
                vez.length()>13     ?
                    (vez.substring(0,13)+((int) (Math.random() * 999) + 1)).toLowerCase():
                    (vez+((int) (Math.random() * 999) + 1)).toLowerCase();
            return (usuarioService.findbyUser(username)!=null)?generaUser(nombre, apellido, username): username.toLowerCase();            
    }
    
    private String aleatory (String user){
        switch(user.length()){
            case 2:
                user+=((int) (Math.random() * 999999) + 1);
                break;
            case 3:
                user+=((int) (Math.random() * 99999) + 1);
                break;
            case 4:
                user+=((int) (Math.random() * 9999) + 1);
                break;
            case 5:
                user+=((int) (Math.random() * 999) + 1);
                break;
            case 6:
                user+=((int) (Math.random() * 99) + 1);
                break;
            case 7:
                user+=((int) (Math.random() * 9) + 1);
                break;
        }
    return user;
    }
}