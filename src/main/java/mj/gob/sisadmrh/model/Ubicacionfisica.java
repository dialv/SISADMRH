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
import javax.validation.constraints.Size;

/**
 *
 * @author developer
 */
@Entity
@Table(name = "ubicacionfisica")
@NamedQueries({
    @NamedQuery(name = "Ubicacionfisica.findAll", query = "SELECT u FROM Ubicacionfisica u")})
public class Ubicacionfisica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigoubicacion")
    private Integer codigoubicacion;
    @Size(max = 50)
    @Column(name = "cargofuncional")
    private String cargofuncional;
    @Size(max = 50)
    @Column(name = "estadoubicacion")
    private Integer estadoubicacion;
    @Size(max = 50)
    @Column(name = "jefeinmediato")
    private String jefeinmediato;
    @Size(max = 50)
    @Column(name = "nombreubicacion")
    private String nombreubicacion;
    @Size(max = 500)
    @Column(name = "teareadesempenia")
    private String teareadesempenia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigoempleado")
    private int codigoempleado;

    public Ubicacionfisica() {
    }

    public Ubicacionfisica(Integer codigoubicacion) {
        this.codigoubicacion = codigoubicacion;
    }

    public Ubicacionfisica(Integer codigoubicacion, int codigoempleado) {
        this.codigoubicacion = codigoubicacion;
        this.codigoempleado = codigoempleado;
    }

    public Integer getCodigoubicacion() {
        return codigoubicacion;
    }

    public void setCodigoubicacion(Integer codigoubicacion) {
        this.codigoubicacion = codigoubicacion;
    }

    public String getCargofuncional() {
        return cargofuncional;
    }

    public void setCargofuncional(String cargofuncional) {
        this.cargofuncional = cargofuncional;
    }

    public String getJefeinmediato() {
        return jefeinmediato;
    }

    public void setJefeinmediato(String jefeinmediato) {
        this.jefeinmediato = jefeinmediato;
    }

    public String getNombreubicacion() {
        return nombreubicacion;
    }

    public void setNombreubicacion(String nombreubicacion) {
        this.nombreubicacion = nombreubicacion;
    }

    public String getTeareadesempenia() {
        return teareadesempenia;
    }

    public void setTeareadesempenia(String teareadesempenia) {
        this.teareadesempenia = teareadesempenia;
    }

    public int getCodigoempleado() {
        return codigoempleado;
    }

    public void setCodigoempleado(int codigoempleado) {
        this.codigoempleado = codigoempleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoubicacion != null ? codigoubicacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ubicacionfisica)) {
            return false;
        }
        Ubicacionfisica other = (Ubicacionfisica) object;
        if ((this.codigoubicacion == null && other.codigoubicacion != null) || (this.codigoubicacion != null && !this.codigoubicacion.equals(other.codigoubicacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mj.gob.sisadmrh.model.Ubicacionfisica[ codigoubicacion=" + codigoubicacion + " ]";
    }

    public Integer getEstadoubicacion() {
        return estadoubicacion;
    }

    public void setEstadoubicacion(Integer estadoubicacion) {
        this.estadoubicacion = estadoubicacion;
    }
    
}
