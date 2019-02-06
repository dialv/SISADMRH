package mj.gob.sisadmrh.controller;
import java.security.Principal;
import mj.gob.sisadmrh.model.Usuario;
import mj.gob.sisadmrh.repository.UsuarioRepository;
import mj.gob.sisadmrh.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 *
 * @author dialv
 */
@Controller
public class HomeController {
//   @RequestMapping("/")
//    public String index() {
//        return "index";
//    }
    
    @Autowired 
    UsuarioRepository usr;
    
    
    @RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
    public String welcomePage(Model model) {
        model.addAttribute("title", "Welcome");
        model.addAttribute("message", "Bienvenido");
        return "loginPage";
    }
 
//    @RequestMapping(value = "/admin", method = RequestMethod.GET)
//    public String adminPage(Model model, Principal principal) {
//         
//        User loginedUser = (User) ((Authentication) principal).getPrincipal();
// 
//        String userInfo = WebUtils.toString(loginedUser);
//        model.addAttribute("userInfo", userInfo);
//         
//        return "adminPage";
//    }
 
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {
         return "loginPage";
    }
 
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String homePage(Model model, Principal principal) {
        Usuario loginedUser = usr.findbyusername(principal.getName());
        model.addAttribute("usuario", loginedUser);
        model.addAttribute("messageuser", "Usuario :" + principal.getName());
        return (loginedUser.getControlcontrasenia()==1)?"passform":"index";
    }
 
    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "loginPage";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {
 
        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();
            String userInfo = WebUtils.toString(loginedUser);
            model.addAttribute("userInfo", userInfo);
            String message = "Hola " + principal.getName() //
            + "<br> Tu no cuentas con los permisos para acceder a esta pagina por favor consulta con tu administrador!";
            model.addAttribute("message", message);
        }
        return "403Page";
    }
}
