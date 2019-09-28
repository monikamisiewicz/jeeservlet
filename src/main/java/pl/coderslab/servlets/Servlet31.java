package pl.coderslab.servlets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet("/servlet31")
public class Servlet31 extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(Servlet31.class);

  //http://localhost:8080/servlet31.html

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //pobranie parametrów
        double amount = Double.parseDouble(req.getParameter("amount"));
        String currency = req.getParameter("currency");

        double result = 0;
        switch (currency) {
            case "eurToUsd":
                result = amount * 1.099;
                resp.getWriter().println( amount + " euro = " + result + " usd" );
                resp.getWriter().append(String.valueOf(amount)).append(" euro = ").append(String.valueOf(result)).append(" usd");
                break;
            case "usdToEur":
                result = amount * 0.910;
                resp.getWriter().println(amount + " usd = " + result + " eur" );
                break;
            case "eurToPln":
                result = amount * 4.380;
                resp.getWriter().println(amount + " eur = " + result + " pln" );
                break;
            case "plnToEur":
                result = amount * 0.228;
                resp.getWriter().println(amount + " pln = " + result + " eur" );
                break;
            case "usdToPln":
                result = amount * 3.984;
                resp.getWriter().println(amount + " usd = " + result + " pln" );
                break;
            case "plnToUsd":
                result = amount * 0.251;
                resp.getWriter().println(amount + " pln = " + result + " usd" );
                break;

            default:
                resp.getWriter().println("Nieprawidłowe dane");
                break;
        }

        //LUB
        Map<String, Double> map = new HashMap<>();
        map.put("eurusd", 1.1);
        map.put("usdeur", 0.9);
        map.put("eurpln", 4.38);
        map.put("plneur", 0.23);
        map.put("usdpln", 3.98);
        map.put("plnusd", 0.25);

        for (Map.Entry<String, Double> entry : map.entrySet()) {
            if (entry.getKey().equals(currency)) {
                resp.getWriter().println(amount * entry.getValue());
            }
        }


    }
}
