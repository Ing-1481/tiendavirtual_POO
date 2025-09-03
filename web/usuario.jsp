<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="tienda.Usuario" %>
<%
    Usuario usuario = new Usuario(1,"Carlos");
%>
<!DOCTYPE html>

<html>
<head>
    <title>Perfil de Usuario</title>
    <style>
        body { font-family: Arial; text-align: center; margin-top: 50px; }
        a.button { display: inline-block; padding: 10px 20px; margin: 10px; background: #4CAF50; color: white; text-decoration: none; border-radius: 5px; }
    </style>
</head>
<body>
    <h1>Perfil de Usuario</h1>
    <p>ID: <%= usuario.getId() %></p>
    <p>Nombre: <%= usuario.getNombre() %></p>

    <a href="index.jsp" class="button">Volver al inicio</a>
    <a href="carrito.jsp" class="button">Ver carrito</a>
</body>
</html>

