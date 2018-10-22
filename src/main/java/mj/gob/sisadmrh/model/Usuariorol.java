/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author root
 */
@Entity
@Table(name = "usuariorol")
@NamedQueries({
    @NamedQuery(name = "Usuariorol.findAll", query = "SELECT u FROM Usuariorol u")})
public class Usuariorol implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsuariorolPK usuariorolPK;
    @JoinColumn(name = "CODIGOROL", referencedColumnName = "CODIGOROL", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Rol rol;
    
    @JoinColumn(name = "CODIGOUSUARIO", referencedColumnName = "CODIGOUSUARIO", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuario;

    public Usuariorol() {
    }

    public Usuariorol(UsuariorolPK usuariorolPK) {
        this.usuariorolPK = usuariorolPK;
    }

    public Usuariorol(int codigousuario, int codigorol) {
        this.usuariorolPK = new UsuariorolPK(codigousuario, codigorol);
    }

    public UsuariorolPK getUsuariorolPK() {
        return usuariorolPK;
    }

    public void setUsuariorolPK(UsuariorolPK usuariorolPK) {
        this.usuariorolPK = usuariorolPK;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuariorolPK != null ? usuariorolPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuariorol)) {
            return false;
        }
        Usuariorol other = (Usuariorol) object;
        if ((this.usuariorolPK == null && other.usuariorolPK != null) || (this.usuariorolPK != null && !this.usuariorolPK.equals(other.usuariorolPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mj.gob.sisadmrh.model.Usuariorol[ usuariorolPK=" + usuariorolPK + " ]";
    }
    
}
