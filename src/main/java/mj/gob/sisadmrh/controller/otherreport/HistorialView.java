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
import mj.gob.sisadmrh.pojos.AbogadosPojo;
 
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;


/**
 *
 * @author root
 */
public class HistorialView extends AbstractXlsView{
 
 @Override
 protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
 HttpServletResponse response) throws Exception {
 
// response.setHeader("Content-Disposition", "<span id="IL_AD8" class="IL_AD">attachment</span>;filename=\"student.xls\"");    
 response.setHeader("Content-Disposition", "attachment; filename=\"Reporte_de_abogados.xls\"");
        
  List<Object[]>  historialList = ( List<Object[]>)  model.get("historialList");
Sheet sheet = workbook.createSheet("Reporte de Historial Laboral de Empleados");
 sheet.createRow(1).createCell(5).setCellValue("Reporte de Historial Laboral de Empleados");
 Row header = sheet.createRow(2);
 
 header.createCell(3).setCellValue("Empleado");
 header.createCell(4).setCellValue("Puesto");
 header.createCell(5).setCellValue("Sueldo Inicial ($)");
  header.createCell(6).setCellValue("Sueldo Final ($)");
   header.createCell(7).setCellValue("Fecha de Contratación");
   header.createCell(8).setCellValue("Fecha de Finalización");
  
 int rowNum = 3;
 for(Object[] historial:historialList){
 Row row = sheet.createRow(rowNum++);
 row.createCell(3).setCellValue(((String) historial[1]));
 row.createCell(4).setCellValue(((String) historial[2]));
 row.createCell(5).setCellValue(((Float) historial[3]));
 row.createCell(6).setCellValue(((Float) historial[4]));
 row.createCell(7).setCellValue(((String) historial[5]));
 row.createCell(8).setCellValue(((String) historial[6]));
 }
 }
}