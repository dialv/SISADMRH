/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Casa
 */
@Entity
@Table(name = "empleadocontacto")
@NamedQueries({
    @NamedQuery(name = "Empleadocontacto.findAll", query = "SELECT e FROM Empleadocontacto e")})
public class Empleadocontacto implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EmpleadocontactoPK empleadocontactoPK;
    @JoinColumn(name = "codigocontacto", referencedColumnName = "codigocontacto", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Contacto contacto;
    @JoinColumn(name = "codigoempleado", referencedColumnName = "codigoempleado", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Empleado empleado;

    public Empleadocontacto() {
    }

    public Empleadocontacto(EmpleadocontactoPK empleadocontactoPK) {
        this.empleadocontactoPK = empleadocontactoPK;
    }

    public Empleadocontacto(int codigoempleado, int codigocontacto) {
        this.empleadocontactoPK = new EmpleadocontactoPK(codigoempleado, codigocontacto);
    }

    public EmpleadocontactoPK getEmpleadocontactoPK() {
        return empleadocontactoPK;
    }

    public void setEmpleadocontactoPK(EmpleadocontactoPK empleadocontactoPK) {
        this.empleadocontactoPK = empleadocontactoPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empleadocontactoPK != null ? empleadocontactoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleadocontacto)) {
            return false;
        }
        Empleadocontacto other = (Empleadocontacto) object;
        if ((this.empleadocontactoPK == null && other.empleadocontactoPK != null) || (this.empleadocontactoPK != null && !this.empleadocontactoPK.equals(other.empleadocontactoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mj.gob.sisadmrh.model.Empleadocontacto[ empleadocontactoPK=" + empleadocontactoPK + " ]";
    }
    
}
