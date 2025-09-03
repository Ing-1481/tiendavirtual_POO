package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ProductoServlet", urlPatterns = {"/ProductoServlet"})
public class ProductoServlet extends HttpServlet {

    // Aquí vamos a simular productos
    private String[][] productos = {
        {"1", "Laptop", "1200"},
        {"2", "Mouse", "25"},
        {"3", "Teclado", "45"},
        {"4", "Monitor", "300"}
    };

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Lista de Productos</h2>");
        out.println("<table border='1'>");
        out.println("<tr><th>ID</th><th>Nombre</th><th>Precio</th><th>Acción</th></tr>");

        for (String[] p : productos) {
            out.println("<tr>");
            out.println("<td>" + p[0] + "</td>");
            out.println("<td>" + p[1] + "</td>");
            out.println("<td>" + p[2] + "</td>");
            out.println("<td><a href='CarritoServlet?id=" + p[0] + "&nombre=" + p[1] + "&precio=" + p[2] + "'>Agregar al carrito</a></td>");
            out.println("</tr>");
        }

        out.println("</table>");
        out.println("</body></html>");
    }
}
