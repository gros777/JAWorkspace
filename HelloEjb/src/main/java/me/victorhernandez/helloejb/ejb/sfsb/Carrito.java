package me.victorhernandez.helloejb.ejb.sfsb;
import java.io.Serializable; 
import java.util.HashMap; 
import java.util.Map; 
import javax.annotation.PostConstruct; 
import javax.annotation.PreDestroy; 
import javax.ejb.PostActivate; 
import javax.ejb.PrePassivate; 
import javax.ejb.Remove; 
import javax.ejb.Stateful; 
import me.victorhernandez.ejb.modelo.Articulo; 
import me.victorhernandez.ejb.util.BaseDeDatos; 

@Stateful 
public class Carrito implements Serializable { 
    private Map articulosEnCarrito = new HashMap(); 
    private BaseDeDatos bbdd; 
    public void a–adirArticulo(Articulo articulo, int cantidad) { 
        // a–adir la cantidad de cierto art’culo al carrito 
    }  
    public void eliminarArticulo(Articulo articulo, int cantidad) { 
        // eliminar la cantidad de cierto art’culo del carrito 
    }     
    public void vaciarCarrito() { 
        // vaciar el carrito 
    } 
    @Remove 
    public void finalizarCompra() { 
        // procesar el pedido 
    } 
    @PostConstruct 
    @PostActivate 
    private void inicializar() { 
        // obtener conexi—n con la base de datos 
    } 
    @PrePassivate 
    @PreDestroy 
    private void detener() { 
        // liberar conexi—n con la base de datos 
    } 
} 
