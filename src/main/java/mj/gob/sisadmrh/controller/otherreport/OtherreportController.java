package mj.gob.sisadmrh.controller.otherreport;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import mj.gob.sisadmrh.controller.UtilsController;
import mj.gob.sisadmrh.model.Beneficio;
import mj.gob.sisadmrh.model.Comite;
import mj.gob.sisadmrh.pojos.AbogadosPojo;
import mj.gob.sisadmrh.service.BeneficioService;
import mj.gob.sisadmrh.service.CapacitacionService;
import mj.gob.sisadmrh.service.ComiteService;
import mj.gob.sisadmrh.service.EmpleadoBeneficioService;
import mj.gob.sisadmrh.service.EmpleadoService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author dialv
 * 
 */
@Controller
@RequestMapping(value = "otherreports")
public class OtherreportController extends UtilsController{
 
@Autowired
private ComiteService comiteService;// instancia para jalar los comites
@Autowired
private EmpleadoService empleadoService;// instancia para listar empleados como filtro de reporte
@Autowired
private CapacitacionService capacitacionSerice;// instancia para jalar las capacitaciones
    private final String PREFIX = "fragments/otherreports/";

    @RequestMapping("abogados/")
    public String reporteabogados() {
        return PREFIX + "abogadosreport";
    }
    @RequestMapping("empleadoincapacidad/")
    public String reporteempleadoincapacidad(Model model) {
         model.addAttribute("empleados", empleadoService.listAllEmpleado());
        return PREFIX + "empleadoincapacidadreport";
    }
    @RequestMapping("hijoscapesp/")
    public String reportehijoscapesp(Model model) {
        model.addAttribute("empleados", empleadoService.listAllEmpleado());
        return PREFIX + "hijoscapespreport";
    }
    @RequestMapping("historial/")
    public String reportehistorial(Model model) {
         model.addAttribute("empleados", empleadoService.listAllEmpleado());
     //   return PREFIX + "constanciasalarialesreport";
        return PREFIX + "historialreport";
    }
    @RequestMapping("motoristas/")
    public String reportemotoristas() {
        
        return PREFIX + "motoristasreport";
    }
    @RequestMapping("notarios/")
    public String reportenotarios() {
        return PREFIX + "notariosreport";
    }
    @RequestMapping("renuncias/")
    public String reporterenuncias(Model model) {
         model.addAttribute("empleados", empleadoService.listAllEmpleado());
        return PREFIX + "renunciasreport";
    }
//    de aqui para abjo reportes de beto ha vergon
     @RequestMapping("cumpleanieros/")
    public String reportecumpleanieros() {
        return PREFIX + "cumpleanierosreport";
    }
    
     @RequestMapping("capacitaciones/")
    public String reportecapacitaciones(Model model) {
        model.addAttribute("capacitaciones", capacitacionSerice.listAllCapacitacion());
        return PREFIX + "capacitacionesreport";
    }
     @RequestMapping("comites/")
    public String reportecomites(Model model) {
        model.addAttribute("comites", comiteService.listAllComite() );
        return PREFIX + "comitesreport";
    }
     @RequestMapping("constanciasalariales/")
    public String reporteconstanciasalariales(Model model) {
        model.addAttribute("empleados", empleadoService.listAllEmpleado());
        return PREFIX + "constanciasalarialesreport";
    }
    
      @RequestMapping("constanciaservicios/")
    public String reporteconstanciaservicios(Model model) {
        model.addAttribute("empleados", empleadoService.listAllEmpleado());
        return PREFIX + "constanciaserviciosreport";
    }
    
               @RequestMapping("misionesinternas/")
    public String reportemisionesinternas() {
        return PREFIX + "misionesinternasreport";
    }
    
     @RequestMapping("1misionesexternas/")
    public String reporte1misionesexternas() {
        return PREFIX + "1misionesexternasreport";
    }
    
      @RequestMapping("2misionesexternas/")
    public String reporte2misionesexternas() {
        return PREFIX + "2misionesexternasreport";
    }
    
    
    @RequestMapping(value = "abogados/{indice}", method = { RequestMethod.POST, RequestMethod.GET })
    public void pdfabogados(@PathVariable("indice") Long indice, 
            @RequestParam(required = false) Boolean download, 
            @RequestParam(value="fechainicial",required = false) String fechainicio, 
            @RequestParam(value="fechafinal", required = false) String fechafin, 
                HttpServletResponse response) throws Exception {
                Map<String, Object> params = new HashMap<>();
		params.put("FECHAINICIO", fechainicio);
		params.put("FECHAFIN", fechafin);
        	generatePdf("otherreports", "rpt_abogados", params, download,response);
    }
 
    @RequestMapping("/abogadosxls")
       public ModelAndView abogadosxls(
              @RequestParam(value="fechainicial",required = false) String fechainicio, 
              @RequestParam(value="fechafinal", required = false) String fechafin){
              List<Object[]> abogadosList = empleadoService.findabogados(fechainicio, fechafin); 
              return new ModelAndView(new AbogadosView(), "abogadosList", abogadosList);
       }

    
    
    @RequestMapping(value = "motoristas/{indice}", method = { RequestMethod.POST, RequestMethod.GET })
    public void pdfmotoristas(@PathVariable("indice") Long indice, 
            @RequestParam(required = false) Boolean download, 
            @RequestParam(value="fechainicial",required = false) String fechainicio, 
            @RequestParam(value="fechafinal", required = false) String fechafin, 
                HttpServletResponse response) throws Exception {
                Map<String, Object> params = new HashMap<>();
//		params.put("CODIGO", indice.toString());
		params.put("FECHAINICIO", fechainicio);
		params.put("FECHAFIN", fechafin);
        	generatePdf("otherreports", "rpt_motoristas", params, download,response);
    }

    @RequestMapping(value = "empleadoincapacidad/{indice}", method = { RequestMethod.POST, RequestMethod.GET })
    public void pdfempleadoincapacidad(@PathVariable("indice") Long indice, 
            @RequestParam(required = false) Boolean download, 
            @RequestParam(value="fechainicial",required = false) String fechainicio, 
            @RequestParam(value="fechafinal", required = false) String fechafin, 
                HttpServletResponse response) throws Exception {
                Map<String, Object> params = new HashMap<>();
		params.put("CODIGO", indice.toString());
		params.put("FECHAINICIO", fechainicio);
		params.put("FECHAFIN", fechafin);
        	generatePdf("otherreports", "rpt_empleadoincapacidad", params, download,response);
    }

    @RequestMapping(value = "hijoscapesp/{indice}", method = { RequestMethod.POST, RequestMethod.GET })
    public void pdfhijoscapesp(@PathVariable("indice") Long indice, 
            @RequestParam(required = false) Boolean download, 
            @RequestParam(value="fechainicial",required = false) String fechainicio, 
            @RequestParam(value="fechafinal", required = false) String fechafin, 
                HttpServletResponse response) throws Exception {
                Map<String, Object> params = new HashMap<>();
		params.put("CODIGO", indice.toString());
		params.put("FECHAINICIO", fechainicio);
		params.put("FECHAFIN", fechafin);
        	generatePdf("otherreports", "rpt_hijoscapesp", params, download,response);
    }

    @RequestMapping(value = "historial/{indice}", method = { RequestMethod.POST, RequestMethod.GET })
    public void pdfhistorial(@PathVariable("indice") Long indice, 
            @RequestParam(required = false) Boolean download, 
            @RequestParam(value="fechainicial",required = false) String fechainicio, 
            @RequestParam(value="fechafinal", required = false) String fechafin, 
                HttpServletResponse response) throws Exception {
                Map<String, Object> params = new HashMap<>();
		params.put("CODIGO", indice.toString());
		params.put("FECHAINICIO", fechainicio);
		params.put("FECHAFIN", fechafin);
        	generatePdf("otherreports", "rpt_historial", params, download,response);
    }



    @RequestMapping(value = "notarios/{indice}", method = { RequestMethod.POST, RequestMethod.GET })
    public void pdfnotarios(@PathVariable("indice") Long indice, 
            @RequestParam(required = false) Boolean download, 
            @RequestParam(value="fechainicial",required = false) String fechainicio, 
            @RequestParam(value="fechafinal", required = false) String fechafin, 
                HttpServletResponse response) throws Exception {
                Map<String, Object> params = new HashMap<>();
//		params.put("CODIGO", indice.toString());
		params.put("FECHAINICIO", fechainicio);
		params.put("FECHAFIN", fechafin);
        	generatePdf("otherreports", "rpt_notarios", params, download,response);
    }

    @RequestMapping(value = "renuncias/{indice}", method = { RequestMethod.POST, RequestMethod.GET })
    public void pdfrenuncias(@PathVariable("indice") Long indice, 
            @RequestParam(required = false) Boolean download, 
            @RequestParam(value="fechainicial",required = false) String fechainicio, 
            @RequestParam(value="fechafinal", required = false) String fechafin, 
                HttpServletResponse response) throws Exception {
                Map<String, Object> params = new HashMap<>();
		params.put("CODIGO", indice.toString());
		params.put("FECHAINICIO", fechainicio);
		params.put("FECHAFIN", fechafin);
        	generatePdf("otherreports", "rpt_renuncias", params, download,response);
    }
    
    
   @RequestMapping(value = "cumpleanieros/{indice}", method = { RequestMethod.POST, RequestMethod.GET })
    public void pdfcumpleanieros(@PathVariable("indice") Long indice, 
            @RequestParam(required = false) Boolean download, 
            @RequestParam(value="fechainicial",required = false) String fechainicio, 
            @RequestParam(value="fechafinal", required = false) String fechafin, 
                HttpServletResponse response) throws Exception {
                Map<String, Object> params = new HashMap<>();
		params.put("CODIGO", indice.toString());
		params.put("FECHAINICIO", fechainicio);
		params.put("FECHAFIN", fechafin);
        	generatePdf("otherreports", "rpt_cumpleanieros", params, download,response);
    } 

    @RequestMapping(value = "capacitaciones/{indice}", method = { RequestMethod.POST, RequestMethod.GET })
    public void pdfcapacitaciones(@PathVariable("indice") Long indice, 
            @RequestParam(required = false) Boolean download, 
            @RequestParam(value="fechainicial",required = false) String fechainicio, 
            @RequestParam(value="fechafinal", required = false) String fechafin, 
                HttpServletResponse response) throws Exception {
                Map<String, Object> params = new HashMap<>();
		params.put("CODIGO", indice.toString());
		params.put("FECHAINICIO", fechainicio);
		params.put("FECHAFIN", fechafin);
        	generatePdf("otherreports", "rpt_capacitaciones", params, download,response);
    } 
        @RequestMapping(value = "constanciasalariales/{indice}", method = { RequestMethod.POST, RequestMethod.GET })
    public void pdfconstanciasalariales(@PathVariable("indice") Long indice, 
            @RequestParam(required = false) Boolean download, 
            @RequestParam(value="fechainicial",required = false) String fechainicio, 
            @RequestParam(value="fechafinal", required = false) String fechafin, 
                HttpServletResponse response) throws Exception {
                Map<String, Object> params = new HashMap<>();
		params.put("CODIGO", indice.toString());
		params.put("FECHAINICIO", fechainicio);
		params.put("FECHAFIN", fechafin);
        	generatePdf("otherreports", "rpt_constanciasalariales", params, download,response);
    }
    
      @RequestMapping(value = "constanciaservicios/{indice}", method = { RequestMethod.POST, RequestMethod.GET })
    public void pdfconstanciaservicios(@PathVariable("indice") Long indice, 
            @RequestParam(required = false) Boolean download, 
            @RequestParam(value="fechainicial",required = false) String fechainicio, 
            @RequestParam(value="fechafinal", required = false) String fechafin, 
                HttpServletResponse response) throws Exception {
                Map<String, Object> params = new HashMap<>();
		params.put("CODIGO", indice.toString());
		params.put("FECHAINICIO", fechainicio);
		params.put("FECHAFIN", fechafin);
        	generatePdf("otherreports", "rpt_constanciaservicios", params, download,response);
    }
    
    @RequestMapping(value = "misionesinternas/{indice}", method = { RequestMethod.POST, RequestMethod.GET })
    public void pdfmisionesinternas(@PathVariable("indice") Long indice, 
            @RequestParam(required = false) Boolean download, 
            @RequestParam(value="fechainicial",required = false) String fechainicio, 
            @RequestParam(value="fechafinal", required = false) String fechafin, 
                HttpServletResponse response) throws Exception {
                Map<String, Object> params = new HashMap<>();
		params.put("CODIGO", indice.toString());
		params.put("FECHAINICIO", fechainicio);
		params.put("FECHAFIN", fechafin);
        	generatePdf("otherreports", "rpt_misionesinternas", params, download,response);
    }
    
     @RequestMapping(value = "2misionesexternas/{indice}", method = { RequestMethod.POST, RequestMethod.GET })
    public void pdf2misionesexternas(@PathVariable("indice") Long indice, 
            @RequestParam(required = false) Boolean download, 
            @RequestParam(value="fechainicial",required = false) String fechainicio, 
            @RequestParam(value="fechafinal", required = false) String fechafin, 
                HttpServletResponse response) throws Exception {
                Map<String, Object> params = new HashMap<>();
		params.put("CODIGO", indice.toString());
		params.put("FECHAINICIO", fechainicio);
		params.put("FECHAFIN", fechafin);
        	generatePdf("otherreports", "rpt_misionesexternas2", params, download,response);// adebio llamarse rpt_misionesexternas2
    }
    
    
     @RequestMapping(value = "1misionesexternas/{indice}", method = { RequestMethod.POST, RequestMethod.GET })
    public void pdf1misionesexternas(@PathVariable("indice") Long indice, 
            @RequestParam(required = false) Boolean download, 
            @RequestParam(value="fechainicial",required = false) String fechainicio, 
            @RequestParam(value="fechafinal", required = false) String fechafin, 
                HttpServletResponse response) throws Exception {
                Map<String, Object> params = new HashMap<>();
		params.put("CODIGO", indice.toString());
		params.put("FECHAINICIO", fechainicio);
		params.put("FECHAFIN", fechafin);
        	generatePdf("otherreports", "rpt_misionesexternas1", params, download,response);
    }
   @RequestMapping(value = "comites/{indice}", method = { RequestMethod.POST, RequestMethod.GET })
    public void pdfcomites(@PathVariable("indice") Long indice, 
            @RequestParam(required = false) Boolean download, 
            @RequestParam(value="fechainicial",required = false) String fechainicio, 
            @RequestParam(value="fechafinal", required = false) String fechafin, 
                HttpServletResponse response) throws Exception {
                Map<String, Object> params = new HashMap<>();
		params.put("CODIGO", indice.toString());
		params.put("FECHAINICIO", fechainicio);
		params.put("FECHAFIN", fechafin);
        	generatePdf("otherreports", "rpt_comites", params, download,response); 
}
    
    
    
    @RequestMapping("reporte/pensionadoreporte")
    public String reporteestadisticoactivo() {
        return PREFIX + "pensionadoreporte";
    }
    
    @RequestMapping(value = "pdfpensionadoreporte/", method = { RequestMethod.POST, RequestMethod.GET })
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
        	generatePdf("pensionadoreporte", "rpt_pensionado", params, download,response);
    }
    
     @RequestMapping("reporte/exoneradoreporte")
    public String reporteexoneradoreporte() {
        return PREFIX + "exoneradoreporte";
    }
    
    @RequestMapping(value = "pdfexoneradoreporte/", method = { RequestMethod.POST, RequestMethod.GET })
    public void pdfexoneradoreporte(
//            @PathVariable("indice") Long indice, 
            @RequestParam(required = false) Boolean download, 
            @RequestParam(value="fechainicial",required = false) String fechainicio, 
            @RequestParam(value="fechafinal", required = false) String fechafin, 
                HttpServletResponse response) throws Exception {
                Map<String, Object> params = new HashMap<>();
//		params.put("CODIGO", indice.toString());
//		params.put("FECHAINICIO", fechainicio);
//		params.put("FECHAFIN", fechafin);
        	generatePdf("exoneradoreporte", "rpt_exonerado", params, download,response);
    }
    
    @RequestMapping("reporte/nivelesreporte")
    public String reportenivelesreporte() {
        return PREFIX + "nivelesreporte";
    }
    
    @RequestMapping(value = "pdfnivelesreporte/", method = { RequestMethod.POST, RequestMethod.GET })
    public void pdfnivelesreporte(
//            @PathVariable("indice") Long indice, 
            @RequestParam(required = false) Boolean download, 
            @RequestParam(value="fechainicial",required = false) String fechainicio, 
            @RequestParam(value="fechafinal", required = false) String fechafin, 
                HttpServletResponse response) throws Exception {
                Map<String, Object> params = new HashMap<>();
//		params.put("CODIGO", indice.toString());
//		params.put("FECHAINICIO", fechainicio);
//		params.put("FECHAFIN", fechafin);
        	generatePdf("nivelesreporte", "rpt_nivelesescolares", params, download,response);
    }
    
    @RequestMapping("reporte/plazaoreporte")
    public String reporteplazaoreporte() {
        return PREFIX + "plazaoreporte";
    }
    
    @RequestMapping(value = "pdfplazaoreporte/", method = { RequestMethod.POST, RequestMethod.GET })
    public void pdfplazaoreporte(
//            @PathVariable("indice") Long indice, 
            @RequestParam(required = false) Boolean download, 
            @RequestParam(value="fechainicial",required = false) String fechainicio, 
            @RequestParam(value="fechafinal", required = false) String fechafin, 
                HttpServletResponse response) throws Exception {
                Map<String, Object> params = new HashMap<>();
//		params.put("CODIGO", indice.toString());
//		params.put("FECHAINICIO", fechainicio);
//		params.put("FECHAFIN", fechafin);
        	generatePdf("plazaoreporte", "rpt_plazasocupadas", params, download,response);
    }
    
     @RequestMapping("reporte/costocreporte")
    public String reportecostocreporte() {
        return PREFIX + "costocreporte";
    }
    
    @RequestMapping(value = "pdfcostocreporte/", method = { RequestMethod.POST, RequestMethod.GET })
    public void pdfcostocreporte(
//            @PathVariable("indice") Long indice, 
            @RequestParam(required = false) Boolean download, 
            @RequestParam(value="fechainicial",required = false) String fechainicio, 
            @RequestParam(value="fechafinal", required = false) String fechafin, 
                HttpServletResponse response) throws Exception {
                Map<String, Object> params = new HashMap<>();
//		params.put("CODIGO", indice.toString());
//		params.put("FECHAINICIO", fechainicio);
//		params.put("FECHAFIN", fechafin);
        	generatePdf("costocreporte", "rpt_costocapacitacion", params, download,response);
    }
}
