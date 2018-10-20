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
public class PuestosCaducarView  extends AbstractXlsView{
 @Override
 protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
 HttpServletResponse response) throws Exception {
 
// response.setHeader("Content-Disposition", "<span id="IL_AD8" class="IL_AD">attachment</span>;filename=\"student.xls\"");    
 response.setHeader("Content-Disposition", "attachment; filename=\"Reporte_de_Puestos_Caducar.xls\"");
        
 List<Object[]> puestosCaducarList = (List<Object[]>) model.get("puestosCaducarList");
 Sheet sheet = workbook.createSheet("Data Puestos Caducar");
 sheet.createRow(0).createCell(3).setCellValue("");
  sheet.createRow(1).createCell(4).setCellValue("REPORTE DE PUESTOS A CADUCAR");
 Row header = sheet.createRow(2);

 header.createCell(2).setCellValue("Codigo");
 header.createCell(3).setCellValue("Nombre Puesto");
 header.createCell(4).setCellValue("Fecha Desde Contratacion");
// header.createCell(5).setCellValue("apelldio");
 header.createCell(5).setCellValue("Fecha de Contratacion Hasta");
 header.createCell(6).setCellValue("Ubicacion");
 header.createCell(7).setCellValue("Sub Linea");
  header.createCell(8).setCellValue("Numero de Partida");
   header.createCell(9).setCellValue("Numero de Sub Partida");
// header.createCell(10).setCellValue("Sub lineade Trabajo");
  
 int rowNum = 3;
 for(Object[] puestosCaducar: puestosCaducarList){
 Row row = sheet.createRow(rowNum++);
 
// DateFormat f = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.mmm'Z'");
//       for(int i = 0;i<plazasOcupadas.length;i++){
//           System.out.println("plazasOcupadas "+i+":"+plazasOcupadas[i]);
//           }
       
           
           
        
 row.createCell(2).setCellValue((Integer) puestosCaducar[0]);
 row.createCell(3).setCellValue((String) puestosCaducar[1]);
 row.createCell(4).setCellValue((Date) puestosCaducar[2]);
 row.createCell(5).setCellValue((Date) puestosCaducar[3]);
 row.createCell(6).setCellValue((String) puestosCaducar[4]);
 row.createCell(7).setCellValue((Float) puestosCaducar[5]);
 
 row.createCell(8).setCellValue((String) puestosCaducar[7]);
  row.createCell(9).setCellValue((String) puestosCaducar[8]);
   row.createCell(10).setCellValue((String) puestosCaducar[9]);
 row.createCell(11).setCellValue((String) puestosCaducar[10]);
 
 }
 }
     
}
