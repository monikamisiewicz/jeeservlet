package pl.coderslab.sessions;

import pl.coderslab.servlets.Country;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

//ZLE , POPRAWIC

@WebServlet("/sess39")
public class Sess39 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");

        List<Country> listOfCountries = initialize();
        Map<Country, String> countries = getMap(listOfCountries); //pobranie mapy

        int countCorrect = 0;

        for (int i = 0; i < listOfCountries.size(); i++) {
            String countryName = listOfCountries.get(i).getName();


            resp.getWriter()
                    .append("<p>")
                    .append("<form action=\"/sess39\" method=\"get\">\n" +
                            "    <label>\n" +
                            "        Stolica: <input type=\"text\" name=\"capital\"/>\n" +
                            "    </label>\n" +
                            "    <input type=\"submit\" value=\"Sprawdź\">\n" +
                            "</form>\n")
                    .append("</p>");

            resp.getWriter().append("Podaj stolicę dla państwa ").append(countryName).append(": ");




            //pobranie parametru z formularza:
            String capital = req.getParameter("capital");


            Set<Map.Entry<Country, String>> entries = countries.entrySet();
            for (Map.Entry<Country, String> entry : entries) {
                Country key = entry.getKey();
                String value = entry.getValue();
                System.out.println(key + " => " + value);

                if(key.getName().equals(countryName)) {
                    if (capital.equalsIgnoreCase(value)) {
                        countCorrect++;
                        resp.getWriter()
                                .append("<p>")
                                .append("Odpowiedź poprawna :)")
                                .append("</p>");
                        break;
                    }
                }
            }

        }
        resp.getWriter().append("<h4> Poprawnych odpowiedzi : ").append(String.valueOf(countCorrect)).append("</h4>");


//        int countCorrect = 0;
//        for (Map.Entry<Country, String> entry : countries.entrySet()) {
//            resp.getWriter().append("Podaj stolicę dla państwa ").append(entry.getKey().getName()).append(": ");
//
//            Iterator it = countries.entrySet().iterator();
//            while (it.hasNext()) {
//
//
//                String capital = req.getParameter("capital");
//                if (capital.equals(value)) {
//                    countCorrect++;
//                    resp.getWriter().println("Odpowiedź poprawna :)");
//                } else {
//                    resp.getWriter().println("Odpowiedź błędna :(");
//                }
//            }
//        }
//        resp.getWriter().append("<h4> Poprawnych odpowiedzi : ").append(String.valueOf(countCorrect)).append("</h4>");
    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        resp.setCharacterEncoding("UTF-8");
//        resp.setContentType("text/html");

//        List<Country> listOfCountries = initialize();
//        Map<Country, String> countries = getMap(listOfCountries); //pobranie mapy
//
//
//        int countCorrect = 0;
////        Iterator it = countries.entrySet().iterator();
//
////        for (int i = 0; i < listOfCountries.size(); i++) {
////            String countryName = listOfCountries.get(i).getName();
////            resp.getWriter().append("Podaj stolicę dla państwa ").append(countryName).append(": ");
//
//            //pobranie parametru z formularza:
//            String capital = req.getParameter("capital");
//
//            //pobranie wartości na podstawie klucza:
//            Set<Country> keys = countries.keySet();
//            for (Country key : keys) {
//                String value = countries.get(key);  // pobieramy wartość na podstawie klucza
//
//                if (capital.equals(value)) {
//                    countCorrect++;
//                    resp.getWriter().println("Odpowiedź poprawna :)");
//                } else {
//                    resp.getWriter().println("Odpowiedź błędna :(");
//                }
//                resp.getWriter().append("<h4> Poprawnych odpowiedzi : ").append(String.valueOf(countCorrect)).append("</h4>");
//            }
////        }


//    }

    public static List<Country> initialize() {

        List<Country> countries = new ArrayList<>(); //lista obiektów klasy Country
        countries.add(new Country("Rosja", "Moskwa"));
        countries.add(new Country("Niemcy", "Berlin"));
        countries.add(new Country("Litwa", "Wilno"));
        countries.add(new Country("Białoruś", "Mińsk"));
        countries.add(new Country("Słowacja", "Bratysława"));
        countries.add(new Country("Czechy", "Praga"));
        countries.add(new Country("Ukraina", "Kijów"));

        return countries;
    }

    public static Map<Country, String> getMap(List<Country> list) {

        Map<Country, String> countryMap = new HashMap<>();//utworzenie mapy
        for (Country country : list) {
            countryMap.put(country, country.getCapital());//umieszczenie kluczy i wartości w mapie
        }

        return countryMap;
    }

}
