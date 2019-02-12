/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author root
 */
@Embeddable
public class EmpleadoasistenciacapacitacionPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "codigoempleado")
    private int codigoempleado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigoasistenciacapacitacion")
    private int codigoasistenciacapacitacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    public EmpleadoasistenciacapacitacionPK() {
    }

    public EmpleadoasistenciacapacitacionPK(int codigoempleado, int codigoasistenciacapacitacion, Date fecha) {
        this.codigoempleado = codigoempleado;
        this.codigoasistenciacapacitacion = codigoasistenciacapacitacion;
        this.fecha = fecha;
    }

    public int getCodigoempleado() {
        return codigoempleado;
    }

    public void setCodigoempleado(int codigoempleado) {
        this.codigoempleado = codigoempleado;
    }

    public int getCodigoasistenciacapacitacion() {
        return codigoasistenciacapacitacion;
    }

    public void setCodigoasistenciacapacitacion(int codigoasistenciacapacitacion) {
        this.codigoasistenciacapacitacion = codigoasistenciacapacitacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoempleado;
        hash += (int) codigoasistenciacapacitacion;
        hash += (fecha != null ? fecha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpleadoasistenciacapacitacionPK)) {
            return false;
        }
        EmpleadoasistenciacapacitacionPK other = (EmpleadoasistenciacapacitacionPK) object;
        if (this.codigoempleado != other.codigoempleado) {
            return false;
        }
        if (this.codigoasistenciacapacitacion != other.codigoasistenciacapacitacion) {
            return false;
        }
        if ((this.fecha == null && other.fecha != null) || (this.fecha != null && !this.fecha.equals(other.fecha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mj.gob.sisadmrh.model.EmpleadoasistenciacapacitacionPK[ codigoempleado=" + codigoempleado + ", codigoasistenciacapacitacion=" + codigoasistenciacapacitacion + ", fecha=" + fecha + " ]";
    }
    
}
