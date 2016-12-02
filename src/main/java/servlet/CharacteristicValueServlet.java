package ru.ncedu.webapp.servlets;

import ru.ncedu.webapp.models.CharacteristicValue;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CharacteristicValue", urlPatterns = {"/characteristicValue"})
public class CharacteristicValueServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CharacteristicValue> characteristicValues = new ArrayList<>();

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
            ResultSet rs = stmt.executeQuery("select * from characteristic_value");
            while (rs.next()) {
                CharacteristicValue characteristicValue = new CharacteristicValue();
                characteristicValue.setCharacteristicId(rs.getInt("characteristic_id"));
                characteristicValue.setProductId(rs.getInt("product_id"));
                characteristicValue.setValue(rs.getString("value"));

                characteristicValues.add(characteristicValue);
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

        request.setAttribute("size", characteristicValues.size());
        request.setAttribute("characteristicValue", characteristicValues);
        request.getRequestDispatcher("/view/characteristicValue.jsp").forward(request, response);
    }
}