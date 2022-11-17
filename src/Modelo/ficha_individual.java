/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class ficha_individual {
    
    private Integer idFicha_individual;
    private Date Fecha;
    
    public ficha_individual(Integer idFicha_individual, Date Fecha){
        
        this.idFicha_individual = idFicha_individual;
        this.Fecha = Fecha;
    }
    
    public ficha_individual(){
        this.idFicha_individual = null;
        this.Fecha = null;
    }

    public Integer getIdFicha_individual() {
        return idFicha_individual;
    }

    public void setIdFicha_individual(Integer idFicha_individual) {
        this.idFicha_individual = idFicha_individual;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }
    
    public void setFecha(String fechaFormateada) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
