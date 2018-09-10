/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.controller.archivos;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mj.gob.sisadmrh.controller.UtilsController;
import mj.gob.sisadmrh.model.Empleado;
import mj.gob.sisadmrh.service.EmpleadoService;
import static org.hibernate.annotations.common.util.impl.LoggerFactory.logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
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
  @RequestMapping(value = {"/upload"}, method = {RequestMethod.POST})
	public @ResponseBody ResponseEntity<?> f07ajax(MultipartHttpServletRequest request, 
			SessionStatus session, HttpServletResponse response,
			@RequestParam(value = "archivo", required = false) MultipartFile file) throws Exception {
		BufferedReader br= null;
                InputStream is = null;
                ArrayList<Empleado> listDocumentos = new ArrayList<>();
            try {
                List<String> result = new ArrayList<>();

                String line;
                int i = 1;
                is = file.getInputStream();
                br = new BufferedReader(new InputStreamReader(is));

                while ((line = br.readLine()) != null) {
                    Empleado documento = new Empleado();
                    result.add(line);
                    String[] parts = line.split(";");
                    // if(validadorLinea(parts)){
                    // llenado del empleado 
                    listDocumentos.add(documento);
                    i++;
                }

                // if(!listDocumentos.isEmpty()) {
                // f07.setDocsFromFile(listDocumentos);
                // }
            } catch (Exception e) {
                e.printStackTrace();
                              
            } finally {
                if (br != null) {
                    br.close();
                }
                if (is != null) {
                    is.close();
                }
            }

		// String content = new String(file.getBytes());

		request.getSession().setAttribute("listDocumentos", listDocumentos);
		return new ResponseEntity<>(listDocumentos, HttpStatus.OK);
	}
    
    
}
