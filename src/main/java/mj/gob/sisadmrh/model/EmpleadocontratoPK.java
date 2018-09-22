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
public class EmpleadocontratoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "codigoempleado")
    private int codigoempleado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigocontrato")
    private int codigocontrato;

    public EmpleadocontratoPK() {
    }

    public EmpleadocontratoPK(int codigoempleado, int codigocontrato) {
        this.codigoempleado = codigoempleado;
        this.codigocontrato = codigocontrato;
    }

    public int getCodigoempleado() {
        return codigoempleado;
    }

    public void setCodigoempleado(int codigoempleado) {
        this.codigoempleado = codigoempleado;
    }

    public int getCodigocontrato() {
        return codigocontrato;
    }

    public void setCodigocontrato(int codigocontrato) {
        this.codigocontrato = codigocontrato;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoempleado;
        hash += (int) codigocontrato;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpleadocontratoPK)) {
            return false;
        }
        EmpleadocontratoPK other = (EmpleadocontratoPK) object;
        if (this.codigoempleado != other.codigoempleado) {
            return false;
        }
        if (this.codigocontrato != other.codigocontrato) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mj.gob.sisadmrh.EmpleadocontratoPK[ codigoempleado=" + codigoempleado + ", codigocontrato=" + codigocontrato + " ]";
    }
    
}
