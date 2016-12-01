package ru.ncedu.webapp.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class Calculator extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        runCalculate(req, resp);
    }

    private void runCalculate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            double num1 = Double.parseDouble(req.getParameter("num_1"));
            double num2 = Double.parseDouble(req.getParameter("num_2"));

            String operation = req.getParameter("operation").toString();

            double result = calculate(num1, num2, operation);
            if (result == 0.0) {
                String error = getError(0);
                sendError(req, resp, error);
            } else {
                sendCalc(req, resp, result);
            }
        } catch (NumberFormatException e) {
            String error = getError(1);
            sendError(req, resp, error);
        } catch (ServletException e) {
            String error = getError(2);
            sendError(req, resp, error);
        }
    }

    private void sendCalc(HttpServletRequest req, HttpServletResponse resp, double result) throws ServletException, IOException {
        req.setAttribute("result", result);
        req.getRequestDispatcher("view/result.jsp").forward(req, resp);
    }

    private double calculate(double num1, double num2, String operation) {
        double result;
        switch (operation) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            default:
                result = 0.0;
        }

        return result;
    }

    private String getError(int error) {
        String result = null;
        switch (error) {
            case 0:
                result = "Operation not found";
                break;
            case 1:
                result = "Number format error: ";
                break;
            case 2:
                result = "Servlet error: ";
                break;
        }
        return result;
    }

    private void sendError(HttpServletRequest req, HttpServletResponse resp, String error) throws ServletException, IOException {
        try {
            req.setAttribute("error", error);
            req.getRequestDispatcher("view/error.jsp").forward(req, resp);
        } catch (ServletException e) {
            String error_servlet = getError(2);
            sendError(req, resp, error_servlet);
        }
    }
}