package ru.ncedu.webapp.servlets;


import model.Market;

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

@WebServlet(name = "MarketServlet", urlPatterns = {"/market"})
public class MarketServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Market> markets = new ArrayList<>();

        Statement stmt = null;
        Connection connection = null;

        try {
            InitialContext cxt = new InitialContext();
            DataSource ds = (DataSource) cxt.lookup("java:comp/env/jdbc/postgres");

            if (ds == null) {
                throw new RuntimeException("Data source not found!");
            }

            connection = ds.getConnection();
            stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT id, name FROM market");
            while (rs.next()) {
                Market market = new Market();
                market.setId(rs.getInt("id"));
                market.setName(rs.getString("name"));

                markets.add(market);
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
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ignored) {
                }
            }
        }

        request.setAttribute("size", markets.size());
        request.setAttribute("markets", markets);
        request.getRequestDispatcher("markets.jsp").forward(request, response);
    }
}