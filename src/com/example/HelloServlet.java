package com.example;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/tomcat_server_example";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "password";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Hello, World!</h1>");
        out.println("<h2>Productos:</h2>");

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Paso 1: Conectar a la base de datos
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);

            // Paso 2: Ejecutar consulta SQL
            stmt = conn.createStatement();
            String sql = "SELECT id, nombre, precio FROM productos";
            rs = stmt.executeQuery(sql);

            // Paso 3: Mostrar resultados
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                double precio = rs.getDouble("precio");
                out.println("<p>ID: " + id + ", Nombre: " + nombre + ", Precio: $" + precio + "</p>");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            out.println("<p>Error al conectar o consultar la base de datos.</p>");
        } finally {
            // Paso 4: Cerrar conexiones
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        out.println("</body></html>");
    }
}