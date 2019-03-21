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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author developer
 */
@Entity
@Table(name = "empleadomision")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleadomision.findAll", query = "SELECT e FROM Empleadomision e"),
//    @NamedQuery(name = "Empleadomision.findByIdme", query = "SELECT e FROM Empleadomision e WHERE e.idme = :idme"),
//    @NamedQuery(name = "Empleadomision.findByCodigoempleado", query = "SELECT e FROM Empleadomision e WHERE e.codigoempleado = :codigoempleado"),
//    @NamedQuery(name = "Empleadomision.findByCodigomision", query = "SELECT e FROM Empleadomision e WHERE e.codigomision = :codigomision")
})
public class Empleadomision implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idme")
    private Integer idme;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigoempleado")
    private int codigoempleado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigomision")
    private int codigomision;

    public Empleadomision() {
    }

    public Empleadomision(Integer idme) {
        this.idme = idme;
    }

    public Empleadomision(Integer idme, int codigoempleado, int codigomision) {
        this.idme = idme;
        this.codigoempleado = codigoempleado;
        this.codigomision = codigomision;
    }

    public Integer getIdme() {
        return idme;
    }

    public void setIdme(Integer idme) {
        this.idme = idme;
    }

    public int getCodigoempleado() {
        return codigoempleado;
    }

    public void setCodigoempleado(int codigoempleado) {
        this.codigoempleado = codigoempleado;
    }

    public int getCodigomision() {
        return codigomision;
    }

    public void setCodigomision(int codigomision) {
        this.codigomision = codigomision;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idme != null ? idme.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleadomision)) {
            return false;
        }
        Empleadomision other = (Empleadomision) object;
        if ((this.idme == null && other.idme != null) || (this.idme != null && !this.idme.equals(other.idme))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mj.gob.sisadmrh.model.Empleadomision[ idme=" + idme + " ]";
    }
    
}
