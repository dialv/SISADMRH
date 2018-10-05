/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.controller.empleadocapacitacion;

import java.io.Serializable;
import mj.gob.sisadmrh.model.Capacitacion;
import mj.gob.sisadmrh.model.Empleado;
import mj.gob.sisadmrh.model.Empleadocapacitacion;

/**
 *
 * @author jorge
 */
public class EmpleadoCapacitacionForm implements Serializable{
    private Iterable<Empleado> empleados;
      private Iterable<Capacitacion> capacitaciones;
      private Empleadocapacitacion empleadocapacitacion;

    public Iterable<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Iterable<Empleado> empleados) {
        this.empleados = empleados;
    }

    public Iterable<Capacitacion> getCapacitaciones() {
        return capacitaciones;
    }

    public void setCapacitaciones(Iterable<Capacitacion> capacitaciones) {
        this.capacitaciones = capacitaciones;
    }

    public Empleadocapacitacion getEmpleadocapacitacion() {
        return empleadocapacitacion;
    }

    public void setEmpleadocapacitacion(Empleadocapacitacion empleadocapacitacion) {
        this.empleadocapacitacion = empleadocapacitacion;
    }
    
}
