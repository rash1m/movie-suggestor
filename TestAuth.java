import java.io.File;// for File
import java.io.FileWriter;// for FileWriter

public class TestAuth {// main
  public static void main(String[] args) {// test auth functionality
    System.out.println("=== Test: Auth ===");
    File tmp = new File("test_users.txt");// temp users file
    try (FileWriter fw = new FileWriter(tmp)) {// create temp users file
      fw.write("alice:password\nbob:1234\n");// write test users
      fw.flush();// ensure data is written
    } catch (Exception e) {// handle exception
      System.out.println("FAIL: Could not create temp users file: " + e);// print error
      e.printStackTrace();// print stack trace
      System.exit(1);// exit on failure
    }// end try-catch

    try {// test Auth class
      Auth auth = new Auth(tmp.getAbsolutePath());// create Auth instance
      boolean pass = true;// track overall pass status
      if (!auth.login("alice", "password")) {// test valid login
        System.out.println("FAIL: valid credentials rejected");// print failure
        pass = false;
      } else {// valid login passed
        System.out.println("PASS: valid credentials accepted");
      }// end if
      if (auth.login("alice", "wrong")) {// test invalid password
        System.out.println("FAIL: wrong password accepted");
        pass = false;
      } else {// invalid password rejected
        System.out.println("PASS: wrong password rejected");
      }
      if (auth.login("unknown", "x")) {// test unknown user
        System.out.println("FAIL: unknown user accepted");
        pass = false;
      } else {// unknown user rejected
        System.out.println("PASS: unknown user rejected");
      }

      if (pass) {// all tests passed
        System.out.println("\nALL Auth TESTS PASSED");
      } else {// some tests failed
        System.out.println("\nSOME Auth TESTS FAILED");
      }// end if
    } catch (Exception e) {// handle exception
      System.out.println("FAIL: Exception while testing Auth: " + e);// print error
      e.printStackTrace();// print stack trace
    } finally {// cleanup
      tmp.delete();
    }// end try-catch-finally
  }// end main
}// end TestAuth class
