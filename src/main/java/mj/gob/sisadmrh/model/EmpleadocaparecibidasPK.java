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
public class EmpleadocaparecibidasPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "codigoempleado")
    private int codigoempleado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigocaparecibidas")
    private int codigocaparecibidas;

    public EmpleadocaparecibidasPK() {
    }

    public EmpleadocaparecibidasPK(int codigoempleado, int codigocaparecibidas) {
        this.codigoempleado = codigoempleado;
        this.codigocaparecibidas = codigocaparecibidas;
    }

    public int getCodigoempleado() {
        return codigoempleado;
    }

    public void setCodigoempleado(int codigoempleado) {
        this.codigoempleado = codigoempleado;
    }

    public int getCodigocaparecibidas() {
        return codigocaparecibidas;
    }

    public void setCodigocaparecibidas(int codigocaparecibidas) {
        this.codigocaparecibidas = codigocaparecibidas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoempleado;
        hash += (int) codigocaparecibidas;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpleadocaparecibidasPK)) {
            return false;
        }
        EmpleadocaparecibidasPK other = (EmpleadocaparecibidasPK) object;
        if (this.codigoempleado != other.codigoempleado) {
            return false;
        }
        if (this.codigocaparecibidas != other.codigocaparecibidas) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mj.gob.sisadmrh.EmpleadocaparecibidasPK[ codigoempleado=" + codigoempleado + ", codigocaparecibidas=" + codigocaparecibidas + " ]";
    }
    
}
