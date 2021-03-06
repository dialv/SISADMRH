/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.model;

import java.io.Serializable;
import java.util.Date;
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
 * @author root
 */
@Entity
@Table(name = "empleadoasistenciacapacitacion")
@NamedQueries({
    @NamedQuery(name = "Empleadoasistenciacapacitacion.findAll", query = "SELECT e FROM Empleadoasistenciacapacitacion e")})
public class Empleadoasistenciacapacitacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EmpleadoasistenciacapacitacionPK empleadoasistenciacapacitacionPK;
   @JoinColumn(name = "codigoasistenciacapacitacion", referencedColumnName = "codigoasistenciacapacitacion", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private AsistenciaCapacitacion asistenciacapacitacion;
    @JoinColumn(name = "codigoempleado", referencedColumnName = "codigoempleado", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Empleado empleado;
    
   

    public Empleadoasistenciacapacitacion() {
    }

    public AsistenciaCapacitacion getAsistenciaCapacitacion() {
        return asistenciacapacitacion;
    }

    public void setAsistenciaCapacitacion(AsistenciaCapacitacion asistenciaCapacitacion) {
        this.asistenciacapacitacion = asistenciaCapacitacion;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Empleadoasistenciacapacitacion(EmpleadoasistenciacapacitacionPK empleadoasistenciacapacitacionPK) {
        this.empleadoasistenciacapacitacionPK = empleadoasistenciacapacitacionPK;
    }

    public Empleadoasistenciacapacitacion(int codigoempleado, int codigoasistenciacapacitacion, Date fecha) {
        this.empleadoasistenciacapacitacionPK = new EmpleadoasistenciacapacitacionPK(codigoempleado, codigoasistenciacapacitacion, fecha);
    }

    public EmpleadoasistenciacapacitacionPK getEmpleadoasistenciacapacitacionPK() {
        return empleadoasistenciacapacitacionPK;
    }

    public void setEmpleadoasistenciacapacitacionPK(EmpleadoasistenciacapacitacionPK empleadoasistenciacapacitacionPK) {
        this.empleadoasistenciacapacitacionPK = empleadoasistenciacapacitacionPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empleadoasistenciacapacitacionPK != null ? empleadoasistenciacapacitacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleadoasistenciacapacitacion)) {
            return false;
        }
        Empleadoasistenciacapacitacion other = (Empleadoasistenciacapacitacion) object;
        if ((this.empleadoasistenciacapacitacionPK == null && other.empleadoasistenciacapacitacionPK != null) || (this.empleadoasistenciacapacitacionPK != null && !this.empleadoasistenciacapacitacionPK.equals(other.empleadoasistenciacapacitacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mj.gob.sisadmrh.model.Empleadoasistenciacapacitacion[ empleadoasistenciacapacitacionPK=" + empleadoasistenciacapacitacionPK + " ]";
    }
    
}
