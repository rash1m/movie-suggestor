import java.util.List;// library for using List

public class TestPreference {// class to test Preference class methods
  public static void main(String[] args) {// main method
    System.out.println("=== Test: Preference ===");
    boolean ok = true;
    // Test mapping for "calm" preference
    Preference calm = new Preference("Calm");// create Preference object for "Calm"
    List<String> calmGenres = calm.getGenres();// get genres for "Calm" preference
    if (calmGenres.contains("Drama") && calmGenres.contains("Romance")) {// check if genres include "Drama" and
                                                                         // "Romance"
      System.out.println("PASS: Calm includes Drama & Romance");
    } else {
      System.out.println("FAIL: Calm mapping incorrect");
      ok = false;
    } // end of if-else
    // Test mapping for "SomethingElse" preference
    Preference unknown = new Preference("SomethingElse");
    List<String> unknownGenres = unknown.getGenres();
    if (unknownGenres.isEmpty()) {// check if genres list is empty for unknown preference
      System.out.println("PASS: Unknown preference yields empty list");// test passed
    } else {// test failed
      System.out.println("FAIL: Unknown preference should yield empty list");
      ok = false;
    } // end of if-else
    // Final test result output

    if (ok)
      System.out.println("\nALL Preference TESTS PASSED");
    else
      System.out.println("\nSOME Preference TESTS FAILED");
  }// end of main method
} // end of TestPreference class
