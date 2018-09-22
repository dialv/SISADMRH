/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author developer
 */
@Entity
@Table(name = "empleadocaparecibidas")
@NamedQueries({
    @NamedQuery(name = "Empleadocaparecibidas.findAll", query = "SELECT e FROM Empleadocaparecibidas e")})
public class Empleadocaparecibidas implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EmpleadocaparecibidasPK empleadocaparecibidasPK;

    public Empleadocaparecibidas() {
    }

    public Empleadocaparecibidas(EmpleadocaparecibidasPK empleadocaparecibidasPK) {
        this.empleadocaparecibidasPK = empleadocaparecibidasPK;
    }

    public Empleadocaparecibidas(int codigoempleado, int codigocaparecibidas) {
        this.empleadocaparecibidasPK = new EmpleadocaparecibidasPK(codigoempleado, codigocaparecibidas);
    }

    public EmpleadocaparecibidasPK getEmpleadocaparecibidasPK() {
        return empleadocaparecibidasPK;
    }

    public void setEmpleadocaparecibidasPK(EmpleadocaparecibidasPK empleadocaparecibidasPK) {
        this.empleadocaparecibidasPK = empleadocaparecibidasPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empleadocaparecibidasPK != null ? empleadocaparecibidasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleadocaparecibidas)) {
            return false;
        }
        Empleadocaparecibidas other = (Empleadocaparecibidas) object;
        if ((this.empleadocaparecibidasPK == null && other.empleadocaparecibidasPK != null) || (this.empleadocaparecibidasPK != null && !this.empleadocaparecibidasPK.equals(other.empleadocaparecibidasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mj.gob.sisadmrh.Empleadocaparecibidas[ empleadocaparecibidasPK=" + empleadocaparecibidasPK + " ]";
    }
    
}
