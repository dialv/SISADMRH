/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.pojos;

import java.io.Serializable;

/**
 *
 * @author root
 */
public class CapacitadorPojo implements Serializable{

private Integer tipocapacitador; 
private String nombrecapacitador; 
private String temadominio;
private String  telefonomovilcapacitador;
private String  emailcapacitador;

    public Integer getTipocapacitador() {
        return tipocapacitador;
    }

    public void setTipocapacitador(Integer tipocapacitador) {
        this.tipocapacitador = tipocapacitador;
    }

    public String getNombrecapacitador() {
        return nombrecapacitador;
    }

    public void setNombrecapacitador(String nombrecapacitador) {
        this.nombrecapacitador = nombrecapacitador;
    }

    public String getTemadominio() {
        return temadominio;
    }

    public void setTemadominio(String temadominio) {
        this.temadominio = temadominio;
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

   


}
