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
public class EmpleadoformacionPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "codigoempleado")
    private int codigoempleado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigoformacionacademica")
    private int codigoformacionacademica;

    public EmpleadoformacionPK() {
    }

    public EmpleadoformacionPK(int codigoempleado, int codigoformacionacademica) {
        this.codigoempleado = codigoempleado;
        this.codigoformacionacademica = codigoformacionacademica;
    }

    public int getCodigoempleado() {
        return codigoempleado;
    }

    public void setCodigoempleado(int codigoempleado) {
        this.codigoempleado = codigoempleado;
    }

    public int getCodigoformacionacademica() {
        return codigoformacionacademica;
    }

    public void setCodigoformacionacademica(int codigoformacionacademica) {
        this.codigoformacionacademica = codigoformacionacademica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoempleado;
        hash += (int) codigoformacionacademica;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpleadoformacionPK)) {
            return false;
        }
        EmpleadoformacionPK other = (EmpleadoformacionPK) object;
        if (this.codigoempleado != other.codigoempleado) {
            return false;
        }
        if (this.codigoformacionacademica != other.codigoformacionacademica) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mj.gob.sisadmrh.EmpleadoformacionPK[ codigoempleado=" + codigoempleado + ", codigoformacionacademica=" + codigoformacionacademica + " ]";
    }
    
}
