/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.controller.EvaluacionCapacitacion;

import java.io.Serializable;
import mj.gob.sisadmrh.model.Capacitacion;
import mj.gob.sisadmrh.model.EvaluacionCapacitacion;

/**
 *
 * @author root
 */
public class EvaluacionCapacitacionForm implements Serializable{
    private EvaluacionCapacitacion evaluacioncapacitacion ;
     private Iterable<Capacitacion> capacitaciones ;

    public EvaluacionCapacitacion getEvaluacioncapacitacion() {
        return evaluacioncapacitacion;
    }

    public void setEvaluacioncapacitacion(EvaluacionCapacitacion evaluacioncapacitacion) {
        this.evaluacioncapacitacion = evaluacioncapacitacion;
    }

    public Iterable<Capacitacion> getCapacitaciones() {
        return capacitaciones;
    }

    public void setCapacitaciones(Iterable<Capacitacion> capacitaciones) {
        this.capacitaciones = capacitaciones;
    }

}
