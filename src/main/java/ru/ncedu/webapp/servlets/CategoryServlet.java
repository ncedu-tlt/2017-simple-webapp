package ru.ncedu.webapp.servlets;

import ru.ncedu.webapp.models.Category;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CategoryServlet", urlPatterns = {"/category"})
public class CategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categories = new ArrayList<>();

        Statement stmt = null;
        try {
            InitialContext cxt = new InitialContext();
            // https://tomcat.apache.org/tomcat-7.0-doc/jndi-datasource-examples-howto.html
            DataSource ds = (DataSource) cxt.lookup( "java:comp/env/jdbc/postgres" );

            if ( ds == null ) {
                throw new RuntimeException("Data source not found!");
            }

            Connection connection = ds.getConnection();

            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select id, name, description from category");
            while (rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                category.setDescription(rs.getString("description"));

                categories.add(category);
            }

        } catch (NamingException | SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ignored) {
                }
            }
        }

        request.setAttribute("size", categories.size());
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("/view/categories.jsp").forward(request, response);
    }
}
