package pl.coderslab.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servlet241")
public class Servlet241 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //Na pierwszej stronie (Servlet241) wygeneruj linki do strony Servlet242, które będą przesyłały
        // metodą GET id szukanego produktu (wygeneruj dla id z zakresu od 0 do 7)


            for (int i = 0; i <= 7; i++) {
                resp.getWriter().append("<p>");
                resp.getWriter().append("<html><body> <a href=/servlet242?id=").append(i + "> ").append(i +"").append("</a></body></html>").append("<br>");
                resp.getWriter().print(i);
                resp.getWriter().append("</p>");

            }


// "<html><body>  przenieśc przed pętlę for a zamykające za pętlę


    }
}
