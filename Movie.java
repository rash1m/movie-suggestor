import java.util.ArrayList; // Importing necessary classes for data structure
import java.util.List;// Importing necessary classes for data structure

public class Movie {// Class to represent a movie
  private String title;// Movie title
  private String[] genres;// Movie genres
  private String description;// Movie description
  private int year;// Movie release year

  public abstract class GenreMovie {// Abstract base class for genre-specific movies
    public abstract String getGenreSpecificInfo();

    public abstract void displayGenreDetails();
  }// End of GenreMovie abstract class

  class ActionMovie extends Movie {// Subclass representing an action movie
    private String mainActor;

    public ActionMovie(String title, String[] genres, String description, int year, String mainActor) {
      super(title, genres, description, year);
      this.mainActor = mainActor;
    }

    public String getMainActor() {
      return mainActor;
    }

    public void setMainActor(String mainActor) {
      this.mainActor = mainActor;
    }
  }

  class ComedyMovie extends Movie {// Subclass representing a comedy movie
    private String comedian;

    public ComedyMovie(String title, String[] genres, String description, int year, String comedian) {
      super(title, genres, description, year);
      this.comedian = comedian;
    }

    public String getComedian() {
      return comedian;
    }

    public void setComedian(String comedian) {
      this.comedian = comedian;
    }
  }

  public Movie(String title, String[] genres, String description, int year) {// Constructor to initialize a Movie object
    this.title = title;// Set the movie title
    this.genres = genres;// Set the movie genres
    this.description = description;// Set the movie description
    this.year = year;// Set the movie release year
  }

  // Getter and setter methods for the Movie class attributes
  public String getTitle() {// Method to get the movie title
    return title;
  }

  public void setTitle(String title) {// Method to set the movie title
    this.title = title;
  }

  public String[] getGenresArray() {// Method to get the movie genres as an array
    return genres;
  }

  public void setGenres(String[] genres) {// Method to set the movie genres
    this.genres = genres;
  }

  public List<String> getGenres() {// Method to get the movie genres as a list
    List<String> result = new ArrayList<>();// Create a new list to hold the genres
    for (int i = 0; i < genres.length; i++) {// Iterate through the genres array
      result.add(genres[i]);
    }
    return result;
  }

  public String getDescription() {// Method to get the movie description
    return description;
  }

  public void setDescription(String description) {// Method to set the movie description
    this.description = description;
  }

  public int getYear() {// Method to get the movie release year
    return year;
  }

  public void setYear(int year) {// Method to set the movie release year
    this.year = year;
  }

  public void printMovie() {// Method to print the movie details
    System.out.println(this.title);// Print the movie title
    for (int i = 0; i < genres.length; i++) {// Iterate through the genres array
      System.out.print(genres[i] + (i < genres.length - 1 ? ", " : ""));// Print each genre with a comma separator
    }
    System.out.println();
    System.out.println(this.description);
    System.out.println(this.year);
  }// End of printMovie method
}
