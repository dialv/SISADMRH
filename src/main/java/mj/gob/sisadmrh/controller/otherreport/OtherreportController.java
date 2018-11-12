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
import mj.gob.sisadmrh.model.Capacitador;
import mj.gob.sisadmrh.model.Comite;
import mj.gob.sisadmrh.model.DiagnosticoCapacitacion;
import mj.gob.sisadmrh.model.Empleado;
import mj.gob.sisadmrh.pojos.AbogadosPojo;
import mj.gob.sisadmrh.service.BeneficioService;
import mj.gob.sisadmrh.service.CapacitacionService;
import mj.gob.sisadmrh.service.CapacitadorService;
import mj.gob.sisadmrh.service.ComiteService;
import mj.gob.sisadmrh.service.DiagnosticoCapacitacionService;
import mj.gob.sisadmrh.service.HijosdiscapacidadService;
import mj.gob.sisadmrh.service.EmpleadoBeneficioService;
import mj.gob.sisadmrh.service.EmpleadoService;
import mj.gob.sisadmrh.service.MisionService;
import mj.gob.sisadmrh.service.PuestoService;

import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

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
//@Autowired
//public void getListComitesExcel(ComiteService comiteService){
//    this.comiteService=comiteService;
//}
        

@Autowired
private EmpleadoService empleadoService;// instancia para listar empleados como filtro de reporte
@Autowired
private CapacitacionService capacitacionService;// instancia para jalar las capacitaciones
@Autowired
private CapacitadorService capacitadorService;
@Autowired
private DiagnosticoCapacitacionService diagnosticoService;
@Autowired
private PuestoService puestoService;
@Autowired
private MisionService misionService;
@Autowired
private HijosdiscapacidadService hijosdiscapacidadService;


    private final String PREFIX = "fragments/otherreports/";

    @RequestMapping("abogados/")
    public String reporteabogados() {
        return PREFIX + "abogadosreport";
    }
    @RequestMapping("capacitadores/")
    public String reportecapacitadores() {
        return PREFIX + "capacitadoresreporte";
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
        model.addAttribute("capacitaciones", capacitacionService.listAllCapacitacion());
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
    
             
    
     @RequestMapping("1misionesexternas/")
    public String reporte1misionesexternas() {
        return PREFIX + "1misionesexternasreport";
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
              Iterable <Empleado> abogadosList = empleadoService.findabogados(fechainicio, fechafin, 3); 
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
        @RequestMapping("/motoristasxls")
       public ModelAndView motoristasxls(
              @RequestParam(value="fechainicial",required = false) String fechainicio, 
              @RequestParam(value="fechafinal", required = false) String fechafin){
              Iterable <Empleado> motoristasList = empleadoService.findabogados(fechainicio, fechafin, 5); 
              return new ModelAndView(new MotoristasView(), "motoristasList", motoristasList);
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
   /* reporte de exel para incapacidades ***********************/
    @RequestMapping("/empleadoincapacidadxls")
       public ModelAndView empleadoincapacidadxls(
              @RequestParam(value="fechainicial",required = false) String fechainicio, 
              @RequestParam(value="fechafinal", required = false) String fechafin){
              List<Object[]>  empleadoincapacidadList = empleadoService.findByIncapacidad(fechainicio, fechafin);
              return new ModelAndView(new IncapacidadView(), "empleadoincapacidadList", empleadoincapacidadList);
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
    
    @RequestMapping("/hijoscapxls")
       public ModelAndView hijoscapxls(
              @RequestParam(value="fechainicial",required = false) String fechainicio, 
              @RequestParam(value="fechafinal", required = false) String fechafin){
              List<Object[]>  hijoscapList = hijosdiscapacidadService.findhijoscap();
              return new ModelAndView(new HijoscapView(), "hijoscapList", hijoscapList);
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

   @RequestMapping("/historialxls")
       public ModelAndView historialxls(
              @RequestParam(value="fechainicial",required = false) String fechainicio, 
              @RequestParam(value="codigo",required = false) String codigo, 
              @RequestParam(value="fechafinal", required = false) String fechafin){
              List<Object[]>  historialList = empleadoService.findByPuestosEmpleados(codigo);//PARA GERNARAR EL HISTORIAL LABORAL
              return new ModelAndView(new HistorialView(), "historialList", historialList);
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

    @RequestMapping("/notariosxls")
       public ModelAndView notariosxls(
              @RequestParam(value="fechainicial",required = false) String fechainicio, 
              @RequestParam(value="fechafinal", required = false) String fechafin){
              Iterable <Empleado> notariosList = empleadoService.findabogados(fechainicio, fechafin, 4); 
              return new ModelAndView(new NotariosView(), "notariosList", notariosList);
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
    @RequestMapping("/renunciasxls")
       public ModelAndView renunciasxls(
              @RequestParam(value="fechainicial",required = false) String fechainicio, 
              @RequestParam(value="fechafinal", required = false) String fechafin){
              List<Object[]> renunciasList = empleadoService.renuncias(fechainicio, fechafin); 
              return new ModelAndView(new RenunciasView(), "renunciasList", renunciasList);
       }

    
   @RequestMapping(value = "cumpleanieros/{indice}", method = { RequestMethod.POST, RequestMethod.GET })
    public void pdfcumpleanieros(@PathVariable("indice") Long indice, 
            @RequestParam(required = false) Boolean download, 
            @RequestParam(value="fechainicial",required = false) String fechainicio, 
            @RequestParam(value="fechafinal", required = false) String fechafin, 
                HttpServletResponse response) throws Exception {
                Map<String, Object> params = new HashMap<>();
//		params.put("CODIGO", indice.toString());
		params.put("FECHAINICIO", fechainicio);
		params.put("FECHAFIN", fechafin);
        	generatePdf("otherreports", "rpt_cumpleanieros", params, download,response);
                
    } 
      // ---------       -- para generar el exel de cimpleaqnieros---------------------
       @RequestMapping("/cumpleanierosxls")
       public ModelAndView cumpleanierosxls(
              @RequestParam(value="fechainicial",required = false) String fechainicio, 
              @RequestParam(value="fechafinal", required = false) String fechafin)
            {
              List<Object[]> cumplesList = empleadoService.findBycumples(fechainicio, fechafin);
              return new ModelAndView((View) new CumpleanierosView(), "cumplesList", cumplesList);
       }
//..................pARA GENERAR EL REPORTE PDF DE CAPACITACIONES ................................................
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
    // ................... Para generar el reporte en excel de capacitaciones............
      @RequestMapping("/capacitacionesxls")
       public ModelAndView capacitacionesxls(
              @RequestParam(value="fechainicial",required = false) String fechainicio, 
              @RequestParam(value="fechafinal", required = false) String fechafin,
              @RequestParam(value="codigo",required = false) String codigo){
              List<Object[]> capacitacionesList = capacitacionService.findByCapacitacionesR(fechainicio, fechafin, codigo);
              return new ModelAndView((View) new CapacitacionesView(), "capacitacionesList", capacitacionesList);
       }
    
        @RequestMapping(value = "constanciasalariales/{indice}/rpt/{rpt}", method = { RequestMethod.POST, RequestMethod.GET })
    public void pdfconstanciasalariales(@PathVariable("indice") Long indice, 
             @PathVariable("rpt") Integer rpt,
            @RequestParam(required = false) Boolean download, 
            @RequestParam(value="fechainicial",required = false) String fechainicio, 
            @RequestParam(value="fechafinal", required = false) String fechafin, 
                HttpServletResponse response) throws Exception {
                Map<String, Object> params = new HashMap<>();
		params.put("CODIGO", indice.toString());
		params.put("FECHAINICIO", fechainicio);
		params.put("FECHAFIN", fechafin);
        	//generatePdf("otherreports", "rpt_constanciasalariales", params, download,response);
                if(rpt==1)
        	generatePdf("otherreports", "rpt_constanciasalariales", params, download,response);
                else generateWord("otherreports", "rpt_constanciasalariales", params, download,response);
    }
    
      @RequestMapping(value = "constanciaservicios/{indice}/rpt/{rpt}", method = { RequestMethod.POST, RequestMethod.GET })
    public void pdfconstanciaservicios(@PathVariable("indice") Long indice, 
            @PathVariable("rpt") Integer rpt,
            @RequestParam(required = false) Boolean download, 
            @RequestParam(value="fechainicial",required = false) String fechainicio, 
            @RequestParam(value="fechafinal", required = false) String fechafin, 
                HttpServletResponse response) throws Exception {
                Map<String, Object> params = new HashMap<>();
		params.put("CODIGO", indice.toString());
		params.put("FECHAINICIO", fechainicio);
		params.put("FECHAFIN", fechafin); 
                if(rpt==1)
        	generatePdf("otherreports", "rpt_constanciaservicios", params, download,response);
                else generateWord("otherreports", "rpt_constanciaservicios", params, download,response);
                    
    }
      @RequestMapping("misionesinternas/")
    public String reportemisionesinternas() {
        return PREFIX + "misionesinternasreport";
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
    /* ***************************Para Generar Reporte de Misiones Internas********************* */
    @RequestMapping("/misionInternaxls")
      public ModelAndView misionInternaxls(
              @RequestParam(value="fechainicial",required = false) String fechainicio, 
              @RequestParam(value="fechafinal", required = false) String fechafin
              ){
              List<Object[]> misionInternaList = misionService.findByMisionInterna(fechainicio, fechafin);
              return new ModelAndView(new MisionesInternasView(), "misionInternaList", misionInternaList);
       }
          @RequestMapping("2misionesexternas/")
    public String reporte2misionesexternas() {
        return PREFIX + "2misionesexternasreport";
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
    //************Gernerar Reporte Misiones dos en exel*************************
    @RequestMapping("/misionExt2xls")
       public ModelAndView misionExt2xls(
              @RequestParam(value="fechainicial",required = false) String fechainicio, 
              @RequestParam(value="fechafinal", required = false) String fechafin
              ){
              List<Object[]> misionExt2List = misionService.findByMisionExterna2(fechainicio, fechafin);
              return new ModelAndView(new MisionesExternas2View(), "misionExt2List", misionExt2List);
       }
    
     @RequestMapping(value = "1misionesexternas/{indice}", method = { RequestMethod.POST, RequestMethod.GET })
    public void pdf1misionesexternas(@PathVariable("indice") Long indice, 
            @RequestParam(required = false) Boolean download, 
            @RequestParam(value="fechainicial",required = false) String fechainicio, 
            @RequestParam(value="fechafinal", required = false) String fechafin, 
                HttpServletResponse response) throws Exception {
                Map<String, Object> params = new HashMap<>();
		//params.put("CODIGO", indice.toString());
		params.put("FECHAINICIO", fechainicio);
		params.put("FECHAFIN", fechafin);
        	generatePdf("otherreports", "rpt_misionesexternas1", params, download,response);
    }
    
    //----------Reporte de Misiones externas 1
     @RequestMapping("/misionExt1xls")
       public ModelAndView misionExt1xls(
              @RequestParam(value="fechainicial",required = false) String fechainicio, 
              @RequestParam(value="fechafinal", required = false) String fechafin
              ){
              List<Object[]> misionExt1List = misionService.findByMisionExterna1(fechainicio, fechafin);
              return new ModelAndView(new MisionesExternas1View(), "misionExt1List", misionExt1List);
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
      @RequestMapping("/comitesxls")
       public ModelAndView comitesxls(
              @RequestParam(value="fechainicial",required = false) String fechainicio, 
              @RequestParam(value="fechafinal", required = false) String fechafin,
              @RequestParam(value="codigo",required = false) String codigo){
              List<Object[]> comitesList = comiteService.findByeComitesR(fechainicio, fechafin, codigo);
              return new ModelAndView(new ComitesView(), "comitesList", comitesList);
       }
    /* ****************Report de niveles de Escolaridad en pdf******************************* */
                    @RequestMapping("nivel/")
    public String reportMivelesEscolares() {
        return PREFIX + "nivelesreporte";
    }
    
       @RequestMapping(value = "nivel/{indice}", method = { RequestMethod.POST, RequestMethod.GET })
    public void pdfNivelesEscolares(@PathVariable("indice") Long indice, 
            @RequestParam(required = false) Boolean download, 
            @RequestParam(value="fechainicial",required = false) String fechainicio, 
            @RequestParam(value="fechafinal", required = false) String fechafin, 
     
            HttpServletResponse response) throws Exception {
                Map<String, Object> params = new HashMap<>();
		//params.put("CODIGO", indice.toString());
		params.put("FECHAINICIO", fechainicio);
		params.put("FECHAFIN", fechafin);
        	generatePdf("otherreports", "rpt_nivelesescolares", params, download,response); 
}/* ******************Para Generar Exel de Niveles escolares ************************ */
      @RequestMapping("/nivelesescolarexls")
       public ModelAndView NivelesEscolaresxls(
              @RequestParam(value="fechainicial",required = false) String fechainicio, 
              @RequestParam(value="fechafinal", required = false) String fechafin)
             {
              List<Object[]> nivelesEscolaresList = empleadoService.findByNivelEscolar(fechainicio, fechafin);
              return new ModelAndView(new EscolaridadView(), "nivelesEscolaresList", nivelesEscolaresList);
       } 
    /* ****************Report de plazas ocupadas en pdf******************************* */
                    @RequestMapping("plazasocupadas/")
    public String reportPlazasOcupadas() {
        return PREFIX + "plazaoreporte";
    }
    
       @RequestMapping(value = "plazasocupadas/{indice}", method = { RequestMethod.POST, RequestMethod.GET })
    public void pdfPlazasOcupadas(@PathVariable("indice") Long indice, 
            @RequestParam(required = false) Boolean download, 
            @RequestParam(value="fechainicial",required = false) String fechainicio, 
            @RequestParam(value="fechafinal", required = false) String fechafin, 
     
            HttpServletResponse response) throws Exception {
                Map<String, Object> params = new HashMap<>();
		//params.put("CODIGO", indice.toString());
		params.put("FECHAINICIO", fechainicio);
		params.put("FECHAFIN", fechafin);
        	generatePdf("otherreports", "rpt_plazasocupadas", params, download,response); 
}/* ******************Para Generar Exel de Plazas ocupadas ************************ */
      @RequestMapping("/plazasocupadasxls")
       public ModelAndView plazasocupadasxls(
              @RequestParam(value="fechainicial",required = false) String fechainicio, 
              @RequestParam(value="fechafinal", required = false) String fechafin){
              List<Object[]> plazasocupadasList = empleadoService.findByPlazasOcupadas(fechainicio, fechafin);
              return new ModelAndView(new PlazasOcupadasView(), "plazasocupadasList", plazasocupadasList);
       }
    @RequestMapping("reporte/pensionadoreporte")
    public String reporteestadisticoactivo() {
        return PREFIX + "pensionadoreporte";
    }
    
    @RequestMapping(value = "pensionadospdf/", method = { RequestMethod.POST, RequestMethod.GET })
    public void pdfestadisticoactivo(
//            @PathVariable("indice") Long indice, 
            @RequestParam(required = false) Boolean download, 
            @RequestParam(value="fechainicial",required = false) String fechainicio, 
            @RequestParam(value="fechafinal", required = false) String fechafin, 
                HttpServletResponse response) throws Exception {
                Map<String, Object> params = new HashMap<>();
//		params.put("CODIGO", indice.toString());
//		params.put("FECHAINICIO", fechainicio);
//		params.puta proba man("FECHAFIN", fechafin);
        	generatePdf("otherreports", "rpt_pensionado", params, download,response);
    }

    @RequestMapping("/pensionadosxls")
       public ModelAndView pensionadosxls(
              @RequestParam(value="fechainicial",required = false) String fechainicio, 
              @RequestParam(value="fechafinal", required = false) String fechafin){
              List<Object[]> pensionadosList = empleadoService.findByPensionados(fechainicio, fechafin);
              return new ModelAndView(new PersonalPensionadoView(), "pensionadosList", pensionadosList);
       }
    /* Reporte   de cpuestos a caducar en exel */
           @RequestMapping("puestoscaducar/")
    public String reportepuestoscaducar() {
        return PREFIX + "puestoreporte";
    }
           @RequestMapping(value = "puestoscaducar/{indice}", method = { RequestMethod.POST, RequestMethod.GET })
    public void pdfPuestoCaducar(@PathVariable("indice") Long indice, 
            @RequestParam(required = false) Boolean download, 
            @RequestParam(value="fechainicial",required = false) String fechainicio, 
            @RequestParam(value="fechafinal", required = false) String fechafin, 
     
            HttpServletResponse response) throws Exception {
                Map<String, Object> params = new HashMap<>();
		//params.put("CODIGO", indice.toString());
		params.put("FECHAINICIO", fechainicio);
		params.put("FECHAFIN", fechafin);
        	generatePdf("otherreports", "rpt_puestos", params, download,response); 
}
     @RequestMapping("/puestoscaducasxls")
       public ModelAndView puestoscaducarxls(
//              
              @RequestParam(value="fechainicial",required = false) String fechainicio, 
              @RequestParam(value="fechafinal", required = false) String fechafin){
              List<Object[]> puestosCaducarList = empleadoService.findByPuestosCaducar(fechainicio, fechafin);
              return new ModelAndView(new PuestosCaducarView(), "puestosCaducarList", puestosCaducarList);
       }
        
     @RequestMapping("exoneradoreporte")
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
        	generatePdf("otherreports", "rpt_exonerado", params, download,response);
    }
   
    /* exonerado de marcacion exel */
      @RequestMapping("/exoneradomarcacionxls")
       public ModelAndView exoneradomarcacionxls(
              @RequestParam(value="fechainicial",required = false) String fechainicio, 
              @RequestParam(value="fechafinal", required = false) String fechafin){
              List<Object[]> exoneradoMarcacionLis = empleadoService.findByExoneradoMarcacion(fechainicio, fechafin);
              return new ModelAndView(new ExoneradoMarcacionView(), "exoneradoMarcacionLis", exoneradoMarcacionLis);
       }
     @RequestMapping("nivelesreporte")
//    @RequestMapping("reporte/nivelesreporte")
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
        	generatePdf("otherreports", "rpt_nivelesescolares", params, download,response);
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
    
     @RequestMapping("costocreporte")
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
        	generatePdf("otherreports", "rpt_costocapacitacion", params, download,response);
    }
    
     @RequestMapping("/costosxls")
       public ModelAndView costosxls(
              @RequestParam(value="fechainicial",required = false) String fechainicio, 
              @RequestParam(value="fechafinal", required = false) String fechafin){
              List<Object[]> costoList = capacitacionService.CostoCapacitacionExcel(fechainicio, fechafin);
              return new ModelAndView(new CostoCapView(), "costoList", costoList);
       }
    
      @RequestMapping(value = "capacitadores/{indice}", method = { RequestMethod.POST, RequestMethod.GET })
    public void pdfacapacitadores(@PathVariable("indice") Long indice, 
            @RequestParam(required = false) Boolean download, 
            @RequestParam(value="fechainicial",required = false) String fechainicio, 
            @RequestParam(value="fechafinal", required = false) String fechafin, 
                HttpServletResponse response) throws Exception {
                Map<String, Object> params = new HashMap<>();
		params.put("FECHAINICIO", fechainicio);
		params.put("FECHAFIN", fechafin);
        	generatePdf("otherreports", "rpt_capacitador", params, download,response);
    }
       
       @RequestMapping("/capacitadoresxls")
       public ModelAndView capacitadoresxls(
              @RequestParam(value="fechainicial",required = false) String fechainicio, 
              @RequestParam(value="fechafinal", required = false) String fechafin){
              Iterable <Capacitador> capacitadorsList = capacitadorService.findCapacitadores(fechainicio, fechafin); 
              return new ModelAndView(new CapacitadorView(), "capacitadorList", capacitadorsList);
       }
       @RequestMapping("temasdiagnosticos/")
    public String reportediagnostico() {
        return PREFIX + "diagnosticoreporte";
    }
        @RequestMapping(value = "temasdiagnostico/", method = { RequestMethod.POST, RequestMethod.GET })
    public void pdfdiagnostico(
            @RequestParam(required = false) Boolean download, 
            @RequestParam(value="fechainicial",required = false) String fechainicio, 
            @RequestParam(value="fechafinal", required = false) String fechafin, 
                HttpServletResponse response) throws Exception {
                Map<String, Object> params = new HashMap<>();
		params.put("FECHAINICIO", fechainicio);
		params.put("FECHAFIN", fechafin);
        	generatePdf("otherreports", "rprt_diagnostico", params, download,response);
    }
       
       @RequestMapping("/diagnosticosxls")
       public ModelAndView diagnosticoxls(
              @RequestParam(value="fechainicial",required = false) String fechainicio, 
              @RequestParam(value="fechafinal", required = false) String fechafin){
              Iterable <DiagnosticoCapacitacion> capacitadorsList = diagnosticoService.Diagnosticoexcel(fechainicio, fechafin); 
              return new ModelAndView(new DiagnosticoView(), "diagnosticoList", capacitadorsList);
       }
       
       @RequestMapping("contrataciones/")
    public String reportecontrataciones() {
        return PREFIX + "contratacionesreporte";
    }
        @RequestMapping(value = "contratacion/", method = { RequestMethod.POST, RequestMethod.GET })
    public void pdfcontrataciones(
            @RequestParam(required = false) Boolean download, 
            @RequestParam(value="fechainicial",required = false) String fechainicio, 
            @RequestParam(value="fechafinal", required = false) String fechafin, 
                HttpServletResponse response) throws Exception {
                Map<String, Object> params = new HashMap<>();
		params.put("FECHAINICIO", fechainicio);
		params.put("FECHAFIN", fechafin);
        	generatePdf("otherreports", "rpt_contrataciones", params, download,response);
    }

        @RequestMapping("/contratacionessxls")
       public ModelAndView contratacionesxls(
              @RequestParam(value="fechainicial",required = false) String fechainicio, 
              @RequestParam(value="fechafinal", required = false) String fechafin){
              List<Object[]> contratacionesList = empleadoService.ContratacionesExcel(fechainicio, fechafin);
              return new ModelAndView(new ContratacionesView(), "contratacionesList", contratacionesList);
       }
    
       
        @RequestMapping("despidos/")
    public String reportedespidos() {
        return PREFIX + "despidosreporte";
    }
        @RequestMapping(value = "despidospdf/", method = { RequestMethod.POST, RequestMethod.GET })
    public void pdfdespidos(
            @RequestParam(required = false) Boolean download, 
            @RequestParam(value="fechainicial",required = false) String fechainicio, 
            @RequestParam(value="fechafinal", required = false) String fechafin, 
                HttpServletResponse response) throws Exception {
                Map<String, Object> params = new HashMap<>();
		params.put("FECHAINICIO", fechainicio);
		params.put("FECHAFIN", fechafin);
        	generatePdf("otherreports", "rpt_despidos", params, download,response);
    }

        @RequestMapping("/despidosxls")
       public ModelAndView despidosxls(
              @RequestParam(value="fechainicial",required = false) String fechainicio, 
              @RequestParam(value="fechafinal", required = false) String fechafin){
              List<Object[]> despidosList = empleadoService.DespidosExcel(fechainicio, fechafin);
              return new ModelAndView(new DespidosView(), "despidosList", despidosList);
       }
       
       
        @RequestMapping("estadisticoactivos/")
    public String reporteestadisticoactivos() {
        return PREFIX + "estadisticoactivoreporte";
    }
        @RequestMapping(value = "personalactivopdf/", method = { RequestMethod.POST, RequestMethod.GET })
    public void pdfdestadisticoactivos(
            @RequestParam(required = false) Boolean download, 
            @RequestParam(value="fechainicial",required = false) String fechainicio, 
            @RequestParam(value="fechafinal", required = false) String fechafin, 
                HttpServletResponse response) throws Exception {
                Map<String, Object> params = new HashMap<>();
		params.put("FECHAINICIO", fechainicio);
		params.put("FECHAFIN", fechafin);
        	generatePdf("otherreports", "rpt_estadisticoactivo", params, download,response);
    }

        @RequestMapping("/personalactivoxls")
       public ModelAndView personalactivoxls(
              @RequestParam(value="fechainicial",required = false) String fechainicio, 
              @RequestParam(value="fechafinal", required = false) String fechafin){
              List<Object[]> personalactivoList = empleadoService.PseronalActivoExcel(fechainicio, fechafin);
              return new ModelAndView(new PersonalActivoView(), "personalactivoList", personalactivoList);
       }
       
        @RequestMapping("estadisticocapacitados/")
    public String estadisticocapacitado() {
        return PREFIX + "personalcapacitadoreporte";
    }
        @RequestMapping(value = "capacitadopdf/", method = { RequestMethod.POST, RequestMethod.GET })
    public void pdfdestadisticocapacitados(
            @RequestParam(required = false) Boolean download, 
            @RequestParam(value="fechainicial",required = false) String fechainicio, 
            @RequestParam(value="fechafinal", required = false) String fechafin, 
                HttpServletResponse response) throws Exception {
                Map<String, Object> params = new HashMap<>();
		params.put("FECHAINICIO", fechainicio);
		params.put("FECHAFIN", fechafin);
        	generatePdf("otherreports", "rpt_personalcapacitado", params, download,response);
    }

        @RequestMapping("/capacitadosxls")
       public ModelAndView estadisticocapacitadoxls(
              @RequestParam(value="fechainicial",required = false) String fechainicio, 
              @RequestParam(value="fechafinal", required = false) String fechafin){
              List<Object[]> estadisticocapacitadoList = empleadoService.EstadisticocapacitadoExcel(fechainicio, fechafin);
              return new ModelAndView(new PersonalCapacitadoView(), "estadisticocapacitadoList", estadisticocapacitadoList);
       }
       
  
       
          @RequestMapping("puestoreporte/")
    public String ReportePuesto() {
        return PREFIX + "puestoreporte";
    }
        @RequestMapping(value = "puestospdf/", method = { RequestMethod.POST, RequestMethod.GET })
    public void pdfPuestosacaducar(
            @RequestParam(required = false) Boolean download, 
            @RequestParam(value="fechainicial",required = false) String fechainicio, 
            @RequestParam(value="fechafinal", required = false) String fechafin, 
                HttpServletResponse response) throws Exception {
                Map<String, Object> params = new HashMap<>();
		params.put("FECHAINICIO", fechainicio);
		params.put("FECHAFIN", fechafin);
        	generatePdf("otherreports", "rpt_puestos", params, download,response);
    }
    
    @RequestMapping("/puestosxls")
       public ModelAndView puestosxls(
              @RequestParam(value="fechainicial",required = false) String fechainicio, 
              @RequestParam(value="fechafinal", required = false) String fechafin){
              List<Object[]> puestoList = puestoService.PuestosoExcel(fechainicio, fechafin);
              return new ModelAndView(new PuestosView(), "puestoList", puestoList);
       }
       
       @RequestMapping("indemnizados/")
    public String Reporteindemnizados() {
        return PREFIX + "indemnizadosreporte";
    }
        @RequestMapping(value = "indemnizadospdf/", method = { RequestMethod.POST, RequestMethod.GET })
    public void pdfindemnizados(
            @RequestParam(required = false) Boolean download, 
            @RequestParam(value="fechainicial",required = false) String fechainicio, 
            @RequestParam(value="fechafinal", required = false) String fechafin, 
                HttpServletResponse response) throws Exception {
                Map<String, Object> params = new HashMap<>();
		params.put("FECHAINICIO", fechainicio);
		params.put("FECHAFIN", fechafin);
        	generatePdf("otherreports", "rpt_indemnizado", params, download,response);
    }
    
    @RequestMapping("/indemnizadosxls")
       public ModelAndView indemnizadosxls(
              @RequestParam(value="fechainicial",required = false) String fechainicio, 
              @RequestParam(value="fechafinal", required = false) String fechafin){
              List<Object[]> IndemnizadoList = empleadoService.PersonalIndemnizadooExcel(fechainicio, fechafin);
              return new ModelAndView(new PersonalIndemnizadoView(), "IndemnizadoList", IndemnizadoList);
       }
       
  
    
     @RequestMapping("evaluacioncap/")
    public String Reporteevaluacioncap(Model model) {
        model.addAttribute("evcapacitaciones", capacitacionService.listAllCapacitacion());
        return PREFIX + "evaluacioncapreporte";
    }

     @RequestMapping(value = "evacapacitaciones/{indice}", method = { RequestMethod.POST, RequestMethod.GET })
    public void pdfevacapacitaciones(@PathVariable("indice") Long indice, 
            @RequestParam(required = false) Boolean download, 
            @RequestParam(value="fechainicial",required = false) String fechainicio, 
            @RequestParam(value="fechafinal", required = false) String fechafin, 
                HttpServletResponse response) throws Exception {
                Map<String, Object> params = new HashMap<>();
		params.put("CODIGO", indice.toString());
		params.put("FECHAINICIO", fechainicio);
		params.put("FECHAFIN", fechafin);
        	generatePdf("otherreports", "rpt_ecapacitaciones", params, download,response);
    } 
    // ................... Para generar el reporte en excel de capacitaciones............
      @RequestMapping("/evacapacitacionesxls")
       public ModelAndView evacapacitacionesxls(
              @RequestParam(value="fechainicial",required = false) String fechainicio, 
              @RequestParam(value="fechafinal", required = false) String fechafin,
              @RequestParam(value="codigo",required = false) String codigo){
              List<Object[]> evacapacitacionesList = capacitacionService.EvaluacionCapacitacionesExcel(fechainicio, fechafin, codigo);
              return new ModelAndView((View) new EvaCapacitacionesView(), "evacapacitacionesList", evacapacitacionesList);
       }
    
       
}
