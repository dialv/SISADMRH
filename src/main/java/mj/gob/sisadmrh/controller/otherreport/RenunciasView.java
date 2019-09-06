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
     Sheet sheet = workbook.createSheet("Reporte de incapacidades");
 sheet.createRow(2).createCell(5).setCellValue("REPORTE DE RENUNCIAS");
 Row header = sheet.createRow(3);
 header.createCell(3).setCellValue("Empleado");
 header.createCell(4).setCellValue("Puesto");
 header.createCell(5).setCellValue("Salario Actual($)");
 header.createCell(6).setCellValue("Fecha Inicio Contrato");
 header.createCell(7).setCellValue("Partida Contrato");
 header.createCell(8).setCellValue("Nivel Puesto");
 header.createCell(9).setCellValue("Fecha Baja contrato");
  
 int rowNum = 4;
 for(Object[] renuncias : renunciasList){
 Row row = sheet.createRow(rowNum++);
 row.createCell(3).setCellValue((String) renuncias[0]);
 row.createCell(4).setCellValue((String) renuncias[1]);
 row.createCell(5).setCellValue((String) ""+"$  "+renuncias[2]);
 row.createCell(6).setCellValue((String) renuncias[3]);
 row.createCell(7).setCellValue((String) ""+renuncias[4]);
 row.createCell(8).setCellValue((String) ""+renuncias[5]);
  row.createCell(9).setCellValue((String) ""+renuncias[6]);
 }
 }
}
