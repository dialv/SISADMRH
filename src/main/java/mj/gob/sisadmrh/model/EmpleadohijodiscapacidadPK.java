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
public class EmpleadohijodiscapacidadPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "codigoempleado")
    private int codigoempleado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigohijodiscapacidad")
    private int codigohijodiscapacidad;

    public EmpleadohijodiscapacidadPK() {
    }

    public EmpleadohijodiscapacidadPK(int codigoempleado, int codigohijodiscapacidad) {
        this.codigoempleado = codigoempleado;
        this.codigohijodiscapacidad = codigohijodiscapacidad;
    }

    public int getCodigoempleado() {
        return codigoempleado;
    }

    public void setCodigoempleado(int codigoempleado) {
        this.codigoempleado = codigoempleado;
    }

    public int getCodigohijodiscapacidad() {
        return codigohijodiscapacidad;
    }

    public void setCodigohijodiscapacidad(int codigohijodiscapacidad) {
        this.codigohijodiscapacidad = codigohijodiscapacidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoempleado;
        hash += (int) codigohijodiscapacidad;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpleadohijodiscapacidadPK)) {
            return false;
        }
        EmpleadohijodiscapacidadPK other = (EmpleadohijodiscapacidadPK) object;
        if (this.codigoempleado != other.codigoempleado) {
            return false;
        }
        if (this.codigohijodiscapacidad != other.codigohijodiscapacidad) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mj.gob.sisadmrh.EmpleadohijodiscapacidadPK[ codigoempleado=" + codigoempleado + ", codigohijodiscapacidad=" + codigohijodiscapacidad + " ]";
    }
    
}
