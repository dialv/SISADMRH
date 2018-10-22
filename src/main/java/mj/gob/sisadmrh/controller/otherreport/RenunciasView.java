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
public class RenunciasView extends AbstractXlsView{
 
 @Override
 protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
 HttpServletResponse response) throws Exception {
 
// response.setHeader("Content-Disposition", "<span id="IL_AD8" class="IL_AD">attachment</span>;filename=\"student.xls\"");    
 response.setHeader("Content-Disposition", "attachment; filename=\"Reporte_de_renunciasvoluntarias.xls\"");
        
 List<Object[]> renunciasList = (List<Object[]>) model.get("renunciasList");
 Sheet sheet = workbook.createSheet("Abogados Data");
 Row header = sheet.createRow(0);
 header.createCell(0).setCellValue("Nombre de empleado");
 header.createCell(1).setCellValue("Nombre de puesto");
 header.createCell(2).setCellValue("Numero de acuerdo");
 header.createCell(3).setCellValue("Nombre de comite");
 header.createCell(4).setCellValue("fecha de ingreso a comite");
 header.createCell(5).setCellValue("fecha de salida de comite");
  
 int rowNum = 1;
 for(Object[] renuncias : renunciasList){
 Row row = sheet.createRow(rowNum++);
 row.createCell(0).setCellValue((String) renuncias[0]);
 row.createCell(1).setCellValue((String) renuncias[1]);
 row.createCell(2).setCellValue((Integer) renuncias[2]);
 row.createCell(3).setCellValue((String) renuncias[3]);
 row.createCell(4).setCellValue((Date) renuncias[4]);
 row.createCell(5).setCellValue((Date) renuncias[5]);
 }
 }
}
