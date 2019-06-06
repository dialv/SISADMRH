/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author dialv
 */
@Entity
@Table(name = "asistenciacapacitacion")
public class AsistenciaCapacitacion implements Serializable {

    private static final long serialVersionUID = 1L;
//    @Basic(optional = false)
//    @NotNull
//    @Column(name = "codigocapacitacion")
//    private int codigocapacitacion;
     @JoinColumn(name = "CODIGOCAPACITACION", referencedColumnName = "CODIGOCAPACITACION")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
   private Capacitacion codigocapacitacion;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigoasistenciacapacitacion")
    private Integer codigoasistenciacapacitacion;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "horasrecibidas")
    private int horasrecibidas;
    @Size(max = 11)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 50)
    @Column(name = "ubicacionasistenciacapacitacion")
    private String ubicacionasistenciacapacitacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADOASISTENCIA")
    private int estadoasistencia;
    @Size(max = 50)
    @Column(name = "puesto")
    private String puesto;
//    @Basic(optional = false)
//    @NotNull
//    @Column(name = "codigoempleado")
//    private int codigoempleado;
    @JoinColumn(name = "codigoempleado", referencedColumnName = "codigoempleado")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Empleado codigoempleado;
    
    public AsistenciaCapacitacion() {
    }

    public AsistenciaCapacitacion(Integer codigoasistenciacapacitacion) {
        this.codigoasistenciacapacitacion = codigoasistenciacapacitacion;
    }

    public AsistenciaCapacitacion(Integer codigoasistenciacapacitacion, Capacitacion codigocapacitacion, int horasrecibidas, int estadoasistencia, Empleado codigoempleado) {
        this.codigoasistenciacapacitacion = codigoasistenciacapacitacion;
        this.codigocapacitacion = codigocapacitacion;
        this.horasrecibidas = horasrecibidas;
        this.estadoasistencia = estadoasistencia;
        this.codigoempleado = codigoempleado;
    }

    public Capacitacion getCodigocapacitacion() {
        return codigocapacitacion;
    }

    public void setCodigocapacitacion(Capacitacion codigocapacitacion) {
        this.codigocapacitacion = codigocapacitacion;
    }

    public Integer getCodigoasistenciacapacitacion() {
        return codigoasistenciacapacitacion;
    }

    public void setCodigoasistenciacapacitacion(Integer codigoasistenciacapacitacion) {
        this.codigoasistenciacapacitacion = codigoasistenciacapacitacion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getHorasrecibidas() {
        return horasrecibidas;
    }

    public void setHorasrecibidas(int horasrecibidas) {
        this.horasrecibidas = horasrecibidas;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUbicacionasistenciacapacitacion() {
        return ubicacionasistenciacapacitacion;
    }

    public void setUbicacionasistenciacapacitacion(String ubicacionasistenciacapacitacion) {
        this.ubicacionasistenciacapacitacion = ubicacionasistenciacapacitacion;
    }

    public int getEstadoasistencia() {
        return estadoasistencia;
    }

    public void setEstadoasistencia(int estadoasistencia) {
        this.estadoasistencia = estadoasistencia;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
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
        hash += (codigoasistenciacapacitacion != null ? codigoasistenciacapacitacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsistenciaCapacitacion)) {
            return false;
        }
        AsistenciaCapacitacion other = (AsistenciaCapacitacion) object;
        if ((this.codigoasistenciacapacitacion == null && other.codigoasistenciacapacitacion != null) || (this.codigoasistenciacapacitacion != null && !this.codigoasistenciacapacitacion.equals(other.codigoasistenciacapacitacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mj.gob.sisadmrh.model.Asistenciacapacitacion[ codigoasistenciacapacitacion=" + codigoasistenciacapacitacion + " ]";
    }
    
}
