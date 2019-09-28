package pl.coderslab.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/servlet32")
public class Servlet32 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String binary = req.getParameter("binary");

        String regex = "[01]+"; //1 lub więcej cyfr 0 lub 1
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(binary);

        char[] digits = binary.toCharArray(); //zamiana stringa na tablicę charów
        System.out.println(Arrays.toString(digits));
        boolean isAMatch = binary.matches(regex);
        int decimal = 0;


        if (!isAMatch) {
            resp.getWriter().println("Nieprawidłowa wartość binarna");
        } else {

            for (int i = digits.length - 1, j = 0; i >= 0; i--, j++) {
                decimal += (int)Math.pow(2, j) * Character.getNumericValue(digits[i]);
            }
            resp.getWriter().append(binary).append(" to liczba ").append(String.valueOf(decimal));
        }

    }
}
