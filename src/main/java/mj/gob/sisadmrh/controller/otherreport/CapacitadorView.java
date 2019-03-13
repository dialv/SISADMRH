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
import mj.gob.sisadmrh.model.Capacitador;
import mj.gob.sisadmrh.pojos.CapacitadorPojo;
 
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;


/**
 *
 * @author root
 */
public class CapacitadorView extends AbstractXlsView{
 
 @Override
 protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
 HttpServletResponse response) throws Exception {
 
// response.setHeader("Content-Disposition", "<span id="IL_AD8" class="IL_AD">attachment</span>;filename=\"student.xls\"");    
 response.setHeader("Content-Disposition", "attachment; filename=\"Reporte_de_capacitadores.xls\"");
        
 List<Object[]> capacitadorList = (List<Object[]>) model.get("capacitadorList");
 Sheet sheet = workbook.createSheet("Capacitador Data");
  sheet.createRow(0).createCell(3).setCellValue("");
  sheet.createRow(1).createCell(4).setCellValue("REPORTE DE CAPACITADORES");
 Row header = sheet.createRow(2);
 header.createCell(2).setCellValue("Nombre de Capacitador");
 header.createCell(3).setCellValue("Tipo Capacitador");
 header.createCell(4).setCellValue("Telefono movil");
  header.createCell(5).setCellValue("Email");
   header.createCell(6).setCellValue("Temas de Dominio");
  
 int rowNum = 3;
 for(Object[] capacitadorPojo:capacitadorList){
 Row row = sheet.createRow(rowNum++);
 row.createCell(2).setCellValue((String) ""+capacitadorPojo[5]);
 row.createCell(3).setCellValue((String) ""+capacitadorPojo[9]);
 row.createCell(4).setCellValue((String) ""+capacitadorPojo[7]);
  row.createCell(5).setCellValue((String) ""+capacitadorPojo[3]);
   row.createCell(6).setCellValue((String) ""+capacitadorPojo[8]);
   
// row.createCell(0).setCellValue(capacitadorPojo.getNombrecapacitador());
// row.createCell(1).setCellValue(capacitadorPojo.getTipocapacitador());
// row.createCell(2).setCellValue(capacitadorPojo.getTelefonomovilcapacitador());
//  row.createCell(3).setCellValue(capacitadorPojo.getEmailcapacitador());
//   row.createCell(4).setCellValue(capacitadorPojo.getTemadominio());
 }
 }
}
