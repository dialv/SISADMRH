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
public class DiagnosticoPojo implements Serializable{

private Integer temacapacitacion; 

    public Integer getTemacapacitacion() {
        return temacapacitacion;
    }

    public void setTemacapacitacion(Integer temacapacitacion) {
        this.temacapacitacion = temacapacitacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNecesidadcapacitacion() {
        return necesidadcapacitacion;
    }

    public void setNecesidadcapacitacion(String necesidadcapacitacion) {
        this.necesidadcapacitacion = necesidadcapacitacion;
    }

    public String getMescapacitacion() {
        return mescapacitacion;
    }

    public void setMescapacitacion(String mescapacitacion) {
        this.mescapacitacion = mescapacitacion;
    }

    public String getResultadoobtener() {
        return resultadoobtener;
    }

    public void setResultadoobtener(String resultadoobtener) {
        this.resultadoobtener = resultadoobtener;
    }

    public String getNombreautorizadiagnosticocapacitacion() {
        return nombreautorizadiagnosticocapacitacion;
    }

    public void setNombreautorizadiagnosticocapacitacion(String nombreautorizadiagnosticocapacitacion) {
        this.nombreautorizadiagnosticocapacitacion = nombreautorizadiagnosticocapacitacion;
    }

    public String getCargoautorizadiagnosticocapacitacion() {
        return cargoautorizadiagnosticocapacitacion;
    }

    public void setCargoautorizadiagnosticocapacitacion(String cargoautorizadiagnosticocapacitacion) {
        this.cargoautorizadiagnosticocapacitacion = cargoautorizadiagnosticocapacitacion;
    }
private String direccion; 
private String necesidadcapacitacion;
private String  mescapacitacion;
private String  resultadoobtener;
private String  nombreautorizadiagnosticocapacitacion;
private String  cargoautorizadiagnosticocapacitacion;




}
