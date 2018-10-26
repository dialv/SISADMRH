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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author daniel
 */
@Entity
@Table(name = "DIAGNOSTICOCAPACITACION")
//@NamedQueries({
//@NamedQuery(name = "DiagnosticoCapacitacion.findAll", query = "SELECT dc FROM DiagnostioCapacitacion dc")})

public class DiagnosticoCapacitacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGODIAGNOSTICOCAPACITACION")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codigodiagnosticocapacitacion;
    //anioejecucion
    @Column(name = "ANIOEJECUCION")
    private Integer anioejecucion;
    
    @Size(max = 500)
    @Column(name = "DIRECCION")
    private String direccion;
//direccion
     @Column(name = "PERSONALRECIBIR")
   private String	personalrecibir;

    public String getPersonalrecibir() {
        return personalrecibir;
    }

    public void setPersonalrecibir(String personalrecibir) {
        this.personalrecibir = personalrecibir;
    }
    @Size(max = 500)
    @Column(name = "NECESIDADCAPACITACION")
    private String necesidadcapacitacion;
    @Size(max = 20)
    @Column(name = "MESCAPACITACION")
    private String mescapacitacion;
    @Size(max = 500)
    @Column(name = "RESULTADOOBTENER")
    private String resultadoobtener;
    @Size(max = 200)
    @Column(name = "TEMACAPACITACION")
    private String temacapacitacion;

    @Size(max = 150)
    @Column(name = "NOMBREAUTORIZADIAGNOSTICOCAPACITACION")
    private String nombreautorizadiagnosticocapacitacion;
    @Size(max = 100)
    
    @Size(max = 100)
    @Column(name = "CARGOAUTORIZADIAGNOSTICOCAPACITACION")
    private String cargoautorizadiagnosticocapacitacion;
    @JoinColumn(name = "CODIGOCAPACITACION", referencedColumnName = "CODIGOCAPACITACION")
    @ManyToOne(optional = false)
    private Capacitacion codigocapacitacion;

    public DiagnosticoCapacitacion() {
    }

    public DiagnosticoCapacitacion(Integer codigodiagnosticocapacitacion) {
        this.codigodiagnosticocapacitacion = codigodiagnosticocapacitacion;
    }

    public Integer getCodigodiagnosticocapacitacion() {
        return codigodiagnosticocapacitacion;
    }

    public void setCodigodiagnosticocapacitacion(Integer codigodiagnosticocapacitacion) {
        this.codigodiagnosticocapacitacion = codigodiagnosticocapacitacion;
    }

    public String getNecesidadcapacitacion() {
        return necesidadcapacitacion;
    }
 public Integer getAnioejecucion() {
        return anioejecucion;
    }

    public void setAnioejecucion(Integer anioejecucion) {
        this.anioejecucion = anioejecucion;
    }
    public void setNecesidadcapacitacion(String necesidadcapacitacion) {
        this.necesidadcapacitacion = necesidadcapacitacion;
    }

    public String getMescapacitacion() {
        return mescapacitacion;
    }

    public void setMescapacitacion(String mescapacitacion) {
        this.mescapacitacion = mescapacitacion;
    }

    public String getResultadoobtener() {
        return resultadoobtener;
    }

    public void setResultadoobtener(String resultadoobtener) {
        this.resultadoobtener = resultadoobtener;
    }

    public String getNombreautorizadiagnosticocapacitacion() {
        return nombreautorizadiagnosticocapacitacion;
    }

    public void setNombreautorizadiagnosticocapacitacion(String nombreautorizadiagnosticocapacitacion) {
        this.nombreautorizadiagnosticocapacitacion = nombreautorizadiagnosticocapacitacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public String getTemacapacitacion() {
        return temacapacitacion;
    }

    public void setTemacapacitacion(String temacapacitacion) {
        this.temacapacitacion = temacapacitacion;
    }

    public String getCargoautorizadiagnosticocapacitacion() {
        return cargoautorizadiagnosticocapacitacion;
    }

    public void setCargoautorizadiagnosticocapacitacion(String cargoautorizadiagnosticocapacitacion) {
        this.cargoautorizadiagnosticocapacitacion = cargoautorizadiagnosticocapacitacion;
    }

    public Capacitacion getCodigocapacitacion() {
        return codigocapacitacion;
    }

    public void setCodigocapacitacion(Capacitacion codigocapacitacion) {
        this.codigocapacitacion = codigocapacitacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigodiagnosticocapacitacion != null ? codigodiagnosticocapacitacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiagnosticoCapacitacion)) {
            return false;
        }
        DiagnosticoCapacitacion other = (DiagnosticoCapacitacion) object;
        if ((this.codigodiagnosticocapacitacion == null && other.codigodiagnosticocapacitacion != null) || (this.codigodiagnosticocapacitacion != null && !this.codigodiagnosticocapacitacion.equals(other.codigodiagnosticocapacitacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mj.gob.sisadmrh.model.Diagnosticocapacitacion[ codigodiagnosticocapacitacion=" + codigodiagnosticocapacitacion + " ]";
    }
    
}
