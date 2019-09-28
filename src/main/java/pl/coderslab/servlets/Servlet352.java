package pl.coderslab.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/servlet352")
public class Servlet352 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");

        //pobranie parametrów:
        req.getParameter("quantity");
        req.getParameter("price");

        HttpSession session = req.getSession();
        List<Product> products = (List<Product>) session.getAttribute("basket"); //unchecked cast??

        if(products==null) {
            resp.getWriter().println("Twój koszyk jest pusty");
        } else {



            resp.getWriter().append("<h1>TWÓJ KOSZYK</h1>");
            double totalSum = 0;

            for (Product product : products) {
                double sum = product.getQuantity() * product.getPrice(); //suma cząstkowa
                String rndSum = String.format("%.2f",sum);
                totalSum += sum; //suma sum cząstkowych

            //złe formatowania
                resp.getWriter()
                        .append("<p>")
                       .append(product.getName()).append(" - ") //pobranie nazwy produktu
                        .append(String.valueOf(product.getQuantity())).append(" x ") //pobranie ilości produktów dodanych
                        .append(String.valueOf(product.getPrice())).append("zł = ") //pobranie ceny
                        .append(String.valueOf(rndSum)).append("zł"); //pobranie sumy cząstkowej, czyli tej wyliczonej
                resp.getWriter().println("</p>");


            }
            String rndTotalSum = String.format("%.2f", totalSum);
            resp.getWriter().append("<p>");
            resp.getWriter()
                    .append("<tr>")
                    .append("<td>").append("</td>")
                    .append("<td>").append("</td>")
                    .append("<td>").append("SUMA ").append("</td>")
                    .append("<td>").append(String.valueOf(rndTotalSum)).append("</td>") //całkowita suma
                    .append("</tr>");
            resp.getWriter().append("</table>");
            resp.getWriter().append("</p>");


        }


        resp.getWriter().append("<p>Dodaj kolejny produkt: <a href=\"/servlet351\">DODAJ</a></p>");
        }
}
