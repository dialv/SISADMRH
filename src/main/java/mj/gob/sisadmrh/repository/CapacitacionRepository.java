/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.repository;

import java.util.List;
import mj.gob.sisadmrh.model.Capacitacion;
import mj.gob.sisadmrh.model.Capacitador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author daniel
 */
public interface CapacitacionRepository extends CrudRepository<Capacitacion, Integer>{
    @Query(value = "SELECT c.* FROM capacitacion c "
            + "WHERE c.nombrecapacitacion LIKE :nom ", nativeQuery = true)

    Iterable<Capacitacion> findByDato(@Param("nom") String dato);

    
    
    
    
    
    
    // consulta para generar el exel
 @Query(value = "SELECT  concat(e.nombreempleado,' ',e.apellidoempleado),p.nombrepuesto,ca.duracionhoracapacitacion,ca.nombrecapacitacion,\n" +
"ca.departamentoresponsable,DATE_FORMAT(ca.fechacapacitaciondesde, '%d/%m/%Y'), DATE_FORMAT(ca.fechacapacitacionhasta, '%d/%m/%Y')  from empleado e \n" +
"\n" +
" inner join puesto p on e.codigopuesto=p.codigopuesto \n" +
" inner join empleadocapacitacion ec on e.codigoempleado=ec.codigoempleado\n" +
" INNER JOIN capacitacion ca on ec.codigocapacitacion=ca.codigocapacitacion" 
+ " where " 
+ " fechacapacitaciondesde >= :FINICIAL " 
+ " and ca.fechacapacitacionhasta  <= :FFINAL ", 
         nativeQuery = true)

    public List<Object[]> findByCapacitacionesR(@Param("FINICIAL") String finicial, 
                                             @Param("FFINAL") String ffinal);
                                             ;
    
    @Query("SELECT o FROM Capacitacion o WHERE o.estadocapacitacion != 0")
    public Iterable<Capacitacion> listAllActivos(); 
    
      @Query(value="SELECT\n" +
                    "     capacitador.codigocapacitador,\n" +
                    "     capacitador.carnetresidencia ,\n" +
                    "     capacitador.duicapacitador ,\n" +
                    "     capacitador.emailcapacitador,\n" +
                    "     capacitador.nitcapacitador ,\n" +
                    "     capacitador.nombrecapacitador ,\n" +
                    "     capacitador.telefonocapacitador ,\n" +
                    "     capacitador.telefonomovilcapacitador ,\n" +
                    "     capacitador.temadominio ,\n" +
                    "     capacitador.tipocapacitador ,\n" +
                    "     capacitador.codigoempleado ,\n" +
                    "     capacitador.institucioncapacitador ,\n" +
                    "     capacitador.tipoagrupacion \n" +
                    "FROM\n" +
                    "     capacitador capacitador"
            , nativeQuery = true) 
            Iterable <Capacitador> findCapacitadores(@Param("FINICIAL") String finicial, 
                                             @Param("FFINAL") String ffinal);
            
              @Query(value = "SELECT  co.`numeropersona` as 'Cantidad de Personas',c.nombrecapacitacion as 'Tema',co.`costopersona` as'Costo por Persona', (co.`costocapacitador`+(co.`numeropersona`*co.`costopersona`)) as 'Costo Total'\n" +
"FROM `costocapacitacion`co,capacitacion c \n" +
"WHERE co.`codigocapacitacion`=c.`codigocapacitacion`"
          ,nativeQuery = true)
  List<Object[]> CostoCapacitacionExcel(@Param("FINICIAL") String finicial, 
                                             @Param("FFINAL") String ffinal);
  
  @Query(value = "SELECT c.nombrecapacitacion,ca.nombrecapacitador,e.lugarcapacitacion, DATE_FORMAT(c.fechacapacitacion, \\\"%d/ %m /%Y\\\") as fechacapacitacion,e.horaevualuacioncapacitacion,e.dominiotema,e.habilidadcomunicacion,e.espectativa,e.contenidoaplicadotrabajo,"
          + "e.claridadtema, e.materialutilizado,e.alclaradudas,e.interestema,e.satifacciondetema,e.interestemae.comprenciondetema,e.contenidoclaro,e.satifacciondetema,e.contenidoaplicadotrabajo,e.satisfechocontenido "
          + "e."
          + " FROM `evaluacioncapacitacion` e, capacitacion c,capacitador ca  WHERE e.`codigocapacitacion`=c.`codigocapacitacion` and c.`codigocapacitador`=ca.`codigocapacitador` and  e.`codigocapacitacion`= :CODIGO \n" +
"and c.fechacapacitaciondesde >= :FINICIAL\n" +
"and c.fechacapacitacionhasta <= :FFINAL", 
         nativeQuery = true)

    public List<Object[]> EvaluacionCapacitacionesExcel(@Param("FINICIAL") String finicial, 
                                             @Param("FFINAL") String ffinal,
                                             @Param("CODIGO") String codigo);
}

