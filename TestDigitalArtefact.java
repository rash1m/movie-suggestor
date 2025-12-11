public class TestDigitalArtefact {// Class to test various components of the movie suggestor application
  // Main method to run the tests
  public static void main(String[] args) {// Main method to run the tests
    if (testGetPoints() && testPreferenceGenres() && testMovieGenres() && testMoviesFromPreference()) {// Run all tests
                                                                                                       // and check if
                                                                                                       // they all pass
      System.out.println();
      System.out.println("ALL TESTS PASSED!");// Print success message if all tests pass
    } else {// If any test fails
      System.out.println();
      System.out.println("❌ At least one test FAILED");
    } // End of if-else statement
  }// End of main method

  // TEST 1 — Test Main.getPoints()
  private static boolean testGetPoints() {// Method to test the getPoints method in the Main class
    System.out.println("=== Test: getPoints ===");// Print the test name
    // Test various genres and their expected point values
    if (Main.getPoints("Drama") == 2.0) {
      System.out.println("PASS: Drama = 2.0");
    } else {
      System.out.println("FAIL: Drama should be 2.0");
      return false;
    }

    if (Main.getPoints("Action") == 1.3) {
      System.out.println("PASS: Action = 1.3");
    } else {
      System.out.println("FAIL: Action should be 1.3");
      return false;
    }

    if (Main.getPoints("Unknown") == 0.5)
      System.out.println("PASS: Unknown = 0.5");
    else {
      System.out.println("FAIL: Unknown should be 0.5");
      return false;
    }
    return true;

  }// End of testGetPoints method

  // TEST 2 — Test Preference.getGenres()
  private static boolean testPreferenceGenres() {// Method to test the getGenres method in the Preference class
    System.out.println("\n=== Test: Preference.getGenres ===");
    // Create a Preference object with "Calm" preference and get the corresponding
    // genres
    Preference calm = new Preference("Calm");
    java.util.List<String> genres = calm.getGenres();
    // Check if the genres list contains "Drama" and "Romance"
    if (genres.contains("Drama") && genres.contains("Romance")) {// If both genres are present, the test passes
      System.out.println("PASS: Calm includes Drama & Romance");
      return true;
    } else {// If either genre is missing, the test fails
      System.out.println("FAIL: Calm mapping incorrect");
      return false;
    } // End of testPreferenceGenres method
  }

  // TEST 3 — Movie.getGenres()
  private static boolean testMovieGenres() {// Method to test the getGenres method in the Movie class
    System.out.println("\n=== Test: Movie.getGenres ===");
    // Create a Movie object with specific genres and get the genres as a list
    Movie m = new Movie("Test", new String[] { "Action", "Thriller" }, "desc", 2000);
    java.util.List<String> g = m.getGenres();
    // Check if the genres list contains exactly "Action" and "Thriller"
    if (g.size() == 2 && g.contains("Action") && g.contains("Thriller")) {
      System.out.println("PASS: Movie genre list correct");
      return true;
    } else {// If the genres list is incorrect, the test fails
      System.out.println("FAIL: Movie genre list incorrect");
      return false;
    }
  }// End of testMovieGenres method

  // TEST 4 — Test getMoviesFromPreference()
  private static boolean testMoviesFromPreference() {// Method to test the getMoviesFromPreference method in the Main
                                                     // class
    System.out.println("\n=== Test: getMoviesFromPreference ===");// Print the test name

    // USER GENRES
    java.util.List<String> userGenres = new java.util.ArrayList<>();// Create a list to hold user genres
    userGenres.add("Drama");
    userGenres.add("Romance");

    // MOVIES
    Movie m1 = new Movie("a", new String[] { "drama", "romance" }, "desc", 2020);
    Movie m2 = new Movie("b", new String[] { "action" }, "desc", 2019);
    // Create two Movie objects with different genres
    Movie[] movies = new Movie[] { m1, m2 };

    // RUN
    java.util.List<Movie> result = Main.getMoviesFromPreference(userGenres, movies);// Get the list of movies that match
                                                                                    // the user genres
    // Check if the result contains m1 (the movie that matches the user genres)
    boolean containsM1 = false;
    for (int i = 0; i < result.size(); i++) {
      if (result.get(i) == m1)
        containsM1 = true;
    } // End of for loop
    // Validate the test result
    if (containsM1) {
      System.out.println("PASS: Movie A selected (correct highest score)");
      return true;
    } else {
      System.out.println("FAIL: Movie A should appear in the results");
      return false;
    } // End of testMoviesFromPreference method
  }// End of TestDigitalArtefact class
}// End of main method
