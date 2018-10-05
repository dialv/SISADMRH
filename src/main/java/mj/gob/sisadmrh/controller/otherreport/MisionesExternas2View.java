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
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

/**
 *
 * @author jorge
 */
public class MisionesExternas2View extends AbstractXlsView{
protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
 HttpServletResponse response) throws Exception {
 
// response.setHeader("Content-Disposition", "<span id="IL_AD8" class="IL_AD">attachment</span>;filename=\"student.xls\"");    
 response.setHeader("Content-Disposition", "attachment; filename=\"Reporte_de_MisionesExternas2.xls\"");
        
 List<Object[]> misionExt2List = (List<Object[]>) model.get("misionExt2List");
 Sheet sheet = workbook.createSheet("Reporte de Misiones externas1");
  sheet.createRow(1).createCell(3).setCellValue("REPORTE DE MISIONES EXTERNAS 2");
 Row header = sheet.createRow(2);

 header.createCell(2).setCellValue("Fecha de Llegada");
 header.createCell(3).setCellValue("Fecha de Regreso");
 header.createCell(4).setCellValue("Gastos");
 header.createCell(5).setCellValue("Acuerdo");
 header.createCell(6).setCellValue("Boleto");
 header.createCell(7).setCellValue("Patrocidandor");
 header.createCell(8).setCellValue("Organismo que Invita");
;
  
 int rowNum = 3;
 for(Object[] misiones : misionExt2List){
 Row row = sheet.createRow(rowNum++);
 row.createCell(2).setCellValue((String) misiones[0]);
 row.createCell(3).setCellValue((String) misiones[1]);
 row.createCell(4).setCellValue((Integer) misiones[2]);
 row.createCell(5).setCellValue((String) misiones[3]);
 row.createCell(6).setCellValue((Date) misiones[4]);
 row.createCell(7).setCellValue((Date) misiones[5]);
 row.createCell(6).setCellValue((Date) misiones[6]);

 }
 }
}
