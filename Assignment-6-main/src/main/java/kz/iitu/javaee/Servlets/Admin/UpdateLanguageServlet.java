package kz.iitu.javaee.Servlets.Admin;

import kz.iitu.javaee.DB.DBManager;
import kz.iitu.javaee.DB.Language;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/updateLanguage")
public class UpdateLanguageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Long id = Long.valueOf(request.getParameter("update_id"));
        String name = request.getParameter("update_name");
        String code = request.getParameter("update_code");
        if (DBManager.updateLanguage(new Language(id, name, code))){
            response.sendRedirect("/languagesAdmin?success");
        }
        else response.sendRedirect("/languagesAdmin?error");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
