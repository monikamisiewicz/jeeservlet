package pl.coderslab.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet ("/servlet27")
public class Servlet27 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().append("<h1>Hello world.</h1>");
        response.getWriter().append("<html><body><h1>test test test").append("</h1></body></html>");
        PrintWriter writer = response.getWriter();
        writer.println("test text");
    }
}


