package kz.iitu.javaee.Servlets.Admin;

import kz.iitu.javaee.DB.DBManager;
import kz.iitu.javaee.DB.Language;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/deletePublication")
public class DeletePublicationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        if (DBManager.deletePublication(id)){
            response.sendRedirect("/publicationsAdmin");

        }
        else response.sendRedirect("404.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
