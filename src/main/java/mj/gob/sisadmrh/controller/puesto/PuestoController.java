package mj.gob.sisadmrh.controller.puesto;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import mj.gob.sisadmrh.model.Puesto;
import mj.gob.sisadmrh.repository.PuestoRepository;
import mj.gob.sisadmrh.service.PuestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import mj.gob.sisadmrh.controller.UtilsController;

/**
 *
 * @author dialv
 * 
 */
@Controller
@RequestMapping(value = "puestos")
public class PuestoController extends UtilsController{
    
    private PuestoService puestoService;
    
    @Autowired
    public void setPuestoService(PuestoService puestoService) {
        this.puestoService = puestoService;
    }
    
    private final String PREFIX = "fragments/puesto/";
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("puestos", puestoService.listAllPuestos());
        return PREFIX + "puestos";
    }
    
    @RequestMapping("edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("puesto", puestoService.getPuestoById(id));
        return PREFIX + "puestoform";
    }

    @RequestMapping("new/puesto")
    public String newPuesto(Model model) {
        model.addAttribute("puesto", new Puesto());
        return PREFIX + "puestoform";
    }

    @RequestMapping(value = "puesto")
    public String savePuesto(Puesto puesto,Model model) {
        try{
        puestoService.savePuesto(puesto);
       
          model.addAttribute("msg", 0);
        }
        catch(Exception e){
         model.addAttribute("msg", 1);
        }
       return PREFIX+"puestoform";
//        return "redirect:./show/" + puesto.getCodigopuesto();
    }
    
    @RequestMapping("show/{id}")
    public String showPuesto(@PathVariable Integer id, Model model) {
        model.addAttribute("puesto", puestoService.getPuestoById(id).get());
        return PREFIX +"puestoshow";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable Integer id,Model model) {
        try{
            puestoService.deletePuesto(id);
          model.addAttribute("msg", 3);
        }
        catch(Exception e){
         model.addAttribute("msg", 4);
        }
//        return "redirect:/puestos/";
         return PREFIX + "puestos";
    }
    
    @RequestMapping("reporte/puesto")
    public String newReportePuesto(Model model) {
        model.addAttribute("puesto", new Puesto());
        return PREFIX + "puestoreporte";
    }
    
// @RequestMapping("report/")
//    public String reporte() {
//        return PREFIX + "puestoreporte";
//    }
    
//    @RequestMapping(value = "pdf/{indice}", method = { RequestMethod.POST, RequestMethod.GET })
//    public void pdf(@PathVariable("indice") Long indice, @RequestParam(required = false) Boolean download, 
//                HttpServletResponse response) throws Exception {
//                Map<String, Object> params = new HashMap<>();
//		params.put("P_param1", indice.toString());
//        	generatePdf("puestos", "rpt_puestos", params, download,response);
//    }
    
     @RequestMapping(value = "/pdf/", method = { RequestMethod.POST, RequestMethod.GET })
    public void pdf( 
            @RequestParam(required = false) Boolean download, 
            @RequestParam(value="fechacontrataciondesde",required = false) String fechainicio, 
            @RequestParam(value="fechacontratacionhasta", required = false) String fechafin, 
                HttpServletResponse response) throws Exception {
                Map<String, Object> params = new HashMap<>();
//		params.put("CODIGO", indice.toString());
		params.put("FECHAINICIO", fechainicio);
		params.put("FECHAFIN", fechafin);
        	generatePdf("puestos", "rpt_puestos", params, download,response);
    }
}
