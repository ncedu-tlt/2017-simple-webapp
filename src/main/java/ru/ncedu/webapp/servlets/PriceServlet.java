package ru.ncedu.webapp.servlets;

import models.Price;

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

@WebServlet(name = "priceServlet", urlPatterns = "/price")
public class PriceServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dbase(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dbase(req, resp);
    }

    private void dbase(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Price> prices = new ArrayList<>();

        Statement statement = null;
        try {
            InitialContext context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/postgres");
            if (dataSource == null){
                throw new RuntimeException("Data sourse not found");
            }
            Connection connection = dataSource.getConnection();

            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT market_id, product_id, price FROM price");
            while (resultSet.next()){
                Price price = new Price();
                price.setMarketId(resultSet.getLong("market_id"));
                price.setProductId(resultSet.getLong("product_id"));
                price.setPrice(resultSet.getBigDecimal("price"));

                prices.add(price);
            }
        } catch (NamingException | SQLException e) {
            throw  new RuntimeException(e);
        }
        finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ignored) {
                }
            }

        }
        request.setAttribute("size", prices.size());
        request.setAttribute("prices", prices);
        request.getRequestDispatcher("/view/price.jsp").forward(request, response);
    }
}
