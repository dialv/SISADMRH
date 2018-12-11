/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author root
 */
@Entity
@Table(name = "miembroscomision")
@NamedQueries({
    @NamedQuery(name = "Miembroscomision.findAll", query = "SELECT m FROM Miembroscomision m")})
public class Miembroscomision implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGOEMPLEADO")
    private Integer codigoempleado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigocomision")
    private int codigocomision;

    public Miembroscomision() {
    }

    public Miembroscomision(Integer codigoempleado) {
        this.codigoempleado = codigoempleado;
    }

    public Miembroscomision(Integer codigoempleado, int codigocomision) {
        this.codigoempleado = codigoempleado;
        this.codigocomision = codigocomision;
    }

    public Integer getCodigoempleado() {
        return codigoempleado;
    }

    public void setCodigoempleado(Integer codigoempleado) {
        this.codigoempleado = codigoempleado;
    }

    public int getCodigocomision() {
        return codigocomision;
    }

    public void setCodigocomision(int codigocomision) {
        this.codigocomision = codigocomision;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoempleado != null ? codigoempleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Miembroscomision)) {
            return false;
        }
        Miembroscomision other = (Miembroscomision) object;
        if ((this.codigoempleado == null && other.codigoempleado != null) || (this.codigoempleado != null && !this.codigoempleado.equals(other.codigoempleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mj.gob.sisadmrh.model.Miembroscomision[ codigoempleado=" + codigoempleado + " ]";
    }
    
}
