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
 * @author Casa
 */
@Embeddable
public class EmpleadocontactoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "codigoempleado")
    private int codigoempleado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigocontacto")
    private int codigocontacto;

    public EmpleadocontactoPK() {
    }

    public EmpleadocontactoPK(int codigoempleado, int codigocontacto) {
        this.codigoempleado = codigoempleado;
        this.codigocontacto = codigocontacto;
    }

    public int getCodigoempleado() {
        return codigoempleado;
    }

    public void setCodigoempleado(int codigoempleado) {
        this.codigoempleado = codigoempleado;
    }

    public int getCodigocontacto() {
        return codigocontacto;
    }

    public void setCodigocontacto(int codigocontacto) {
        this.codigocontacto = codigocontacto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoempleado;
        hash += (int) codigocontacto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpleadocontactoPK)) {
            return false;
        }
        EmpleadocontactoPK other = (EmpleadocontactoPK) object;
        if (this.codigoempleado != other.codigoempleado) {
            return false;
        }
        if (this.codigocontacto != other.codigocontacto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mj.gob.sisadmrh.model.EmpleadocontactoPK[ codigoempleado=" + codigoempleado + ", codigocontacto=" + codigocontacto + " ]";
    }
    
}
