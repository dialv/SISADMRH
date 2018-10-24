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
import mj.gob.sisadmrh.model.Capacitador;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

/**
 *
 * @author jorge
 */
public class IncapacidadView  extends AbstractXlsView {
    @Override
 protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
 HttpServletResponse response) throws Exception {
 
// response.setHeader("Content-Disposition", "<span id="IL_AD8" class="IL_AD">attachment</span>;filename=\"student.xls\"");    
 response.setHeader("Content-Disposition", "attachment; filename=\"Reporte_de_Incapacidades.xls\"");
        
 List<Object[]> empleadoincapacidadList = (List<Object[]>) model.get("empleadoincapacidadList");
 Sheet sheet = workbook.createSheet("Reporte de incapacidades");
 sheet.createRow(1).createCell(3).setCellValue("REPORTE DE INCAPACIDADES");
 Row header = sheet.createRow(2);
 header.createCell(2).setCellValue("Nombre de empleado");
 header.createCell(3).setCellValue("Nombre de incapacidad");
 header.createCell(4).setCellValue("cargo ");
 header.createCell(4).setCellValue("DUI ");
 header.createCell(5).setCellValue("Fecha Desde");
 header.createCell(6).setCellValue("Fecha Hasta");
 header.createCell(7).setCellValue("Afiliacion al ISSS");
 header.createCell(9).setCellValue("Tipo de Incapacidad");
 header.createCell(10).setCellValue("Forma de Incapacidad");
 header.createCell(11).setCellValue("Subsidio");
 header.createCell(12).setCellValue("Fecha de Emision");
;
  
 int rowNum = 3;
 for(Object[] incapacidad : empleadoincapacidadList){
 Row row = sheet.createRow(rowNum++);
 row.createCell(2).setCellValue((String) incapacidad[0]);
 row.createCell(3).setCellValue((String) incapacidad[1]);
 row.createCell(4).setCellValue((String) incapacidad[2]);
 row.createCell(5).setCellValue((String) incapacidad[3]);
 row.createCell(6).setCellValue((Date) incapacidad[4]);
 row.createCell(7).setCellValue((Date) incapacidad[5]);
 row.createCell(8).setCellValue((String) incapacidad[6]);
 row.createCell(9).setCellValue((String) incapacidad[7]);
 row.createCell(10).setCellValue((String) incapacidad[8]);
 row.createCell(11).setCellValue((Float) incapacidad[9]);
 row.createCell(12).setCellValue((Date) incapacidad[10]);

 }
 }
    
}
