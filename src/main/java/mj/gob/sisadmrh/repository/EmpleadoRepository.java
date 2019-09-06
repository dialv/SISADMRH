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
    @Query(value = "select\n" +
"e.codigoempleado, \n" +
"concat(e.nombreempleado,\" \",e.apellidoempleado)as Empleado,\n" +
"DATE_FORMAT(e.fechaingresoministerio, '%d/%m/%Y') AS Fecha, \n" +
"fa.centroeducativo, \n" +
"e.duiempleado \n" +
"from\n" +
"empleado e ,\n" +
"empleadoformacion f ,\n" +
"formacionacademica fa,\n" +
"puesto p\n" +
"WHERE\n" +
"e.codigoempleado=f.codigoempleado and\n" +
"fa.codigoformacionacademica=f.codigoformacionacademica and\n" +
"e.codigoempleado=f.codigoempleado and\n" +
"e.codigopuesto=p.codigopuesto and\n" +
"p.nombrepuesto like '%Abogado' and\n" +
"e.estadoempleado!= 0  and\n" +
"e.estadoempleado!= 2  and\n" +
"e.estadoempleado!= 4  and e.estadoempleado!= 5  and \n" +
"fa.estadoformacion = 1 and \n" +
"p.estadopuesto != 0 and\n" +
"e.fechaingresoministerio >= STR_TO_DATE(:FINICIAL, '%d/%m/%Y') and\n" +
"e.fechaingresoministerio <= STR_TO_DATE(:FFINAL, '%d/%m/%Y') ",
             nativeQuery = true)
     List<Object[]> findabogados(@Param("FINICIAL") String finicial,
            @Param("FFINAL") String ffinal
          );
     
     
        /* GERAR REPORTE EXEL DE ABOGADOS */
    @Query(value = "select\n" +
"e.codigoempleado, \n" +
"concat(e.nombreempleado,\" \",e.apellidoempleado)as Empleado,\n" +
"DATE_FORMAT(e.fechaingresoministerio, '%d/%m/%Y') AS Fecha, \n" +
"fa.centroeducativo, \n" +
"e.duiempleado \n" +
"from\n" +
"empleado e ,\n" +
"empleadoformacion f ,\n" +
"formacionacademica fa,\n" +
"puesto p\n" +
"WHERE\n" +
"e.codigoempleado=f.codigoempleado and\n" +
"fa.codigoformacionacademica=f.codigoformacionacademica and\n" +
"e.codigoempleado=f.codigoempleado and\n" +
"e.codigopuesto=p.codigopuesto and\n" +
"p.nombrepuesto like '%Notario' and\n" +
"e.estadoempleado!= 0  and\n" +
"e.estadoempleado!= 2  and\n" +
"e.estadoempleado!= 4  and e.estadoempleado!= 5  and  \n" +
"fa.estadoformacion = 1 and \n" +
"p.estadopuesto != 0 and\n" +
"e.fechaingresoministerio >= STR_TO_DATE(:FINICIAL, '%d/%m/%Y') and\n" +
"e.fechaingresoministerio <= STR_TO_DATE(:FFINAL, '%d/%m/%Y') ",
             nativeQuery = true)
     List<Object[]> findByNotario(@Param("FINICIAL") String finicial,
            @Param("FFINAL") String ffinal
          );
     //reporte de Motoristas
       @Query(value = " select \n" +
"e.codigoempleado,concat(e.nombreempleado,' ',e.apellidoempleado) as Empleado,\n" +
"DATE_FORMAT(c.fechafincontrato,'%d/%m/%Y') AS \"Fin contrato\"\n" +
"from \n" +
"empleado e \n" +
"inner join contrato c on e.CODIGOEMPLEADO = c.codigoempleado \n" +
"inner join puesto p on p.codigopuesto = e.codigopuesto \n" +
"where  \n" +
"e.estadoempleado!=0 and p.estadopuesto != 0 and \n" +
"e.estadoempleado!=2 and e.estadoempleado!=4 and e.estadoempleado!=5 and p.estadopuesto!=0 and \n" +
"c.estadocontrato=1 and p.nombrepuesto='Motorista' and\n" +
"c.estadocontrato!=0 and\n" +
"c.fechafincontrato >= STR_TO_DATE(:FINICIAL, '%d/%m/%Y') and \n" +
"c.fechafincontrato <= STR_TO_DATE(:FFINAL, '%d/%m/%Y') ",
             nativeQuery = true)
     List<Object[]> motoristaexel(@Param("FINICIAL") String finicial,
            @Param("FFINAL") String ffinal
          );

    /*GENERAR REPORTE DE RENUNCIAS VOLUNTARIAS */
    @Query(value = "select concat(e.nombreempleado,' ', e.apellidoempleado) as nombres ,p.nombrepuesto,c.salarioactual,DATE_FORMAT(c.fechainiciocontrato, '%d/%m/%Y')as \"Fecha Inicio Contrato\",c.partidacontrato,p.nivelpuesto,DATE_FORMAT(p.fechabaja, '%d/%m/%Y')as \"Baja Contrato\" \n" +
"from empleado e inner join puesto p on e.codigopuesto=p.codigopuesto inner join contrato c on e.codigoempleado=c.codigoempleado "
            + "where e.estadoempleado=6 and  c.estadocontrato=1 and p.estadopuesto<>0 and c.fechainiciocontrato >= STR_TO_DATE(:FINICIAL, '%d/%m/%Y')  and c.fechainiciocontrato  <= STR_TO_DATE(:FFINAL, '%d/%m/%Y')",
             nativeQuery = true)
    List<Object[]> renuncias(@Param("FINICIAL") String finicial,
            @Param("FFINAL") String ffinal);

    /*PARA GENERAR REPORTES DE CUMPLEANIEROS EXEL */
    @Query(value = " SELECT CONCAT( DAY( e.fechanacimientoempleado ) ,  \"/\", ELT( MONTH( e.fechanacimientoempleado ) ,  \"Enero\",  \"Febrero\",  \"Marzo\",  \"Abril\",  \"Mayo\",  \"Junio\",  \"Julio\",  \"Agosto\",  \"Septiembre\",  \"Octubre\", \"Noviembre\",  \"Diciembre\" ) ) AS Fecha, p.nombrepuesto, uf.nombreubicacion, CONCAT( e.nombreempleado,  ' ', e.apellidoempleado ) AS Empleado\n" +
"FROM empleado e\n" +
"INNER JOIN puesto p ON e.codigopuesto = p.codigopuesto\n" +
"INNER JOIN ubicacionfisica uf ON uf.codigoempleado = e.codigoempleado \n" +
"where   e.estadoempleado!=0 and e.estadoempleado!=2 and e.estadoempleado!=4 and e.estadoempleado!=5 and  p.estadopuesto!=0 and uf.estadoubicacion!=0 and  MONTH(e.fechanacimientoempleado)=:FINICIAL ",
             nativeQuery = true)

    List<Object[]> findByCumples(@Param("FINICIAL") String finicial
            );

    /*PARA GENERAR REPORTE DE NIVELES ESCOLARES EXEL */
    @Query(value = " SELECT concat(e.nombreempleado,' ',e.apellidoempleado)as 'nombre', p.nombrepuesto as 'Nombre de Plaza' , n.tituloobtenido as 'Nivel Escolar', n.estudiosrealizados as 'Estudios Realizados', "
            + "DATE_FORMAT(n.fechadesdeformacionacademica, \"%d/ %m /%Y\") as 'Fecha Desde', "
            + "DATE_FORMAT(n.fechahastaformacionacademica, \"%d/ %m /%Y\") as 'Fecha Hasta', n.centroeducativo as 'Institucion Educativa' FROM empleadoformacion en, empleado e, formacionacademica n , puesto p\n" +
"where\n" +
"e.codigopuesto=p.codigopuesto and\n" +
"e.codigoempleado=en.codigoempleado and\n" +
"n.codigoformacionacademica=en.codigoformacionacademica   and p.estadopuesto!=0 and e.estadoempleado!=0 and e.estadoempleado!=2 and e.estadoempleado!=4 and e.estadoempleado!=5 and n.estadoformacion=1 and \n" +
"n.fechadesdeformacionacademica>= STR_TO_DATE(:FINICIAL, '%d/%m/%Y') \n" +
"and n.fechadesdeformacionacademica <= STR_TO_DATE(:FFINAL, '%d/%m/%Y')", nativeQuery = true)
            
    List<Object[]> findByNivelEscolar(@Param("FINICIAL") String finicial,
            @Param("FFINAL") String ffinal);

    /* PARA GNERAR REPORTE PLAZAS OCUPADAS EXEL***************************/
     @Query(value = " SELECT p.codigopuesto as 'codigo Puesto',"
             + "p.nombrepuesto as 'Nombre Puesto',"
             + "concat(e.nombreempleado,' ',e.apellidoempleado) as 'Nombre de Empleado',"
             + "e.sexoempleado as 'Sexo',"
             + "p.sueldobase as 'sueldo Basico'," 
             + "DATE_FORMAT(p.fechacontrataciondesde, \"%d/ %m /%Y\") as 'Fecha de Nombramiento', "
             + "DATE_FORMAT(p.fechacontratacionhasta, \"%d/ %m /%Y\") as 'Fecha de Desvinculacion'," 
             + "p.ubicacionpuesto as 'Ubicacion',"
             + "p.sublinea as 'Linea de Trabajo'" 
             + " FROM `puesto` p , empleado e WHERE  e.codigopuesto=p.codigopuesto and  p.estadopuesto=2 and  e.estadoempleado in(1,3)\n" +
            "and p.fechacontrataciondesde >= STR_TO_DATE(:FINICIAL, '%d/%m/%Y')\n" +
            "and p.fechacontrataciondesde <= STR_TO_DATE(:FFINAL, '%d/%m/%Y')", nativeQuery = true)
    List<Object[]> findByPlazasOcupadas(@Param("FINICIAL") String finicial,
            @Param("FFINAL") String ffinal);

     @Query(value = "SELECT e.codigoempleado,e.nombreempleado,e.apellidoempleado,p.nombrepuesto,p.ubicacionpuesto,DATE_FORMAT(c.fechainiciocontrato, \"%d/ %m /%Y\") as fechainiciocontrato ,c.salarioactual FROM `empleado` e, puesto p, contrato c where e.codigoempleado=c.codigoempleado and e.codigopuesto=p.codigopuesto  and e.estadoempleado in(1,3)\n" +
"and c.estadocontrato=1 and p.estadopuesto != 0 and c.fechainiciocontrato>= STR_TO_DATE(:FINICIAL, '%d/%m/%Y') and c.fechainiciocontrato<= STR_TO_DATE(:FFINAL, '%d/%m/%Y')", nativeQuery = true)
    List<Object[]> ContratacionesExcel(@Param("FINICIAL") String finicial,
            @Param("FFINAL") String ffinal);

    @Query(value = "SELECT e.nombreempleado, e.apellidoempleado,p.ubicacionpuesto,p.nombrepuesto,p.numeropartidapuesto, p.numerosubpartidapuesto,p.sueldobase FROM `empleado` e, puesto p, contrato c where e.codigoempleado=c.codigoempleado and e.codigopuesto=p.codigopuesto and e.estadoempleado=1",
             nativeQuery = true)
    List<Object[]> DespidosExcel(@Param("FINICIAL") String finicial,
            @Param("FFINAL") String ffinal);

    @Query(value = "SELECT count(e.codigoempleado) as nempleados,sum(p.sueldobase) as sumsueldo,p.ubicacionpuesto FROM `empleado`e , puesto p WHERE e.estadoempleado=1 or e.estadoempleado=3 and p.estadopuesto!=0 and e.codigopuesto=p.codigopuesto group by p.ubicacionpuesto and e.fechaingresoministerio >= STR_TO_DATE(:FINICIAL, '%d/%m/%Y')\n" +
"and e.fechaingresoministerio <= STR_TO_DATE(:FFINAL, '%d/%m/%Y'), '%d/%m/%Y'",
             nativeQuery = true)
    List<Object[]> PseronalActivoExcel(@Param("FINICIAL") String finicial,
            @Param("FFINAL") String ffinal);
    


    @Query(value = "SELECT count(a.codigoempleado) as Noempleados, a.ubicacionasistenciacapacitacion as Ubicacion, count(c.nombrecapacitacion) as NoCapacitaciones,c.nombrecapacitacion, DATE_FORMAT(c.fechacapacitaciondesde, \\\"%d/ %m /%Y\\\")  as FechaCapacitacion,c.fechacapacitacionhasta \n"
            + "FROM `asistenciacapacitacion`a ,`capacitacion` c\n"
            + "WHERE c.estadocapacitacion!=0 and a.estadoasistencia!=0 and a.codigocapacitacion=c.codigocapacitacion group by c.nombrecapacitacion,c.fechacapacitaciondesde",
             nativeQuery = true)
    List<Object[]> EstadisticocapacitadoExcel(@Param("FINICIAL") String finicial,
            @Param("FFINAL") String ffinal);

  @Query(value = "SELECT \n"
            + " e.nombreempleado, e.apellidoempleado,e.sexoempleado,p.acuerdo ,p.sueldobase ,"
            + "DATE_FORMAT(p.fechacontrataciondesde, \\\"%d/ %m /%Y\\\")  as fechacontrataciondesde , DATE_FORMAT(p.fechacontratacionhasta, \\\"%d/ %m /%Y\\\")  as fechacontratacionhasta ,p.nombrepuesto,p.ubicacionpuesto\n"
            + "FROM `empleado` e, puesto p ,contrato c,empleadocontrato ec \n"
            + "WHERE  e.codigopuesto=p.codigopuesto and \n" +
"e.codigoempleado=ec.codigoempleado and\n" +
"c.codigocontrato=ec.codigocontrato and c.estadocontrato=1  and e.estadoempleado=2  and p.estadopuesto<>0 and \n" +
"c.fechainiciocontrato>=STR_TO_DATE(:FINICIAL, '%d/%m/%Y') and\n" +
"c.fechainiciocontrato<=STR_TO_DATE(:FFINAL, '%d/%m/%Y') ",
             nativeQuery = true)
    List<Object[]> PersonalIndemnizadooExcel(@Param("FINICIAL") String finicial,
            @Param("FFINAL") String ffinal);

    // PARA GENERAR REPORTE DE EXEL EXONERADO DE MARCACION----------------------------------------------
   
    
    
    @Query(value = " SELECT concat(e.nombreempleado,' ',e.apellidoempleado),p.nombrepuesto,u.nombreubicacion as 'Ubicacion',c.acuerdocuadrodirectivo , "
            + "DATE_FORMAT(c.fechapresentaciondesde,'%d/%m/%Y'), DATE_FORMAT(c.fechapresentacionhasta, '%d/%m/%Y') FROM `empleado` e, puesto p , ubicacionfisica u,"
            + " cuadrodirectivo c WHERE e.codigopuesto=p.codigopuesto and e.codigoempleado=u.codigoempleado and e.codigoempleado=c.codigoempleado and e.estadoempleado in(1,3)and u.estadoubicacion=1 \n" +
"and c.estadocuadrodirectivo=1\n" +
"and p.estadopuesto<>0 "
            + "and c.fechapresentaciondesde >= STR_TO_DATE(:FINICIAL, '%d/%m/%Y') and c.fechapresentaciondesde <= STR_TO_DATE(:FFINAL, '%d/%m/%Y') ", nativeQuery = true)
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
            " FROM `empleado` e, puesto p WHERE e.codigopuesto=p.codigopuesto and e.estadoempleado=3 and p.estadopuesto!=0 and " +
            " e.fechaingresoministerio >= STR_TO_DATE(:FINICIAL, '%d/%m/%Y') " +
            "and e.fechaingresoministerio <= STR_TO_DATE(:FFINAL, '%d/%m/%Y')", nativeQuery = true)
    List<Object[]> findByPensionados(@Param("FINICIAL") String finicial,
            @Param("FFINAL") String ffinal);

    @Query(value = " select p.codigopuesto,p.nombrepuesto,DATE_FORMAT(p.fechacontrataciondesde, '%d/%m/%Y'),DATE_FORMAT(p.fechacontratacionhasta, '%d/%m/%Y'),p.ubicacionpuesto,p.sublinea ,p.numeropartidapuesto,p.numerosubpartidapuesto from puesto p where  p.fechacontratacionhasta >= STR_TO_DATE(:FINICIAL, '%d/%m/%Y') and p.fechacontratacionhasta  <= STR_TO_DATE(:FFINAL, '%d/%m/%Y') ", nativeQuery = true)
    List<Object[]> findByPuestosCaducarExcel(@Param("FINICIAL") String finicial,
            @Param("FFINAL") String ffinal);
//histiral laboral de empleados
    @Query(value = "select e.codigoempleado, concat(e.nombreempleado,' ',e.apellidoempleado)as Empleado ,el.cargo,el.salarioinicial,el.salariofinal,DATE_FORMAT(el.fechadesdeexperiencialaboral, '%d/%m/%Y') as Desde,DATE_FORMAT(el.fechahastaexperiencialaboral, '%d/%m/%Y') as Hasta \n"
            + "from empleado e\n"
            + " inner join puesto p on e.codigopuesto=p.codigopuesto\n"
            + " inner join empleadoexperiencialaboral ex on e.codigoempleado=ex.codigoempleado\n"
            + " inner join experiencialaboral el on ex.codigoexperiencialaboral=el.codigoexperiencialaboral\n"
            + "where e.estadoempleado!=0  and p.estadopuesto!=0 and estadoexp!=0 and\n"
            + "e.codigoempleado=:CODIGO and el.fechadesdeexperiencialaboral >= STR_TO_DATE(:FINICIAL, '%d/%m/%Y')\n"
            + "and el.fechadesdeexperiencialaboral <= STR_TO_DATE(:FFINAL,'%d/%m/%Y')", nativeQuery = true)
    List<Object[]> findByHistorialEmpleados(@Param("CODIGO") String codigo, @Param("FINICIAL") String finicial, @Param("FFINAL") String ffinal);// ES EL METODO DE HISTORIAL LABRORAL
//estado del empeado		
    @Query("SELECT o FROM Empleado o WHERE o.estadoempleado = :id")
    public Iterable<Empleado> getEmpleadosByEstado(@Param("id") int dato);
   
    
//reporte de incapacidad
    @Query(value = " select concat(e.nombreempleado,' ',e.apellidoempleado) as Empleado,i.nombreincapacidad, p.nombrepuesto,e.duiempleado,DATE_FORMAT(i.fechadesdeincapacidad, '%d/%m/%Y') as Desde,DATE_FORMAT(i.fechahastaincapacidad, '%d/%m/%Y') as Hasta , i.numerofichaisss,i.tipoincapacidad,i.formaincapacidad,i.subsidio,DATE_FORMAT(i.fechaemision, '%d/%m/%Y')as \"Fecha Emision\" \n"
            + "from empleado e inner join puesto p on e.codigopuesto=p.codigopuesto\n"
            + " inner join incapacidad i on e.codigoempleado=i.codigoempleado\n"
            + " WHERE\n"
            + "p.estadopuesto!=0 and e.estadoempleado!=0 and i.estadoincapacidad=1 and i.fechadesdeincapacidad >= STR_TO_DATE(:FINICIAL, '%d/%m/%Y')  and i.fechadesdeincapacidad <= STR_TO_DATE(:FFINAL, '%d/%m/%Y') ", nativeQuery = true)
    List<Object[]> findByIncapacidad(
            @Param("FINICIAL") String finicial,
            @Param("FFINAL") String ffinal);

    @Query(value = "SELECT c.nombrecapacitacion,e.nombreempleado,e.apellidoempleado,a.codigoasistenciacapacitacion,e.codigoempleado,a.codigocapacitacion FROM empleado e , capacitacion c ,asistenciacapacitacion a WHERE \n"
            + " c.codigocapacitacion = a.codigocapacitacion and \n"
            + " a.codigoempleado=e.codigoempleado and \n"
            + " a.codigocapacitacion= :id  ", nativeQuery = true)
    List<Object[]> findByDato(@Param("id") int dato);
// Reporte de asistencias capacitacion
    @Query(value = "SELECT c.nombrecapacitacion,s.codigocapacitacion FROM  capacitacion c ,asistenciacapacitacion s WHERE \n"
            + " c.codigocapacitacion = s.codigocapacitacion and \n"
            + " s.codigoasistenciacapacitacion= :id  ", nativeQuery = true)
    List<Object[]> findByAsistenciaCapacitacion(@Param("id") int dato);

    @Query(value = "DELETE FROM  empleadoasistenciacapacitacion  WHERE \n"
            + " codigoempleado= :id  ", nativeQuery = true)
    void DeleteEmpleadoAsistenciaCap(@Param("id") int dato);

    @Query("SELECT o FROM Empleado o WHERE o.estadoempleado != 0")
    public Iterable<Empleado> listAllActivos();
    
    @Query("SELECT o FROM Empleado o WHERE o.estadoempleado != 0 and o.codigopuesto= :idpuesto")
    public Iterable<Empleado> listAllActivosPuestos(@Param("idpuesto") int estado);
    
    
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
    
    @Query("SELECT o FROM Empleado o WHERE o.estadoempleado = 1 or o.estadoempleado = 3")
    public Iterable<Empleado> listAllActivosPensionados();
    
    
@Query(value = "  select e.codigoempleado, concat(e.nombreempleado,' ',e.apellidoempleado)as Empleado ,\n" +
                    "el.cargo,\n" +
                    "el.salarioinicial,\n" +
                    "el.salariofinal,\n" +
                    "DATE_FORMAT(el.fechadesdeexperiencialaboral, '%d/%m/%Y') as Desde,\n" +
                    "DATE_FORMAT(el.fechahastaexperiencialaboral, '%d/%m/%Y') as Hasta \n" +
                    "from \n" +
                    "empleado e,\n" +
                    "contrato c, \n" +
                    "puesto p,\n" +
                    "experiencialaboral el,\n" +
                    "empleadoexperiencialaboral ex \n" +
                    "where \n" +
                    "c.codigopuesto=p.codigopuesto and\n" +
                    "c.codigocontrato=el.codigocontrato and\n" +
                    "e.codigoempleado=ex.codigoempleado and\n" +
                    "e.codigoempleado=c.codigoempleado and\n" +
                    "ex.codigoexperiencialaboral=el.codigoexperiencialaboral and\n" +
                    "p.estadopuesto!=0 and\n" +
                    "el.estadoexp!=0 and\n" +
                    "e.estadoempleado!=0 and\n" +
                    " p.estadopuesto!=0 and \n" +
                    "c.estadocontrato=1 and\n" +
                    "e.codigoempleado=:CODIGO and \n" +
                    "el.fechadesdeexperiencialaboral >= STR_TO_DATE(:FINICIAL, '%d/%m/%Y') and \n" +
                    "el.fechadesdeexperiencialaboral <= STR_TO_DATE(:FFINAL, '%d/%m/%Y')", nativeQuery = true)
    List<Object[]> historialempleadoexcel(
            @Param("FINICIAL") String finicial,
            @Param("FFINAL") String ffinal,@Param("CODIGO") String codigo);
}
