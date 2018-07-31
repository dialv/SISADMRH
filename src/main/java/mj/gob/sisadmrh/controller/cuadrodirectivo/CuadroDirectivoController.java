/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.controller.cuadrodirectivo;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import mj.gob.sisadmrh.controller.UtilsController;
import mj.gob.sisadmrh.model.Beneficio;
import mj.gob.sisadmrh.model.Capacitacion;
import mj.gob.sisadmrh.model.CuadroDirectivo;
import mj.gob.sisadmrh.model.Empleado;
import mj.gob.sisadmrh.service.BeneficioService;
import mj.gob.sisadmrh.service.CapacitacionService;
import mj.gob.sisadmrh.service.CuadroDirectivoService;
import mj.gob.sisadmrh.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

@RequestMapping(value = "cuadrodirectivos")
public class CuadroDirectivoController extends UtilsController{
    private CuadroDirectivoService cuadroDirectivoService;
    @Autowired
    public void setCuadroDirectivoService (CuadroDirectivoService cuadroDirectivoService) {
        this.cuadroDirectivoService = cuadroDirectivoService;
    }
   
    
     private EmpleadoService empleadoService;
    @Autowired
    public void setEmpleadoService (EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }
    
    private final String PREFIX = "fragments/cuadrodirectivo/";
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("cuadrodirectivos", cuadroDirectivoService.listAllCuadroDirectivo());
        return PREFIX + "cuadrodirectivos";
    }
    
    @RequestMapping("edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("cuadrodirectivo", cuadroDirectivoService.getCuadroDirectivoById(id));
        return PREFIX + "cuadrodirectivoform";
    }

    @RequestMapping("new/cuadrodirectivo")
    public String newCuadroDirectivo(Model model) {
        model.addAttribute("cuadrodirectivo", new CuadroDirectivo());
        Iterable<Empleado> empleados = empleadoService.listAllEmpleado();
//         
      model.addAttribute("empleados", empleados);
        return PREFIX + "cuadrodirectivoform";
    }

    @RequestMapping(value = "cuadrodirectivo")//El erorr que te daba era puta el jasPer dice que recibire un int y vos me man
    public String saveCuadroDirectivo(CuadroDirectivo cuadroDirectivo,Model model) {
        try{
         cuadroDirectivoService.saveCuadroDirectivo(cuadroDirectivo);
         model.addAttribute("msg", 0);
        }
        catch(Exception e){
        model.addAttribute("msg", 1);
        }
        //return PREFIX + "cuadrodirectivoform";
        return "redirect:/cuadrodirectivos/";  
  
    // return "redirect:./show/" + cuadroDirectivo.getCodigocuadrodirectivo();
    }
    
    @RequestMapping("show/{id}")
    public String showCuadroDirectivo(@PathVariable Integer id, Model model) {
        model.addAttribute("cuadrodirectivo", cuadroDirectivoService.getCuadroDirectivoById(id).get());
        return PREFIX +"cuadrodirectivoshow";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        try{
         cuadroDirectivoService.deleteCuadroDirectivo(id);
          model.addAttribute("msg", 3);
        }
        catch(Exception e){
         model.addAttribute("msg", 4);
        }
      // return "redirect:/estados/";
        return "redirect:/cuadrodirectivos/";
    }
    

    @RequestMapping("report/")
    public String reporte() {
        return PREFIX + "cuadrodirectivosreport";
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
        	generatePdf("cuadrodirectivos", "rpt_cuadrodirectivos", params, download,response);
    }

    
}
