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
public class PersonalPensionadoView extends AbstractXlsView{
    @Override
 protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
 HttpServletResponse response) throws Exception {
 
// response.setHeader("Content-Disposition", "<span id="IL_AD8" class="IL_AD">attachment</span>;filename=\"student.xls\"");    
 response.setHeader("Content-Disposition", "attachment; filename=\"Reporte_de_Pensionados.xls\"");
        
 List<Object[]> pensionadosList = (List<Object[]>) model.get("pensionadosList");
 Sheet sheet = workbook.createSheet("Data Plazas pensionados");
 sheet.createRow(0).createCell(3).setCellValue("");
  sheet.createRow(1).createCell(4).setCellValue("REPORTE DE PENSIONADOS");
 Row header = sheet.createRow(2);

 header.createCell(2).setCellValue("Empleado");
// header.createCell(3).setCellValue("Apellido");
 header.createCell(3).setCellValue("Puesto");
// header.createCell(5).setCellValue("apelldio");
 header.createCell(4).setCellValue("Sueldo Base");
 header.createCell(5).setCellValue("Anio");
 header.createCell(6).setCellValue("Mes");
  header.createCell(7).setCellValue("Afiliacion");
//   header.createCell(9).setCellValue("Ubicacion");
// header.createCell(10).setCellValue("Sub lineade Trabajo");
  
 int rowNum = 3;
 for(Object[]pensionados : pensionadosList){
 Row row = sheet.createRow(rowNum++);
 
// DateFormat f = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.mmm'Z'");
//       for(int i = 0;i<plazasOcupadas.length;i++){
//           System.out.println("plazasOcupadas "+i+":"+plazasOcupadas[i]);
//           }
       
           
           
        
 row.createCell(2).setCellValue((String) ""+pensionados[0]);
 row.createCell(3).setCellValue((String) ""+pensionados[1]);
 row.createCell(4).setCellValue((String) ""+pensionados[2]);
 row.createCell(5).setCellValue((String) ""+pensionados[3]);
 row.createCell(6).setCellValue((String)""+ pensionados[4]);
 row.createCell(7).setCellValue((String) ""+pensionados[5]);
 //row.createCell(7).setCellValue((String) plazasOcupadas[6]);
// row.createCell(8).setCellValue((String) ""+pensionados[6]);
//  row.createCell(9).setCellValue((String)""+ pensionados[8]);
//   row.createCell(9).setCellValue((String) plazasOcupadas[9]);
// row.createCell(10).setCellValue((String) plazasOcupadas[10]);
 
 }
 }
    
}
