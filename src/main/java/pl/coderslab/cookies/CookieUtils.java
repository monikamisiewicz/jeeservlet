package pl.coderslab.cookies;

import javax.servlet.http.Cookie;

public class CookieUtils {

    public static Cookie findCookie(String name, Cookie[] cookies){

        //sprawdzenie tablicy cookies czy nie jest nullem
        if(cookies !=null) {
            for(Cookie cookie: cookies) {
                if(cookie.getName().equals(name)) {
                    return cookie;
                }
            }
        }
        return null;
    }
}
