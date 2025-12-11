import java.util.List;// library for using List

public class TestMovie {// class to test Movie class methods
  public static void main(String[] args) {// main method
    System.out.println("=== Test: Movie ===");// header for test output
    Movie m = new Movie("TestTitle", new String[] { "Action", "Thriller" }, "A desc", 2022);// create a Movie object for
                                                                                            // testing
    // Test getters
    boolean ok = true;// flag to track if all tests pass
    if (!"TestTitle".equals(m.getTitle())) {// check if getTitle returns correct value
      System.out.println("FAIL: getTitle");
      ok = false;
    } else
      System.out.println("PASS: getTitle");
    // Test getDescription
    if (!"A desc".equals(m.getDescription())) {
      System.out.println("FAIL: getDescription");
      ok = false;
    } else
      System.out.println("PASS: getDescription");
    // Test getYear
    if (m.getYear() != 2022) {
      System.out.println("FAIL: getYear");
      ok = false;
    } else
      System.out.println("PASS: getYear");
    // Test getGenres
    List<String> genres = m.getGenres();
    if (genres.size() != 2 || !genres.contains("Action") || !genres.contains("Thriller")) {
      System.out.println("FAIL: getGenres");
      ok = false;
    } else
      System.out.println("PASS: getGenres");
    // Test setters
    m.setTitle("New");
    m.setDescription("newdesc");
    m.setYear(1999);
    m.setGenres(new String[] { "Drama" });
    // Verify setters
    if (!"New".equals(m.getTitle()) || !"newdesc".equals(m.getDescription()) || m.getYear() != 1999
        || m.getGenres().size() != 1) {
      System.out.println("FAIL: setters");
      ok = false;
    } else
      System.out.println("PASS: setters");
    // Final test result output
    if (ok)
      System.out.println("\nALL Movie TESTS PASSED");
    else
      System.out.println("\nSOME Movie TESTS FAILED");
  }// end of main method
} // end of TestMovie class
