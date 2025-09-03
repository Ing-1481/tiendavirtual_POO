<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="tienda.Producto, java.util.List, java.util.ArrayList" %>
<%
    List<Producto> productos = new ArrayList<>();
    productos.add(new Producto(1,"Laptop",1500));
    productos.add(new Producto(2,"Mouse",25));
    productos.add(new Producto(3,"Teclado",50));
%>
<!DOCTYPE html>
<html>
<head>
    <title>Productos</title>
    <style>
        body { font-family: Arial; text-align: center; margin-top: 50px; }
        table { margin: 0 auto; border-collapse: collapse; }
        th, td { border: 1px solid #ddd; padding: 8px; }
        th { background: #4CAF50; color: white; }
        a.button { display: inline-block; padding: 10px 20px; margin: 10px; background: #4CAF50; color: white; text-decoration: none; border-radius: 5px; }
    </style>
</head>
<body>
    <h1>Lista de Productos</h1>
    <table>
        <tr><th>ID</th><th>Nombre</th><th>Precio</th></tr>
        <%
            for(Producto p : productos){
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
</body>
</html>
