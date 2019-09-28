package pl.coderslab.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//Celem zadania jest przechowywanie koszyka zakupowego.

@WebServlet("/servlet351")
public class Servlet351 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");

        resp.getWriter().append("<p>");
        resp.getWriter()
                .append("<form action = \"/servlet351\" method=\"post\">\n" +
                        "   <label>\n" +
                        "   Nazwa: <input type=\"text\" name=\"name\"> <br/>\n" +
                        "</label>\n" +
                        "    <label>\n" +
                        "        Ilość: <input type=\"number\" name=\"quantity\" /> <br/>\n" +
                        "    </label>\n" +
                        "    <label>\n" +
                        "        Cena: <input type=\"number\" step=\"0.01\" name=\"price\" /> <br/>\n" +
                        "    </label>\n" +
                        "\n" +
                        "    <input type = \"submit\" value=\"Wyślij\"/>\n" +
                        "</form>\n")
                .append("Twój koszyk: <a href=\"/servlet352\">PRZEJDŹ DO KOSZYKA</a><br/>");
        resp.getWriter().append("</p>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");

        //Po przesłaniu danych metodą POST przesłany produkt wraz z ceną i ilością
        // dodaj do sesji pod kluczem basket.

        //pobranie parametrów
        String name = req.getParameter("name");
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        double price = Double.parseDouble(req.getParameter("price"));

        //pobranie sesji
        HttpSession session = req.getSession();
        //ustawienie atrybutu
        if (session.getAttribute("basket") == null) {
            session.setAttribute("basket", new ArrayList<Product>());
        }

        //zapisanie przesłanego produktu (z ceną i ilością) w sesji pod kluczem basket
        List<Product> products = (List<Product>) session.getAttribute("basket");
        products.add(new Product(name, quantity, price)); //dodanie produktu do listy
        resp.getWriter().println("Produkt dodany");
        resp.sendRedirect(req.getContextPath() + "/servlet351"); //przekierowanie



    }


}
