package pl.coderslab.cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/rememberMe")
public class Cookie37 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");

        String firstName = req.getParameter("firstName");
        //sprawdzenie czy ciasteczko istnieje
        Cookie[] cookies = req.getCookies();//pobranie ciasteczek za pomocą metody HttpServletRequest.getCookies()
        Cookie cookie = CookieUtils.findCookie("firstName", cookies);//sprawdzenie czy ciasteczko istnieje:
        if (cookie != null) { //jeśli nie ciasteczko istnieje
            String userName = cookie.getValue();
            resp.getWriter().append("Cześć ").append(userName).append("! Twoje dane zostały wczytane z ciasteczka.");

        } else {

            resp.getWriter()
                    .append("<p>")
                    .append("<form action = \"/rememberMe\" method=\"post\">\n" +
                            "    <label>\n" +
                            "        Nazwa: <input type=\"text\" name=\"firstName\" /> <br/>\n" +
                            "    </label>\n" +
                            "    <label>\n" +
                            "       Zapamiętaj mnie: <input type=\"checkbox\" name=\"rememberMe\" value=\"true\" /> <br/>\n" + //domyślnie zaznaczony
                            "    </label>\n" +
                            "    <input type = \"submit\" value=\"Wyślij\"/>\n" +
                            "</form>")
                    .append("</p>");

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");

        String firstName = req.getParameter("firstName");
        String rememberMe = req.getParameter("rememberMe");

        resp.getWriter().append("Cześć ").append(firstName);
        boolean isChecked = Boolean.parseBoolean(rememberMe);

        if (isChecked) { //jeśli checkbox jest zaznaczony
            Cookie newCookie = new Cookie("firstName", firstName);//utworzenie ciasteczka i zapamiętanie imienia użytkownika
            resp.addCookie(newCookie);
            System.out.println("ciasteczko zostało dodane");
        }
    }
}
