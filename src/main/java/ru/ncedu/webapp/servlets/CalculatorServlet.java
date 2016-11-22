package ru.ncedu.webapp.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculatorServlet", urlPatterns = {"/calculate"})
public class CalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter writer = response.getWriter();
        double result = 0;
        try {
            double number1 = Double.valueOf(request.getParameter("number1"));
            double number2 = Double.valueOf(request.getParameter("number2"));
            int action = Integer.valueOf(request.getParameter("action"));

            switch (action) {
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
        } catch (Exception e) {
            request.setAttribute("error", e.getClass().toString());
            request.getRequestDispatcher("/view/error.jsp").forward(request, response);
            return;
        }

        request.setAttribute("result", result);
        request.getRequestDispatcher("/view/result.jsp").forward(request, response);

    }
}