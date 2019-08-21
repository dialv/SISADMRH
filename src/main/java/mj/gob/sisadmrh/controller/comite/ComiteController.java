package mj.gob.sisadmrh.controller.comite;

import java.util.HashMap;
import java.util.Map;
import mj.gob.sisadmrh.controller.UtilsController;
import javax.servlet.http.HttpServletResponse;
import mj.gob.sisadmrh.model.Comite;
import mj.gob.sisadmrh.model.Empleado;
import mj.gob.sisadmrh.service.ComiteService;
import mj.gob.sisadmrh.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("comite")
@RequestMapping(value = "comites")
public class ComiteController extends UtilsController {

    private ComiteService comiteService;

    @Autowired
    public void setComiteService(ComiteService comiteService) {
        this.comiteService = comiteService;
    }
    @Autowired
    private EmpleadoService empleadoService;

    @RequestMapping("edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("comite", comiteService.getComiteById(id));
        Iterable<Empleado> empleados = empleadoService.listAllActivosPensionados();
        model.addAttribute("empleados", empleados);
        return PREFIX + "comiteform";
    }
    private final String PREFIX = "fragments/comite/";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String list(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        model.addAttribute("comites", comiteService.listAllActivos());//paginado
        return PREFIX + "comites";
    }

    @RequestMapping("new/comite")
    public String newComite(Model model) {
        model.addAttribute("comite", new Comite());
        Iterable<Empleado> empleados = empleadoService.listAllActivosPensionados();
        model.addAttribute("empleados", empleados);
        return PREFIX + "comiteform";
    }

    @RequestMapping(value = "comite")
    public String saveComite(Comite comite, Model model, SessionStatus status) {
        try {
            comite.setEstadocomite(1);
            comiteService.saveComite(comite);
            status.setComplete();
            model.addAttribute("comites", comiteService.listAllActivos());
            model.addAttribute("msg", 0);
            bitacoraService.BitacoraRegistry("se guardo un Comite", getRequest().getRemoteAddr(),
                    getRequest().getUserPrincipal().getName());//COBTROLARA EVENTO DE LA BITACORA

        } 
//        catch (Exception e) {
//            model.addAttribute("msg", 1);
//        }
        
        catch (Exception ex) {
                  
                     System.out.println("Error {");
                     StackTraceElement[] elementRaster3 = ex.getStackTrace();
                     for (int in3=0;in3<elementRaster3.length;in3++) {
                         final StackTraceElement elementSTD=elementRaster3[in3];
                           System.out.println(" "+comite.getFechadesdecomite());
                         System.out.println("   "+ in3 +" - getClassName="+elementSTD.getClassName());
                         System.out.println("   getMethodName="+elementSTD.getMethodName());
                         System.out.println("   getLineNumber="+elementSTD.getLineNumber());
                         System.out.println("   errorMSG="+ex.getMessage());
                     }
                     System.out.println("}");
                  model.addAttribute("msg", 1);
              }

        return PREFIX + "comiteform";
    }

    @RequestMapping("show/{id}")
    public String showComite(@PathVariable Integer id, Model model) {
        model.addAttribute("comite", comiteService.getComiteById(id).get());
        return PREFIX + "comiteshow";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        try {
            Comite comite = comiteService.getComiteById(id).get();
            comite.setEstadocomite(0);
            comiteService.saveComite(comite);
            bitacoraService.BitacoraRegistry("se elimino un Comite", getRequest().getRemoteAddr(),
            getRequest().getUserPrincipal().getName());//COBTROLARA EVENTO DE LA BITACORA
            model.addAttribute("msg", 3);
        } catch (Exception e) {
            model.addAttribute("msg", 4);
        }
        return "redirect:/comites/";
    }

    @RequestMapping("buscar/")
    public String buscar() {

        return PREFIX + "buscar";
    }

    @RequestMapping(value = "buscar/listar/{dato}", method = {RequestMethod.GET})
    public ModelAndView listComite(@PathVariable("dato") String dato) {

        ModelAndView mv = new ModelAndView(PREFIX + "listComite");

        Iterable<Comite> lista = comiteService.findByComite(dato);

        mv.addObject("comites", lista);
        mv.addObject("dato", dato);
        return mv;
    }

    @RequestMapping("report/")
    public String reporte(Model model) {
        model.addAttribute("comites", comiteService.listAllComite());
        return PREFIX + "comitesreport";
    }

    @RequestMapping(value = "pdf/{indice}", method = {RequestMethod.POST, RequestMethod.GET})
    public void pdf(@PathVariable("indice") Long indice,
            @RequestParam(required = false) Boolean download,
            @RequestParam(value = "fechainicial", required = false) String fechainicio,
            @RequestParam(value = "fechafinal", required = false) String fechafin,
            HttpServletResponse response) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("CODIGO", indice.toString());
        params.put("FECHAINICIO", fechainicio);
        params.put("FECHAFIN", fechafin);
        generatePdf("comites", "rpt_comites", params, download, response);
    }

}
