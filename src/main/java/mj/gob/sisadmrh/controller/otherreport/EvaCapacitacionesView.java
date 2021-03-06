/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.controller.otherreport;

import java.sql.Timestamp;
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
@Component("fragments/evacapacitacionesxls.xlsx")
public class EvaCapacitacionesView  extends AbstractXlsView{
     @Override
 protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
 HttpServletResponse response) throws Exception {
 
// response.setHeader("Content-Disposition", "<span id="IL_AD8" class="IL_AD">attachment</span>;filename=\"student.xls\"");    
 response.setHeader("Content-Disposition", "attachment; filename=\"Reporte_de_evacapacitaciones.xls\"");
        
  List<Object[]> evacapacitacionesList = (List<Object[]>) model.get("evacapacitacionesList");
 Sheet sheet = workbook.createSheet("Comites Data");
 sheet.createRow(1).createCell(3).setCellValue("REPORTE DE EVALUACION DE CAPACITACIONES");
 Row header = sheet.createRow(2);
header.createCell(2).setCellValue("Tema de Capacitacion");
header.createCell(3).setCellValue("Facilitador");
header.createCell(4).setCellValue("Lugar de Capacitacion");
 header.createCell(5).setCellValue("Fecha");
header.createCell(6).setCellValue("Hora");
header.createCell(7).setCellValue("Dominio del Tema");
 header.createCell(8).setCellValue("Habilidad de comunicarse");
 header.createCell(9).setCellValue("El conferencista lleno sus espectativas");
 header.createCell(10).setCellValue("Contenido desarrollado con claridad");
 header.createCell(11).setCellValue("se cubrio el material de manera efectiva");
 header.createCell(12).setCellValue("Aclaro sus dudas");
header.createCell(13).setCellValue("Mantuvo su interes durante el desarrollo del tema");
header.createCell(14).setCellValue("Satisfecho con el exponeente");
//header.createCell(14).setCellValue("El tema respondio sus intereses");
header.createCell(15).setCellValue("Comprension del tema");
header.createCell(16).setCellValue("Contenido se expuso clramente");
header.createCell(17).setCellValue("Es aplicable a su area de trabajo");
header.createCell(18).setCellValue("Satisfecho con el contenido");
  
   
 int rowNum = 3;

  for(Object[] evacapacitaciones : evacapacitacionesList){
 Row row = sheet.createRow(rowNum++);
 row.createCell(2).setCellValue((String) ""+evacapacitaciones[0]);
 row.createCell(3).setCellValue((String) ""+evacapacitaciones[1]);
 row.createCell(4).setCellValue((String) ""+evacapacitaciones[2]);
 row.createCell(5).setCellValue((String) ""+evacapacitaciones[3]);
 row.createCell(6).setCellValue((String) ""+evacapacitaciones[4]);
 row.createCell(7).setCellValue((String) ""+evacapacitaciones[5]);
 row.createCell(8).setCellValue((String) ""+evacapacitaciones[6]);
 row.createCell(9).setCellValue((String) ""+evacapacitaciones[7]);
  row.createCell(10).setCellValue((String) ""+evacapacitaciones[8]);
 row.createCell(11).setCellValue((String) ""+evacapacitaciones[9]);
 row.createCell(12).setCellValue((String) ""+evacapacitaciones[10]);
 row.createCell(13).setCellValue((String) ""+evacapacitaciones[11]);
 row.createCell(14).setCellValue((String) ""+evacapacitaciones[12]);
 row.createCell(15).setCellValue((String) ""+evacapacitaciones[13]);
  row.createCell(16).setCellValue((String) ""+evacapacitaciones[14]);
 row.createCell(17).setCellValue((String) ""+evacapacitaciones[15]);
 row.createCell(18).setCellValue((String) ""+evacapacitaciones[16]);
// row.createCell(19).setCellValue((String) ""+evacapacitaciones[17]);
 }

    
}
}
