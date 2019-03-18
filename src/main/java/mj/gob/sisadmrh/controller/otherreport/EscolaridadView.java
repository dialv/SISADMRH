/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.controller.otherreport;

import java.sql.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

/**
 *
 * @author jorge
 */
public class EscolaridadView  extends AbstractXlsView{

   protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
 HttpServletResponse response) throws Exception {
 
// response.setHeader("Content-Disposition", "<span id="IL_AD8" class="IL_AD">attachment</span>;filename=\"student.xls\"");    
 response.setHeader("Content-Disposition", "attachment; filename=\"Reporte_de_Niveles_Escolares.xls\"");
        
 List<Object[]> nivelesEscolaresList = (List<Object[]>) model.get("nivelesEscolaresList");
 Sheet sheet = workbook.createSheet("Reporte de Niveles Escolares");
 sheet.createRow(0).createCell(3).setCellValue("");
sheet.createRow(1).createCell(5).setCellValue("REPORTE DE NIVELES ESCOLARES");
 Row header = sheet.createRow(2);
 header.createCell(2).setCellValue("Nombre de empleado");
 header.createCell(3).setCellValue("Nombre Puesto");
 header.createCell(4).setCellValue("Nivel Escolar");
 header.createCell(5).setCellValue("Estudios Realizados");
 header.createCell(6).setCellValue("Fecha Desde");
 header.createCell(7).setCellValue("Fecha Hasta");
 header.createCell(8).setCellValue("Institucion Educativa");
;
  
 int rowNum = 3;
 for(Object[] escolares : nivelesEscolaresList){
 Row row = sheet.createRow(rowNum++);
 row.createCell(2).setCellValue((String) ""+escolares[0]);
 row.createCell(3).setCellValue((String) ""+escolares[1]);
 row.createCell(4).setCellValue((String) ""+escolares[2]);
  row.createCell(5).setCellValue((String) ""+escolares[3]);
   row.createCell(6).setCellValue((String) ""+escolares[4]);
 row.createCell(7).setCellValue((String) ""+escolares[5]);
 row.createCell(8).setCellValue((String) ""+escolares[6]);

 }
 }
    
    
}
