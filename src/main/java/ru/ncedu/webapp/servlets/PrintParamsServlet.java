package ru.ncedu.webapp.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/calc")
public class PrintParamsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        double result = 0;
        try {
            double number1 = Double.parseDouble(request.getParameter("number1"));
            double number2 = Double.parseDouble(request.getParameter("number2"));
            int operation = Integer.valueOf(request.getParameter("operation"));

            switch (operation) {
                case 1:
                    result = number1 + number2;
                    break;
                case 2:
                    result = number1 - number2;
                    break;
                case 3:
                    result = number1 * number2;
                    break;
                case 4:
                    result = number1 / number2;
                    break;
            }

            request.setAttribute("Result", result);
            request.getRequestDispatcher("/result.jsp").forward(request, response);

        } catch (ServletException e) {
            e.printStackTrace();
            String error = "error";
            request.setAttribute("Error", error);
            request.getRequestDispatcher("/error.jsp").forward(request, response);

        } catch (NumberFormatException e) {
            e.printStackTrace();
            String error = "NumberFormatException";
            request.setAttribute("NumberFormatException", error);
            request.getRequestDispatcher("/numberFormatException.jsp").forward(request, response);
        }
    }
}