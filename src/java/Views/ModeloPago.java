/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import java.io.Serializable;

/**
 *
 * @author José Carlos Grijalva González
 */
public class ModeloPago implements Serializable{
    private double Cuota;
    private double Interes;
    private double Servicio;
    private double Capital;
    private double Saldo;
    
    private int indice;

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }
    
    private double MontoActual;

    public double getMontoActual() {
        return MontoActual;
    }

    public void setMontoActual(double MontoActual) {
        this.MontoActual = MontoActual;
    }

    public double getCuota() {
        return Cuota;
    }

    public void setCuota(double Cuota) {
        this.Cuota = Cuota;
    }

    public double getInteres() {
        return Interes;
    }

    public void setInteres(double Interes) {
        this.Interes = Interes;
    }

    public double getServicio() {
        return Servicio;
    }

    public void setServicio(double Servicio) {
        this.Servicio = Servicio;
    }

    public double getCapital() {
        return Capital;
    }

    public void setCapital(double Capital) {
        this.Capital = Capital;
    }

    public double getSaldo() {
        return Saldo;
    }

    public void setSaldo(double Saldo) {
        this.Saldo = Saldo;
    }
    
    
}
