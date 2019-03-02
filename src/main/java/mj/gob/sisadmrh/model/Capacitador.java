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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "CAPACITADOR")
@NamedQueries({
    @NamedQuery(name = "Capacitador.findAll", query = "SELECT c FROM Capacitador c")})
public class Capacitador implements Serializable {
    
    
    @Column(name = "TEMADOMINIO")
    private String temadominio;
    
    @Column(name = "estadocapacitador")
    private Integer estadocapacitador;
    
    @Column(name = "INSTITUCIONCAPACITADOR")
    private String institucioncapacitador;
    
    
    @Column(name = "TIPOCAPACITADOR")
    private String tipocapacitador;
    
    @Column(name = "TIPOAGRUPACION")
    private String tipoagrupacion;
    
    
    @Size(max = 10)
    @Column(name = "DUICAPACITADOR")
    
    private String duicapacitador;
    
    
    @Size(max = 17)
    @Column(name = "NITCAPACITADOR")
    
    private String nitcapacitador;
    
    
    @Size(max = 11)
    @Column(name = "TELEFONOCAPACITADOR")
 
    private String telefonocapacitador;
    
    
    @Size(max = 11)
    @Column(name = "TELEFONOMOVILCAPACITADOR")
    
    private String telefonomovilcapacitador;
    
    
    @Size(max = 50)
   
    @Column(name = "EMAILCAPACITADOR")
    private String emailcapacitador;
    
    @Size(max = 100)
    
    @Column(name = "NOMBRECAPACITADOR")
    private String nombrecapacitador;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigocapacitador")
    private List<Capacitacion> capacitacionList;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODIGOCAPACITADOR")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codigocapacitador;
    
    
    @Column(name = "CARNETRESIDENCIA")
    private Integer carnetresidencia;
    @JoinColumn(name = "CODIGOEMPLEADO", referencedColumnName = "CODIGOEMPLEADO")
    @ManyToOne(optional = false)
    private Empleado codigoempleado;

    public Capacitador() {
    }

    public Capacitador(Integer codigocapacitador) {
        this.codigocapacitador = codigocapacitador;
    }

    public Integer getCodigocapacitador() {
        return codigocapacitador;
    }

    public void setCodigocapacitador(Integer codigocapacitador) {
        this.codigocapacitador = codigocapacitador;
    }


    public Integer getCarnetresidencia() {
        return carnetresidencia;
    }

    public void setCarnetresidencia(Integer carnetresidencia) {
        this.carnetresidencia = carnetresidencia;
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
        hash += (codigocapacitador != null ? codigocapacitador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Capacitador)) {
            return false;
        }
        Capacitador other = (Capacitador) object;
        if ((this.codigocapacitador == null && other.codigocapacitador != null) || (this.codigocapacitador != null && !this.codigocapacitador.equals(other.codigocapacitador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mj.gob.sisadmrh.model.Capacitador[ codigocapacitador=" + codigocapacitador + " ]";
    }
    @XmlTransient
    public List<Capacitacion> getCapacitacionList() {
        return capacitacionList;
    }
    public void setCapacitacionList(List<Capacitacion> capacitacionList) {
        this.capacitacionList = capacitacionList;
    }

    public String getTemadominio() {
        return temadominio;
    }

    public void setTemadominio(String temadominio) {
        this.temadominio = temadominio;
    }

    public String getInstitucioncapacitador() {
        return institucioncapacitador;
    }

    public void setInstitucioncapacitador(String institucioncapacitador) {
        this.institucioncapacitador = institucioncapacitador;
    }

    public String getTipocapacitador() {
        return tipocapacitador;
    }

    public void setTipocapacitador(String tipocapacitador) {
        this.tipocapacitador = tipocapacitador;
    }

    public String getTipoagrupacion() {
        return tipoagrupacion;
    }

    public void setTipoagrupacion(String tipoagrupacion) {
        this.tipoagrupacion = tipoagrupacion;
    }

    public String getDuicapacitador() {
        return duicapacitador;
    }

    public void setDuicapacitador(String duicapacitador) {
        this.duicapacitador = duicapacitador;
    }

    public String getNitcapacitador() {
        return nitcapacitador;
    }

    public void setNitcapacitador(String nitcapacitador) {
        this.nitcapacitador = nitcapacitador;
    }

    public String getTelefonocapacitador() {
        return telefonocapacitador;
    }

    public void setTelefonocapacitador(String telefonocapacitador) {
        this.telefonocapacitador = telefonocapacitador;
    }

    public String getTelefonomovilcapacitador() {
        return telefonomovilcapacitador;
    }

    public void setTelefonomovilcapacitador(String telefonomovilcapacitador) {
        this.telefonomovilcapacitador = telefonomovilcapacitador;
    }

    public String getEmailcapacitador() {
        return emailcapacitador;
    }

    public void setEmailcapacitador(String emailcapacitador) {
        this.emailcapacitador = emailcapacitador;
    }

    public String getNombrecapacitador() {
        return nombrecapacitador;
    }

    public void setNombrecapacitador(String nombrecapacitador) {
        this.nombrecapacitador = nombrecapacitador;
    }

    public Integer getEstadocapacitador() {
        return estadocapacitador;
    }

    public void setEstadocapacitador(Integer estadocapacitador) {
        this.estadocapacitador = estadocapacitador;
    }
    
}
