package kz.iitu.javaee.Servlets.Admin;

import kz.iitu.javaee.DB.DBManager;
import kz.iitu.javaee.DB.Publication;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/updatePublication")
public class UpdatePublicationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Long id = Long.valueOf(request.getParameter("update_id"));
        String name = request.getParameter("update_name");
        String description = request.getParameter("update_description");
        double rating = Double.parseDouble(request.getParameter("update_rating"));
        if (DBManager.updatePublication(new Publication(id, name, description,rating))){
            response.sendRedirect("/publicationsAdmin?success");
        }
        else response.sendRedirect("/publicationsAdmin?error");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
