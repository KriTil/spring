package lv.accenture.bootcamp.movies;
        import java.util.*;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.*;
        import javax.annotation.PostConstruct;

@RestController
//@Controller
//@RequestMapping
public class MoviesController {

    @Autowired
    private MoviesService movies;
    //private MoviesRepository moviesRepository;

//    @GetMapping("/movies")
//    public Iterable<Movie>movies() {
//        return moviesRepository.findAll();
//    }

//    @GetMapping
//    public void update() {
//        Optional<Movie> movieOpt = moviesRepository.findById("1");
//        if(movieOpt.isPresent()) {
//            Movie movie = movieOpt.get();
//            movie.setName("newNameforMovie");
//            moviesRepository.save(movie);
//        }
//    }


    @GetMapping("/movies")
    public List<Movie> movies() {
        return movies.movies();
    }


    @PostMapping("/movies")
    public void create(@RequestBody Movie movie) {
        movies.create(movie);
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

