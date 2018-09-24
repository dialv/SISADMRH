/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.controller.otherreport;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mj.gob.sisadmrh.model.Comite;
import mj.gob.sisadmrh.model.Empleado;
import mj.gob.sisadmrh.model.Puesto;
import mj.gob.sisadmrh.pojos.ComitePojo;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsView;

/**
 *
 * @author jorge
 */
@Component("fragments/comites.xlsx")
public class ComitesView   extends AbstractXlsView{
//    Puesto puesto;
//    Comite comite;
//    Empleado empleado;
 @Override
 protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
 HttpServletResponse response) throws Exception {
 
// response.setHeader("Content-Disposition", "<span id="IL_AD8" class="IL_AD">attachment</span>;filename=\"student.xls\"");    
 response.setHeader("Content-Disposition", "attachment; filename=\"Reporte_de_comites.xls\"");
        
  List<Object[]> comitesList = (List<Object[]>) model.get("comitesList");
 Sheet sheet = workbook.createSheet("Comites Data");
 Row header = sheet.createRow(0);
 header.createCell(0).setCellValue("Nombre Empleado");
 header.createCell(1).setCellValue("Puesto");
 header.createCell(2).setCellValue("Comite");
  header.createCell(3).setCellValue("Desde");
  header.createCell(4).setCellValue("Hasta");
  
  
   
 int rowNum = 1;

  for(Object[] comites : comitesList){
 Row row = sheet.createRow(rowNum++);
 row.createCell(0).setCellValue((String) comites[0]);
 row.createCell(1).setCellValue((String) comites[1]);
 row.createCell(2).setCellValue((Integer) comites[2]);
 row.createCell(3).setCellValue((String) comites[3]);
 row.createCell(4).setCellValue((Timestamp) comites[4]);
 row.createCell(5).setCellValue((Timestamp) comites[5]);
 }

// int rowNum = 1;
// for(ComitePojo comitePojo:comiteList){
// Row row = sheet.createRow(rowNum++);
// row.createCell(0).setCellValue(comitePojo.getApellidoempleado()+ "" + comitePojo.getNombreempleado());
// row.createCell(2).setCellValue(comitePojo.puesto.getNombrepuesto());
// row.createCell(1).setCellValue(comitePojo.comite.getNombrecomite());
// 
// row.createCell(3).setCellValue(comitePojo.comite.getFechadesdecomite());
//  row.createCell(4).setCellValue(comitePojo.comite.getFechahastacomite());
// }
 }
}