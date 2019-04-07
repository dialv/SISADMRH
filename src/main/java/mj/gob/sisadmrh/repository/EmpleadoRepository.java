package mj.gob.sisadmrh.repository;

import java.util.List;
import mj.gob.sisadmrh.model.Empleado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author jorge
 */
public interface EmpleadoRepository extends CrudRepository<Empleado, Integer> {

    /* GERAR REPORTE EXEL DE ABOGADOS */
    @Query(value = "select  o.* from empleado o where codigopuesto= :tipo"
            + " AND o.fechaingresoministerio >= STR_TO_DATE(:FINICIAL, '%d/%m/%Y') "
            + " AND o.fechaingresoministerio <= STR_TO_DATE(:FFINAL, '%d/%m/%Y')",
             nativeQuery = true)
    Iterable<Empleado> findabogados(@Param("FINICIAL") String finicial,
            @Param("FFINAL") String ffinal,
            @Param("tipo") Integer tipo);

    /*GENERAR REPORTE DE RENUNCIAS VOLUNTARIAS */
    @Query(value = "select concat(e.nombreempleado,' ', e.apellidoempleado) as nombres ,p.nombrepuesto,c.salarioactual,DATE_FORMAT(c.fechainiciocontrato, '%d/%m/%Y')as \"Fecha Inicio Contrato\",c.partidacontrato,p.nivelpuesto,DATE_FORMAT(p.fechabaja, '%d/%m/%Y')as \"Baja Contrato\" \n" +
"from empleado e inner join puesto p on e.codigopuesto=p.codigopuesto inner join contrato c on e.codigoempleado=c.codigoempleado "
            + "where c.fechainiciocontrato >= STR_TO_DATE(:FINICIAL, '%d/%m/%Y')  and c.fechainiciocontrato  <= STR_TO_DATE(:FFINAL, '%d/%m/%Y')",
             nativeQuery = true)
    List<Object[]> renuncias(@Param("FINICIAL") String finicial,
            @Param("FFINAL") String ffinal);

    /*PARA GENERAR REPORTES DE CUMPLEANIEROS EXEL */
    @Query(value = " SELECT concat(DAY(e.fechanacimientoempleado),\" / \", MONTH(e.fechanacimientoempleado)) AS Fecha,p.nombrepuesto,uf.nombreubicacion,e.nombreempleado from SISADMRH.empleado e INNER JOIN SISADMRH.puesto p ON e.codigopuesto=p.codigopuesto INNER JOIN SISADMRH.ubicacionfisica uf on uf.codigoempleado=e.codigoempleado "
            + "where concat(DAY(e.fechanacimientoempleado),\" / \", MONTH(e.fechanacimientoempleado))>=:FINICIAL and concat(DAY(e.fechanacimientoempleado),\" / \", MONTH(e.fechanacimientoempleado))<=STR_TO_DATE(:FFINAL, '%d/%m/%Y') ",
             nativeQuery = true)

    List<Object[]> findByCumples(@Param("FINICIAL") String finicial,
            @Param("FFINAL") String ffinal);

    /*PARA GENERAR REPORTE DE NIVELES ESCOLARES EXEL */
    @Query(value = " SELECT concat(e.nombreempleado,' ', e.apellidoempleado) as nombre, \n" +
"p.nombrepuesto, ne.tituloobtenido, ne.estudiorealizado,\n" +
"DATE_FORMAT(ne.fechadesdenivelescolaridad, '%d/%m/%Y') as fechadesdenivelescolaridad,\n" +
"DATE_FORMAT(ne.fechahastanivelescolaridad,  '%d/%m/%Y') as fechahastanivelescolaridad,\n" +
"ne.centroeducativo from empleado e, empleadopuesto ep,puesto p,empleadonivelescolaridad ene,nivelescolaridad ne\n" +
"where e.codigopuesto=ep.codigopuesto  and\n" +
"ep.codigopuesto=p.codigopuesto and\n" +
"e.codigoempleado=ene.codigoempleado and \n" +
"ene.codigonivelnivelescolaridad=ne.codigonivelnivelescolaridad and \n" +
"ne.fechadesdenivelescolaridad >= STR_TO_DATE(:FINICIAL, '%d/%m/%Y') \n" +
"and ne.fechadesdenivelescolaridad <= ne.fechadesdenivelescolaridad <= STR_TO_DATE(:FFINAL, '%d/%m/%Y')", nativeQuery = true)
            
    List<Object[]> findByNivelEscolar(@Param("FINICIAL") String finicial,
            @Param("FFINAL") String ffinal);

    /* PARA GNERAR REPORTE PLAZAS OCUPADAS EXEL***************************/
    @Query(value = " SELECT p.codigopuesto,p.nombrepuesto,e.nombreempleado, e.apellidoempleado,e.sexoempleado,p.sueldobase,p.fechanombramiento,DATE_FORMAT(p.fechacontrataciondesde,  '%d/%m/%Y') as fechacontrataciondesde, "
            + "DATE_FORMAT(p.fechacontratacionhasta,  '%d/%m/%Y') as  fechacontratacionhasta,p.ubicacionpuesto,p.sublinea FROM puesto p "
            + "  inner join empleadopuesto ep on p.codigopuesto=ep.codigopuesto "
            + " inner join empleado e on ep.codigoempleado=e.codigoempleado "
            + " where p.fechacontrataciondesde >= STR_TO_DATE(:FINICIAL, '%d/%m/%Y') and p.fechacontrataciondesde <= STR_TO_DATE(:FFINAL, '%d/%m/%Y') ", nativeQuery = true)
    List<Object[]> findByPlazasOcupadas(@Param("FINICIAL") String finicial,
            @Param("FFINAL") String ffinal);

    @Query(value = "SELECT e.codigoempleado,e.nombreempleado,e.apellidoempleado,p.nombrepuesto,p.ubicacionpuesto,DATE_FORMAT(c.fechainiciocontrato, \"%d/ %m /%Y\") as fechainiciocontrato ,c.salarioactual FROM `empleado` e, puesto p, contrato c where e.codigoempleado=c.codigoempleado and e.codigopuesto=p.codigopuesto and c.fechainiciocontrato>= STR_TO_DATE(:FINICIAL, '%d/%m/%Y') and c.fechainiciocontrato<= STR_TO_DATE(:FFINAL, '%d/%m/%Y')", nativeQuery = true)
    List<Object[]> ContratacionesExcel(@Param("FINICIAL") String finicial,
            @Param("FFINAL") String ffinal);

    @Query(value = "SELECT e.nombreempleado, e.apellidoempleado,p.ubicacionpuesto,p.nombrepuesto,p.numeropartidapuesto, p.numerosubpartidapuesto,p.sueldobase FROM `empleado` e, puesto p, contrato c where e.codigoempleado=c.codigoempleado and e.codigopuesto=p.codigopuesto and e.estadoempleado=4",
             nativeQuery = true)
    List<Object[]> DespidosExcel(@Param("FINICIAL") String finicial,
            @Param("FFINAL") String ffinal);

    @Query(value = "SELECT count(e.codigoempleado) as nempleados,sum(p.sueldobase) as sumsueldo,p.ubicacionpuesto FROM `empleado`e , puesto p WHERE e.estadoempleado=1 and e.codigopuesto=p.codigopuesto group by p.ubicacionpuesto",
             nativeQuery = true)
    List<Object[]> PseronalActivoExcel(@Param("FINICIAL") String finicial,
            @Param("FFINAL") String ffinal);
    


    @Query(value = "SELECT count(a.codigoempleado) as Noempleados, a.ubicacionasistenciacapacitacion as Ubicacion, count(c.nombrecapacitacion) as NoCapacitaciones,c.nombrecapacitacion, DATE_FORMAT(c.fechacapacitaciondesde, \\\"%d/ %m /%Y\\\")  as FechaCapacitacion,c.fechacapacitacionhasta \n"
            + "FROM `asistenciacapacitacion`a ,`capacitacion` c\n"
            + "WHERE a.codigocapacitacion=c.codigocapacitacion group by c.nombrecapacitacion,c.fechacapacitaciondesde",
             nativeQuery = true)
    List<Object[]> EstadisticocapacitadoExcel(@Param("FINICIAL") String finicial,
            @Param("FFINAL") String ffinal);

    @Query(value = "SELECT \n"
            + " e.nombreempleado, e.apellidoempleado,e.sexoempleado,p.acuerdo ,p.sueldobase ,"
            + "DATE_FORMAT(p.fechacontrataciondesde, \\\"%d/ %m /%Y\\\")  as fechacontrataciondesde , DATE_FORMAT(p.fechacontratacionhasta, \\\"%d/ %m /%Y\\\")  as fechacontratacionhasta ,p.nombrepuesto,p.ubicacionpuesto\n"
            + "FROM `empleado` e, puesto p \n"
            + "WHERE e.codigopuesto=p.codigopuesto and e.estadoempleado=1",
             nativeQuery = true)
    List<Object[]> PersonalIndemnizadooExcel(@Param("FINICIAL") String finicial,
            @Param("FFINAL") String ffinal);

    // PARA GENERAR REPORTE DE EXEL EXONERADO DE MARCACION----------------------------------------------
   
    
    
    @Query(value = " SELECT concat(e.nombreempleado,' ',e.apellidoempleado) as 'Nombre',p.nombrepuesto as 'Nombre de Puesto',u.nombreubicacion as 'Ubicacion',c.acuerdocuadrodirectivo as 'No. Acuerdo' , DATE_FORMAT(c.fechapresentaciondesde,'%d/%m/%Y') as 'Fecha Desde', DATE_FORMAT(c.fechapresentacionhasta, '%d/%m/%Y') as 'Fecha Hasta' FROM `empleado` e, puesto p , ubicacionfisica u, cuadrodirectivo c WHERE e.codigopuesto=p.codigopuesto and e.codigoempleado=u.codigoempleado and e.codigoempleado=c.codigoempleado and e.estadoempleado=2 and c.fechapresentaciondesde >= STR_TO_DATE(:FINICIAL, '%d/%m/%Y') and c.fechapresentacionhasta <= STR_TO_DATE(:FFINAL, '%d/%m/%Y') ", nativeQuery = true)
    List<Object[]> findByExoneradoMarcacion(@Param("FINICIAL") String finicial,
            @Param("FFINAL") String ffinal);
// reporte exel para personal pensionado

 @Query(value = "SELECT " +
           " concat(e.nombreempleado,' ',e.apellidoempleado)as Empleado, "
         + " p.nombrepuesto as 'Nombre de Puesto', "
         + " p.sueldobase as 'Salario',"
         + " year(e.fechaingresoministerio) as Año, "
         + " monthname(e.fechaingresoministerio) as Mes, "
         + " e.afiliacionpension as 'Institucion Pensionadora' " +
            " FROM `empleado` e, puesto p WHERE e.codigopuesto=p.codigopuesto and e.estadoempleado=3 and " +
            " e.fechaingresoministerio >= STR_TO_DATE(:FINICIAL, '%d/%m/%Y') " +
            "and e.fechaingresoministerio <= STR_TO_DATE(:FFINAL, '%d/%m/%Y')", nativeQuery = true)
    List<Object[]> findByPensionados(@Param("FINICIAL") String finicial,
            @Param("FFINAL") String ffinal);

    @Query(value = " select p.codigopuesto,p.nombrepuesto,DATE_FORMAT(p.fechacontrataciondesde, '%d/%m/%Y'),DATE_FORMAT(p.fechacontratacionhasta, '%d/%m/%Y'),p.ubicacionpuesto,p.sublinea ,p.numeropartidapuesto,p.numerosubpartidapuesto from puesto p where  p.fechacontratacionhasta >= STR_TO_DATE(:FINICIAL, '%d/%m/%Y') and p.fechacontratacionhasta  <= STR_TO_DATE(:FFINAL, '%d/%m/%Y') ", nativeQuery = true)
    List<Object[]> findByPuestosCaducarExcel(@Param("FINICIAL") String finicial,
            @Param("FFINAL") String ffinal);

    @Query(value = " SELECT e.codigoempleado, concat(e.nombreempleado,' ',e.apellidoempleado)as Empleado,d.nombrepuesto, d.sueldobase, d.sueldotopepuesto, DATE_FORMAT(d.fechacontrataciondesde, '%d/%m/%Y'),DATE_FORMAT(d.fechacontratacionhasta, '%d/%m/%Y') \n" +
"FROM empleado e INNER JOIN empleadopuesto p\n" +
"on e.codigoempleado=p.codigoempleado  inner join puesto d on d.codigopuesto=p.codigopuesto\n" +
"where\n" +
"e.codigoempleado= :CODIGO ", nativeQuery = true)
    List<Object[]> findByPuestosEmpleados(@Param("CODIGO") String codigo);// ES EL METODO DE HISTORIAL LABRORAL

    @Query(value = " select concat(e.nombreempleado,' ',e.apellidoempleado),i.nombreincapacidad, p.nombrepuesto,e.duiempleado,DATE_FORMAT(i.fechadesdeincapacidad, '%d/%m/%Y'),DATE_FORMAT(i.fechahastaincapacidad, '%d/%m/%Y') ,"
            + " i.numerofichaisss,i.tipoincapacidad,i.formaincapacidad,i.subsidio,DATE_FORMAT(i.fechaemision, '%d/%m/%Y') from empleado e "
            + " inner join empleadopuesto ep on e.codigopuesto=ep.codigopuesto inner join puesto p on ep.codigopuesto=p.codigopuesto "
            + " inner join incapacidad i on e.codigoempleado=i.codigoempleado "
            + " where i.fechadesdeincapacidad >= STR_TO_DATE(:FINICIAL, '%d/%m/%Y')  and i.fechadesdeincapacidad <= STR_TO_DATE(:FFINAL, '%d/%m/%Y') ", nativeQuery = true)
    List<Object[]> findByIncapacidad(
            @Param("FINICIAL") String finicial,
            @Param("FFINAL") String ffinal);

    @Query(value = "SELECT c.nombrecapacitacion,e.nombreempleado,e.apellidoempleado,a.codigoasistenciacapacitacion,e.codigoempleado,a.codigocapacitacion FROM empleado e , capacitacion c ,asistenciacapacitacion a WHERE \n"
            + " c.codigocapacitacion = a.codigocapacitacion and \n"
            + " a.codigoempleado=e.codigoempleado and \n"
            + " a.codigocapacitacion= :id  ", nativeQuery = true)
    List<Object[]> findByDato(@Param("id") int dato);

    @Query(value = "SELECT c.nombrecapacitacion,s.codigocapacitacion FROM  capacitacion c ,asistenciacapacitacion s WHERE \n"
            + " c.codigocapacitacion = s.codigocapacitacion and \n"
            + " s.codigoasistenciacapacitacion= :id  ", nativeQuery = true)
    List<Object[]> findByAsistenciaCapacitacion(@Param("id") int dato);

    @Query(value = "DELETE FROM  empleadoasistenciacapacitacion  WHERE \n"
            + " codigoempleado= :id  ", nativeQuery = true)
    void DeleteEmpleadoAsistenciaCap(@Param("id") int dato);

    @Query("SELECT o FROM Empleado o WHERE o.estadoempleado != 0")
    public Iterable<Empleado> listAllActivos();
    
    
    @Query(value = "select \n" +
                        "em.idme,m.codigomision,m.nombremision, \n" +
                        "e.codigoempleado,e.nombreempleado,e.apellidoempleado\n" +
                        "from mision m, empleado e, empleadomision em \n" +
                        "where\n" +
                        "m.codigomision=em.codigomision and \n" +
                        "e.codigoempleado=em.codigoempleado and \n" +
                        "m.codigomision= :id  ", nativeQuery = true)
    List<Object[]> findByMisionesEmpleados(@Param("id") int dato);
    
    
    @Query(value = "select  \n" +
"                        em.idme,m.codigomision,m.nombremision,m.tipomision,m.fechasalidamision\n" +
"                        from mision m, empleado e, empleadomision em \n" +
"                        where\n" +
"                        m.codigomision=em.codigomision and \n" +
"                        e.codigoempleado=em.codigoempleado group by m.codigomision ", nativeQuery = true)
    List<Object[]> findByMisionesAsignadas();
    
     @Query(value = "DELETE FROM  empleadomision  WHERE \n"
            + " codigomision= :id  ", nativeQuery = true)
    void DeleteListadoMision(@Param("id") int dato);
}
