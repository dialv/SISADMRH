/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author developer
 */
@Embeddable
public class EmpleadoubicacionfisicaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "codigoempleado")
    private int codigoempleado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigoubicacion")
    private int codigoubicacion;

    public EmpleadoubicacionfisicaPK() {
    }

    public EmpleadoubicacionfisicaPK(int codigoempleado, int codigoubicacion) {
        this.codigoempleado = codigoempleado;
        this.codigoubicacion = codigoubicacion;
    }

    public int getCodigoempleado() {
        return codigoempleado;
    }

    public void setCodigoempleado(int codigoempleado) {
        this.codigoempleado = codigoempleado;
    }

    public int getCodigoubicacion() {
        return codigoubicacion;
    }

    public void setCodigoubicacion(int codigoubicacion) {
        this.codigoubicacion = codigoubicacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoempleado;
        hash += (int) codigoubicacion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpleadoubicacionfisicaPK)) {
            return false;
        }
        EmpleadoubicacionfisicaPK other = (EmpleadoubicacionfisicaPK) object;
        if (this.codigoempleado != other.codigoempleado) {
            return false;
        }
        if (this.codigoubicacion != other.codigoubicacion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mj.gob.sisadmrh.EmpleadoubicacionfisicaPK[ codigoempleado=" + codigoempleado + ", codigoubicacion=" + codigoubicacion + " ]";
    }
    
}
