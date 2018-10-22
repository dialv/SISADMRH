/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.controller.otherreport;

import java.util.List;
import java.util.Map;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mj.gob.sisadmrh.model.Empleado;
 
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;


/**
 *
 * @author root
 */
public class HijoscapView extends AbstractXlsView{
 
 @Override
 protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
 HttpServletResponse response) throws Exception {
 
// response.setHeader("Content-Disposition", "<span id="IL_AD8" class="IL_AD">attachment</span>;filename=\"student.xls\"");    
 response.setHeader("Content-Disposition", "attachment; filename=\"Reporte_de_hijos_cap_esp.xls\"");
 List<Object[]> hijoscapList = (List<Object[]>) model.get("hijoscapList");
 Sheet sheet = workbook.createSheet("Reporte de hijos con capacidades especiales");
 sheet.createRow(1).createCell(3).setCellValue("REPORTE DE HIJOS CON CAPACIDADES ESPECIALES");
 Row header = sheet.createRow(2);

 header.createCell(2).setCellValue("Codigo de Empleado");
 header.createCell(3).setCellValue("Nombre de Empleado");
 header.createCell(4).setCellValue("Tipo de discapacidad");
 header.createCell(5).setCellValue("Nombre de hijo con discapacidad");
  
 int rowNum = 3;
 for(Object[] hijoscap :hijoscapList){
 Row row = sheet.createRow(rowNum++);
 row.createCell(2).setCellValue((double) hijoscap[0]);
 row.createCell(3).setCellValue((String) hijoscap[1]);
 row.createCell(4).setCellValue((String) hijoscap[2]);
 row.createCell(5).setCellValue((String) hijoscap[3]);
 }
 }
}
