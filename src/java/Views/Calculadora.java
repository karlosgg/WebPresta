/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import entity.Pagos;
import entity.Prestamos;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author admin
 */
@ManagedBean(name = "calculadora")
@ViewScoped
public class Calculadora implements Serializable {

    private double monto=0.0;
    private double prima;
    private int mensualidad;
    private double tasa;
    private double recargoServicio;
    private double montoPrestar;
    private double cuotaMensual;
    private double saldo;
    private ModeloPago pagos;
    List<ModeloPago> cuotas;
    
    private double capital;

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getCapital() {
        return capital;
    }

    public void setCapital(double capital) {
        this.capital = capital;
    }

    public double getMontoPrestar() {
        return montoPrestar;
    }

    public void setMontoPrestar(double montoPrestar) {
        this.montoPrestar = montoPrestar;
    }
    
    public double getCuotaMensual() {
        return cuotaMensual;
    }

    public void setCuotaMensual(double cuotaMensual) {
        this.cuotaMensual = cuotaMensual;
    }
    
    
    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getPrima() {
        return prima;
    }

    public void setPrima(double prima) {
        this.prima = prima;
    }

    public int getMensualidad() {
        return mensualidad;
    }

    public void setMensualidad(int mensualidad) {
        this.mensualidad = mensualidad;
    }

    public double getTasa() {
        return tasa;
    }

    public void setTasa(double tasa) {
        this.tasa = tasa;
    }

    public double getRecargoServicio() {
        return recargoServicio;
    }

    public void setRecargoServicio(double recargoServicio) {
        this.recargoServicio = recargoServicio;
    }

    public Calculadora() {
    }

    public void doCalcularMensualidad() {
       calcularMensualidad();
       getCuotasp();
    }

    private void calcularMensualidad() {
        
        double o1, o2, a1, a2, ay;
        try{
            tasa=tasa/100;
            o1 = 1+tasa;
            a1 = (Math.pow(o1, mensualidad))*tasa;

            o2 = 1+tasa;
            a2 = (Math.pow(o2, mensualidad))-1;

           montoPrestar = monto - prima;

            ay = recargoServicio + (montoPrestar * (a1 / a2));

            DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
            simbolos.setDecimalSeparator('.');
            DecimalFormat formateador = new DecimalFormat("####.##",simbolos);
            ay = Double.parseDouble(formateador.format(ay));
            cuotaMensual = ay;
            
        }
        catch(Exception e){
        FacesContext contexto = FacesContext.getCurrentInstance();
        contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Error en los datos", "Revise los valores ingresados"));  
        }
    }
    
    
    public void docalcularMontoPrestar(){
        calcularMontoPrestar();
        
    }
    
    private void calcularMontoPrestar() {
        montoPrestar = monto - prima;   
    }

   
    
    public List<ModeloPago> getCuotasp(){
    
    cuotas=new ArrayList<ModeloPago>();
    saldo=monto-prima;
    try{
    for (int i=1; i<=mensualidad;i++){
        if(i==1){
            pagos=new ModeloPago();
            capital=cuotaMensual-saldo*(tasa)-recargoServicio;
//            saldo=montoPrestar-(cuotaMensual-montoPrestar*(tasa+1)-recargoServicio);
            pagos.setIndice(i);
            pagos.setMontoActual( (new BigDecimal(saldo).setScale(2, RoundingMode.HALF_UP)).doubleValue());
            pagos.setCuota(cuotaMensual);
            pagos.setInteres((new BigDecimal(saldo*(tasa)).setScale(2, RoundingMode.HALF_UP)).doubleValue());
            pagos.setServicio(recargoServicio);
            pagos.setCapital((new BigDecimal(capital).setScale(2, RoundingMode.HALF_UP)).doubleValue());
            saldo=saldo-(cuotaMensual-saldo*(tasa)-recargoServicio);
            pagos.setSaldo((new BigDecimal(saldo).setScale(2, RoundingMode.HALF_UP)).doubleValue());
            
            cuotas.add(pagos);
            
        }else{
            pagos=new ModeloPago();
            pagos.setIndice(i);
            pagos.setMontoActual((new BigDecimal(saldo).setScale(2, RoundingMode.HALF_UP)).doubleValue());
            pagos.setCuota(cuotaMensual);
            pagos.setInteres((new BigDecimal(saldo*(tasa)).setScale(2, RoundingMode.HALF_UP)).doubleValue());
            pagos.setServicio(recargoServicio);
            capital=cuotaMensual-saldo*(tasa)-recargoServicio;
            pagos.setCapital((new BigDecimal(capital).setScale(2, RoundingMode.HALF_UP)).doubleValue());
            saldo=saldo-(cuotaMensual-saldo*(tasa)-recargoServicio);
            pagos.setSaldo((new BigDecimal(saldo).setScale(2, RoundingMode.HALF_UP)).doubleValue());
            
            cuotas.add(pagos);
        }   
            System.out.println(pagos.getCapital());
           
        }
    }
    catch(Exception ex){
            
    }
    tasa=tasa*100;
    return cuotas;
    
    }
//   
    public List<ModeloPago> getCuotas() {
        return cuotas;
    }
    
}
