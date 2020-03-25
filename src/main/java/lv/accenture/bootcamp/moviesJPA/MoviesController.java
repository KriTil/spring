package lv.accenture.bootcamp.moviesJPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class MoviesController {

    @Autowired
    MoviesService movies;


    @GetMapping("/movies")
    public Iterable<Movie> movies() {
        return movies.movies();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/movies")
    public Iterable<Movie> create(@RequestBody Movie movie) {
        movies.create(movie);
        return movies();
    }


    @PutMapping("/movies/{id}")
    public void update(@PathVariable String id,     //mainīgajam jāsakrīt - id
                       @RequestBody Movie movie) {
        movies.update(id, movie);
    }

    @DeleteMapping("/movies/{id}")
    public void delete( @PathVariable String id) {
        movies.delete(id);
    }

}

