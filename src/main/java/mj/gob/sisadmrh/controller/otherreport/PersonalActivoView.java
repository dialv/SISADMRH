/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.controller.otherreport;

import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsView;

/**
 *
 * @author jorge
 */

public class PersonalActivoView extends AbstractXlsView{
@Override
 protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
 HttpServletResponse response) throws Exception {
 
// response.setHeader("Content-Disposition", "<span id="IL_AD8" class="IL_AD">attachment</span>;filename=\"student.xls\"");    
 response.setHeader("Content-Disposition", "attachment; filename=\"Reporte_de_PersonalActivo.xls\"");
        
 List<Object[]> personalactivoList = (List<Object[]>) model.get("personalactivoList");
 Sheet sheet = workbook.createSheet("Data Personal Activo");
 sheet.createRow(0).createCell(3).setCellValue("");
  sheet.createRow(1).createCell(4).setCellValue("REPORTE DE PERSONAL ACTIVO");
 Row header = sheet.createRow(2);

 header.createCell(2).setCellValue("No de Empleados");
 header.createCell(3).setCellValue("Ubicacion");
 header.createCell(4).setCellValue("Suma de Salarios");
  
 int rowNum = 3;
 for(Object[] List : personalactivoList){
 Row row = sheet.createRow(rowNum++);
 

 row.createCell(2).setCellValue((String) "" +List[0]);
 row.createCell(3).setCellValue((String) List[2]);
 row.createCell(4).setCellValue((String) "" + List[1]);
 
 }
 }
  

}
