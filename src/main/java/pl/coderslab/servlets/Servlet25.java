package pl.coderslab.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet("/servlet25")
public class Servlet25 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        System.out.println();
        Random random = new Random();
        int[] randomNumbers = new int[10];
        List<Integer> reversedList = new ArrayList<>();

        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = random.nextInt(100); //zakres od 0-99
            System.out.println(randomNumbers[i] + 1);//dodajemy 1 aby otrzymać liczby z zakresu 1-100
            reversedList.add(randomNumbers[i]);
        }

        resp.getWriter().println("<p> Random number list: " + Arrays.toString(randomNumbers) + "<br/>");
        Collections.reverse(reversedList);
        resp.getWriter().println("Reversed list: " + reversedList +"<br/>");
        Collections.sort(reversedList);
        resp.getWriter().println("Sorted list: " + reversedList + "<br/>");

        resp.getWriter().println("*******" + "<br/>");
        resp.getWriter().append("<table>");

        for (int i = 1; i <= randomNumbers.length; i++) {
            resp.getWriter().append("<tr><td>");
            resp.getWriter().append(String.valueOf(randomNumbers[i] + 1));
            resp.getWriter().append("</td></tr>");
        }
        resp.getWriter().append("</table></p>");






//        Random random = new Random();
//        int[] randomNumbers = new int[10];
//
//        for (int i = 0; i < randomNumbers.length; i++) {
//            randomNumbers[i] = random.nextInt(100)+1; //zakres od 0-99, dodajemy 1 aby otrzymać liczby z zakresu 1-100
//            System.out.println(randomNumbers[i] );
//
//        }
//       int[] sortedNumbers = Arrays.copyOf(randomNumbers, randomNumbers.length);
//       Arrays.sort(sortedNumbers);
//
//
//        resp.getWriter().append("<table border=\"10\">");
//        resp.getWriter().append("<table>");
//        resp.getWriter().append("<tr>");
//        for (int i = 1; i <= randomNumbers.length; i++) {
//            resp.getWriter().append("<td>" + randomNumbers[i] + "</td>");
//        }
//        resp.getWriter().append("</tr>");
//        resp.getWriter().append("</table>");
//
//
//
//        resp.getWriter().append("<table border=\"5\">");
//        resp.getWriter().append("<table>");
//        resp.getWriter().append("<tr>");
//        for (int i = 1; i <= sortedNumbers.length; i++) {
//            resp.getWriter().append("<td>" + sortedNumbers[i] + "</td>");
//        }
//        resp.getWriter().append("</tr>");
//        resp.getWriter().append("</table>");


    }
}



