#Java Persistance API - cwiczenia

1. Pobierz kod i zaimportuj go do swojego IDE

2. Uruchom aplikację

3. Sprawdz zawartość bazy danych filmów (przy użyciu przeglądarki http://localhost:8080/movies
lub w terminalu Windows poleceniem: curl -i -X GET http://localhost:8080/movies)

4. Dodaj film przy użyciu polecenia:
curl -i -X POST -H 'Content-Type: application/json' -d '{"title": "Skazani na Shawshank", "releaseDate":"1995-04-16"}' http://localhost:8080/movies
a następnie sprawdź rezultat tak jak w punkcie 3.

5.  W pliku pom.xml dodaj zależności do odpowiednich bibliotek które umożliwią nam zapis danych w bazie danych
- Spring Data JPA & Hibernate
    ```xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    ```
- H2 - baza danych w pamięci
    ```xml
    <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
        <scope>runtime</scope>
    </dependency>
    ```

6. Dla oszczędności czasu użyjemy bazy danych H2, jest to baza danych "in memory", nie musimy jej istalować ani konfigurować, będzie dostępna po uruchomieniu aplikacji.
Dzięki odpowiedniej konfiguracji (która znajduje się w pliku application.properties) nie musimy różnież martwić się o aktualność struktury danych (struktura bazy będzie się zmieniała podczas ćwiczeń),

Skonfiguruj adres bazy danych, sterownik bazy danych, użytkownika do połączenia i hasło. Aby to zrobić dodaj w pliku application.properties poniższe linijki:
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

7. Zbuduj projekt w celu pobrania zależności (mvn install lub przy użyciu IDE), uruchom aplikację, sprawdź pod adresem http://localhost:8080/h2-console czy dostępna jest konsola bazy danych H2
(ustaw "JDBC URL:" jako: jdbc:h2:mem:test , pozostałe dane bez zmian). Podczas prac przy użyciu konsoli będzie można podejrzeć dane znajdujące się w bazie.

8. W klasie Movie dodaj odpowiednie adnotację aby możliwy był zapis danych w bazie danych, użyj: @Id, @Entity, @Table, @Column (ściąga jak używać tych adnotacji: https://kobietydokodu.pl/13-baza-danych-z-jpa-cz-1/#lekcja)

9. W pakiecie pl.lodz.uni.movies.repository stwórz interfejs MovieRepository, sprawdź jakie metody są dostępne w tej klasie (metody pochodzące z klasy JpaRepository oraz innych).
W klasie MovieService użyj instancji klasy MovieRepository zastępując bieżącą implementacje.

```
package pl.lodz.uni.movies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.lodz.uni.movies.domain.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

}
```

10. Przetestuj dodawanie danych do bazy, najprościej można to zrobić używając polecenia "curl" z punktu 4.

11. Jeśli wszystko działa, przy użyciu odpowiednich adnotacji odwzoruj w aplikacji relacje bazodanową pomiędzy tabelami Movie oraz Director,
jest to relacja jeden do wielu, to znaczy jedna osoba może być reżyserem wielu filmów. (ściągawka: https://kobietydokodu.pl/15-relacje-jeden-do-wielu-wiele-do-jednego/)

12. Uruchom aplikację i sprawdź czy dane są widoczne, spróbuj zapisać w bazie film wraz z danymi reżysera

13. W klasie MovieRepository stwórz metodę która pozwoli wyszukać film po fragmencie tytułu, użyj rozwiązania w pl.lodz.uni.movies.api.MoviesController.getMoviesByTitlePart
(ściągawka: https://kobietydokodu.pl/14-spring-data/)

14.  W klasie MovieRepository stwórz metodę która pozwoli wyszukać wszystkie film które stworzył dany reżyser, użyj rozwiązania w pl.lodz.uni.movies.api.MoviesController.getMoviesByDirectorLastName


