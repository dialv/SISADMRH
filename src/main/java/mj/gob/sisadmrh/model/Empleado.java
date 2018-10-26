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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author root
 */
@Entity
@Table(name = "empleado")
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e")})
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 50)
    @Column(name = "NOMBREEMPLEADO")
    private String nombreempleado;
    @Size(max = 50)
    @Column(name = "APELLIDOEMPLEADO")
    private String apellidoempleado;
    @Column(name = "FECHANACIMIENTOEMPLEADO")
     @DateTimeFormat(pattern = "dd/MM/YYYY")
    private Date fechanacimientoempleado;
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
    @Column(name = "RESIDENCIAPERMANENTE")
    private String residenciapermanente;
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
    @Column(name = "FECHAINGRESOSECPUB")
     @DateTimeFormat(pattern = "dd/MM/YYYY")
    private Date fechaingresosecpub;
    @Column(name = "FECHAINGRESOSECPRIV")
     @DateTimeFormat(pattern = "dd/MM/YYYY")
    private Date fechaingresosecpriv;
    @Column(name = "FECHAINGRESOMINISTERIO")
     @DateTimeFormat(pattern = "dd/MM/YYYY")
    private Date fechaingresoministerio;
    @Size(max = 12)
    @Column(name = "AFILIACIONPENSION")
    private String afiliacionpension;
    @Size(max = 12)
    @Column(name = "NUMEROAFILIACION")
    private String numeroafiliacion;
    @Size(max = 12)
    @Column(name = "TIPOCUENTA")
    private String tipocuenta;
    @Size(max = 50)
    @Column(name = "NOMBREINSTIUCIONDEPOSITAR")
    private String nombreinstiuciondepositar;
    @Size(max = 30)
    @Column(name = "NUMEROCUENTA")
    private String numerocuenta;
    @Size(max = 50)
    @Column(name = "EMAILEMPLEADO")
    private String emailempleado;
    @Column(name = "ESTADOEMPLEADO")
    private Integer estadoempleado;
    @Size(max = 12)
    @Column(name = "SEXOEMPLEADO")
    private String sexoempleado;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "CODIGOEMPLEADO")
    private Integer codigoempleado;
    @Size(max = 50)
    @Column(name = "recidenciapermanente")
    private String recidenciapermanente;
    @Basic(optional = false)
    @NotNull
//    @JoinColumn(name = "codigopuesto", referencedColumnName = "codigopuesto")
//    @OneToOne(optional = false)
    @Column(name = "codigopuesto")
    private int  codigopuesto;
 @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.LAZY)
    private List<Empleadocapacitacion> empleadocapacitacionList;
 
 @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.LAZY)
    private List<Empleadoasistenciacapacitacion> empleadoasistenciacapacitacionList;
    public Empleado() {
    }

    public Empleado(Integer codigoempleado) {
        this.codigoempleado = codigoempleado;
    }

    public Empleado(Integer codigoempleado, int codigopuesto) {
        this.codigoempleado = codigoempleado;
        this.codigopuesto = codigopuesto;
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

    public Date getFechanacimientoempleado() {
        return fechanacimientoempleado;
    }

    public void setFechanacimientoempleado(Date fechanacimientoempleado) {
        this.fechanacimientoempleado = fechanacimientoempleado;
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

    public String getResidenciapermanente() {
        return residenciapermanente;
    }

    public void setResidenciapermanente(String residenciapermanente) {
        this.residenciapermanente = residenciapermanente;
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

    public Integer getEstadoempleado() {
        return estadoempleado;
    }

    public void setEstadoempleado(Integer estadoempleado) {
        this.estadoempleado = estadoempleado;
    }
public String getNumerocuenta() {
        return numerocuenta;
    }

    public void setNumerocuenta(String numerocuenta) {
        this.numerocuenta = numerocuenta;
    }
    public String getSexoempleado() {
        return sexoempleado;
    }

    public void setSexoempleado(String sexoempleado) {
        this.sexoempleado = sexoempleado;
    }

    public Integer getCodigoempleado() {
        return codigoempleado;
    }

    public void setCodigoempleado(Integer codigoempleado) {
        this.codigoempleado = codigoempleado;
    }

    public String getRecidenciapermanente() {
        return recidenciapermanente;
    }

    public void setRecidenciapermanente(String recidenciapermanente) {
        this.recidenciapermanente = recidenciapermanente;
    }

    public int getCodigopuesto() {
        return codigopuesto;
    }

    public void setCodigopuesto(int codigopuesto) {
        this.codigopuesto = codigopuesto;
    }

    public List<Empleadocapacitacion> getEmpleadocapacitacionList() {
        return empleadocapacitacionList;
    }

    public void setEmpleadocapacitacionList(List<Empleadocapacitacion> empleadocapacitacionList) {
        this.empleadocapacitacionList = empleadocapacitacionList;
    }

    public List<Empleadoasistenciacapacitacion> getEmpleadoasistenciacapacitacionList() {
        return empleadoasistenciacapacitacionList;
    }

    public void setEmpleadoasistenciacapacitacionList(List<Empleadoasistenciacapacitacion> empleadoasistenciacapacitacionList) {
        this.empleadoasistenciacapacitacionList = empleadoasistenciacapacitacionList;
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
    
}
