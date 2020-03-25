package lv.accenture.bootcamp.moviesThymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class MovieController {
    private final MovieRepository movieRepository;

    @Autowired
    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping("/movie")
    public String index(Model model) {
        model.addAttribute("movies", movieRepository.findAll());
        return "index";
    }

    @GetMapping("/signup")
    public String showSignUpForm(Movies movies) {
        return "add-movie";
    }

    @PostMapping("/addmovie")
    public String addMovie(@Valid Movies movies, Model model) {
        movieRepository.save(movies);
        model.addAttribute("movies", movieRepository.findAll());
        return "index";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") String id, Model model) {
        Movies movies = movieRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("movies", movies);
        return "update-movie";
    }

    @PostMapping("/update/{id}")
    public String updateMovie(@PathVariable("id") String id,
                             @Valid Movies movies,
                             Model model) {
        movieRepository.save(movies);
        model.addAttribute("movies", movieRepository.findAll());
        return "index";
    }

    @GetMapping("/delete/{id}")
    public String deleteMovie(@PathVariable("id") String id, Model model) {
        Movies movies = movieRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        movieRepository.delete(movies);
        model.addAttribute("movies", movieRepository.findAll());
        return "index";
    }

}
