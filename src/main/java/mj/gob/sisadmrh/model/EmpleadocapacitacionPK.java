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
public class EmpleadocapacitacionPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CODIGOEMPLEADO")
    private String codigoempleado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGOCAPACITACION")
    private int codigocapacitacion;

    public EmpleadocapacitacionPK() {
    }

    public EmpleadocapacitacionPK(String codigoempleado, int codigocapacitacion) {
        this.codigoempleado = codigoempleado;
        this.codigocapacitacion = codigocapacitacion;
    }

    public String getCodigoempleado() {
        return codigoempleado;
    }

    public void setCodigoempleado(String codigoempleado) {
        this.codigoempleado = codigoempleado;
    }

    public int getCodigocapacitacion() {
        return codigocapacitacion;
    }

    public void setCodigocapacitacion(int codigocapacitacion) {
        this.codigocapacitacion = codigocapacitacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoempleado != null ? codigoempleado.hashCode() : 0);
        hash += (int) codigocapacitacion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpleadocapacitacionPK)) {
            return false;
        }
        EmpleadocapacitacionPK other = (EmpleadocapacitacionPK) object;
        if ((this.codigoempleado == null && other.codigoempleado != null) || (this.codigoempleado != null && !this.codigoempleado.equals(other.codigoempleado))) {
            return false;
        }
        if (this.codigocapacitacion != other.codigocapacitacion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.EmpleadocapacitacionPK[ codigoempleado=" + codigoempleado + ", codigocapacitacion=" + codigocapacitacion + " ]";
    }
    
}
