package ru.ncedu.webapp.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintParamsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        calc(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        calc(req, resp);
    }

    private void calc(HttpServletRequest calcRequest, HttpServletResponse calcResponse) throws IOException {
        PrintWriter calcWriter = calcResponse.getWriter();
        try {

            double num1 = Double.parseDouble(calcRequest.getParameter("text1"));
            double num2 = Double.parseDouble(calcRequest.getParameter("text2"));
            double result = 0;
            if (calcRequest.getParameter("sum") != null) {
                result = num1 + num2;
            }
            if (calcRequest.getParameter("dif") != null) {
                result = num1 - num2;
            }
            if (calcRequest.getParameter("mul") != null) {
                result = num1 * num2;
            }
            if (calcRequest.getParameter("div") != null) {
                result = num1 / num2;
            }
            if (calcRequest.getParameter("pow") != null) {
                result = Math.pow(num1, num2);
            }
            if (calcRequest.getParameter("sqrt") != null) {
                result = Math.sqrt(num1);
            }
            calcRequest.setAttribute("result", result);
            calcRequest.getRequestDispatcher("/result.jsp").forward(calcRequest, calcResponse);
        } catch (NumberFormatException e) {
            calcWriter.println("<h1>Error</h1>" + "Number is empty");
        } catch (ServletException e) {
            e.printStackTrace();
        }

    }
}