package lv.accenture.bootcamp.moviesThymeleaf;

import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movies, String> {
}
