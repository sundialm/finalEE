package kz.iitu.javaee.Servlets.Admin;

import kz.iitu.javaee.DB.DBManager;
import kz.iitu.javaee.DB.Publication;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/addPublication")
public class AddPublicationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String description = request.getParameter("description");
        double rating = Double.parseDouble(request.getParameter("rating"));
        if (DBManager.addPublication(new Publication(null, name,description,rating))){
            response.sendRedirect("/publicationsAdmin?success");
        }
        else response.sendRedirect("/publicationsAdmin?error");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
