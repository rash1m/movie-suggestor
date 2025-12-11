import java.util.ArrayList;// Importing necessary classes for data structure
import java.util.List;//  Importing necessary classes for data structure
// Class to represent user preference

public class Preference {// Class to represent user preference
  private String preference;// User preference
  // Constructor to initialize Preference object

  public Preference(String preference) {// Constructor to initialize Preference object
    this.preference = preference;// Set the user preference
  }// End of constructor

  public abstract static class AbstractPreference {// Abstract base class for preferences
    protected String preference;// User preference

    public AbstractPreference(String preference) { // Constructor to initialize AbstractPreference object
      this.preference = preference;
    }// End of constructor

    public abstract List<String> getGenres(); // Abstract method to get genres based on preference

    public String getPreference() {// Method to get the user preference
      return preference;// Return the user preference
    }// End of getPreference method

    public void setPreference(String preference) {// Method to set the user preference
      this.preference = preference;// Set the user preference
    }
  }// End of AbstractPreference class

  public String getPreference() {// Method to get the user preference
    return preference;
  }// End of getPreference method

  public void setPreference(String preference) {// Method to set the user preference
    this.preference = preference;
  }// End of setPreference method

  public List<String> getGenres() {// Method to get genres based on user preference
    List<String> result = new ArrayList<>();// Create a new list to hold the genres
    switch (preference) {// Switch statement to map preferences to genres
      // Map user preferences to corresponding genres
      case "Calm":
        result.add("Drama");
        result.add("Romance");
        result.add("SliceOfLife");
        break;
      case "Stressed":
        result.add("Comedy");
        result.add("Adventure");
        result.add("Animation");
        break;
      case "Sad":
        result.add("Family");
        result.add("FeelGood");
        result.add("Romance");
        break;
      case "Happy":
        result.add("Comedy");
        result.add("Music");
        result.add("Adventure");
        break;

      case "Slow and thoughtful":
        result.add("Drama");
        result.add("Romance");
        result.add("Psychological");
        break;
      case "Fast and thrilling":
        result.add("Action");
        result.add("Thriller");
        result.add("Scifi");
        break;

      case "Escapism":
        result.add("Fantasy");
        result.add("Scifi");
        result.add("Adventure");
        break;
      case "Realism":
        result.add("Drama");
        result.add("Biopic");
        result.add("Documentary");
        break;

      case "Inspired":
        result.add("Biopic");
        result.add("Documentary");
        result.add("Drama");
        break;
      case "Comforted":
        result.add("Romance");
        result.add("Family");
        result.add("Comedy");
        break;

      case "Classics":
        result.add("Classics");
        result.add("Retro");
        break;
      case "Modern":
        result.add("Modern");
        result.add("Contemporary");
        break;

      case "Alone":
        result.add("Psychological");
        result.add("Drama");
        result.add("Reflective");
        break;
      case "Friends/Family":
        result.add("Comedy");
        result.add("Adventure");
        result.add("Action");
        break;

      default:
        break;
    }// End of switch statement
    return result;// Return the list of genres
  }// End of getGenres method
}// End of Preference class
