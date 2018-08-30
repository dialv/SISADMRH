package mj.gob.sisadmrh.controller.empleado;

import mj.gob.sisadmrh.controller.empleado.*;
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
import mj.gob.sisadmrh.service.EmpleadoService;
//import mj.gob.sisadmrh.service.EmpleadoEmpleadoService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author dialv
 * 
 */
@Controller
@RequestMapping(value = "empleados")
public class EmpleadoController extends UtilsController{
    
    private EmpleadoService empleadoService;
//    private EmpleadoEmpleadoService empleadoEmpleadoService;
    


    
    @Autowired
    public void setEmpleadoService(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }
    
    private final String PREFIX = "fragments/empleado/";
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("empleado", empleadoService.listAllEmpleado());
        return PREFIX + "empleado";
    }
    
    @RequestMapping("edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("empleado", empleadoService.getEmpleadoById(id));
        return PREFIX + "empleadoform";
    }

    @RequestMapping("new/empleado")
    public String newEmpleado(Model model) {
        model.addAttribute("empleado", new Empleado());
        return PREFIX + "empleadoform";
    }

    @RequestMapping(value = "empleado")
    public String saveEmpleado(Empleado empleado) {
        empleadoService.saveEmpleado(empleado);
        return "redirect:./show/" + empleado.getCodigoempleado();
    }
    
    @RequestMapping("show/{id}")
    public String showEmpleado(@PathVariable Integer id, Model model) {
        model.addAttribute("empleado", empleadoService.getEmpleadoById(id).get());
        return PREFIX +"empleadohow";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable Integer id) {
        empleadoService.deleteEmpleado(id);
        return "redirect:/empleado/";
    }
    
    @RequestMapping("reporte/contrataciones")
    public String reportecontrataciones() {
        return PREFIX + "contratacionesreporte";
    }
    
    @RequestMapping(value = "pdfcontrataciones/", method = { RequestMethod.POST, RequestMethod.GET })
    public void pdfcontrataciones(
//            @PathVariable("indice") Long indice, 
            @RequestParam(required = false) Boolean download, 
            @RequestParam(value="fechainicial",required = false) String fechainicio, 
            @RequestParam(value="fechafinal", required = false) String fechafin, 
                HttpServletResponse response) throws Exception {
                Map<String, Object> params = new HashMap<>();
//		params.put("CODIGO", indice.toString());
//		params.put("FECHAINICIO", fechainicio);
//		params.put("FECHAFIN", fechafin);
        	generatePdf("contrataciones", "rpt_contrataciones", params, download,response);
    }
    
    @RequestMapping("crear/empleados")
    public String newempleado() {
        return PREFIX + "empleadoform";
    }
    
    @RequestMapping("reporte/despidos")
    public String reportedespidos() {
        return PREFIX + "despidosreporte";
    }
    
    
    @RequestMapping(value = "pdfdespidos/", method = { RequestMethod.POST, RequestMethod.GET })
    public void pdfdespidos(
//            @PathVariable("indice") Long indice, 
            @RequestParam(required = false) Boolean download, 
            @RequestParam(value="fechainicial",required = false) String fechainicio, 
            @RequestParam(value="fechafinal", required = false) String fechafin, 
                HttpServletResponse response) throws Exception {
                Map<String, Object> params = new HashMap<>();
//		params.put("CODIGO", indice.toString());
//		params.put("FECHAINICIO", fechainicio);
//		params.put("FECHAFIN", fechafin);
        	generatePdf("despidos", "rpt_despidos", params, download,response);
    }

     @RequestMapping("reporte/estadisticoactivo")
    public String reporteestadisticoactivo() {
        return PREFIX + "estadisticoactivoreporte";
    }
    
    @RequestMapping(value = "pdfestadisticoactivo/", method = { RequestMethod.POST, RequestMethod.GET })
    public void pdfestadisticoactivo(
//            @PathVariable("indice") Long indice, 
            @RequestParam(required = false) Boolean download, 
            @RequestParam(value="fechainicial",required = false) String fechainicio, 
            @RequestParam(value="fechafinal", required = false) String fechafin, 
                HttpServletResponse response) throws Exception {
                Map<String, Object> params = new HashMap<>();
//		params.put("CODIGO", indice.toString());
//		params.put("FECHAINICIO", fechainicio);
//		params.put("FECHAFIN", fechafin);
        	generatePdf("estadisticoactivo", "rpt_estadisticoactivo", params, download,response);
    }
    
    
}
