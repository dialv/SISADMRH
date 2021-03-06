package mj.gob.sisadmrh.controller.Inasistencia;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import mj.gob.sisadmrh.controller.UtilsController;
import mj.gob.sisadmrh.model.Empleado;
import mj.gob.sisadmrh.model.Inasistencia;
import mj.gob.sisadmrh.service.EmpleadoService;
import mj.gob.sisadmrh.service.InasistenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author jorge
 */
@Controller
@SessionAttributes("inasistencia")
@RequestMapping(value = "inasistencias")
public class InasistenciaController extends UtilsController{
    @Autowired
    private EmpleadoService empleadoService;
    @Autowired
    private InasistenciaService inasistenciaService;
    
    
    private final String PREFIX = "fragments/inasistencia/";
      @RequestMapping(value = "/", method=RequestMethod.GET)
    public String list(Model model){
    model.addAttribute("inasistencias", inasistenciaService.listAllActivos());
    return PREFIX + "inasistencias";
    }
       @RequestMapping("edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("inasistencia",inasistenciaService.getInasistenciaById(id));
         Iterable<Empleado> empleados = empleadoService.listAllActivos();
//         
      model.addAttribute("empleados", empleados);
//       return PREFIX + "inasistenciaform";
         return PREFIX + "inasistenciaform";
    }
    
     @RequestMapping("new/inasistencia")
    public String newInasistencia(Model model) {
        model.addAttribute("inasistencia", new Inasistencia());
          Iterable<Empleado> empleados = empleadoService.listAllActivos();
//         
      model.addAttribute("empleados", empleados);
       return PREFIX + "inasistenciaform";
                }
    
     @RequestMapping(value = "/descarga/{id}")
    public void verDocumento(HttpServletResponse response, @PathVariable(value = "id") Integer id) 
           throws IOException{ 
           streamReport(response, inasistenciaService.getInasistenciaById(id).get().getAcuerdo(), "acuerdo.pdf");
    }
       @RequestMapping(value = "inasistencia")
    public String saveInasistencia(Inasistencia inasistencia,Model model,SessionStatus status,@RequestParam("file") MultipartFile file) {
        try{
            inasistencia.setAcuerdo(file.getBytes());
            inasistencia.setEstadoinasistencia(1);
        inasistenciaService.saveInasistencia(inasistencia);
        status.setComplete();
         bitacoraService.BitacoraRegistry("se Creo una Inasistencias",getRequest().getRemoteAddr(), 
                getRequest().getUserPrincipal().getName());//COBTROLARA EVENTO DE LA BITACORA
        model.addAttribute("msg", 0);
       // model.addAttribute("inasistencias", inasistenciaService.listAllInasistencia());
      // return PREFIX+"inasistencias";
        }
        catch(Exception e){
          model.addAttribute("msg", 1);
        }
        // return PREFIX+"inasistenciaform";
        return PREFIX+"inasistencias";
       // return "redirect:./show/" + comision.getCodigocomision();
    }
     @RequestMapping("show/{id}")
    public String Inasistencia(@PathVariable Integer id, Model model) {
        model.addAttribute("inasistencia", inasistenciaService.getInasistenciaById(id).get());
        return PREFIX +"inasistenciashow";
    }
    
    @RequestMapping("delete/{id}")
    public String delete(@PathVariable Integer id,Model model) {
        try{
            Inasistencia inasistencia = inasistenciaService.getInasistenciaById(id).get();
            inasistencia.setEstadoinasistencia(0);
        inasistenciaService.saveInasistencia(inasistencia);
        bitacoraService.BitacoraRegistry("se elimino una Inasistencias",getRequest().getRemoteAddr(), 
                getRequest().getUserPrincipal().getName());//COBTROLARA EVENTO DE LA BITACORA
         model.addAttribute("msg", 3);
        }
        catch(Exception e){
        model.addAttribute("msg", 4);
         
        }
         return PREFIX + "inasistencias";
        //return "redirect:/comisiones/";
    }
     @RequestMapping("buscar/")
    public String buscar() {
             
        return PREFIX +"buscar";
    }
    
    
      @RequestMapping(value="buscar/listar/{dato}",method = { RequestMethod.GET})
    public ModelAndView listInasistencia(@PathVariable("dato") String dato) {
        
          ModelAndView mv = new ModelAndView(PREFIX +"listInasistencia");
          
       Iterable<Inasistencia> lista =  inasistenciaService.findByMotivo(dato);
          
          
           mv.addObject("inasistencias", lista);
           mv.addObject("dato", dato);
        return mv;
    }
    
}
