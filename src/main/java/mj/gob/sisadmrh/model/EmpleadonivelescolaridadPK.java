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
public class EmpleadonivelescolaridadPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "codigoempleado")
    private int codigoempleado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigonivelnivelescolaridad")
    private int codigonivelnivelescolaridad;

    public EmpleadonivelescolaridadPK() {
    }

    public EmpleadonivelescolaridadPK(int codigoempleado, int codigonivelnivelescolaridad) {
        this.codigoempleado = codigoempleado;
        this.codigonivelnivelescolaridad = codigonivelnivelescolaridad;
    }

    public int getCodigoempleado() {
        return codigoempleado;
    }

    public void setCodigoempleado(int codigoempleado) {
        this.codigoempleado = codigoempleado;
    }

    public int getCodigonivelnivelescolaridad() {
        return codigonivelnivelescolaridad;
    }

    public void setCodigonivelnivelescolaridad(int codigonivelnivelescolaridad) {
        this.codigonivelnivelescolaridad = codigonivelnivelescolaridad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoempleado;
        hash += (int) codigonivelnivelescolaridad;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpleadonivelescolaridadPK)) {
            return false;
        }
        EmpleadonivelescolaridadPK other = (EmpleadonivelescolaridadPK) object;
        if (this.codigoempleado != other.codigoempleado) {
            return false;
        }
        if (this.codigonivelnivelescolaridad != other.codigonivelnivelescolaridad) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mj.gob.sisadmrh.EmpleadonivelescolaridadPK[ codigoempleado=" + codigoempleado + ", codigonivelnivelescolaridad=" + codigonivelnivelescolaridad + " ]";
    }
    
}
