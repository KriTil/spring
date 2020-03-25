package lv.accenture.bootcamp.moviesJPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service  //vai @Component  - tas pats
public class MoviesService {

    @Autowired
    private MoviesRepository moviesRepository;


    public Iterable<Movie> movies() {
        List<Movie> movie = (List<Movie>) moviesRepository.findAll();
        return movie;
    }

    public void create(Movie movie) {
        movie.setId(movie.getId());
        moviesRepository.save(movie);
    }

    public void update(String id, Movie movie) {
        Optional<Movie> optional = moviesRepository.findById(id);
        if (optional.isPresent()) {
            moviesRepository.deleteById(id);
            movie.setId(id);
            moviesRepository.save(movie);
        }
    }


    public void delete(String id) {
        Optional<Movie> optional = moviesRepository.findById(id);
        if (optional.isPresent()) {
            moviesRepository.deleteById(id);
        }

    }
}
