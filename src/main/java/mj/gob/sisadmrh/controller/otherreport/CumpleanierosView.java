/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.controller.otherreport;

import java.sql.Date;
import java.sql.Timestamp;
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
@Component("fragments/plazasocupadas.xlsx")
public class CumpleanierosView extends AbstractXlsView{

    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
       response.setHeader("Content-Disposition", "attachment; filename=\"Reporte_de_cumpleanieros.xls\"");
       
//       SELECT count(e.codigoempleado),concat(DAY(e.fechanacimientoempleado)," / ", MONTH(e.fechanacimientoempleado)) AS Fecha,
//               e.nombreempleado,p.nombrepuesto ,uf.nombreubicacion from empleado e inner join empleadopuesto ep on e.codigopuesto=ep.codigopuesto inner join puesto p on ep.codigopuesto=p.codigopuesto inner join empleadoubicacionfisica euf on e.codigoempleado=euf.codigoempleado INNER JOIN ubicacionfisica uf on euf.codigoubicacion=uf.codigoubicacion where month(e.fechanacimientoempleado)=month(NOW())
        List<Object[]> cumplesList = (List<Object[]>) model.get("cumplesList");
 Sheet sheet = workbook.createSheet("Lista de cumpleanieros");
 sheet.createRow(1).createCell(3).setCellValue("REPORTE DE CUMPLEANIEROS");
 Row header = sheet.createRow(2);
// header.createCell(0).setCellValue("Codigo empleado");
 header.createCell(1).setCellValue("Fecha");
 header.createCell(2).setCellValue("Puesto");
 header.createCell(3).setCellValue("Ubicacion");
 header.createCell(4).setCellValue("Empleado");

 
 int rowNum = 3;
 for(Object[] cumples : cumplesList){
 Row row = sheet.createRow(rowNum++);
 row.createCell(1).setCellValue((String) cumples[0]);
 row.createCell(2).setCellValue((String) cumples[1]);
 row.createCell(3).setCellValue((String) cumples[2]);
 row.createCell(4).setCellValue((String) cumples[3]);

 }
 }

    
}
