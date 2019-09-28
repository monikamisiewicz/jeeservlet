package pl.coderslab.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

@WebServlet("/servlet242")
public class Servlet242 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");


        List<String> products = new ArrayList<>();
        products.add("\"Asus Transformr;2999.99\"");
        products.add("iPhone 6';3499.18");
        products.add("Converse Sneakers;125.00");
        products.add("LG OLED55B6P OLED TV;6493.91");
        products.add("Samsung HT-J4100;800.99");
        products.add("Alpine Swiss Dress Belt;99.08");
        products.add("60 Watt LED;1.50");
        products.add("Arduino Nano;3.26");


        int id = Integer.parseInt(req.getParameter("id")); //pobranie parametru id i konwersja na int
        String s = products.get(id); //pobranie produktu z listy i przypisanie do zmiennej
        String[] split = s.split(";"); //utworzenie tablicy i rozdzielenie elementu po średniku, powstaną 2 elementy
        resp.getWriter().println(split[0] + " - " + split[1] + "zł"); //odpowiedz

    }
}




