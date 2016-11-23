package ru.ncedu.webapp.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "calc", urlPatterns = "/calc")
public class PrintParamsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        calc(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        calc(req, resp);
    }

    private void calc(HttpServletRequest calcRequest, HttpServletResponse calcResponse) throws IOException, ServletException {
        try {

            double num1 = Double.parseDouble(calcRequest.getParameter("text1"));
            double num2 = Double.parseDouble(calcRequest.getParameter("text2"));
            String operation = String.valueOf(calcRequest.getParameter("operation"));
            double result = 0;
            calcRequest.setAttribute("result", result(num1, num2 ,result, operation));
            calcRequest.getRequestDispatcher("view/result.jsp").forward(calcRequest, calcResponse);
        } catch (NumberFormatException e) {
            String error = "Number is empty";
            errors(error, calcRequest, calcResponse);

        } catch (ServletException e) {
            String error = "Errors on Servlet";
            errors(error, calcRequest, calcResponse);
        }

    }

    private void errors(String error, HttpServletRequest errRequest, HttpServletResponse errResponse) throws ServletException, IOException {
        errRequest.setAttribute("errors", error);
        errRequest.getRequestDispatcher("view/errors.jsp").forward(errRequest, errResponse);
    }

    private double result(double num1, double num2, double result, String operation){
        switch (operation) {
            case "sum":
                result = num1 + num2;
                break;
            case "dif":
                result = num1 - num2;
                break;
            case "mul":
                result = num1 * num2;
                break;
            case "div":
                result = num1 / num2;
                break;
            case "pow":
                result = Math.pow(num1, num2);
                break;
            case "sqrt":
                result = Math.sqrt(num1);
                break;
        }
        return result;
    }
}