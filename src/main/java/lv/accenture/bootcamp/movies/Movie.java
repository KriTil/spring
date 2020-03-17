package lv.accenture.bootcamp.movies;

//import javax.persistence.*;
import java.util.List;

//@Entity
//@Table(name="movies") //šis nepieciešams, ja klases un tabulas vārdi atšķiras
public class Movie {
    //@Id
    private String id;
    private String name;
    private String description;
    private Float rating;
    //private List<String> cast;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    //public List<String> getCast() {
//        return cast;
//    }

    //public void setCast(List<String> cast) {
//        this.cast = cast;
//    }

//    public <T> void getCast(List<T> be) {
//    }
}
