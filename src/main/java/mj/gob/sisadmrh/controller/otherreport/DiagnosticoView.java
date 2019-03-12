/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.controller.otherreport;

import java.util.List;
import java.util.Map;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mj.gob.sisadmrh.model.DiagnosticoCapacitacion;
import mj.gob.sisadmrh.pojos.DiagnosticoPojo;
 
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;


/**
 *
 * @author root
 */
public class DiagnosticoView extends AbstractXlsView{
 
 @Override
 protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
 HttpServletResponse response) throws Exception {
 
// response.setHeader("Content-Disposition", "<span id="IL_AD8" class="IL_AD">attachment</span>;filename=\"student.xls\"");    
 response.setHeader("Content-Disposition", "attachment; filename=\"Reporte_de_temasdiagnostico.xls\"");
        
 List<Object[]> capacitadorList = (List<Object[]>) model.get("diagnosticoList");
 Sheet sheet = workbook.createSheet("Diagnostico Data");
 sheet.createRow(0).createCell(3).setCellValue("");
 sheet.createRow(1).createCell(4).setCellValue("REPORTE DE DIAGNOSTICO DE NECESIDADES DE CAPACITACION");
 
 Row header = sheet.createRow(0);
  
 header.createCell(0).setCellValue("Temas");
 header.createCell(1).setCellValue("Direccion");
 header.createCell(2).setCellValue("Necesidades");
 header.createCell(3).setCellValue("Mes");
 header.createCell(4).setCellValue("Resultados a Obtener");
 header.createCell(5).setCellValue("Quien autoriza");
 header.createCell(6).setCellValue("Cargo quien autoriza");
  
 int rowNum = 1;
 for(Object[] DiagnosticoPojo:capacitadorList){
 Row row = sheet.createRow(rowNum++);
 
  row.createCell(0).setCellValue((String) ""+DiagnosticoPojo[8]);
 row.createCell(1).setCellValue((String) ""+DiagnosticoPojo[2]);
 row.createCell(2).setCellValue((String) ""+DiagnosticoPojo[4]);
  row.createCell(3).setCellValue((String) ""+DiagnosticoPojo[3]);
   row.createCell(4).setCellValue((String) ""+DiagnosticoPojo[6]);
   row.createCell(5).setCellValue((String) ""+DiagnosticoPojo[5]);
   row.createCell(6).setCellValue((String) ""+DiagnosticoPojo[1]);
 }
// row.createCell(0).setCellValue(DiagnosticoPojo.getTemacapacitacion());
// row.createCell(1).setCellValue(DiagnosticoPojo.getDireccion());
// row.createCell(2).setCellValue(DiagnosticoPojo.getNecesidadcapacitacion());
//  row.createCell(3).setCellValue(DiagnosticoPojo.getMescapacitacion());
//   row.createCell(4).setCellValue(DiagnosticoPojo.getResultadoobtener());
//   row.createCell(5).setCellValue(DiagnosticoPojo.getNombreautorizadiagnosticocapacitacion());
//   row.createCell(6).setCellValue(DiagnosticoPojo.getCargoautorizadiagnosticocapacitacion());
// }
 }
}
