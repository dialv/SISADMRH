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
public class EmpleadoexperiencialaboralPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "codigoempleado")
    private int codigoempleado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigoexperiencialaboral")
    private int codigoexperiencialaboral;

    public EmpleadoexperiencialaboralPK() {
    }

    public EmpleadoexperiencialaboralPK(int codigoempleado, int codigoexperiencialaboral) {
        this.codigoempleado = codigoempleado;
        this.codigoexperiencialaboral = codigoexperiencialaboral;
    }

    public int getCodigoempleado() {
        return codigoempleado;
    }

    public void setCodigoempleado(int codigoempleado) {
        this.codigoempleado = codigoempleado;
    }

    public int getCodigoexperiencialaboral() {
        return codigoexperiencialaboral;
    }

    public void setCodigoexperiencialaboral(int codigoexperiencialaboral) {
        this.codigoexperiencialaboral = codigoexperiencialaboral;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoempleado;
        hash += (int) codigoexperiencialaboral;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpleadoexperiencialaboralPK)) {
            return false;
        }
        EmpleadoexperiencialaboralPK other = (EmpleadoexperiencialaboralPK) object;
        if (this.codigoempleado != other.codigoempleado) {
            return false;
        }
        if (this.codigoexperiencialaboral != other.codigoexperiencialaboral) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mj.gob.sisadmrh.model.EmpleadoexperiencialaboralPK[ codigoempleado=" + codigoempleado + ", codigoexperiencialaboral=" + codigoexperiencialaboral + " ]";
    }
    
}
