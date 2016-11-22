package ru.ncedu.webapp.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;

@WebServlet("/calc")
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        addition(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        addition(req, resp);
    }

    private void addition(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        try {
            long number1 = Long.parseLong(req.getParameter("x"));
            long number2 = Long.parseLong(req.getParameter("y"));
            long result = plus(number1, number2);
            req.setAttribute("Result", result);
            req.getRequestDispatcher("/result.jsp").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
            String error = "SomeError";
            req.setAttribute("Error", error);
            req.getRequestDispatcher("/error.jsp").forward(req, resp);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            String numberFormatException = "NumberFormatException";
            req.setAttribute("NumberFormatException", numberFormatException);
            req.getRequestDispatcher("/numberFormatException.jsp").forward(req, resp);
        }

    }

    private long plus(long x, long y) {
        return x + y;
    }
}