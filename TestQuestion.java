public class TestQuestion {// class to test Question class methods
  public static void main(String[] args) {// main method
    System.out.println("=== Test: Question ===");// header for test output
    boolean ok = true;
    // flag to track if all tests pass
    String[] opts = new String[] { "One", "Two" };// options for the question
    Question q = new Question("How are you?", opts);
    // create a Question object for testing
    if (!"How are you?".equals(q.getQuestion())) {// check if getQuestion returns correct value
      System.out.println("FAIL: getQuestion");// test failed
      ok = false;
    } else
      System.out.println("PASS: getQuestion");// test passed
    // Test getOptions
    if (q.getOptions().length != 2 || !"One".equals(q.getOptions()[0])) {// check if getOptions returns correct values
      System.out.println("FAIL: getOptions");// test failed
      ok = false;// set flag to false
    } else
      System.out.println("PASS: getOptions");
    // test passed
    // Test setters
    q.setQuestion("New?");// set new question text
    q.setOptions(new String[] { "A" });// set new options
    if (!"New?".equals(q.getQuestion()) || q.getOptions().length != 1) {// verify setters
      System.out.println("FAIL: setters");// test failed
      ok = false;
    } else
      System.out.println("PASS: setters");// test passed
    // Final test result output
    if (ok)
      System.out.println("\nALL Question TESTS PASSED");
    else
      System.out.println("\nSOME Question TESTS FAILED");
  }// end of main method
}// end of TestQuestion class
