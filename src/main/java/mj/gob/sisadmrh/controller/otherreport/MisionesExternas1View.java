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
public class MisionesExternas1View extends AbstractXlsView{
    @Override
 protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
 HttpServletResponse response) throws Exception {
 
// response.setHeader("Content-Disposition", "<span id="IL_AD8" class="IL_AD">attachment</span>;filename=\"student.xls\"");    
 response.setHeader("Content-Disposition", "attachment; filename=\"Reporte_de_MisionesExternas1.xls\"");
        
 List<Object[]> misionExt1List = (List<Object[]>) model.get("misionExt1List");
 Sheet sheet = workbook.createSheet("Reporte de Misiones externas1");
 sheet.createRow(1).createCell(3).setCellValue("REPORTE DE MISIONES EXTERNAS 1");
 Row header = sheet.createRow(2);
 header.createCell(2).setCellValue("Empleado");
 header.createCell(3).setCellValue("Puesto");
 header.createCell(4).setCellValue("Mision");
 header.createCell(5).setCellValue("Objetivo");
 header.createCell(6).setCellValue("Instirucion o departamento");
 header.createCell(7).setCellValue("Pais");
 header.createCell(8).setCellValue("Ciudad");
;
  
 int rowNum = 3;
 for(Object[] misiones : misionExt1List){
 Row row = sheet.createRow(rowNum++);
 row.createCell(2).setCellValue((String) misiones[0]);
 row.createCell(3).setCellValue((String) misiones[1]);
 row.createCell(4).setCellValue((String) misiones[2]);
 row.createCell(5).setCellValue((String) misiones[3]);
 row.createCell(6).setCellValue((String) misiones[4]);
 row.createCell(7).setCellValue((String) misiones[5]);
 row.createCell(8).setCellValue((String) misiones[6]);

 }
 }
    
}
