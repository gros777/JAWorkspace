package me.victorhernandez.helloejb.ejb.slsb;

import javax.ejb.Stateless; 
import me.victorhernandez.ejb.modelo.Cuenta; 

@Stateless 
public class OperacionesConEfectivo { 
    public void ingresarEfectivo(Cuenta cuenta, double cantidad) { 
        // ingresar cantidad en cuenta 
    } 

    public void retirarEfectivo(Cuenta cuenta, double cantidad) { 
        //retirar cantidad de cuenta 
    } 

    public void transferirEfectivo(Cuenta cuentaOrigen, Cuenta cuentaDestino, double cantidad) { 
        // transferir cantidad de cuenta origen a cuenta destino 
    } 
}
