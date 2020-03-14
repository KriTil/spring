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
        List<Movie> movies = jdbcTemplate.query("SELECT id, name, description, rating FROM movies", this::mapRow);
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
        addMovie();
        //List<Movie> movies = jdbcTemplate.query("SELECT id, name, description, rating FROM movies", this::mapRow);
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

//
//    public void update(Employee employee) {
//        String sqlQuery = "update employees set " +
//                "first_name = ?, last_name = ?, yearly_income = ? " +
//                "where id = ?";
//        jdbcTemplate.update(sqlQuery
//                , employee.getFirstName()
//                , employee.getLastName()
//                , employee.getYearlyIncome()
//                , employee.getId());


    public void update(String id, Movie movie) {
        String sqlQuery = "update movies set " +
                "id = ?, name = ?, description = ?, rating = ? " +
                "where id = ?";
        jdbcTemplate.update(sqlQuery,
                    movie.getId(),
                    movie.getName(),
                    movie.getDescription(),
                    movie.getRating());
    }

   // public void delete(String id) {
   public boolean delete(String id) {
            String sqlQuery = "delete from employees where id = ?";
            return jdbcTemplate.update(sqlQuery, id) > 0;
        }

    //labākais veids:
    //String elementToRemove = "E";
    //Iterator<String> it = movies.iterator();
    //while(it.hasNext()) {
//        String element = it.next();
//            if(elementToRemove.equals(element)) {
//              it.remove();
//             }

    //vēl var izmantot lambda expression;
    //remove metodei ir 2 veidi - remove by index/remove by object
    //lietojot remove by index jāizmanto garais for cikls - for each ciklā nevar mainīt kolekciju

}
