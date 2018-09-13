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
 * @author IPalacios
 */
@Entity
@Table(name = "contacto")
@NamedQueries({   //
    @NamedQuery(name = "Contacto.findAll", query = "SELECT c FROM Contacto c"),
//    @NamedQuery(name = "Contacto.findByCodigocontacto", query = "SELECT c FROM Contacto c WHERE c.codigocontacto = :codigocontacto"),
//    @NamedQuery(name = "Contacto.findByNombrecontacto", query = "SELECT c FROM Contacto c WHERE c.nombrecontacto = :nombrecontacto"),
//    @NamedQuery(name = "Contacto.findByApellidocontacto", query = "SELECT c FROM Contacto c WHERE c.apellidocontacto = :apellidocontacto"),
//    @NamedQuery(name = "Contacto.findByDireccion", query = "SELECT c FROM Contacto c WHERE c.direccion = :direccion"),
//    @NamedQuery(name = "Contacto.findByEmailcontacto", query = "SELECT c FROM Contacto c WHERE c.emailcontacto = :emailcontacto"),
//    @NamedQuery(name = "Contacto.findBySexocontacto", query = "SELECT c FROM Contacto c WHERE c.sexocontacto = :sexocontacto"),
//    @NamedQuery(name = "Contacto.findByTelefonofijocontacto", query = "SELECT c FROM Contacto c WHERE c.telefonofijocontacto = :telefonofijocontacto"),
//    @NamedQuery(name = "Contacto.findByTelefonomovilcontacto", query = "SELECT c FROM Contacto c WHERE c.telefonomovilcontacto = :telefonomovilcontacto")
})
public class Contacto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigocontacto")
    private Integer codigocontacto;
    @Size(max = 50)
    @Column(name = "nombrecontacto")
    private String nombrecontacto;
    @Size(max = 50)
    @Column(name = "apellidocontacto")
    private String apellidocontacto;
    @Size(max = 100)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 100)
    @Column(name = "emailcontacto")
    private String emailcontacto;
    @Size(max = 100)
    @Column(name = "sexocontacto")
    private String sexocontacto;
    @Size(max = 11)
    @Column(name = "telefonofijocontacto")
    private String telefonofijocontacto;
    @Size(max = 11)
    @Column(name = "telefonomovilcontacto")
    private String telefonomovilcontacto;

    public Contacto() {
    }

    public Contacto(Integer codigocontacto) {
        this.codigocontacto = codigocontacto;
    }

    public Integer getCodigocontacto() {
        return codigocontacto;
    }

    public void setCodigocontacto(Integer codigocontacto) {
        this.codigocontacto = codigocontacto;
    }

    public String getNombrecontacto() {
        return nombrecontacto;
    }

    public void setNombrecontacto(String nombrecontacto) {
        this.nombrecontacto = nombrecontacto;
    }

    public String getApellidocontacto() {
        return apellidocontacto;
    }

    public void setApellidocontacto(String apellidocontacto) {
        this.apellidocontacto = apellidocontacto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmailcontacto() {
        return emailcontacto;
    }

    public void setEmailcontacto(String emailcontacto) {
        this.emailcontacto = emailcontacto;
    }

    public String getSexocontacto() {
        return sexocontacto;
    }

    public void setSexocontacto(String sexocontacto) {
        this.sexocontacto = sexocontacto;
    }

    public String getTelefonofijocontacto() {
        return telefonofijocontacto;
    }

    public void setTelefonofijocontacto(String telefonofijocontacto) {
        this.telefonofijocontacto = telefonofijocontacto;
    }

    public String getTelefonomovilcontacto() {
        return telefonomovilcontacto;
    }

    public void setTelefonomovilcontacto(String telefonomovilcontacto) {
        this.telefonomovilcontacto = telefonomovilcontacto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigocontacto != null ? codigocontacto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contacto)) {
            return false;
        }
        Contacto other = (Contacto) object;
        if ((this.codigocontacto == null && other.codigocontacto != null) || (this.codigocontacto != null && !this.codigocontacto.equals(other.codigocontacto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mj.gob.sisadmrh.model.Contacto[ codigocontacto=" + codigocontacto + " ]";
    }
    
}
