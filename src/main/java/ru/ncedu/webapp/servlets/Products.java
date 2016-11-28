package ru.ncedu.webapp.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "products", urlPatterns = "/products")
public class Products extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        viewProducts(req, resp);
    }
    private void viewProducts(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            String result = "testing page.";

            request.setAttribute("result", result);
            request.getRequestDispatcher("/view.jsp").forward(request, response);
        } catch (ServletException e) {
            String error = "Error in the server";
            errors(error, request, response);
        }
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
