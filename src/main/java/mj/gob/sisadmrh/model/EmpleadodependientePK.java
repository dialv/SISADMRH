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
public class EmpleadodependientePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "codigoempleado")
    private int codigoempleado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigodependiente")
    private int codigodependiente;

    public EmpleadodependientePK() {
    }

    public EmpleadodependientePK(int codigoempleado, int codigodependiente) {
        this.codigoempleado = codigoempleado;
        this.codigodependiente = codigodependiente;
    }

    public int getCodigoempleado() {
        return codigoempleado;
    }

    public void setCodigoempleado(int codigoempleado) {
        this.codigoempleado = codigoempleado;
    }

    public int getCodigodependiente() {
        return codigodependiente;
    }

    public void setCodigodependiente(int codigodependiente) {
        this.codigodependiente = codigodependiente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoempleado;
        hash += (int) codigodependiente;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpleadodependientePK)) {
            return false;
        }
        EmpleadodependientePK other = (EmpleadodependientePK) object;
        if (this.codigoempleado != other.codigoempleado) {
            return false;
        }
        if (this.codigodependiente != other.codigodependiente) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mj.gob.sisadmrh.EmpleadodependientePK[ codigoempleado=" + codigoempleado + ", codigodependiente=" + codigodependiente + " ]";
    }
    
}
