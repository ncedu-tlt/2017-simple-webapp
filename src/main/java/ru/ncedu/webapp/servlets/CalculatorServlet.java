package ru.ncedu.webapp.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", urlPatterns = {"/calculate"})
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String valueStr = request.getParameter("value");
        try {
            long value = Long.valueOf(valueStr);
            request.setAttribute("result", value * value);
            request.getRequestDispatcher("/view/result.jsp").forward(request, response);
        }
        catch (Exception e) {
            request.setAttribute("errorMsg", e.getClass().toString() + ": " + e.getLocalizedMessage());
            request.getRequestDispatcher("/view/error.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new UnsupportedOperationException("GET method");
    }
}
