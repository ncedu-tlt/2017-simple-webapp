package ru.ncedu.webapp.servlets;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Calculator extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {


        PrintWriter writer = response.getWriter();
        try {


            long numForFactorial = Long.parseLong(request.getParameter("text"));
            long result = factorial(numForFactorial);

            this.getServletContext().getRequestDispatcher("/handler.jsp?result=" + result).forward(request, response);

        } catch (NumberFormatException e) {
            writer.println("<h1>Error: </h1> <p>Number is empty <p>");
        } catch (ServletException e) {
            writer.println("<h1>Error in server </h1>" );
        }


    }

    public static long factorial(long n) {
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }

}
