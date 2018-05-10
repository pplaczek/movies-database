package pl.lodz.uni.movies.service;

import org.springframework.stereotype.Service;
import pl.lodz.uni.movies.domain.Movie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MovieService {

    private Map<Long, Movie> database = new HashMap<>();

    public Movie save(Movie movie) {
        if (movie.getId() == null) {
            Long key = database.keySet().stream()
                    .max(Long::compare)
                    .orElse(0L);
            movie.setId(key + 1);
        }
        database.put(movie.getId(), movie);
        return movie;
    }

    public Movie findById(Long id) {
        return database.get(id);
    }

    public List<Movie> getAll() {
        return new ArrayList(database.values());
    }

}
