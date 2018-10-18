/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.controller.capacitacion;

import java.io.Serializable;
import mj.gob.sisadmrh.model.Capacitador;
import mj.gob.sisadmrh.model.Empleadocapacitacion;

/**
 *
 * @author jorge
 */
public class CapacitacionForm  implements Serializable{
     private Iterable<Capacitador> capacitador ;
    private Iterable<Empleadocapacitacion> empleadocapacitaciones ;

    private Object[] complement;

    public Iterable<Capacitador> getCapacitador() {
        return capacitador;
    }

    public void setCapacitador(Iterable<Capacitador> capacitador) {
        this.capacitador = capacitador;
    }

  

   

    public Iterable<Empleadocapacitacion> getEmpleadocapacitaciones() {
        return empleadocapacitaciones;
    }

    public void setEmpleadocapacitaciones(Iterable<Empleadocapacitacion> empleadocapacitaciones) {
        this.empleadocapacitaciones = empleadocapacitaciones;
    }

    public Object[] getComplement() {
        return complement;
    }

    public void setComplement(Object[] complement) {
        this.complement = complement;
    }
    
    
}
