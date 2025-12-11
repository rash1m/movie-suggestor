import java.util.ArrayList; //library for using ArrayList
import java.util.List;// library for using List

public class TestMain {// class to test Main class methods
  public static void main(String[] args) {// main method
    System.out.println("=== Test: Main (getPoints & getMoviesFromPreference) ===");// header for test output
    boolean ok = true;// flag to track if all tests pass
    // Test getPoints method
    if (Main.getPoints("Drama") == 2.0) {// checking if getPoints returns correct value for "Drama"
      System.out.println("PASS: getPoints Drama");// test passed
    } else {// test failed
      System.out.println("FAIL: getPoints Drama");// test failed message
      ok = false;// set flag to false
    } // end of if-else
    // Test getPoints method for "Action"
    if (Main.getPoints("Action") == 1.3) {
      System.out.println("PASS: getPoints Action");
    } else {
      System.out.println("FAIL: getPoints Action");
      ok = false;
    }

    // Prepare movies and user genres (using exact casing expected by Main)
    List<String> userGenres = new ArrayList<>();// list to hold user preferred genres
    userGenres.add("Drama");
    userGenres.add("Romance");
    // Create movies to test getMoviesFromPreference
    Movie m1 = new Movie("A", new String[] { "Drama", "Romance" }, "desc", 2020);// best match movie
    Movie m2 = new Movie("B", new String[] { "Action" }, "desc", 2019);// less relevant movie
    Movie[] movies = new Movie[] { m1, m2 };// array of movies to test
    // Test getMoviesFromPreference method

    List<Movie> result = Main.getMoviesFromPreference(userGenres, movies);// get movies based on user preferences
    boolean containsM1 = false;// flag to check if best match movie is included
    for (Movie m : result) {// iterate through result movies
      if (m == m1)
        containsM1 = true;// check if best match movie is present
    } // end of for loop
    // Check if best match movie is included in the result
    if (containsM1)
      System.out.println("PASS: getMoviesFromPreference includes best match");
    else {
      System.out.println("FAIL: getMoviesFromPreference should include best match");
      ok = false;
    }
    // Final test result output
    if (ok)
      System.out.println("\nALL Main TESTS PASSED");
    else
      System.out.println("\nSOME Main TESTS FAILED");
  }// end of main method
}// end of TestMain class
