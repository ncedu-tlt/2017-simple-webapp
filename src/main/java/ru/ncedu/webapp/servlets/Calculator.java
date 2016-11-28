package ru.ncedu.webapp.servlets;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "calc", urlPatterns = "/calc")
public class Calculator extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            long numForFactorial = Long.parseLong(request.getParameter("text"));
            long result = factorial(numForFactorial);

            request.setAttribute("result", result);
            request.getRequestDispatcher("/handler.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            String error = "Number is empty.";
            errors(error, request, response);
        } catch (ServletException e) {
            String error = "Error in the server";
            errors(error, request, response);
        }


    }

    private long factorial(long n) {
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }

    private void errors(String error, HttpServletRequest errRequest, HttpServletResponse errResponse) {
        errRequest.setAttribute("errors", error);
        try {
            errRequest.getRequestDispatcher("/error.jsp").forward(errRequest, errResponse);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
