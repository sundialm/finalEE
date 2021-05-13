package kz.iitu.javaee.Servlets.Admin;

import kz.iitu.javaee.DB.DBManager;
import kz.iitu.javaee.DB.Language;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/languagesAdmin")
public class LanguageAdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        ArrayList<Language> languages = DBManager.allLanguages();
        request.setAttribute("languages", languages);
        request.getRequestDispatcher("admin/languages_admin.jsp").forward(request,response);
    }
}
