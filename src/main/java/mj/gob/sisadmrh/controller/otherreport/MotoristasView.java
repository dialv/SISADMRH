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
public class MotoristasView extends AbstractXlsView{
 
 @Override
 protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
 HttpServletResponse response) throws Exception {
 
// response.setHeader("Content-Disposition", "<span id="IL_AD8" class="IL_AD">attachment</span>;filename=\"student.xls\"");    
 response.setHeader("Content-Disposition", "attachment; filename=\"Reporte_de_abogados.xls\"");
        
  List<Object[]>  motoristaList = ( List<Object[]>)  model.get("motoristasList");
Sheet sheet = workbook.createSheet("Reporte de Motoristas Activos");
 sheet.createRow(1).createCell(4).setCellValue("Reporte de Motoristas Activos");
 Row header = sheet.createRow(2);
 
 header.createCell(3).setCellValue("Codigo de empleado");
 header.createCell(4).setCellValue("Nombre de Empleado");
 header.createCell(5).setCellValue("Fin Contrato");
  
 int rowNum = 3;
 for(Object[] motorista:motoristaList){
 Row row = sheet.createRow(rowNum++);
 row.createCell(3).setCellValue(((Integer) motorista[0]));
 row.createCell(4).setCellValue(((String) motorista[1]));
 row.createCell(5).setCellValue(((String) motorista[2]));
 }
 }
}