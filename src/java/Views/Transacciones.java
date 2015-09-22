
package Views;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Transacciones implements Serializable{
    
    String cuentaCargada;
    String cuentaAbonada;
    double cargo;
    double abono;

    public String getCuentaCargada() {
        return cuentaCargada;
    }

    public void setCuentaCargada(String cuentaCargada) {
        this.cuentaCargada = cuentaCargada;
    }

    public String getCuentaAbonada() {
        return cuentaAbonada;
    }

    public void setCuentaAbonada(String cuentaAbonada) {
        this.cuentaAbonada = cuentaAbonada;
    }

    public double getCargo() {
        return cargo;
    }

    public void setCargo(double cargo) {
        this.cargo = cargo;
    }

    public double getAbono() {
        return abono;
    }

    public void setAbono(double abono) {
        this.abono = abono;
    }
    
    
    
   
public void prueba(){
PrestamosController p = new PrestamosController();


}
   
}
