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

public class BeneficioView extends AbstractXlsView{
@Override
 protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
 HttpServletResponse response) throws Exception {
 
// response.setHeader("Content-Disposition", "<span id="IL_AD8" class="IL_AD">attachment</span>;filename=\"student.xls\"");    
 response.setHeader("Content-Disposition", "attachment; filename=\"Reporte_de_beneficios.xls\"");
        
 List<Object[]> costoList = (List<Object[]>) model.get("beneList");
 Sheet sheet = workbook.createSheet("Data Personal Activo");
 sheet.createRow(0).createCell(3).setCellValue("");
  sheet.createRow(1).createCell(4).setCellValue("REPORTE DE BENEFICIOS DE EMPLEADO");
 Row header = sheet.createRow(2);

 header.createCell(2).setCellValue("Codigo de Beneficio");
 header.createCell(3).setCellValue("Nombre de Beneficio");
  header.createCell(4).setCellValue("Nombre de Empleado");
 header.createCell(5).setCellValue("Sexo del Empleado");
  header.createCell(6).setCellValue("Descripcion del Beneficio");
  
 int rowNum = 3;
 for(Object[] List : costoList){
 Row row = sheet.createRow(rowNum++);
 

 row.createCell(2).setCellValue((String) ""+List[0]);
 row.createCell(3).setCellValue((String) ""+List[1]);
 row.createCell(4).setCellValue((String) ""+List[2]);
  row.createCell(5).setCellValue((String) ""+List[3]);
  row.createCell(6).setCellValue((String) ""+List[4]);
 
 }
 }
  

}
