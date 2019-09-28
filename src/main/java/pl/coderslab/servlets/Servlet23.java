package pl.coderslab.servlets;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.Charset;

//Servlet wczyta zawartość pliku oop.txt,
// a następnie wyświetli jego zawartość na stronie.

@WebServlet("/servlet23")
public class Servlet23 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        String pathToFile = "/Users/monikamisiewicz/Desktop/code/repositories/servlety/jeeservlet/src/main/resources/oop.txt"; //działa tylko na komputerze
//        String pathToFile = "/oop.txt"; //????? relative path nie działa

        //pobieranie resoursów do aplikacji , odczytywanie strumieniowo plików, szuka pliku w katalogu resources
        //pliki do odczytu umieszczamy w katalogu resources
        InputStream resourceAsStream = Servlet23.class.getResourceAsStream("/oop.txt");
        String file = convert(resourceAsStream, Charset.defaultCharset());
        System.out.println("file = " + file);

        System.out.println("r = " + resourceAsStream);
        resp.getWriter().append(file);

//        Path path = Paths.get(pathToFile);
//
//
//        List<String>languages = new ArrayList<>();
//            languages = Files.readAllLines(Paths.get(pathToFile));
//            for(String language:languages) {
//                System.out.println(language);
//            }
//
//        for(String param: languages) { //lista, jeden pod drugim
//            resp.getWriter().println(param);
//            resp.getWriter().print(" ");
//
//        }
//        resp.getWriter().println("************");
//        resp.getWriter().println(languages); //jak tablica, po przecinku

    }

    //metoda do przekształcenia streama na Stringa
    public String convert(InputStream inputStream, Charset charset) throws IOException {


        StringBuilder stringBuilder = new StringBuilder();
        String line = null;

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, charset))) {
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
        }

        return stringBuilder.toString();
    }
}
