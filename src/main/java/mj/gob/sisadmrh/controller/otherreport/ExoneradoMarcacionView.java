/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.controller.otherreport;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
public class ExoneradoMarcacionView extends AbstractXlsView{
    @Override
 protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
 HttpServletResponse response) throws Exception {
 
// response.setHeader("Content-Disposition", "<span id="IL_AD8" class="IL_AD">attachment</span>;filename=\"student.xls\"");    
 response.setHeader("Content-Disposition", "attachment; filename=\"Reporte_de_Exonerado Marcacion.xls\"");
        
 List<Object[]> exoneradoMarcacionList = (List<Object[]>) model.get("exoneradoMarcacionLis");
 Sheet sheet = workbook.createSheet("Data exonerados");
 sheet.createRow(0).createCell(3).setCellValue("");
  sheet.createRow(1).createCell(4).setCellValue("REPORTE DE EXONERADO DE MARCACION");
 Row header = sheet.createRow(2);

 header.createCell(2).setCellValue("Nombre empleado");
 header.createCell(3).setCellValue("Apellido");
 header.createCell(4).setCellValue("Nombre Puesto");
 header.createCell(6).setCellValue("ubicacion");
 header.createCell(7).setCellValue("Acuerdo ");
 header.createCell(8).setCellValue("Fecha Desde ");
 header.createCell(9).setCellValue("Fecha hasta ");
//  header.createCell(10).setCellValue("Hasta");
//   header.createCell(11).setCellValue("Ubicacion");
// header.createCell(12).setCellValue("Sub lineade Trabajo");
  
 int rowNum = 3;
 for(Object[] exoneradoMarcacion : exoneradoMarcacionList){
 Row row = sheet.createRow(rowNum++);
 
 DateFormat f = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.mmm'Z'");
//       for(int i = 0;i<plazasOcupadas.length;i++){
//           System.out.println("plazasOcupadas "+i+":"+plazasOcupadas[i]);
//           }
       
           
           
        
 row.createCell(2).setCellValue((String) exoneradoMarcacion[0]);
 row.createCell(3).setCellValue((String) exoneradoMarcacion[1]);
 row.createCell(4).setCellValue((String) exoneradoMarcacion[2]);
 row.createCell(5).setCellValue((String) exoneradoMarcacion[3]);
 row.createCell(5).setCellValue((Integer) exoneradoMarcacion[4]);
 row.createCell(6).setCellValue((Date) exoneradoMarcacion[5]);
 row.createCell(7).setCellValue((Date) exoneradoMarcacion[6]);
// row.createCell(7).setCellValue((Date) exoneradoMarcacion[7]);
//  row.createCell(8).setCellValue((Date) exoneradoMarcacion[8]);
//   row.createCell(9).setCellValue((String) exoneradoMarcacion[9]);
// row.createCell(10).setCellValue((String) exoneradoMarcacion[10]);
// 
 }
 }
    
}
