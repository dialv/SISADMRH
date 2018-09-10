/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author daniel
 */
@Entity
@Table(name = "EMPLEADO")
@NamedQueries({
@NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e")})
public class Empleado implements Serializable {
    @Size(max = 50)
    @Column(name = "NOMBREEMPLEADO")
    private String nombreempleado;
    @Size(max = 50)
    @Column(name = "APELLIDOEMPLEADO")
    private String apellidoempleado;
    @Size(max = 50)
    @Column(name = "NACIONALIDAD")
    private String nacionalidad;
    @Size(max = 50)
    @Column(name = "TIPONACIONALIDAD")
    private String tiponacionalidad;
    @Size(max = 50)
    @Column(name = "DEPARTAMENTONACIMIENTO")
    private String departamentonacimiento;
    @Size(max = 50)
    @Column(name = "MUNICIPIONACIMIENTO")
    private String municipionacimiento;
    @Size(max = 20)
    @Column(name = "GRUPOSANQUINEO")
    private String gruposanquineo;
    @Size(max = 11)
    @Column(name = "TELEFONOMOVILEMPLEADO")
    private String telefonomovilempleado;
    @Size(max = 11)
    @Column(name = "TELEFONOFIJOEMPLEADO")
    private String telefonofijoempleado;
    @Size(max = 50)
    @Column(name = "RECIDENCIAPERMANENTE")
    private String recidenciapermanente;
    @Size(max = 50)
    @Column(name = "ESTADOFAMILIAR")
    private String estadofamiliar;
    @Size(max = 50)
    @Column(name = "DEPARTAMENTORECIDENCIA")
    private String departamentorecidencia;
    @Size(max = 50)
    @Column(name = "MUNICIPIORESIDENCIA")
    private String municipioresidencia;
    @Size(max = 10)
    @Column(name = "DUIEMPLEADO")
    private String duiempleado;
    @Size(max = 17)
    @Column(name = "NITEMPLEADOR")
    private String nitempleador;
    @Size(max = 9)
    @Column(name = "ISSSEMPLEADO")
    private String isssempleado;
    @Size(max = 6)
    @Column(name = "AFILIACIONPENSION")
    private String afiliacionpension;
    @Size(max = 12)
    @Column(name = "NUMEROAFILIACION")
    private String numeroafiliacion;
    @Size(max = 2)
    @Column(name = "TIPOCUENTA")
    private String tipocuenta;
    @Size(max = 50)
    @Column(name = "NOMBREINSTIUCIONDEPOSITAR")
    private String nombreinstiuciondepositar;
    @Size(max = 50)
    @Column(name = "EMAILEMPLEADO")
    private String emailempleado;
    @Size(max = 1)
    @Column(name = "SEXOEMPLEADO")
    private String sexoempleado;
   // private List<Descuento> descuentoList;
     @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoempleado")
    private List<Inasistencia> inasistenciaList;
    @JoinTable(name = "EMPLEADOMISION", joinColumns = {
        @JoinColumn(name = "CODIGOEMPLEADO", referencedColumnName = "CODIGOEMPLEADO")}, inverseJoinColumns = {
        @JoinColumn(name = "CODIGOMISION", referencedColumnName = "CODIGOMISION")})
    @ManyToMany
    private List<Mision> misionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoempleado")
    private List<UbicacionFisica> ubicacionfisicaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoempleado")
    private List<Incapacidad> incapacidadList;
    
    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGOEMPLEADO")
    private Integer codigoempleado;
    @Column(name = "FECHANACIMIENTOEMPLEADO")
    @Temporal(TemporalType.DATE)
    private Date fechanacimientoempleado;
    @Column(name = "FECHAINGRESOSECPUB")
    @Temporal(TemporalType.DATE)
    private Date fechaingresosecpub;
    @Column(name = "FECHAINGRESOSECPRIV")
    @Temporal(TemporalType.DATE)
    private Date fechaingresosecpriv;
    @Column(name = "FECHAINGRESOMINISTERIO")
    @Temporal(TemporalType.DATE)
    private Date fechaingresoministerio;
    @Column(name = "ESTADOEMPLEADO")
    private Integer estadoempleado;
    @JoinTable(name = "EMPLEADONIVELESCOLARIDAD", joinColumns = {
        @JoinColumn(name = "CODIGOEMPLEADO", referencedColumnName = "CODIGOEMPLEADO")}, inverseJoinColumns = {
        @JoinColumn(name = "CODIGONIVELNIVELESCOLARIDAD", referencedColumnName = "CODIGONIVELNIVELESCOLARIDAD")})
    @ManyToMany
    private List<NivelEscolaridad> nivelescolaridadList;
    @JoinTable(name = "EMPLEADOASISTENCIACAPACITACION", joinColumns = {
        @JoinColumn(name = "CODIGOEMPLEADO", referencedColumnName = "CODIGOEMPLEADO")}, inverseJoinColumns = {
        @JoinColumn(name = "CODIGOASISTENCIACAPACITACION", referencedColumnName = "CODIGOASISTENCIACAPACITACION")})
    @ManyToMany
    private List<AsistenciaCapacitacion> asistenciacapacitacionList;
    @JoinTable(name = "EMPLEADOCAPACITACION", joinColumns = {
        @JoinColumn(name = "CODIGOEMPLEADO", referencedColumnName = "CODIGOEMPLEADO")}, inverseJoinColumns = {
        @JoinColumn(name = "CODIGOCAPACITACION", referencedColumnName = "CODIGOCAPACITACION")})
    @ManyToMany
    private List<Capacitacion> capacitacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoempleado")
    private List<Capacitador> capacitadorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoempleado")
    private List<Comite> comiteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoempleado")
    private List<CuadroDirectivo> cuadrodirectivoList;
    
    //private List<Descuento> descuentoList;

@JoinTable(name = "empleadodescuento", joinColumns = {
        @JoinColumn(name = "CODIGOEMPLEADO", referencedColumnName = "CODIGOEMPLEADO")}, inverseJoinColumns = {
        @JoinColumn(name = "CODIGODESCUENTO", referencedColumnName = "CODIGODESCUENTO")})
    @ManyToMany
    private List<Descuento> descuentoList;


    public Empleado() {
    }

    public Empleado(Integer codigoempleado) {
        this.codigoempleado = codigoempleado;
    }

    public Integer getCodigoempleado() {
        return codigoempleado;
    }

    public void setCodigoempleado(Integer codigoempleado) {
        this.codigoempleado = codigoempleado;
    }


    public Date getFechanacimientoempleado() {
        return fechanacimientoempleado;
    }

    public void setFechanacimientoempleado(Date fechanacimientoempleado) {
        this.fechanacimientoempleado = fechanacimientoempleado;
    }


    public Date getFechaingresosecpub() {
        return fechaingresosecpub;
    }

    public void setFechaingresosecpub(Date fechaingresosecpub) {
        this.fechaingresosecpub = fechaingresosecpub;
    }

    public Date getFechaingresosecpriv() {
        return fechaingresosecpriv;
    }

    public void setFechaingresosecpriv(Date fechaingresosecpriv) {
        this.fechaingresosecpriv = fechaingresosecpriv;
    }

    public Date getFechaingresoministerio() {
        return fechaingresoministerio;
    }

    public void setFechaingresoministerio(Date fechaingresoministerio) {
        this.fechaingresoministerio = fechaingresoministerio;
    }


    public Integer getEstadoempleado() {
        return estadoempleado;
    }

    public void setEstadoempleado(Integer estadoempleado) {
        this.estadoempleado = estadoempleado;
    }


    public List<NivelEscolaridad> getNivelescolaridadList() {
        return nivelescolaridadList;
    }

    public void setNivelescolaridadList(List<NivelEscolaridad> nivelescolaridadList) {
        this.nivelescolaridadList = nivelescolaridadList;
    }

    public List<AsistenciaCapacitacion> getAsistenciacapacitacionList() {
        return asistenciacapacitacionList;
    }

    public void setAsistenciacapacitacionList(List<AsistenciaCapacitacion> asistenciacapacitacionList) {
        this.asistenciacapacitacionList = asistenciacapacitacionList;
    }

    public List<Capacitacion> getCapacitacionList() {
        return capacitacionList;
    }

    public void setCapacitacionList(List<Capacitacion> capacitacionList) {
        this.capacitacionList = capacitacionList;
    }

    public List<Capacitador> getCapacitadorList() {
        return capacitadorList;
    }

    public void setCapacitadorList(List<Capacitador> capacitadorList) {
        this.capacitadorList = capacitadorList;
    }

    public List<Comite> getComiteList() {
        return comiteList;
    }

    public void setComiteList(List<Comite> comiteList) {
        this.comiteList = comiteList;
    }

    public List<CuadroDirectivo> getCuadrodirectivoList() {
        return cuadrodirectivoList;
    }

    public void setCuadrodirectivoList(List<CuadroDirectivo> cuadrodirectivoList) {
        this.cuadrodirectivoList = cuadrodirectivoList;
    }
    
    

public List<Descuento> getDescuentoList() {
        return descuentoList;
    }

    public void setDescuentoList(List<Descuento> descuentoList) {
        this.descuentoList = descuentoList;
    }
     public List<Incapacidad> getIncapacidadList() {
        return incapacidadList;
    }

    public void setIncapacidadList(List<Incapacidad> incapacidadList) {
        this.incapacidadList = incapacidadList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoempleado != null ? codigoempleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.codigoempleado == null && other.codigoempleado != null) || (this.codigoempleado != null && !this.codigoempleado.equals(other.codigoempleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mj.gob.sisadmrh.model.Empleado[ codigoempleado=" + codigoempleado + " ]";
    }
    @XmlTransient
    public List<UbicacionFisica> getUbicacionfisicaList() {
        return ubicacionfisicaList;
    }
    public void setUbicacionfisicaList(List<UbicacionFisica> ubicacionfisicaList) {
        this.ubicacionfisicaList = ubicacionfisicaList;
    }

    public String getNombreempleado() {
        return nombreempleado;
    }

    public void setNombreempleado(String nombreempleado) {
        this.nombreempleado = nombreempleado;
    }

    public String getApellidoempleado() {
        return apellidoempleado;
    }

    public void setApellidoempleado(String apellidoempleado) {
        this.apellidoempleado = apellidoempleado;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getTiponacionalidad() {
        return tiponacionalidad;
    }
    public List<Inasistencia> getInasistenciaList() {
        return inasistenciaList;
    }

    public void setTiponacionalidad(String tiponacionalidad) {
        this.tiponacionalidad = tiponacionalidad;
    }

    public String getDepartamentonacimiento() {
        return departamentonacimiento;
    }

    public void setDepartamentonacimiento(String departamentonacimiento) {
        this.departamentonacimiento = departamentonacimiento;
    }

    public String getMunicipionacimiento() {
        return municipionacimiento;
    }

    public void setMunicipionacimiento(String municipionacimiento) {
        this.municipionacimiento = municipionacimiento;
    }

    public String getGruposanquineo() {
        return gruposanquineo;
    }

    public void setGruposanquineo(String gruposanquineo) {
        this.gruposanquineo = gruposanquineo;
    }

    public String getTelefonomovilempleado() {
        return telefonomovilempleado;
    }

    public void setTelefonomovilempleado(String telefonomovilempleado) {
        this.telefonomovilempleado = telefonomovilempleado;
    }

    public String getTelefonofijoempleado() {
        return telefonofijoempleado;
    }

    public void setTelefonofijoempleado(String telefonofijoempleado) {
        this.telefonofijoempleado = telefonofijoempleado;
    }

    public String getRecidenciapermanente() {
        return recidenciapermanente;
    }

    public void setRecidenciapermanente(String recidenciapermanente) {
        this.recidenciapermanente = recidenciapermanente;
    }

    public String getEstadofamiliar() {
        return estadofamiliar;
    }

    public void setEstadofamiliar(String estadofamiliar) {
        this.estadofamiliar = estadofamiliar;
    }

    public String getDepartamentorecidencia() {
        return departamentorecidencia;
    }

    public void setDepartamentorecidencia(String departamentorecidencia) {
        this.departamentorecidencia = departamentorecidencia;
    }

    public String getMunicipioresidencia() {
        return municipioresidencia;
    }

    public void setMunicipioresidencia(String municipioresidencia) {
        this.municipioresidencia = municipioresidencia;
    }

    public String getDuiempleado() {
        return duiempleado;
    }

    public void setDuiempleado(String duiempleado) {
        this.duiempleado = duiempleado;
    }

    public String getNitempleador() {
        return nitempleador;
    }

    public void setNitempleador(String nitempleador) {
        this.nitempleador = nitempleador;
    }

    public String getIsssempleado() {
        return isssempleado;
    }

    public void setIsssempleado(String isssempleado) {
        this.isssempleado = isssempleado;
    }

    public String getAfiliacionpension() {
        return afiliacionpension;
    }

    public void setAfiliacionpension(String afiliacionpension) {
        this.afiliacionpension = afiliacionpension;
    }

    public String getNumeroafiliacion() {
        return numeroafiliacion;
    }

    public void setNumeroafiliacion(String numeroafiliacion) {
        this.numeroafiliacion = numeroafiliacion;
    }

    public String getTipocuenta() {
        return tipocuenta;
    }

    public void setTipocuenta(String tipocuenta) {
        this.tipocuenta = tipocuenta;
    }

    public String getNombreinstiuciondepositar() {
        return nombreinstiuciondepositar;
    }

    public void setNombreinstiuciondepositar(String nombreinstiuciondepositar) {
        this.nombreinstiuciondepositar = nombreinstiuciondepositar;
    }

    public String getEmailempleado() {
        return emailempleado;
    }

    public void setEmailempleado(String emailempleado) {
        this.emailempleado = emailempleado;
    }

    public String getSexoempleado() {
        return sexoempleado;
    }

    public void setSexoempleado(String sexoempleado) {
        this.sexoempleado = sexoempleado;
    }

    public List<Mision> getMisionList() {
        return misionList;
    }

    public void setMisionList(List<Mision> misionList) {
        this.misionList = misionList;
    }
    
     public void setInasistenciaList(List<Inasistencia> inasistenciaList) {
        this.inasistenciaList = inasistenciaList;
    }
    
}
