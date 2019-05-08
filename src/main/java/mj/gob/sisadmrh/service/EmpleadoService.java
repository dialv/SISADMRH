/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.service;

import java.util.List;
import java.util.Optional;
import mj.gob.sisadmrh.model.Empleado;


/**
 *
 * @author jorge
 */
public interface EmpleadoService {
    Iterable <Empleado> listAllEmpleado();
    Iterable <Empleado> listAllActivos();
     Iterable <Empleado> listAllActivosPensionados();
    
    Optional<Empleado> getEmpleadoById(Integer id);

    Empleado saveEmpleado(Empleado empleado);

    void deleteEmpleado(Integer id);
    
    Iterable <Empleado> findabogados(String finicial, String ffinal, Integer tipo);

    List<Object[]> renuncias(String finicial, String ffinal);

    List<Object[]> ContratacionesExcel(String finicial, String ffinal);
    List<Object[]> DespidosExcel(String finicial, String ffinal);
    List<Object[]> PseronalActivoExcel(String finicial, String ffinal);    
    List<Object[]> EstadisticocapacitadoExcel(String finicial, String ffinal);
    List<Object[]> PersonalIndemnizadooExcel(String finicial, String ffinal);
   
    

    List<Object[]> findBycumples(String finicial, String ffinal);
    List<Object[]> findByNivelEscolar(String finicial, String ffinal);
    List<Object[]> findByPlazasOcupadas(String finicial, String ffinal);
    List<Object[]> findByExoneradoMarcacion(String finicial, String ffinal);
    List<Object[]> findByPensionados(String finicial, String ffinal);
    List<Object[]> findByPuestosCaducarExcel(String finicial, String ffinal);
    List<Object[]> findByPuestosEmpleados( String codigo);//para el historial laboral
    List<Object[]> findByIncapacidad(String finicial, String ffinal);
    List<Object[]> findByDato(int id) ;
    List<Object[]> findByAsistenciaCapacitacion(int id) ;
    List<Object[]> findByMisionesEmpleados(int id) ;
    List<Object[]> findByMisionesAsignadas() ;
   
    void DeleteEmpleadoAsistenciaCap(int id) ;
    void DeleteListadoMision(int id) ;

}
