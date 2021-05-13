package kz.iitu.javaee.Servlets.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import kz.iitu.javaee.DB.DBManager;
import kz.iitu.javaee.DB.Language;
import kz.iitu.javaee.DB.Publication;
import kz.iitu.javaee.DB.SongLyrics;

@WebServlet(value = "/home")
public class HomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id_str = request.getParameter("publication_id");

        String body_color = "white";
        String style_of_pages = "default";
        String color_navbar2 = "white";
        String color_dif = "white";
        String dif_text1 = "white";
        String dif_text2 = "white";
        String navbar2_border_width="0px";
        String navbar2_border_color = "white";
        String dif_border_width="0px";
        String dif_border_color = "white";
        String navbar2_pub_color = "white";
        String navbar1_back_color = "white";
        String navbar1_text_color = "darkgrey";
        String navbar1_border_color = "white";
        String navbar1_border_width = "0px";
        String song_img = "0%";
        String song_card_background = "white";
        String song_card_text = "black";

        ArrayList<SongLyrics> songLyrics = DBManager.allSongLyrics();

        ArrayList<Publication> publications = DBManager.allPublications();
        ArrayList<Language> languages =  DBManager.allLanguages();

        int language_id = 2;

        if (id_str != null){
            Long id = Long.valueOf(id_str);
            songLyrics = DBManager.getSongsByPublicationId(id);
        }

        if (style_of_pages.equals("default")){
            body_color = "white";
            color_navbar2 ="rgba(48,100,60,0.89)";
            color_dif = "rgba(10,221,212,0.89)";
            dif_text1 = "white";
            dif_text2 = "white";
            navbar2_border_width="0px";
            navbar2_border_color = "white";
            dif_border_width = "0";
            dif_border_color = "white";
            navbar2_pub_color = "white";
            navbar1_back_color = "white";
             navbar1_text_color = "darkgrey";
             navbar1_border_color = "white";
             navbar1_border_width = "0px";
             song_img = "0%";
            song_card_background = "white";
            song_card_text = "black";

        }
        if (style_of_pages.equals("light")){
            body_color = "white";
            color_navbar2 ="white";
            color_dif = "white";
            dif_text1 = "black";
            dif_text2 = "black";
            navbar2_border_width="0px";
            navbar2_border_color = "white";
            dif_border_width = "2px";
            dif_border_color = "red";
            navbar2_pub_color = "black";
            navbar1_back_color = "white";
             navbar1_text_color = "darkgrey";
             navbar1_border_color = "white";
             navbar1_border_width = "0px";
            song_img = "0%";
             song_card_background = "white";
            song_card_text = "black";

        }
        if (style_of_pages.equals("dark")){
            body_color = "#5F626F";
            color_navbar2 ="5F626F";
            color_dif = "white";
            dif_text1 = "5F626F";
            dif_text2 = "5F626F";
            navbar2_pub_color = "white";
            navbar2_border_width="2px";
            navbar2_border_color = "white";
            dif_border_width = "0px";
            dif_border_color = "white";

            navbar1_back_color = "5F626F";
            navbar1_text_color = "white";
            navbar1_border_color = "white";
            navbar1_border_width = "2px";
            song_img = "0%";
            song_card_background = "white";
            song_card_text = "black";

        }
        if (style_of_pages.equals("monochrome")){
            body_color = "#313131";
            color_navbar2 ="313131";
            color_dif = "313131";

            navbar2_pub_color = "white";
            navbar2_border_width="2px";
            navbar2_border_color = "white";

            dif_border_width = "2px";
            dif_border_color = "white";
            dif_text1 = "white";
            dif_text2 = "white";

            navbar1_back_color = "313131";
            navbar1_text_color = "white";
            navbar1_border_color = "white";
            navbar1_border_width = "2px";
            song_img = "100%";
            song_card_background = "313131";
            song_card_text = "white";

        }
        if (style_of_pages.equals("monochrome_inverse")){
            body_color = "white";
            color_navbar2 ="white";
            color_dif = "white";

            navbar2_pub_color = "black";
            navbar2_border_width="2px";
            navbar2_border_color = "black";

            dif_border_width = "2px";
            dif_border_color = "black";
            dif_text1 = "black";
            dif_text2 = "black";

            navbar1_back_color = "white";
            navbar1_text_color = "black";
            navbar1_border_color = "black";
            navbar1_border_width = "2px";
            song_img = "100%";
            song_card_background = "white";
            song_card_text = "black";

        }

        request.setAttribute("body_color", body_color);
        request.setAttribute("color_navbar2", color_navbar2);
        request.setAttribute("navbar2_border_width", navbar2_border_width);
        request.setAttribute("navbar2_border_color", navbar2_border_color);
        request.setAttribute("color_dif", color_dif);
        request.setAttribute("dif_text1", dif_text1);
        request.setAttribute("dif_text2", dif_text2);
        request.setAttribute("dif_border_width", dif_border_width);
        request.setAttribute("dif_border_color", dif_border_color);
        request.setAttribute("navbar2_pub_color", navbar2_pub_color);
        request.setAttribute("navbar1_back_color", navbar1_back_color);
        request.setAttribute("navbar1_text_color", navbar1_text_color);
        request.setAttribute("navbar1_border_color", navbar1_border_color);
        request.setAttribute("navbar1_border_width", navbar1_border_width);
        request.setAttribute("song_img", song_img);
        request.setAttribute("song_card_background", song_card_background);
        request.setAttribute("song_card_text", song_card_text);
        request.setAttribute("language_id", language_id);
        request.setAttribute("songLyrics", songLyrics);
        request.setAttribute("publications", publications);
        request.setAttribute("languages", languages);
        request.getRequestDispatcher("user/home.jsp").forward(request, response);
    }
}
