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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author daniel
 */
@Entity
@Table(name = "UBICACIONFISICA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UbicacionFisica.findAll", query = "SELECT u FROM UbicacionFisica u")
   })
public class UbicacionFisica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGOUBICACION")
    private Integer codigoubicacion;
    @Size(max = 50)
    @Column(name = "NOMBREUBICACION")
    private String nombreubicacion;
    @Size(max = 50)
    @Column(name = "JEFEINMEDIATO")
    private String jefeinmediato;
    @Size(max = 50)
    @Column(name = "CARGOFUNCIONAL")
    private String cargofuncional;
    @Size(max = 500)
    @Column(name = "TEAREADESEMPENIA")
    private String teareadesempenia;
    @JoinColumn(name = "CODIGOEMPLEADO", referencedColumnName = "CODIGOEMPLEADO")
    @ManyToOne(optional = false)
    private Empleado codigoempleado;

    public UbicacionFisica() {
    }

    public UbicacionFisica(Integer codigoubicacion) {
        this.codigoubicacion = codigoubicacion;
    }

    public Integer getCodigoubicacion() {
        return codigoubicacion;
    }

    public void setCodigoubicacion(Integer codigoubicacion) {
        this.codigoubicacion = codigoubicacion;
    }

    public String getNombreubicacion() {
        return nombreubicacion;
    }

    public void setNombreubicacion(String nombreubicacion) {
        this.nombreubicacion = nombreubicacion;
    }

    public String getJefeinmediato() {
        return jefeinmediato;
    }

    public void setJefeinmediato(String jefeinmediato) {
        this.jefeinmediato = jefeinmediato;
    }

    public String getCargofuncional() {
        return cargofuncional;
    }

    public void setCargofuncional(String cargofuncional) {
        this.cargofuncional = cargofuncional;
    }

    public String getTeareadesempenia() {
        return teareadesempenia;
    }

    public void setTeareadesempenia(String teareadesempenia) {
        this.teareadesempenia = teareadesempenia;
    }

    public Empleado getCodigoempleado() {
        return codigoempleado;
    }

    public void setCodigoempleado(Empleado codigoempleado) {
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
        if (!(object instanceof UbicacionFisica)) {
            return false;
        }
        UbicacionFisica other = (UbicacionFisica) object;
        if ((this.codigoubicacion == null && other.codigoubicacion != null) || (this.codigoubicacion != null && !this.codigoubicacion.equals(other.codigoubicacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mj.gob.sisadmrh.model.Ubicacionfisica[ codigoubicacion=" + codigoubicacion + " ]";
    }
    
}
