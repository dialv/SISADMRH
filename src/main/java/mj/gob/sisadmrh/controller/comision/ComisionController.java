package mj.gob.sisadmrh.controller.comision;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import mj.gob.sisadmrh.controller.UtilsController;
import mj.gob.sisadmrh.model.Comision;
import mj.gob.sisadmrh.service.ComisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author dialv
 * 
 */
@Controller
@RequestMapping(value = "comisiones")
public class ComisionController extends UtilsController{
    
    private ComisionService comisionService;
    @Autowired
    public void setComisionService(ComisionService comisionService) {
        this.comisionService = comisionService;
    }
    private final String PREFIX = "fragments/comision/";
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("comisiones", comisionService.listAllActivos());
        return PREFIX + "comisiones";
    }
    
    @RequestMapping("edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("comision", comisionService.getComisionById(id));
        return PREFIX + "comisionform";
    }

    @RequestMapping("new/comision")
    public String newComision(Model model) {
        model.addAttribute("comision", new Comision());
        return PREFIX + "comisionform";
    }

     @RequestMapping(value = "/descarga/{id}")
    public void verDocumento(HttpServletResponse response, @PathVariable(value = "id") Integer id) 
           throws IOException{ 
           streamReport(response, comisionService.getComisionById(id).get().getDocaprovacion(), "acuerdo.pdf");
    }

    
    @RequestMapping(value = "comision" )
    public String saveComision(Comision comision,Model model, @RequestParam("file") MultipartFile file) {
        try{
        comision.setDocaprovacion(file.getBytes());
        comisionService.saveComision(comision);
        
        model.addAttribute("msg", 0);
        model.addAttribute("comisiones", comisionService.listAllActivos());
        return PREFIX+"comisiones";
        }
        catch(Exception e){
          model.addAttribute("msg", 1);
        }
         return PREFIX+"comisionform";
       // return "redirect:./show/" + comision.getCodigocomision();
    }
    
    @RequestMapping("show/{id}")
    public String showComision(@PathVariable Integer id, Model model) {
        model.addAttribute("comision", comisionService.getComisionById(id).get());
        return PREFIX +"comisionshow";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable Integer id,Model model) {
        try{
            Comision comision = comisionService.getComisionById(id).get();
            comision.setEstadocomision(0);
        comisionService.saveComision(comision);
         model.addAttribute("msg", 3);
        }
        catch(Exception e){
        model.addAttribute("msg", 4);
         
        }
         return PREFIX + "comisiones";
        //return "redirect:/comisiones/";
    }
    
    @RequestMapping("report/")
    public String reporte() {
        return PREFIX + "comisionesreport";
    }
    
    @RequestMapping(value = "pdf/{indice}", method = { RequestMethod.POST, RequestMethod.GET })
    public void pdf(@PathVariable("indice") Long indice, 
            @RequestParam(required = false) Boolean download, 
            @RequestParam(value="fechainicial",required = false) String fechainicio, 
            @RequestParam(value="fechafinal", required = false) String fechafin, 
                HttpServletResponse response) throws Exception {
                Map<String, Object> params = new HashMap<>();
		params.put("CODIGO", indice.toString());
		params.put("FECHAINICIO", fechainicio);
		params.put("FECHAFIN", fechafin);
        	generatePdf("comisiones", "rpt_comisiones", params, download,response);
    }

    
}
