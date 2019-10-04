# jeeservlet
### Zadania.

1. utwórz projekt Mavena:
- groupId - **pl.coderslab**
- artifactId - **jee-servlet**.

#### Zadanie 1

1. Za pomocą pliku pom.xml dołącz do projektu bibliotekę `apache commons io`.
2. Zapoznaj się z jej możliwościami i wypróbuj wybraną z nich.
    http://commons.apache.org/proper/commons-io/

#### Zadanie 2

1. Za pomocą pliku pom.xml skonfiguruj plugin `maven-javadoc-plugin`, plugin ten służy do tworzenia różnego rodzaju archiwów zawierających nasz projekt, np. zip, jar.
2. Wykorzystamy go do utworzenia wykonywalnego archiwum jar z naszego projektu. Plik ten będzie zawierał w sobie wszystkie wymagane do uruchomienia zależności.
3. Uzupełnij plik pom o definicję pluginu (musi się znajdować w tagu **project**  :
    ```xml
    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-javadoc-plugin</artifactId>
                <version>2.10.4</version>
                <configuration>

                </configuration>
            </plugin>
        </plugins>
    </build>
    ```
4. Z konsoli lub eclipse wykonaj następującą komendę:
mvn javadoc:javadoc
5. Po poprawnym wykonaniu w folderze target otrzymamy folder site - w którym znajduje się dokumentacja z naszych klas w formacie html.
https://maven.apache.org/plugins/maven-javadoc-plugin/index.html

<!-- Links -->
[zone-date-time]:https://docs.oracle.com/javase/8/docs/api/java/time/ZonedDateTime.html 
[date-example1]:https://www.mkyong.com/java/java-convert-date-and-time-between-timezone/
[date-example2]:https://dzone.com/articles/deeper-look-java-8-date-and
[dao-wiki]:https://pl.wikipedia.org/wiki/Data_Access_Object
[lorem-ipsum]:http://pl.lipsum.com/

#### Zadanie 3

W projekcie stwórz servlet `Servlet23`, dostępny pod adresem **/servlet23**,  
Servlet wczyta zawartość pliku oop.txt, a następnie wyświetli jego zawartość na stronie. 
Jest to lista języków programowania, które wzorują się na [paradygmacie obiektowym][oop-paradygmat] pobrana z [Wikipedii][oop-wiki].


#### Zadanie 4

W projekcie stwórz servlety `Servlet241`, `Servlet242`, dostępne odpowiednio pod adresami
 **/Servlet241**, **/Servlet242**.  
Dopisz następującą funkcjonalność:
* Na pierwszej stronie (`Servlet241`) wygeneruj linki do strony `Servlet242`, 
które będą przesyłały metodą GET id szukanego produktu (wygeneruj dla id z zakresu od `0` do `7`).
* Druga strona (`Servlet242`) po odebraniu danych powinna odnaleźć w przygotowanej tablicy lub liście produkt (zakładamy że id kolejny element). 
Poniżej znajduje się przykładowa tablica z produktami:
    ```java
    String products[] = {
        "Asus Transformr;2999.99",
        "iPhone 6';3499.18",
        "Converse Sneakers;125.00",
        "LG OLED55B6P OLED TV;6493.91",
        "Samsung HT-J4100;800.99",
        "Alpine Swiss Dress Belt;99.08",
        "60 Watt LED;1.50",
        "Arduino Nano;3.26",
    };
    ```
* Jeśli produkt znajduje się w tablicy powinna zostać wyświetlona jego nazwa i cena np.`Asus Transformer - 2999.99zł`
* Jeśli wybierzemy produkt spoza zakresu powinien zostać wyświetlony komunikat `Product not found.`



#### Zadanie 5

W projekcie stwórz servlet `Servlet25` dostępny pod adresem **/servlet25**, 
który wylosuje 10 liczb z zakresu 1-100. Następnie Wyświetl dwie tabelki z tymi liczbami:
1. Pierwsza tabelka powinna wyświetlić wartości w kolejności jakiej zostały wylosowane.
2. Druga tabelka powinna wyświetlać wartości posortowane (od najmniejszej do największej).


#### Zadanie 6
1. W projekcie stwórz servlet `Servlet26` dostępny pod adresem **/servlet26**,
2. Przy pomocy kodu:
    ````java
    Map<String, String> map = new HashMap<String, String>();
    
            Enumeration headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String key = (String) headerNames.nextElement();
                String value = request.getHeader(key);
                map.put(key, value);
            }
    
            return map;
        }
    ````
    utworzysz mapę wszystkich wartości nagłówka.
3. Wyświetl wszystkie informacje w formacie: `nazwaNagłówka : wartość`.

<!-- Links -->
[oop-paradygmat]:https://pl.wikipedia.org/wiki/Programowanie_obiektowe
[oop-wiki]:https://en.wikipedia.org/wiki/List_of_object-oriented_programming_languages

### Zadania.

Rozwiązania zadań umieszczaj w utworzonym wcześniej projekcie **jee-servlet**.

#### Zadanie 1

1. W projekcie stwórz servlet `Servlet31` oraz stronę HTML `servlet31.html`,
w której zawarty jest formularz, który zawiera jedno pole liczbowe oraz pola typu `radio`. 
Po przesłaniu formularza Servlet przelicza waluty:  
    * `EUR → USD`
    * `USD → EUR`
    * `EUR → PLN`
    * `PLN → EUR`
    * `USD → PLN`
    * `PLN → USD`
  
Przeliczona kwota pokazuje się jako wynik w przeglądarce.  
Hint: Kursy walut możesz przygotować jako tablicę (kursy mogą być przez Ciebie wymyślone lub możesz je na stronie [NBP][nbp]).


#### Zadanie 2

W projekcie stwórz servlet `Servlet32`, oraz stronę HTML `servlet32.html`, w której zawarty jest formularz, zawierający jedno pole liczbowe. Po przesłaniu formularza Servlet przelicza wpisaną do formularza wartość binarną liczby na wartość dziesiętną.  
Servlet musi wykonać następujące kroki:  
  * Sprawdzić czy przekazany ciąg zawiera **tylko** `0` i `1`, jeśli nie, wyświetlić stosowny komunikat
  * Podzielić ciąg na pojedyncze znaki
  * Idąc od końca ciągu mnożyć kolejne liczby przez kolejne potęgi liczby `2`  
    * `Ostatnia liczba` x `2^0`
    * `Przedostatnia liczba` x `2^1`
    * itd.
    * Po dokonaniu obliczeń należy zsumować wszystkie wyniki potęgowania.
  * Po dokonaniu obliczenia wyświetl na stronie komunikat np. `1001 to liczba 9`.


Hint: Jeżeli nie rozumiesz jak przeliczyć liczbę zapisaną w systemie binarnym na system dziesiętny to zajrzyj [tutaj][binary-convertion].


#### Zadanie 3
W projekcie stwórz servlet `Servlet33`. Ma on implementować następujące funkcjonalności:
1. Po wejściu na stronę metodą GET (czyli w metodzie `doGet`), wygeneruj formularz z `5` polami tekstowymi `input`. Formularz ma przesyłać dane z użyciem `POST` do adresu z servletu.
2. Po otrzymaniu danych z formularza, zapisz pobrane dane w sesji.
3. Do metody `doGet` dopisz funkcjonalność sprawdzającą czy w sesji istnieją dane z poprzedniego punktu. Jeżeli dane istnieją  wypełnij nimi pola `input` formularza.

#### Zadanie 4
W projekcie stwórz servlet `Servlet34`. Celem zadania jest wyświetlanie ilości wizyt na stronie. W servlecie:
1. Sprawdź czy użytkownik posiada zapisane ciasteczko o nazwie `visits`:
    * jeśli nie, wyświetl komunikat: `Witaj pierwszy raz na naszej stronie` oraz dodaj ciasteczko o nazwie `visit`s zapisując mu wartość 1 i czas ważności 1 rok.
    * jeśli ciasteczko jest zapisane, pobierz jego aktualną wartość i wypisz na stronie komunikat `Witaj, odwiedziłeś nas już X razy`. Zwiększ też wartość ciasteczka o 1.

#### Zadanie 5
W projekcie stwórz servlet `Servlet351` oraz `Servlet352`. Celem zadania jest przechowywanie koszyka zakupowego.
1. Stwórz formularz z polem tekstowym (nazwa) oraz dwoma numerycznymi (ilość i cena) służącymi do dodawania produktu do koszyka. Formularz powinien być przesłany na tą samą stronę metodą `POST`. 
2. Po przesłaniu danych metodą POST przesłany produkt wraz z ceną i ilością dodaj do sesji pod kluczem `basket`.
 Pamiętaj, iż klucz `basket` w sesji musi przechowywać więcej niż `1` produkt (użyj tablicy). 
 Po dodaniu elementu do koszyka wyświetl komunikat `Produkt dodany` i formularz służący do dodanie następnego produktu (taki sam jak w punkcie 1).
3. Na stronie formularza dodaj odnośnik do strony wyświetlającej zawartość koszyka.
4. W servlecie `Servlet352` wyświetl zawartość koszyka oraz sumę cen produktów, pamiętaj iż każdy produkt ma dodaną ilość.

Przykład - strona koszyka:
```
Produkt 1 - 4 x 5.20zł = 20.80zł
Produkt 2 - 1 x 9.99zł =  9.99zł
Produkt 3 - 1 x 2.20zł =  2.20zł
                   SUMA: 32.99zł
```

#### Zadanie 6

W projekcie stwórz servlet `Servlet36`, oraz stronę HTML `servlet36.html`, 
w której zawarty jest formularz przesyłający (metodą GET) 4 parametry liczbowe o nazwie `num`.
 Po przejściu do servletu oblicz ich średnią, sumę oraz iloczyn i zwróć wynik w przeglądarce:

````
Liczby:
  - x1
  - x2
  - x3
  - x4
Średnia:
  - średnia 
Suma:
  - suma 
Iloczyn:
  - iloczyn 
````

#### Zadanie 7 - dodatkowe

W projekcie stwórz servlet `Cookie37`, dostępny pod adresem `/rememberMe`. Następnie:
1. W servlecie utwórz formularz, zawierający pole `name` oraz checkbox z labelem `Zapamiętaj mnie`.
 Formularz powinien przesyłać dane metodą POST na ten sam adres.
2. Dopisz obsługę metody POST w servlecie. Servlet powinien wyświetlić komunikat `Cześć {imię przesłane w formularzu}`.
 W przypadku zaznaczenia checkboxa, imię użytkownika zapamiętaj w ciasteczku.
3. Dodaj funkcjonalność, która w przypadku wejścia na stronę metodą GET sprawdzi czy istnieje odpowiednie ciasteczko.
 Jeżeli tak, to nie wyświetlaj formularza do logowania tylko wyświetl komunikat `Cześć {imię przesłane w formularzu}. Twoje dane zostały wczytane z ciasteczka`

#### Zadanie 8 - dodatkowe

W projekcie stwórz servlet `Sess38`. Następnie:
1. Wylosuj w nim 2 liczby całkowite z przedziału 20-1000.
2. Wyświetl 3 pola do wpisania wyników działań na wylosowanych liczbach:
    * dodawania, 
    * odejmowania, 
    * mnożenia.
3. Po wysłaniu formularza wygeneruj stronę, która sprawdzi wpisane przez nas wyniki i przedstawi je w postaci:

```
20	+	3	=	23	Correct
20	-	3	=	17	Correct
20	*	3	=	89	Wrong
```
Hint: w sesji zapamiętaj liczby, a nie wyniki - dzięki temu będziesz trzymać jedną zmienną mniej. 

#### Zadanie 9 - dodatkowe

W projekcie stwórz servlet `Sess39`. Następnie:
1. Przygotuj sobie tablicę z nazwami krajów sąsiadujących z Polską i ich stolicami.
2. Po uruchomieniu servletu na serwerze, wyświetl formularz z zapytaniem o stolicę sąsiadującego z Polską państwa. W postaci: `Podaj stolicę dla państwa: Niemcy `
3. Po przesłaniu odpowiedzi, system zweryfikuje poprawność odpowiedzi i wyświetli odpowiedni komunikat oraz ponownie wyświetli pytanie o kolejne państwo.
4. Po wyświetleniu wszystkich pytań wyświetli się wynik naszego quizu z informacją o liczbie poprawnych odpowiedzi:
`Poprawnych odpowiedzi: 4`.

Hint: To zadanie będzie miało podobny algorytm działania co zadanie 6 - wzoruj się na nim.


<!-- Links -->
[degrees-convertion]:https://pl.wikipedia.org/wiki/Skala_Fahrenheita#Spos.C3.B3b_dok.C5.82adny
[submit-btns]:http://stackoverflow.com/a/2680198
[nbp]:http://www.nbp.pl/home.aspx?navid=archa&c=/ascx/tabarch.ascx&n=a008z170112
[binary-convertion]:http://www.wikihow.com/Convert-from-Binary-to-Decimal
[lorempixel]:http://lorempixel.com/

### Zadania.

Rozwiązania zadań umieszczaj w utworzonym wcześniej projekcie **jee-servlet**.

#### Zadanie 1

W projekcie stwórz stronę jsp `index41.jsp`. Następnie:
1. Pobierz wartość parametru GET o nazwie `author`.
2. Sprawdź czy parametr istnieje oraz czy nie jest pusty.
3. Wyświetl informacje w postaci:
    ```html
    <p>Wybrany autor <Pobrana wartość></p>
    ```

#### Zadanie 2

W projekcie stwórz stronę jsp `index42.jsp`. 
Za pomocą pętli forEach wyświetl na stronie liczby w taki sposób by uzyskać poniższy wynik.
 Wykorzystaj dodatkowe atrybuty pętli `begin` oraz `step`.    
```html
2 
4 
6 
8 
10 
```

#### Zadanie 3

W projekcie stwórz servlet `Servlet311` oraz `Servlet312`. Następnie:
1. Na pierwszej stronie (`Servlet311`) stwórz formularz z elementem `select`
 oraz opcjami wyboru zgodnymi z kluczami poniższej mapy:
   ```java
   Map<String, String> lang = new  HashMap<>();
   lang.put("en", "Hello");
   lang.put("pl", "Cześć");
   lang.put("de", "Ehre");
   lang.put("es", "Hola");
   lang.put("fr", "Bienvenue");
   ```
2. Strona ma przesyłać dane za pomocą `POST` do drugiej strony (`Servlet412`),
 która ma ustawić ciasteczko `language` na wartość wybraną przez użytkownika.
3. Po ponownym wejściu na pierwszą powinna być wyświetlana informacja powitalna w wybranym przez użytkownika języku.
4. Gdy ciasteczko nie istnieje, wiadomość powitalna powinna być wyświetlana w języku polskim.

Hint: Odpowiednie dane przekaż i przetwórz w pliku widoku.

  
#### Zadanie 4

1. Umieść na stronie dostępnej pod adresem **/newsletter** dowolny tekst, możesz skorzystać z generatora: [lorem-ipsum].
2. Umieść na stronie formularz z możliwością zapisu użytkownika na newsletter.
Formularz musi mieć następujące pola:
  * email (Adres email),
  * name (Imię i nazwisko).
3. Formularz powinien wyświetlać się dla użytkownika raz na 24 godziny - wykorzystaj w tym celu ciasteczka.
4. Napisz obsługę formularza - dane zapisz do bazy.
5. Zapytania tworzące tabele w bazie danych umieść w pliku `query.sql`.
 
 
#### Zadanie 5 (DODATKOWE)

Celem zadania jest udostępnienie funkcjonalności księgi gości.

1. Utwórz servlet wyświetlający listę wpisów z księgi gości. Ma być dostępny pod adresem **/guest-book**
2. Wyświetlane mają być wpisy w kolejności od najnowszego do najstarszego.
3. Informacje o wpisach mają być pobierane z bazy danych.
4. Zapytania tworzące tabele w bazie danych umieść w pliku `query.sql`.
5. Dane dostępowe do bazy danych umieść w parametrach inicjalizacji dla całej aplikacji - sprawdź snippety aby dowiedzieć się jak zapisać i odczytać parametry.
6. Na stronie nad wpisami umieść formularz umożliwiający dodawanie nowego wpisu (nazwa oraz opis). 


#### Zadanie 6 (DODATKOWE)

Utwórz filtr, który będzie zapisywał do bazy danych poniższe informacje pobrane w filtrze:
  - przeglądarkę użytkownika,  
  - datę i godzinę żądania,  
  - wszystkie parametry żądania (zastanów się w jaki sposób przechowywać te dane w bazie),  
  - czas wykonania żądania.

<!-- Links -->
[zone-date-time]:https://docs.oracle.com/javase/8/docs/api/java/time/ZonedDateTime.html 
[date-example1]:https://www.mkyong.com/java/java-convert-date-and-time-between-timezone/
[date-example2]:https://dzone.com/articles/deeper-look-java-8-date-and
[dao-wiki]:https://pl.wikipedia.org/wiki/Data_Access_Object
[lorem-ipsum]:http://pl.lipsum.com/
