package mj.gob.sisadmrh.controller.archivos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import mj.gob.sisadmrh.controller.UtilsController;
import mj.gob.sisadmrh.model.Empleado;
import mj.gob.sisadmrh.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
/**
 *
 * @author victor.alvarado
 */
@Controller
@RequestMapping(value = "archivos")
public class ArchivosController extends UtilsController{
     @Autowired
    private EmpleadoService empleadoService;
         private final String PREFIX = "fragments/archivo/";
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String list(){
        return PREFIX + "archivoform";
    }
  @RequestMapping(value = {"/upload"}, method = {RequestMethod.POST})
	public String arcvhivosubir(MultipartHttpServletRequest request, Model model,
			@RequestParam(value = "archivo", required = false) MultipartFile file) throws Exception {
		BufferedReader br= null;
                InputStream is = null;
                ArrayList<Empleado> listDocumentos = new ArrayList<>();
            try {
                String line;
                int i = 1;
                is = file.getInputStream();
                br = new BufferedReader(new InputStreamReader(is));
                while ((line = br.readLine()) != null) {
                    if(i!=1){
                    Empleado documento = new Empleado();
                    String[] parts = line.split(";");
                    // llenado del empleado 
                    documento.setAfiliacionpension(parts[0]);
                    documento.setApellidoempleado(parts[1]);
                    documento.setDepartamentonacimiento(parts[2]);
                    documento.setDepartamentorecidencia(parts[3]);
                    documento.setDuiempleado(parts[4]);
                    documento.setEmailempleado(parts[5]);
                    documento.setEstadoempleado(Integer.parseInt(parts[6]));
                    documento.setEstadofamiliar(parts[7]);
                    documento.setFechaingresoministerio(sqlfecha(parts[8]));
                    documento.setFechaingresosecpriv(sqlfecha(parts[9]));
                    documento.setFechaingresosecpub(sqlfecha(parts[10]));
                    documento.setFechanacimientoempleado(sqlfecha(parts[11]));
                    documento.setGruposanquineo(parts[12]);
                    documento.setIsssempleado(parts[13]);
                    documento.setMunicipionacimiento(parts[14]);
                    documento.setMunicipioresidencia(parts[15]);
                    documento.setNacionalidad(parts[16]);
                    documento.setNitempleador(parts[17]);
                    documento.setNombreempleado(parts[18]);
                    documento.setNombreinstiuciondepositar(parts[19]);
                    documento.setNumeroafiliacion(parts[20]);
                    documento.setRecidenciapermanente(parts[21]);
                    documento.setSexoempleado(parts[22]);
                    documento.setTelefonofijoempleado(parts[23]);
                    documento.setTelefonomovilempleado(parts[24]);
                    documento.setTipocuenta(parts[25]);
                    documento.setTiponacionalidad(parts[26]);
                    listDocumentos.add(documento);
                    }
                    i++;
                }
                listDocumentos.forEach((emp) -> {
                    try{
                    empleadoService.saveEmpleado(emp);
                    bitacoraService.BitacoraRegistry("se guardo un archivo",getRequest().getRemoteAddr(), 
                        getRequest().getUserPrincipal().getName());//COBTROLARA EVENTO DE LA BITACORA
                    model.addAttribute("msg", 2);
                    }
                    catch(Exception e){
                    model.addAttribute("msg", 4);
                    }
                    });
                
            } catch (IOException | NumberFormatException | ParseException e) {
                model.addAttribute("msg", 3);
            } finally {
                if (br != null) {
                    br.close();
                }
                if (is != null) {
                    is.close();
                }
            }
        return PREFIX + "archivoform";
	}
        
    private Date sqlfecha(String fecha) throws ParseException {
        SimpleDateFormat sdf1 = new SimpleDateFormat("MM-dd-yyyy");
        java.util.Date date = sdf1.parse(fecha);
        java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
        return sqlStartDate;
    } 
}
