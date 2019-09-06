/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.controller.otherreport;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsView;

/**
 *
 * @author jorge
 */

public class CostoCapView extends AbstractXlsView{
@Override
 protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
 HttpServletResponse response) throws Exception {
 
// response.setHeader("Content-Disposition", "<span id="IL_AD8" class="IL_AD">attachment</span>;filename=\"student.xls\"");    
 response.setHeader("Content-Disposition", "attachment; filename=\"Reporte_de_CostoCap.xls\"");
        
 List<Object[]> costoList = (List<Object[]>) model.get("costoList");
 Sheet sheet = workbook.createSheet("Data Personal Activo");
 sheet.createRow(0).createCell(3).setCellValue("");
  sheet.createRow(1).createCell(4).setCellValue("REPORTE DE COSTO DE CAPACITACIONES");
 Row header = sheet.createRow(2);

 header.createCell(2).setCellValue("Nº Personas");
 header.createCell(3).setCellValue("Tema");
 header.createCell(4).setCellValue("Costo por Persona ($)");
  header.createCell(5).setCellValue("Costo Total ($)");
  
 int rowNum = 3;
 for(Object[] List : costoList){
 Row row = sheet.createRow(rowNum++);
 

 row.createCell(2).setCellValue((String) ""+List[0]);
 row.createCell(3).setCellValue((String) ""+List[1]);
 row.createCell(4).setCellValue((String) ""+List[2]);
  row.createCell(5).setCellValue((String) ""+List[3]);
 
 }
 }
  

}
