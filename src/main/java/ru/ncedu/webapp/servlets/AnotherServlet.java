package ru.ncedu.webapp.servlets;

import ru.ncedu.webapp.servlets.models.Characteristic;

import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Antoine on 28.11.2016.
 */
@WebServlet(name = "SqlServlet", urlPatterns = {"/sql"})
public class AnotherServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Characteristic> characteristics = new ArrayList<>();

        Statement statement = null;
        try {
            InitialContext context = new InitialContext();

            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/postgres");

            if (dataSource == null) throw new RuntimeException("Data source not found!");

            Connection connection = dataSource.getConnection();

            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select id, name, groupid, categoryid " +
                    "from сharacteristic");
            while (resultSet.next()) {
                Characteristic characteristic = new Characteristic();
                characteristic.setId(resultSet.getInt("id"));
                characteristic.setName(resultSet.getString("name"));
                characteristic.setGroupId(resultSet.getInt("groupid"));
                characteristic.setCategoryId(resultSet.getInt("categoryid"));

                characteristics.add(characteristic);
            }
        } catch (NamingException | SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ignored) {

                }
            }
        }

        req.setAttribute("size", characteristics.size());
        req.setAttribute("characteristics", characteristics);
        req.getRequestDispatcher("/view/characteristic.jsp").forward(req, resp);
    }
}
