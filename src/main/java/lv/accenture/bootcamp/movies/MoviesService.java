package lv.accenture.bootcamp.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import static java.util.Arrays.asList;

@Service  //vai @Component  - tas pats
public class MoviesService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private List<Movie> movies;
    @PostConstruct
    public void addMovie() {
        List<Movie> movies = jdbcTemplate.query("SELECT id, name, description, rating FROM movies",
                this::mapRow);
    }

    public Movie mapRow(ResultSet result, int rowNum) throws SQLException {
        Movie movie = new Movie();
        movie.setId(result.getString("id"));
        movie.setName(result.getString("name"));
        movie.setDescription(result.getString("description"));
        movie.setRating(result.getFloat("rating"));
        return movie;
    }


    public List<Movie> movies() {
        String sql = "select * from movies";
        List<Movie> movies = jdbcTemplate.query("SELECT id, name, description, rating FROM movies",
                this::mapRow);
        return movies;
    }


  public void create(Movie movie) {
        String sqlQuery = "insert into movies(id, name, description, rating)" + "values (?, ?, ?, ?)";
        jdbcTemplate.update(sqlQuery,
                        movie.getId(),
                        movie.getName(),
                        movie.getDescription(),
                        movie.getRating());
  }


    public void update(String id, Movie movie) {
        String sqlQuery = "update movies set " +
                "id = ?, name = ?, description = ?, rating = ? " +
                "where id ="+id+"";
        jdbcTemplate.update(sqlQuery,
                    movie.getId(),
                    movie.getName(),
                    movie.getDescription(),
                    movie.getRating());
    }


   public int delete(String id) {
            String sqlQuery = "delete from movies where id ="+id+"";
            return jdbcTemplate.update(sqlQuery);
        }
        
}
