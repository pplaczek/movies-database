package pl.lodz.uni.movies.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.lodz.uni.movies.domain.Movie;
import pl.lodz.uni.movies.service.MovieService;

import java.util.Collections;
import java.util.List;

@RestController
public class MoviesController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/movies")
    public List<Movie> getMovies() {
        return movieService.getAll();
    }

    @GetMapping("/movies/{id}")
    public Movie getStudent(@PathVariable("id") Long movieId) {
        return movieService.findById(movieId);
    }

    @PostMapping("/movies")
    public Movie insert(@RequestBody Movie movie) {
        return movieService.save(movie);
    }

    @GetMapping("/movies/search/{titlePart}")
    public List<Movie> getMoviesByTitlePart(@PathVariable("titlePart") String titlePart) {
        return Collections.emptyList();
    }

    @GetMapping("/movies/search/{directorLastName}")
    public List<Movie> getMoviesByDirectorLastName(@PathVariable("directorLastName") String directorLastName) {
        return Collections.emptyList();
    }


}
