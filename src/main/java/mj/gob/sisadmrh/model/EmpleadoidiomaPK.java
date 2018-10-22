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
public class EmpleadoidiomaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "codigoempleado")
    private int codigoempleado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigoidioma")
    private int codigoidioma;

    public EmpleadoidiomaPK() {
    }

    public EmpleadoidiomaPK(int codigoempleado, int codigoidioma) {
        this.codigoempleado = codigoempleado;
        this.codigoidioma = codigoidioma;
    }

    public int getCodigoempleado() {
        return codigoempleado;
    }

    public void setCodigoempleado(int codigoempleado) {
        this.codigoempleado = codigoempleado;
    }

    public int getCodigoidioma() {
        return codigoidioma;
    }

    public void setCodigoidioma(int codigoidioma) {
        this.codigoidioma = codigoidioma;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoempleado;
        hash += (int) codigoidioma;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpleadoidiomaPK)) {
            return false;
        }
        EmpleadoidiomaPK other = (EmpleadoidiomaPK) object;
        if (this.codigoempleado != other.codigoempleado) {
            return false;
        }
        if (this.codigoidioma != other.codigoidioma) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mj.gob.sisadmrh.EmpleadoidiomaPK[ codigoempleado=" + codigoempleado + ", codigoidioma=" + codigoidioma + " ]";
    }
    
}
