/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.repository;

import java.util.List;
import mj.gob.sisadmrh.model.Capacitacion;
import mj.gob.sisadmrh.model.Capacitador;
import mj.gob.sisadmrh.model.Empleado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author jorge
 */
public interface EmpleadoRepository extends CrudRepository<Empleado, Integer>{
//      @Query(value = "SELECT c.* FROM capacitador c "
//            + "WHERE c.nombrecapacitador LIKE :nom ", nativeQuery = true)
//
//    Iterable<Capacitador> findByDato(@Param("nom") String dato);
    @Query(value="select  o.* from empleado o where codigopuesto= :tipo"
            + " AND o.fechaingresoministerio >= :FINICIAL "
            + " AND o.fechaingresoministerio <= :FFINAL"
            , nativeQuery = true) 
            Iterable <Empleado> findabogados(@Param("FINICIAL") String finicial, 
                                             @Param("FFINAL") String ffinal,
                                             @Param("tipo") Integer tipo);
            
    @Query(value="SELECT e.nombreempleado,p.nombrepuesto,c.numeroacuerdocomite,"
            + "c.nombrecomite,c.fechadesdecomite,c.fechahastacomite FROM empleado e "
            + "inner join empleadopuesto ep on e.codigopuesto=ep.codigopuesto "
            + "inner join puesto p on ep.codigopuesto=p.codigopuesto "
            + "INNER JOIN comite c on e.codigoempleado=c.codigoempleado "
            + "where c.fechadesdecomite >= :FINICIAL  and c.fechahastacomite <= :FFINAL"
            , nativeQuery = true) 
            List<Object[]> renuncias(@Param("FINICIAL") String finicial, 
                                             @Param("FFINAL") String ffinal);
@Query(value=" SELECT concat(DAY(e.fechanacimientoempleado),\" / \", MONTH(e.fechanacimientoempleado)) AS Fecha,"
        + "e.nombreempleado,p.nombrepuesto ,uf.nombreubicacion from empleado e "
        + "inner join empleadopuesto ep on e.codigopuesto=ep.codigopuesto "
        + "inner join puesto p on ep.codigopuesto=p.codigopuesto "
        + "inner join empleadoubicacionfisica euf on e.codigoempleado=euf.codigoempleado "
        + "INNER JOIN ubicacionfisica uf on euf.codigoubicacion=uf.codigoubicacion "
        + "where e.fechanacimientoempleado >= :FINICIAL  and e.fechanacimientoempleado <= :FFINAL"
, nativeQuery = true)
 
 List<Object[]> findByCumples(@Param("FINICIAL") String finicial, 
                                             @Param("FFINAL") String ffinal);
 
 
  @Query(value = " SELECT e.nombreempleado, e.apellidoempleado, p.nombrepuesto, ne.tituloobtenido, ne.estudiorealizado, ne.fechadesdenivelescolaridad, ne.fechahastanivelescolaridad, ne.centroeducativo from empleado e"
          + " inner join empleadopuesto ep on e.codigopuesto=ep.codigopuesto "
          + " inner join puesto p on ep.codigopuesto=p.codigopuesto"
          + " inner join empleadonivelescolaridad ene on e.codigoempleado=ene.codigoempleado"
          + " inner join nivelescolaridad ne on ene.codigonivelnivelescolaridad"
          + " WHERE ne.fechadesdenivelescolaridad >= :FINICIAL  "
          + " and ne.fechahastanivelescolaridad <= :FFINAL",nativeQuery = true)
  List<Object[]> findByNivelEscolar(@Param("FINICIAL") String finicial, 
                                             @Param("FFINAL") String ffinal);
  
  @Query(value = " SELECT p.codigopuesto,p.nombrepuesto,e.nombreempleado, e.apellidoempleado,e.sexoempleado,p.sueldobase,p.fechanombramiento,p.fechacontrataciondesde, p.fechacontratacionhasta,p.ubicacionpuesto,p.sublinea FROM puesto p "
          + "  inner join empleadopuesto ep on p.codigopuesto=ep.codigopuesto "
          + " inner join empleado e on ep.codigoempleado=e.codigoempleado "
          + " where p.fechacontrataciondesde >= :FINICIAL and p.fechacontratacionhasta <= :FFINAL ",nativeQuery = true)
  List<Object[]> findByPlazasOcupadas(@Param("FINICIAL") String finicial, 
                                             @Param("FFINAL") String ffinal); 
  
  @Query(value = "SELECT e.codigoempleado,e.nombreempleado,e.apellidoempleado,p.nombrepuesto,p.ubicacionpuesto,c.fechainiciocontrato,c.salarioactual FROM `empleado` e, puesto p, contrato c where e.codigoempleado=c.codigoempleado and e.codigopuesto=p.codigopuesto",nativeQuery = true)
  List<Object[]> ContratacionesExcel(@Param("FINICIAL") String finicial, 
                                             @Param("FFINAL") String ffinal);
  @Query(value = "SELECT e.nombreempleado, e.apellidoempleado,p.ubicacionpuesto,p.nombrepuesto,p.numeropartidapuesto, p.numerosubpartidapuesto,p.sueldobase FROM `empleado` e, puesto p, contrato c where e.codigoempleado=c.codigoempleado and e.codigopuesto=p.codigopuesto"
          ,nativeQuery = true)
  List<Object[]> DespidosExcel(@Param("FINICIAL") String finicial, 
                                             @Param("FFINAL") String ffinal);
  
  @Query(value = "SELECT count(e.codigoempleado) as nempleados,sum(p.sueldobase) as sumsueldo,p.ubicacionpuesto FROM `empleado`e , puesto p WHERE e.estadoempleado=1 and e.codigopuesto=p.codigopuesto group by p.ubicacionpuesto"
          ,nativeQuery = true)
  List<Object[]> PseronalActivoExcel(@Param("FINICIAL") String finicial, 
                                             @Param("FFINAL") String ffinal);
   @Query(value = "SELECT count(a.codigoempleado) as Noempleados, a.ubicacionasistenciacapacitacion as Ubicacion, count(c.nombrecapacitacion) as NoCapacitaciones,c.nombrecapacitacion, c.fechacapacitaciondesde as FechaCapacitacion,c.fechacapacitacionhasta \n" +
"FROM `asistenciacapacitacion`a ,`capacitacion` c\n" +
"WHERE a.codigocapacitacion=c.codigocapacitacion group by c.nombrecapacitacion,c.fechacapacitaciondesde"
          ,nativeQuery = true)
  List<Object[]> EstadisticocapacitadoExcel(@Param("FINICIAL") String finicial, 
                                             @Param("FFINAL") String ffinal);
  
  @Query(value = "SELECT \n" +
" e.nombreempleado, e.apellidoempleado,e.sexoempleado,p.acuerdo ,p.sueldobase ,p.fechacontrataciondesde , p.fechacontratacionhasta ,p.nombrepuesto,p.ubicacionpuesto\n" +
"FROM `empleado` e, puesto p \n" +
"WHERE e.codigopuesto=p.codigopuesto and e.estadoempleado=1"
          ,nativeQuery = true)
  List<Object[]> PersonalIndemnizadooExcel(@Param("FINICIAL") String finicial, 
                                             @Param("FFINAL") String ffinal);
}
