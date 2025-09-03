/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "TiendaServlet", urlPatterns = {"/tienda"})
public class TiendaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String accion = request.getParameter("accion");
        if (accion == null) accion = "productos";

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html><head><meta charset='UTF-8'><title>Tienda Virtual</title></head><body>");
            out.println("<h1>Tienda Virtual</h1>");
            out.println("<nav>");
            out.println("<a href='tienda?accion=productos'>Productos</a> | ");
            out.println("<a href='tienda?accion=usuarios'>Usuarios</a> | ");
            out.println("<a href='tienda?accion=carrito'>Carrito</a>");
            out.println("</nav><hr>");

            switch (accion) {
                case "productos":
                    out.println("<h2>Lista de Productos</h2>");
                    out.println("<ul><li>Producto 1 - $10</li><li>Producto 2 - $15</li></ul>");
                    out.println("<h3>Registrar producto</h3>");
                    out.println("<form action='tienda' method='post'>");
                    out.println("<input type='hidden' name='accion' value='productos' />");
                    out.println("Nombre: <input name='nombre' required/> Precio: <input name='precio' required/>");
                    out.println("<input type='submit' value='Registrar'/> </form>");
                    break;

                case "usuarios":
                    out.println("<h2>Gestión de Usuarios</h2>");
                    out.println("<form action='tienda' method='post'>");
                    out.println("<input type='hidden' name='accion' value='usuarios' />");
                    out.println("Nombre: <input name='nombre' required/> Correo: <input name='correo' required/>");
                    out.println("<input type='submit' value='Registrar'/> </form>");
                    break;

                case "carrito":
                    out.println("<h2>Carrito de Compras</h2>");
                    out.println("<form action='tienda' method='post'>");
                    out.println("<input type='hidden' name='accion' value='carrito' />");
                    out.println("Producto: <input name='producto' required/> Cantidad: <input type='number' name='cantidad' min='1' required/>");
                    out.println("<input type='submit' value='Agregar'/> </form>");
                    break;

                default:
                    out.println("<p>Opción no válida</p>");
            }
            out.println("</body></html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // procesar formularios y volver a GET para mostrar resultado
        request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");

        if ("productos".equals(accion)) {
            String nombre = request.getParameter("nombre");
            String precio = request.getParameter("precio");
            request.getSession().setAttribute("msg", "Producto registrado: " + nombre + " - $" + precio);
        } else if ("usuarios".equals(accion)) {
            String nombre = request.getParameter("nombre");
            String correo = request.getParameter("correo");
            request.getSession().setAttribute("msg", "Usuario registrado: " + nombre + " (" + correo + ")");
        } else if ("carrito".equals(accion)) {
            String producto = request.getParameter("producto");
            String cantidad = request.getParameter("cantidad");
            request.getSession().setAttribute("msg", "Agregado al carrito: " + producto + " x" + cantidad);
        }

        // redirige a GET para mostrar la página actual (PRG pattern)
        response.sendRedirect("tienda?accion=" + (accion != null ? accion : "productos"));
    }
}
