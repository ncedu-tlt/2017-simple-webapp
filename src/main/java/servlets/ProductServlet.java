package servlets;

import models.Product;
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

@WebServlet(name = "ProductsServlet", urlPatterns = {"/ProductsServlet"})
public class ProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = new ArrayList<>();

        Statement stmt = null;
        try {
            InitialContext cxt = new InitialContext();
            DataSource ds = (DataSource) cxt.lookup( "java:comp/env/jdbc/postgres" );

            if ( ds == null ) {
                throw new RuntimeException("Data source not found!");
            }

            Connection connection = ds.getConnection();

            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select id, name, categoryid, description from products");
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setCategoryId(rs.getInt("categoryid"));
                product.setDescription(rs.getString("description"));

                products.add(product);
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

        request.setAttribute("size", products.size());
        request.setAttribute("products", products);
        request.getRequestDispatcher("/view/products.jsp").forward(request, response);
    }
}
