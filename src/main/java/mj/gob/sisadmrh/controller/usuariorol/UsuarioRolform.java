/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.controller.usuariorol;

import java.io.Serializable;
import mj.gob.sisadmrh.model.Rol;
import mj.gob.sisadmrh.model.Usuario;
import mj.gob.sisadmrh.model.Usuariorol;

/**
 *
 * @author root
 */
public class UsuarioRolform implements Serializable{
    
    private Iterable<Usuario> usuarios ;
    private Iterable<Rol> roles ;
    private Usuariorol usuariorol ;

    public Iterable<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Iterable<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Iterable<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Iterable<Rol> roles) {
        this.roles = roles;
    }

    public Usuariorol getUsuariorol() {
        return usuariorol;
    }

    public void setUsuariorol(Usuariorol usuariorol) {
        this.usuariorol = usuariorol;
    }
    
    
}
