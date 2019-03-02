/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author root
 */
@Entity
@Table(name = "beneficio")
@NamedQueries({
    @NamedQuery(name = "Beneficio.findAll", query = "SELECT b FROM Beneficio b")})
public class Beneficio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "CODIGOBENEFICIO")
    private Integer codigobeneficio;
    @Size(max = 30)
    @Column(name = "NOMBREBENEFICIO")
    private String nombrebeneficio;
    @Size(max = 100)
    @Column(name = "DESCRIPCIONBENEFICIO")
    private String descripcionbeneficio;
    @Column(name = "FECHAINICIOBENEFICIO")
    @Temporal(TemporalType.DATE)
    private Date fechainiciobeneficio;
    @Column(name = "FECHAFINALIZARBENEFICIO")
    @Temporal(TemporalType.DATE)
    private Date fechafinalizarbeneficio;
    @Column(name = "ESTADOBENEFICIO")
    private int estadobeneficio;

    public Beneficio() {
    }

    public Beneficio(Integer codigobeneficio) {
        this.codigobeneficio = codigobeneficio;
    }

    public Beneficio(Integer codigobeneficio, int estadobeneficio) {
        this.codigobeneficio = codigobeneficio;
        this.estadobeneficio = estadobeneficio;
    }

    public Integer getCodigobeneficio() {
        return codigobeneficio;
    }

    public void setCodigobeneficio(Integer codigobeneficio) {
        this.codigobeneficio = codigobeneficio;
    }

    public String getNombrebeneficio() {
        return nombrebeneficio;
    }

    public void setNombrebeneficio(String nombrebeneficio) {
        this.nombrebeneficio = nombrebeneficio;
    }

    public String getDescripcionbeneficio() {
        return descripcionbeneficio;
    }

    public void setDescripcionbeneficio(String descripcionbeneficio) {
        this.descripcionbeneficio = descripcionbeneficio;
    }

    public Date getFechainiciobeneficio() {
        return fechainiciobeneficio;
    }

    public void setFechainiciobeneficio(Date fechainiciobeneficio) {
        this.fechainiciobeneficio = fechainiciobeneficio;
    }

    public Date getFechafinalizarbeneficio() {
        return fechafinalizarbeneficio;
    }

    public void setFechafinalizarbeneficio(Date fechafinalizarbeneficio) {
        this.fechafinalizarbeneficio = fechafinalizarbeneficio;
    }

    public int getEstadobeneficio() {
        return estadobeneficio;
    }

    public void setEstadobeneficio(int estadobeneficio) {
        this.estadobeneficio = estadobeneficio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigobeneficio != null ? codigobeneficio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Beneficio)) {
            return false;
        }
        Beneficio other = (Beneficio) object;
        if ((this.codigobeneficio == null && other.codigobeneficio != null) || (this.codigobeneficio != null && !this.codigobeneficio.equals(other.codigobeneficio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mj.gob.sisadmrh.model.Beneficio[ codigobeneficio=" + codigobeneficio + " ]";
    }
    
}
