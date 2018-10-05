/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.controller.empleadoasistenciacapacitacion;

import java.io.Serializable;
import mj.gob.sisadmrh.model.AsistenciaCapacitacion;
import mj.gob.sisadmrh.model.Empleado;
import mj.gob.sisadmrh.model.Empleadoasistenciacapacitacion;

/**
 *
 * @author jorge
 */
public class EmpleadoAsistenciaCapacitacionForm  implements Serializable{
       private Iterable<Empleado> empleados;
      private Iterable<AsistenciaCapacitacion> asistenciaCapacitaciones;
      private Empleadoasistenciacapacitacion empleadoasistenciacapacitacion;

    public Iterable<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Iterable<Empleado> empleados) {
        this.empleados = empleados;
    }

    public Iterable<AsistenciaCapacitacion> getAistenciaCapacitaciones() {
        return asistenciaCapacitaciones;
    }

    public void setAsistenciaCapacitaciones(Iterable<AsistenciaCapacitacion> asistenciaCapacitaciones) {
        this.asistenciaCapacitaciones = asistenciaCapacitaciones;
    }

    public Empleadoasistenciacapacitacion getEmpleadoasistenciacapacitacion() {
        return empleadoasistenciacapacitacion;
    }

    public void setEmpleadoasistenciacapacitacion(Empleadoasistenciacapacitacion empleadoasistenciacapacitacion) {
        this.empleadoasistenciacapacitacion = empleadoasistenciacapacitacion;
    }
      
    
}
