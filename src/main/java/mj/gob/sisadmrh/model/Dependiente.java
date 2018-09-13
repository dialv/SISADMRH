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
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author developer
 */
@Entity
@Table(name = "dependiente")
@NamedQueries({
    @NamedQuery(name = "Dependiente.findAll", query = "SELECT d FROM Dependiente d")})
public class Dependiente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigodependiente")
    private Integer codigodependiente;
    @Size(max = 50)
    @Column(name = "nombredependiente")
    private String nombredependiente;
    @Size(max = 50)
    @Column(name = "apellidodependiente")
    private String apellidodependiente;
    @Column(name = "fechanacimiento")
    @DateTimeFormat(pattern = "YYYY-MM-dd")
    private Date fechanacimiento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "salarioinicial")
    private Float salarioinicial;
    @Column(name = "salariofinal")
    private Float salariofinal;
    @Size(max = 200)
    @Column(name = "parentesco")
    private String parentesco;
    @Size(max = 200)
    @Column(name = "dependiente")
    private String dependiente;
    @Size(max = 20)
    @Column(name = "sexo")
    private String sexo;

    public Dependiente() {
    }

    public Dependiente(Integer codigodependiente) {
        this.codigodependiente = codigodependiente;
    }

    public Integer getCodigodependiente() {
        return codigodependiente;
    }

    public void setCodigodependiente(Integer codigodependiente) {
        this.codigodependiente = codigodependiente;
    }

    public String getNombredependiente() {
        return nombredependiente;
    }

    public void setNombredependiente(String nombredependiente) {
        this.nombredependiente = nombredependiente;
    }

    public String getApellidodependiente() {
        return apellidodependiente;
    }

    public void setApellidodependiente(String apellidodependiente) {
        this.apellidodependiente = apellidodependiente;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public Float getSalarioinicial() {
        return salarioinicial;
    }

    public void setSalarioinicial(Float salarioinicial) {
        this.salarioinicial = salarioinicial;
    }

    public Float getSalariofinal() {
        return salariofinal;
    }

    public void setSalariofinal(Float salariofinal) {
        this.salariofinal = salariofinal;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public String getDependiente() {
        return dependiente;
    }

    public void setDependiente(String dependiente) {
        this.dependiente = dependiente;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigodependiente != null ? codigodependiente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dependiente)) {
            return false;
        }
        Dependiente other = (Dependiente) object;
        if ((this.codigodependiente == null && other.codigodependiente != null) || (this.codigodependiente != null && !this.codigodependiente.equals(other.codigodependiente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mj.gob.sisadmrh.model.Dependiente[ codigodependiente=" + codigodependiente + " ]";
    }
    
}
