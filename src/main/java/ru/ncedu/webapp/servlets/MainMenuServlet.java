package ru.ncedu.webapp.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "mainMenu", urlPatterns = "/mainMenu")
public class MainMenuServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        mainMenu(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        mainMenu(req, resp);
    }

    private void mainMenu(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String choice = String.valueOf(request.getParameter("choice"));
        switch (choice){
            case "calc":
                request.getRequestDispatcher("/view/calc.jsp").forward(request,response);
                break;
            case "price":
                request.getRequestDispatcher("/price").forward(request,response);
                break;
        }
        /*if (request.getParameter("price")!=null) {

        }*/
    }
}