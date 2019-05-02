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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jorge
 */
@Entity
@Table(name = "asistenciacapacitacion")
//@NamedQueries({
//    @NamedQuery(name = "AsistenciaCapacitacion.findAll", query = "SELECT a FROM AsistenciaCapacitacion a")})
public class AsistenciaCapacitacion implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "HORASRECIBIDAS")
    private int horasrecibidas;
    @Size(max = 50)
    @Column(name = "UBICACIONASISTENCIACAPACITACION")
    private String ubicacionasistenciacapacitacion;
   
    @Size(max = 11)
    @Column(name = "TELEFONO")
    private String telefono;
    @Size(max = 50)
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "ESTADOASISTENCIA")
    private int estadoasistencia;
    @Basic(optional = false)
//    @NotNull
//    @Column(name = "codigoempleado")
//    private int codigoempleado;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGOASISTENCIACAPACITACION")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codigoasistenciacapacitacion;
      @Size(max = 50)
        @Column(name = "PUESTO")
    private String puesto;

//    @ManyToMany(mappedBy = "asistenciacapacitacionList")
//    private List<Empleado> empleadoList;
    @JoinColumn(name = "CODIGOCAPACITACION", referencedColumnName = "CODIGOCAPACITACION")
    @ManyToOne(optional = false)
   private Capacitacion codigocapacitacion;
   @OneToMany(cascade = CascadeType.ALL, mappedBy = "asistenciacapacitacion", fetch = FetchType.LAZY)
    private List<Empleadoasistenciacapacitacion> empleadoasistenciacapacitacionList;

    public AsistenciaCapacitacion() {
    }

    public Capacitacion getCodigocapacitacion() {
        return codigocapacitacion;
    }

    public void setCodigocapacitacion(Capacitacion codigocapacitacion) {
        this.codigocapacitacion = codigocapacitacion;
    }

    public AsistenciaCapacitacion(Integer codigoasistenciacapacitacion) {
        this.codigoasistenciacapacitacion = codigoasistenciacapacitacion;
    }

    public AsistenciaCapacitacion(Integer codigoasistenciacapacitacion, int horasrecibidas) {
        this.codigoasistenciacapacitacion = codigoasistenciacapacitacion;
        this.horasrecibidas = horasrecibidas;
    }

    public Integer getCodigoasistenciacapacitacion() {
        return codigoasistenciacapacitacion;
    }

    public void setCodigoasistenciacapacitacion(Integer codigoasistenciacapacitacion) {
        this.codigoasistenciacapacitacion = codigoasistenciacapacitacion;
    }

    public List<Empleadoasistenciacapacitacion> getEmpleadoasistenciacapacitacionList() {
        return empleadoasistenciacapacitacionList;
    }

    public void setEmpleadoasistenciacapacitacionList(List<Empleadoasistenciacapacitacion> empleadoasistenciacapacitacionList) {
        this.empleadoasistenciacapacitacionList = empleadoasistenciacapacitacionList;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
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
 
    public int getHorasrecibidas() {
        return horasrecibidas;
    }

    public void setHorasrecibidas(int horasrecibidas) {
        this.horasrecibidas = horasrecibidas;
    }

    public String getUbicacionasistenciacapacitacion() {
        return ubicacionasistenciacapacitacion;
    }

    public void setUbicacionasistenciacapacitacion(String ubicacionasistenciacapacitacion) {
        this.ubicacionasistenciacapacitacion = ubicacionasistenciacapacitacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEstadoasistencia() {
        return estadoasistencia;
    }

    public void setEstadoasistencia(int estadoasistencia) {
        this.estadoasistencia = estadoasistencia;
    }
    
}
