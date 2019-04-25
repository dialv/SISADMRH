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
public class AbogadosView extends AbstractXlsView{
 
 @Override
 protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
 HttpServletResponse response) throws Exception {
 
// response.setHeader("Content-Disposition", "<span id="IL_AD8" class="IL_AD">attachment</span>;filename=\"student.xls\"");    
 response.setHeader("Content-Disposition", "attachment; filename=\"Reporte_de_abogados.xls\"");
        
 Iterable<Empleado> abogadoList = (Iterable<Empleado>) model.get("abogadosList");
Sheet sheet = workbook.createSheet("Lista de Abogados");
 sheet.createRow(1).createCell(3).setCellValue("REPORTE DE ABOGADOS");
 Row header = sheet.createRow(2);
 
 header.createCell(3).setCellValue("Codigo de empleado");
 header.createCell(4).setCellValue("Fecha de ingreso");
 header.createCell(5).setCellValue("Nombre completo");
  
 int rowNum = 3;
 for(Empleado abogadosPojo:abogadoList){
 Row row = sheet.createRow(rowNum++);
 row.createCell(3).setCellValue(abogadosPojo.getCodigoempleado());
 row.createCell(4).setCellValue(abogadosPojo.getFechaingresoministerio());
 row.createCell(5).setCellValue(abogadosPojo.getNombreempleado());
 }
 }
}
