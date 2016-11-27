package servlets;

import models.CharacteristicGroup;

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

@WebServlet(name = "CharacteristicGroupServlet", urlPatterns = {"/characteristicGroup"})
public class CharacteristicGroupServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CharacteristicGroup> characteristicGroups = new ArrayList<>();

        Statement stmt = null;
        try {
            InitialContext cxt = new InitialContext();
            // https://tomcat.apache.org/tomcat-7.0-doc/jndi-datasource-examples-howto.html
            DataSource ds = (DataSource) cxt.lookup("java:comp/env/jdbc/postgres");

            if (ds == null) {
                throw new RuntimeException("Data source not found!");
            }

            Connection connection = ds.getConnection();

            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select id, name, orderNumber from characteristicGroup");
            while (rs.next()) {
                CharacteristicGroup characteristicGroup = new CharacteristicGroup();
                characteristicGroup.setId(rs.getInt("id"));
                characteristicGroup.setName(rs.getString("name"));
                characteristicGroup.setOrderNumber(rs.getInt("orderNumber"));

                characteristicGroups.add(characteristicGroup);
            }

        } catch (NamingException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ignored) {
                }
            }
        }

        request.setAttribute("size", characteristicGroups.size());
        request.setAttribute("characteristicGroups", characteristicGroups);
        request.getRequestDispatcher("/view/characteristicGroups.jsp").forward(request, response);
    }
}
