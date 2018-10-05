package mj.gob.sisadmrh.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jorge
 */
@Embeddable
public class EmpleadoasistenciacapacitacionPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CODIGOEMPLEADO")
    private Integer codigoempleado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGOASISTENCIACAPACITACION")
    private int codigoasistenciacapacitacion;

    public EmpleadoasistenciacapacitacionPK() {
    }

    public EmpleadoasistenciacapacitacionPK(Integer codigoempleado, int codigoasistenciacapacitacion) {
        this.codigoempleado = codigoempleado;
        this.codigoasistenciacapacitacion = codigoasistenciacapacitacion;
    }

    public Integer getCodigoempleado() {
        return codigoempleado;
    }

    public void setCodigoempleado(Integer codigoempleado) {
        this.codigoempleado = codigoempleado;
    }

    public int getCodigoasistenciacapacitacion() {
        return codigoasistenciacapacitacion;
    }

    public void setCodigoasistenciacapacitacion(int codigoasistenciacapacitacion) {
        this.codigoasistenciacapacitacion = codigoasistenciacapacitacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoempleado != null ? codigoempleado.hashCode() : 0);
        hash += (int) codigoasistenciacapacitacion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpleadoasistenciacapacitacionPK)) {
            return false;
        }
        EmpleadoasistenciacapacitacionPK other = (EmpleadoasistenciacapacitacionPK) object;
        if ((this.codigoempleado == null && other.codigoempleado != null) || (this.codigoempleado != null && !this.codigoempleado.equals(other.codigoempleado))) {
            return false;
        }
        if (this.codigoasistenciacapacitacion != other.codigoasistenciacapacitacion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.EmpleadoasistenciacapacitacionPK[ codigoempleado=" + codigoempleado + ", codigoasistenciacapacitacion=" + codigoasistenciacapacitacion + " ]";
    }
    
}
