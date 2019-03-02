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

public class PersonalIndemnizadoView extends AbstractXlsView{
@Override
 protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
 HttpServletResponse response) throws Exception {
 
// response.setHeader("Content-Disposition", "<span id="IL_AD8" class="IL_AD">attachment</span>;filename=\"student.xls\"");    
 response.setHeader("Content-Disposition", "attachment; filename=\"Reporte_de_PersonalCapacitado.xls\"");
        
 List<Object[]> IndemnizadoList = (List<Object[]>) model.get("IndemnizadoList");
 Sheet sheet = workbook.createSheet("Data Personal Indemnizado");
 sheet.createRow(0).createCell(3).setCellValue("");
  sheet.createRow(1).createCell(4).setCellValue("REPORTE DE PERSONAL INDEMNIZADO");
 Row header = sheet.createRow(2);

 header.createCell(2).setCellValue("Nombre Empleado");
 header.createCell(3).setCellValue("Sexo");
 header.createCell(4).setCellValue("No de Acuerdo");
 header.createCell(5).setCellValue("Salario");
 header.createCell(6).setCellValue("Fecha Desde");
 header.createCell(7).setCellValue("Fecha Hasta");
 header.createCell(8).setCellValue("Nombre de Puesto");
 header.createCell(9).setCellValue("Ubicacion");
  
 int rowNum = 3;
 for(Object[] List : IndemnizadoList){
 Row row = sheet.createRow(rowNum++);
 

 row.createCell(2).setCellValue((String) ""+List[0] +" "+List[1]);
 row.createCell(3).setCellValue((String) ""+List[2]);
 row.createCell(4).setCellValue((String) ""+List[3]);
 row.createCell(5).setCellValue((String) ""+List[4]);
 row.createCell(6).setCellValue((String) ""+List[5]);
 row.createCell(7).setCellValue((String) ""+List[6]);
 row.createCell(8).setCellValue((String) ""+List[7]);
 row.createCell(9).setCellValue((String) ""+List[8]);
 
 
 }
 }
  
//   protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
// HttpServletResponse response) throws Exception {
// 
//// response.setHeader("Content-Disposition", "<span id="IL_AD8" class="IL_AD">attachment</span>;filename=\"student.xls\"");    
// response.setHeader("Content-Disposition", "attachment; filename=\"Reporte_de_Plazas_Ocupadas.xls\"");
//        
// List<Object[]> plazasOcupadasList = (List<Object[]>) model.get("plazasOcupadasList");
// Sheet sheet = workbook.createSheet("Reporte de Niveles Escolares");
// sheet.createRow(0).createCell(3).setCellValue("REPORTE DE PLAZAS OCUPADAS");
// Row header = sheet.createRow(1);
// header.createCell(2).setCellValue("Codigo");
// header.createCell(3).setCellValue("Nombre Puesto");
// header.createCell(4).setCellValue("Nombre Empleado");
// header.createCell(5).setCellValue("apelldio");
// header.createCell(6).setCellValue("Sexo");
// header.createCell(7).setCellValue("Sueldo Basico");
// header.createCell(8).setCellValue("Desde");
//  header.createCell(9).setCellValue("hasta");
// header.createCell(10).setCellValue("Linea de Trabajo")
//;
//  
// int rowNum = 1;
// for(Object[] plazasOcupadas : plazasOcupadasList){
// Row row = sheet.createRow(rowNum++);
// row.createCell(2).setCellValue((Integer) plazasOcupadas[0]);
// row.createCell(3).setCellValue((String) plazasOcupadas[1]);
// row.createCell(4).setCellValue((String) plazasOcupadas[2]);
// row.createCell(5).setCellValue((String) plazasOcupadas[3]);
// row.createCell(6).setCellValue((String) plazasOcupadas[4]);
// row.createCell(7).setCellValue((String) plazasOcupadas[5]);
// row.createCell(8).setCellValue((Date) plazasOcupadas[6]);
//  row.createCell(9).setCellValue((Date) plazasOcupadas[7]);
// row.createCell(10).setCellValue((String) plazasOcupadas[8]);
//
// }
// }
    
}
