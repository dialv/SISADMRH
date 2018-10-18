package mj.gob.sisadmrh.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author jorge
 */
@Entity
@Table(name = "empleadocapacitacion")
@NamedQueries({
    @NamedQuery(name = "Empleadocapacitacion.findAll", query = "SELECT e FROM Empleadocapacitacion e")})
public class Empleadocapacitacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EmpleadocapacitacionPK empleadocapacitacionPK;
  @JoinColumn(name = "CODIGOCAPACITACION", referencedColumnName = "CODIGOCAPACITACION", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Capacitacion capacitacion;

    public Capacitacion getCapacitacion() {
        return capacitacion;
    }

    public void setCapacitacion(Capacitacion capacitacion) {
        this.capacitacion = capacitacion;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    @JoinColumn(name = "CODIGOEMPLEADO", referencedColumnName = "CODIGOEMPLEADO", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Empleado empleado;
    public Empleadocapacitacion() {
    }

    public Empleadocapacitacion(EmpleadocapacitacionPK empleadocapacitacionPK) {
        this.empleadocapacitacionPK = empleadocapacitacionPK;
    }

    public Empleadocapacitacion(Integer codigoempleado, int codigocapacitacion) {
        this.empleadocapacitacionPK = new EmpleadocapacitacionPK(codigoempleado, codigocapacitacion);
    }

    public EmpleadocapacitacionPK getEmpleadocapacitacionPK() {
        return empleadocapacitacionPK;
    }

    public void setEmpleadocapacitacionPK(EmpleadocapacitacionPK empleadocapacitacionPK) {
        this.empleadocapacitacionPK = empleadocapacitacionPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empleadocapacitacionPK != null ? empleadocapacitacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleadocapacitacion)) {
            return false;
        }
        Empleadocapacitacion other = (Empleadocapacitacion) object;
        if ((this.empleadocapacitacionPK == null && other.empleadocapacitacionPK != null) || (this.empleadocapacitacionPK != null && !this.empleadocapacitacionPK.equals(other.empleadocapacitacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Empleadocapacitacion[ empleadocapacitacionPK=" + empleadocapacitacionPK + " ]";
    }
    
}
