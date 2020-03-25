package lv.accenture.bootcamp.moviesJPA;

import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;

//@Repository
public interface MoviesRepository extends CrudRepository<Movie, String> {
}
