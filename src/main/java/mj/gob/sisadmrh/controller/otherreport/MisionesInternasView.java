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
 Sheet sheet = workbook.createSheet("Mision interna");
 sheet.createRow(1).createCell(4).setCellValue("REPORTE DE MISIONES INTERAS");
 Row header = sheet.createRow(2);
 header.createCell(3).setCellValue("Nombre de empleado");
 header.createCell(4).setCellValue("Nombre de puesto");
 header.createCell(5).setCellValue("Nombre Mision");
 header.createCell(6).setCellValue("Objetivo de Mision");
 header.createCell(7).setCellValue("Instirucion o departamento");
 header.createCell(8).setCellValue("Fecha");

;
  
 int rowNum = 3;
 for(Object[] misiones : misionInternaList){
 Row row = sheet.createRow(rowNum++);
 row.createCell(3).setCellValue((String) misiones[0]);
 row.createCell(4).setCellValue((String) misiones[1]);
 row.createCell(5).setCellValue((String) misiones[2]);
 row.createCell(6).setCellValue((String) misiones[3]);
 row.createCell(7).setCellValue((Date) misiones[4]);
 row.createCell(8).setCellValue((Date) misiones[5]);
 

 }
 }
    
}
