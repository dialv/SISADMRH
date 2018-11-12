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
public class MisionesInternasView extends AbstractXlsView{
    

   protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
 HttpServletResponse response) throws Exception {
 
// response.setHeader("Content-Disposition", "<span id="IL_AD8" class="IL_AD">attachment</span>;filename=\"student.xls\"");    
 response.setHeader("Content-Disposition", "attachment; filename=\"Reporte_de_Internas.xls\"");
        
 List<Object[]> misionInternaList = (List<Object[]>) model.get("misionInternaList");
 Sheet sheet = workbook.createSheet("Reporte de Misiones Internas");
 Row header = sheet.createRow(0);
 header.createCell(0).setCellValue("Nombre de empleado");
 header.createCell(1).setCellValue("Nombre de puesto");
 header.createCell(2).setCellValue("Nombre Mision");
 header.createCell(3).setCellValue("Objetivo de Mision");
 header.createCell(4).setCellValue("Instirucion o departamento");
 header.createCell(5).setCellValue("Fecha");

;
  
 int rowNum = 1;
 for(Object[] misiones : misionInternaList){
 Row row = sheet.createRow(rowNum++);
 row.createCell(0).setCellValue((String) misiones[0]);
 row.createCell(1).setCellValue((String) misiones[1]);
 row.createCell(2).setCellValue((String) misiones[2]);
 row.createCell(3).setCellValue((String) misiones[3]);
 row.createCell(4).setCellValue((Date) misiones[4]);
 row.createCell(5).setCellValue((Date) misiones[5]);
 

 }
 }
    
}
