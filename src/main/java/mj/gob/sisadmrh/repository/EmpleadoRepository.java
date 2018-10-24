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
    
    /* GERAR REPORTE EXEL DE ABOGADOS */
    @Query(value="select  o.* from empleado o where codigopuesto= :tipo"
            + " AND o.fechaingresoministerio >= :FINICIAL "
            + " AND o.fechaingresoministerio <= :FFINAL"
            , nativeQuery = true) 
            Iterable <Empleado> findabogados(@Param("FINICIAL") String finicial, 
                                             @Param("FFINAL") String ffinal,
                                             @Param("tipo") Integer tipo);
        /*GENERAR REPORTE DE RENUNCIAS VOLUNTARIAS */    
    @Query(value="SELECT e.nombreempleado,p.nombrepuesto,c.numeroacuerdocomite,"
            + "c.nombrecomite,c.fechadesdecomite,c.fechahastacomite FROM empleado e "
            + "inner join empleadopuesto ep on e.codigopuesto=ep.codigopuesto "
            + "inner join puesto p on ep.codigopuesto=p.codigopuesto "
            + "INNER JOIN comite c on e.codigoempleado=c.codigoempleado "
            + "where c.fechadesdecomite >= :FINICIAL  and c.fechahastacomite <= :FFINAL"
            , nativeQuery = true) 
            List<Object[]> renuncias(@Param("FINICIAL") String finicial, 
                                             @Param("FFINAL") String ffinal);
            /*PARA GENERAR REPORTES DE CUMPLEANIEROS EXEL */
@Query(value=" SELECT concat(DAY(e.fechanacimientoempleado),\" / \", MONTH(e.fechanacimientoempleado)) AS Fecha,"
        + " e.nombreempleado,p.nombrepuesto ,uf.nombreubicacion from empleado e "
        + " inner join empleadopuesto ep on e.codigopuesto=ep.codigopuesto "
        + " inner join puesto p on ep.codigopuesto=p.codigopuesto "
        + " inner join empleadoubicacionfisica euf on e.codigoempleado=euf.codigoempleado "
        + " INNER JOIN ubicacionfisica uf on euf.codigoubicacion=uf.codigoubicacion "
        + " where e.fechanacimientoempleado >= :FINICIAL  and e.fechanacimientoempleado <= :FFINAL "
, nativeQuery = true)
 
 List<Object[]> findByCumples(@Param("FINICIAL") String finicial, 
                                             @Param("FFINAL") String ffinal);
 
 /*PARA GENERAR REPORTE DE NIVELES ESCOLARES EXEL */
  @Query(value = " SELECT e.nombreempleado, e.apellidoempleado, p.nombrepuesto, ne.tituloobtenido, ne.estudiorealizado, ne.fechadesdenivelescolaridad, ne.fechahastanivelescolaridad, ne.centroeducativo from empleado e"
          + " inner join empleadopuesto ep on e.codigopuesto=ep.codigopuesto "
          + " inner join puesto p on ep.codigopuesto=p.codigopuesto"
          + " inner join empleadonivelescolaridad ene on e.codigoempleado=ene.codigoempleado"
          + " inner join nivelescolaridad ne on ene.codigonivelnivelescolaridad"
          + " WHERE ne.fechadesdenivelescolaridad >= :FINICIAL  "
          + " and ne.fechahastanivelescolaridad <= :FFINAL",nativeQuery = true)
  List<Object[]> findByNivelEscolar(@Param("FINICIAL") String finicial, 
                                             @Param("FFINAL") String ffinal);
  /* PARA GNERAR REPORTE PLAZAS OCUPADAS EXEL***************************/
  @Query(value = " SELECT p.codigopuesto,p.nombrepuesto,e.nombreempleado, e.apellidoempleado,e.sexoempleado,p.sueldobase,p.fechanombramiento,p.fechacontrataciondesde, p.fechacontratacionhasta,p.ubicacionpuesto,p.sublinea FROM puesto p "
          + "  inner join empleadopuesto ep on p.codigopuesto=ep.codigopuesto "
          + " inner join empleado e on ep.codigoempleado=e.codigoempleado "
          + " where p.fechacontrataciondesde >= :FINICIAL and p.fechacontratacionhasta <= :FFINAL ",nativeQuery = true)
  List<Object[]> findByPlazasOcupadas(@Param("FINICIAL") String finicial, 
                                             @Param("FFINAL") String ffinal); 
  
  // PARA GENERAR REPORTE DE EXEL EXONERADO DE MARCACION----------------------------------------------
   @Query(value = " SELECT  e.nombreempleado, e.apellidoempleado, p.nombrepuesto ,u.nombreubicacion ,cd.acuerdocuadrodirectivo  , cd.fechapresentaciondesde , cd.fechapresentacionhasta \n" +
" FROM `empleado` e, puesto p ,empleadopuesto ep, ubicacionfisica u, cuadrodirectivo cd " +
" WHERE\n" +
" e.codigopuesto=ep.codigopuesto AND " +
" ep.codigopuesto=p.codigopuesto and " +
" e.codigopuesto=p.codigopuesto and " +
" e.estadoempleado=2 and " +
" e.codigoempleado=u.codigoempleado and " +
" e.codigoempleado=cd.codigoempleado and cd.fechapresentaciondesde>= :FINICIAL and cd.fechapresentacionhasta <= :FFINAL  ",nativeQuery = true)
List<Object[]> findByExoneradoMarcacion(@Param("FINICIAL") String finicial, 
                                             @Param("FFINAL") String ffinal); 
// reporte exel para personal pensionado
@Query(value = "SELECT e.nombreempleado, e.apellidoempleado, p.nombrepuesto,p.sueldobase,year(e.fechaingresoministerio), month(e.fechaingresoministerio), e.afiliacionpension FROM `empleado` e,empleadopuesto ep, puesto p WHERE e.codigopuesto=ep.codigopuesto and ep.codigopuesto=p.codigopuesto and e.estadoempleado=3 and e.fechaingresoministerio>= :FINICIAL and e.fechaingresoministerio<= :FFINAL" ,nativeQuery = true)
List<Object[]> findByPensionados(@Param("FINICIAL") String finicial, 
                                             @Param("FFINAL") String ffinal);
@Query(value = " select p.codigopuesto,p.nombrepuesto,p.fechacontrataciondesde,p.fechacontratacionhasta,p.ubicacionpuesto,p.numerosubpartidapuesto,p.numeropartidapuesto from puesto p where  p.fechacontratacionhasta between curdate() and curdate() + interval 60 day",nativeQuery = true)
List<Object[]> findByPuestosCaducar(@Param("FINICIAL") String finicial, 
                                             @Param("FFINAL") String ffinal);

@Query(value = " SELECT e.codigoempleado, e.nombreempleado,d.nombrepuesto, d.sueldobase, d.sueldotopepuesto, "
        + " d.fechacontrataciondesde, d.fechacontratacionhasta FROM empleado e INNER JOIN empleadopuesto p " +
" on e.codigoempleado=p.codigoempleado  inner join puesto d on d.codigopuesto=p.codigopuesto " +
" where " +
" e.codigoempleado=:CODIGO",nativeQuery = true)
List<Object[]> findByPuestosEmpleados(@Param("CODIGO") String codigo);// ES EL METODO DE HISTORIAL LABRORAL

 @Query(value = " select e.nombreempleado,i.nombreincapacidad, p.nombrepuesto,e.duiempleado,i.fechadesdeincapacidad,i.fechahastaincapacidad,"
         + " i.numerofichaisss,i.tipoincapacidad,i.formaincapacidad,i.subsidio,i.fechaemision from empleado e "
         + " inner join empleadopuesto ep on e.codigopuesto=ep.codigopuesto inner join puesto p on ep.codigopuesto=p.codigopuesto "
         + " inner join incapacidad i on e.codigoempleado=i.codigoempleado "
         + " where i.fechahastaincapacidad >= :FINICIAL and i.fechahastaincapacidad <= :FFINAL ",nativeQuery = true)
List<Object[]> findByIncapacidad(
                                             @Param("FINICIAL") String finicial, 
                                             @Param("FFINAL") String ffinal);                                           

}
