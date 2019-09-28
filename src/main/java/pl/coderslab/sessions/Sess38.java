package pl.coderslab.sessions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Random;

@WebServlet("/sess38")
public class Sess38 extends HttpServlet {

    //Losowanie liczb z zakresu [20,1000]
    Random random = new Random();
    private int num1 = random.nextInt(981) + 20;
    private int num2 = random.nextInt(981) + 20;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        //?jak zapamiętać 2 liczby w sesji i ich potem użyć w metodzie doPost?
        HttpSession session =  req.getSession();
        session.setAttribute("num1", num1);
        session.setAttribute("num2", num2);


        resp.getWriter().println("<h4>WYLOSOWANE LICZBY: </h4>");
        resp.getWriter().append("<p>").append(String.valueOf(num1)).append("</p>");
        resp.getWriter().append("<p>").append(String.valueOf(num2)).append("</p>");
        resp.getWriter().println("Podaj wyniki: ");

        resp.getWriter().append("<p>");
        resp.getWriter()
                .append("<form action=\"sess38\" method=\"POST\">" +
                        "    <label>" +
                        "        Dodawanie:" +
                        "        <input type=\"number\" name=\"add\">" +
                        "    </label><br/>" +
                        "    <label>" +
                        "        Odejmowanie:" +
                        "        <input type=\"number\" name=\"substract\">" +
                        "    </label><br/>" +
                        "    <label>" +
                        "        Mnożenie:" +
                        "        <input type=\"number\" name=\"multiplicate\">" +
                        "    </label><br/>" +
                        "    <input type=\"submit\" value =\"Sprawdź\">" +
                        "</form>");
        resp.getWriter().append("</p>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        //pobranie sesji i atrybutów
        HttpSession session = req.getSession();
        int num1 = (int) session.getAttribute("num1");
        int num2 = (int) session.getAttribute("num2");

        int addResult = num1 + num2;
        int substractResult = num1 - num2;
        int multiplicateResult = num1 * num2;

        int add = Integer.parseInt(req.getParameter("add"));
        int substract = Integer.parseInt(req.getParameter("substract"));
        int multiplicate = Integer.parseInt(req.getParameter("multiplicate"));

        String addAnswer;
        if (addResult == add) {
            addAnswer = "Correct";
        } else {
            addAnswer = "Wrong";
        }

        String substractAnswer;
        if (substractResult == substract) {
            substractAnswer = "Correct";
        } else {
            substractAnswer = "Wrong";
        }

        String multiplicateAnswer;
        if (multiplicateResult == multiplicate) {
            multiplicateAnswer = "Correct";
        } else {
            multiplicateAnswer = "Wrong";
        }

        resp.getWriter()
                .append("<p>")
                .append(String.valueOf(num1)).append(" + ").append(String.valueOf(num2)).append(" = ")
                .append(String.valueOf(addResult)).append(" ").append(addAnswer)
                .append("</p>");
        resp.getWriter()
                .append("<p>")
                .append(String.valueOf(num1)).append(" - ").append(String.valueOf(num2)).append(" = ")
                .append(String.valueOf(substractResult)).append(" ").append(substractAnswer)
                .append("</p>");
        resp.getWriter()
                .append("<p>")
                .append(String.valueOf(num1)).append(" * ").append(String.valueOf(num2)).append(" = ")
                .append(String.valueOf(multiplicateResult)).append(" ").append(multiplicateAnswer)
                .append("</p>");


    }
}
