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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author jorge
 */
@Entity
@Table(name = "inasistencia")
@NamedQueries({
    @NamedQuery(name = "Inasistencia.findAll", query = "SELECT i FROM Inasistencia i")})
public class Inasistencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGOINASISTENCIA")
     @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codigoinasistencia;
    @Size(max = 200)
    @Column(name = "MOTIVOINASISTENCIA")
    private String motivoinasistencia;
    @Size(max = 200)
    @Column(name = "CONSTANCIAINASISTENCIA")
    private String constanciainasistencia;
    @Column(name = "FECHADESDEINASISTENCIA")
    //@Temporal(TemporalType.DATE)
      @DateTimeFormat(pattern = "YYYY-MM-dd")
    private Date fechadesdeinasistencia;
      @DateTimeFormat(pattern = "YYYY-MM-dd")
    @Column(name = "FECHAHASTAINASISTENCIA")
    @Temporal(TemporalType.DATE)
    private Date fechahastainasistencia;
    @JoinColumn(name = "CODIGOEMPLEADO", referencedColumnName = "CODIGOEMPLEADO")
    @ManyToOne(optional = false)
    private Empleado codigoempleado;

    public Inasistencia() {
    }

    public Inasistencia(Integer codigoinasistencia) {
        this.codigoinasistencia = codigoinasistencia;
    }

    public Integer getCodigoinasistencia() {
        return codigoinasistencia;
    }

    public void setCodigoinasistencia(Integer codigoinasistencia) {
        this.codigoinasistencia = codigoinasistencia;
    }

    public String getMotivoinasistencia() {
        return motivoinasistencia;
    }

    public void setMotivoinasistencia(String motivoinasistencia) {
        this.motivoinasistencia = motivoinasistencia;
    }

    public String getConstanciainasistencia() {
        return constanciainasistencia;
    }

    public void setConstanciainasistencia(String constanciainasistencia) {
        this.constanciainasistencia = constanciainasistencia;
    }

    public Date getFechadesdeinasistencia() {
        return fechadesdeinasistencia;
    }

    public void setFechadesdeinasistencia(Date fechadesdeinasistencia) {
        this.fechadesdeinasistencia = fechadesdeinasistencia;
    }

    public Date getFechahastainasistencia() {
        return fechahastainasistencia;
    }

    public void setFechahastainasistencia(Date fechahastainasistencia) {
        this.fechahastainasistencia = fechahastainasistencia;
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
        hash += (codigoinasistencia != null ? codigoinasistencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inasistencia)) {
            return false;
        }
        Inasistencia other = (Inasistencia) object;
        if ((this.codigoinasistencia == null && other.codigoinasistencia != null) || (this.codigoinasistencia != null && !this.codigoinasistencia.equals(other.codigoinasistencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mj.gob.sisadmrh.model.Inasistencia[ codigoinasistencia=" + codigoinasistencia + " ]";
    }
    
}
