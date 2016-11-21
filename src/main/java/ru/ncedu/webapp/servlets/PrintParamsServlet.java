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
            if (calcRequest.getParameter("sum") != null) {
                calcWriter.println("<h1>Sum</h1>" + (num1 + num2));
            }
            if (calcRequest.getParameter("dif") != null) {
                calcWriter.println("<h1>Difference</h1>" + (num1 - num2));
            }
            if (calcRequest.getParameter("mul") != null) {
                calcWriter.println("<h1>Multiplication</h1>" + (num1 * num2));
            }
            if (calcRequest.getParameter("div") != null) {
                calcWriter.println("<h1>Division</h1>" + (num1 / num2));
            }
            if (calcRequest.getParameter("pow") != null) {
                calcWriter.println("<h1>Involution</h1>" + (Math.pow(num1, num2)));
            }
            if (calcRequest.getParameter("sqrt") != null) {
                calcWriter.println("<h1>Square</h1>" + (Math.sqrt(num1)));
            }
        } catch (NumberFormatException e) {
            calcWriter.println("<h1>Error</h1>" + "Number is empty");
        }
    }
}