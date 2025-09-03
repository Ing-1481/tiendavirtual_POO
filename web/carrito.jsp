<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="tienda.Producto, tienda.Carrito, tienda.Usuario, java.util.List, java.util.ArrayList" %>
<%
    Usuario usuario = new Usuario(1,"Carlos");
    Carrito carrito = new Carrito(usuario);
    
    // Simulamos que se agregaron productos
    carrito.agregarProducto(new Producto(1,"Laptop",1500));
    carrito.agregarProducto(new Producto(2,"Mouse",25));

    List<Producto> productosEnCarrito = carrito.getProductos();
%>
<!DOCTYPE html>
<html>
<head>
    <title>Carrito de Compras</title>
    <style>
        body { font-family: Arial; text-align: center; margin-top: 50px; }
        table { margin: 0 auto; border-collapse: collapse; }
        th, td { border: 1px solid #ddd; padding: 8px; }
        th { background: #4CAF50; color: white; }
        a.button { display: inline-block; padding: 10px 20px; margin: 10px; background: #4CAF50; color: white; text-decoration: none; border-radius: 5px; }
    </style>
</head>
<body>
    <h1>Carrito de <%= usuario.getNombre() %></h1>
    <table>
        <tr><th>ID</th><th>Nombre</th><th>Precio</th></tr>
        <%
            for(Producto p : productosEnCarrito){
        %>
        <tr>
            <td><%= p.getId() %></td>
            <td><%= p.getNombre() %></td>
            <td>$<%= p.getPrecio() %></td>
        </tr>
        <%
            }
        %>
    </table>
    <a href="index.jsp" class="button">Volver al inicio</a>
    <a href="productos.jsp" class="button">Agregar más productos</a>
</body>
</html>
