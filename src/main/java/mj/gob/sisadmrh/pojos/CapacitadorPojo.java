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
public class AbogadosPojo implements Serializable{

private Integer codigoempleado; 
private String nombreempleado; 
private String fechaingresoministerio;

    public Integer getCodigoempleado() {
        return codigoempleado;
    }

    public void setCodigoempleado(Integer codigoempleado) {
        this.codigoempleado = codigoempleado;
    }

    public String getNombreempleado() {
        return nombreempleado;
    }

    public void setNombreempleado(String nombreempleado) {
        this.nombreempleado = nombreempleado;
    }

    public String getFechaingresoministerio() {
        return fechaingresoministerio;
    }

    public void setFechaingresoministerio(String fechaingresoministerio) {
        this.fechaingresoministerio = fechaingresoministerio;
    }


}
