package tienda;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private Usuario usuario;
    private List<Producto> productos;

    public Carrito(Usuario usuario){
        this.usuario = usuario;
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto p){
        productos.add(p);
    }

    public List<Producto> getProductos(){
        return productos;
    }

    public Usuario getUsuario(){
        return usuario;
    }
}


