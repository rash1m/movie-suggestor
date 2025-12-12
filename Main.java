import java.util.ArrayList; // for ArrayList
import java.util.Collections; // for Collections.shuffle
import java.util.List;// for List
import java.util.Scanner;// for Scanner

public class Main { // main class
  public static void main(String[] args) { // main method
    Scanner scanner = new Scanner(System.in);// Create a Scanner object to read user input
    System.out.print("\033[H\033[2J");// ANSI escape code to clear the console
    System.out.flush();// Flush the console output
    System.out.println("=== Movie Suggestor ===");
    System.out.println("Welcome to the Movie Suggestor!");
    System.out.println("Answer a few questions to get personalized movie recommendations!");
    System.out.println("Please login to continue:");
    System.out.println("username = user, password = 1234");

    try {// Try block to handle potential exceptions during authentication
      // Use project-relative users file (located in the same folder as the .java
      // files)
      Auth auth = new Auth("users.txt");

      System.out.print("Username: ");// Prompt for username
      String username = scanner.nextLine().trim();// Read username input
      if (username.isEmpty()) {
        System.out.println("Username cannot be empty. Exiting...");
        scanner.close();
        return;
      }
      // Read username input
      System.out.print("Password: ");
      String password = scanner.nextLine().trim();
      if (password.isEmpty()) {
        System.out.println("Password cannot be empty. Exiting...");
        scanner.close();
        return;
      }
      // quick read password input
      if (!auth.login(username, password)) {// Attempt to login with provided credentials
        System.out.println("Invalid credentials. Exiting...");// If login fails, print message and exit
        scanner.close();// Close the scanner
        return;// Exit the program
      } // End of login check
    } catch (Exception e) {// Catch block to handle exceptions
      System.out.println("Login failed: " + e);// Print error message
      scanner.close();
      return;
    } // End of try-catch for authentication
    System.out.print("\033[H\033[2J");// ANSI escape code to clear the console
    System.out.flush();// Flush the console output
    System.out.println("Login successful!");// Print success message
    System.out.println("Let's find the perfect movie for you!");// Print welcome message
    System.out.println("Answer the following questions to help us understand your preferences:");// Print instructions
    System.out.println("You can press Enter to skip any question if you don't have a preference.");// Print instructions
    System.out.print("Press Enter to continue");// Prompt to continue
    scanner.nextLine();
    // Clear the console
    try {// Try block to handle potential exceptions during movie suggestion process
      List<String> genres = new ArrayList<>();// List to hold user-preferred genres
      Question[] questions = new Question[] { // Array of questions to ask the user
          new Question("How do you feel right now?", new String[] { "Calm", "Stressed", "Sad", "Happy" }),
          new Question("What kind of pace do you want?", new String[] { "Slow and thoughtful", "Fast and thrilling" }),
          new Question("Do you want to escape reality or face it?", new String[] { "Escapism", "Realism" }),
          new Question("What do you want to feel after the movie?", new String[] { "Inspired", "Comforted" }),
          new Question("Do you prefer stories from the past or present?", new String[] { "Classics", "Modern" }),
          new Question("Who are you watching with?", new String[] { "Alone", "Friends/Family" }) };

      for (int i = 0; i < questions.length; i++) {// Iterate through each question
        Question q = questions[i];// Get the current question
        System.out.print("\033[H\033[2J");// ANSI escape code to clear the console
        System.out.flush();// Flush the console output
        // Print the question and options
        System.out.println(q.getQuestion() + "  (Input the number selected please)");
        System.out.println("Please select an option by entering the corresponding number:");
        String[] opts = q.getOptions();
        for (int j = 0; j < opts.length; j++) {// Iterate through each option
          System.out.println((j + 1) + ". " + opts[j]);
        } // Print each option with its number

        int input = -1;
        while (true) {// Loop until valid input is received
          System.out.print("Please enter your choice (1-" + opts.length + ") or press Enter to skip: ");// Prompt for
                                                                                                        // user input
          String line = scanner.nextLine();// Read user input
          if (line.trim().isEmpty()) {// Check if input is empty (user wants to skip)
            System.out.println("Skipping question.");
            break;
          } // Check if input is empty (user wants to skip)
          try {// Try block to parse user input
            input = Integer.parseInt(line.trim());
            if (input > 0 && input <= opts.length) {// Check if input is within valid range
              System.out.println("You selected: " + opts[input - 1]);// Print the selected option
              break;
            } else {// If input is out of range, prompt again
              System.out.println("Please enter a number between 1 and " + opts.length + ".");// Prompt again
            } // If input is out of range, prompt again
          } catch (NumberFormatException nfe) {// Catch block for invalid number format
            System.out.println("Invalid input. Please enter a number.");// Prompt again
          } // Catch block for invalid number format
        } // Loop until valid input is received

        if (input > 0) {// If a valid option was selected
          Preference preference = new Preference(opts[input - 1]);
          genres.addAll(preference.getGenres());
        } // If a valid option was selected
      } // Iterate through each question

      Movie[] movies = new Movie[] { // Array of available movies
          new Movie("Her", new String[] { "Scifi", "Romance", "Modern", "SliceOfLife" },
              "A lonely writer develops a relationship with an AI assistant.", 2013),
          new Movie("Eternal Sunshine of the Spotless Mind",
              new String[] { "Scifi", "Romance", "Drama", "Psychological" },
              "A man undergoes a procedure to erase memories of his ex-lover.", 2004),
          new Movie("Before Sunrise", new String[] { "Romance", "Drama", "Reflective", "SliceOfLife" },
              "Two strangers connect deeply during one night in Vienna.", 1995),
          new Movie("Lost in Translation", new String[] { "Drama", "Romance", "Reflective", "Modern" },
              "Two lost souls form a bond in Tokyo amid loneliness and alienation.", 2003),
          new Movie("Past Lives", new String[] { "Romance", "Drama", "Realism", "Modern" },
              "Childhood friends reconnect decades later, reflecting on love and fate.", 2023),
          new Movie("Inception", new String[] { "Scifi", "Action", "Thriller", "Modern" },
              "A skilled thief enters people's dreams to steal secrets.", 2010),
          new Movie("Mad Max: Fury Road", new String[] { "Action", "Adventure", "Thriller", "Modern" },
              "In a desert wasteland, two rebels fight to restore balance.", 2015),
          new Movie("The Dark Knight", new String[] { "Action", "Thriller", "Drama", "Classics" },
              "Batman faces chaos and moral conflict against the Joker.", 2008),
          new Movie("John Wick", new String[] { "Action", "Thriller", "Modern", "Revenge" },
              "A retired hitman seeks vengeance after his dog is killed.", 2014),
          new Movie("Edge of Tomorrow", new String[] { "Scifi", "Action", "Adventure", "Modern" },
              "A soldier relives the same day fighting aliens, learning each time.", 2014),
          new Movie("The Truman Show", new String[] { "Drama", "Reflective", "Classics", "Realism" },
              "A man discovers his entire life is a reality TV show.", 1998),
          new Movie("Interstellar", new String[] { "Scifi", "Drama", "Adventure", "Philosophy" },
              "Explorers travel through a wormhole in search of a new home for humanity.", 2014),
          new Movie("A Beautiful Mind", new String[] { "Biopic", "Drama", "Psychological", "Inspired" },
              "The life of brilliant mathematician John Nash and his battle with schizophrenia.", 2001),
          new Movie("The Tree of Life", new String[] { "Drama", "Philosophy", "Reflective", "Realism" },
              "A cosmic and intimate exploration of existence and family.", 2011),
          new Movie("Synecdoche, New York", new String[] { "Drama", "Philosophy", "Psychological", "Modern" },
              "A playwright builds a life-sized replica of New York inside a warehouse.", 2008),
          new Movie("Soul", new String[] { "Animation", "Drama", "Inspired", "Modern", "FeelGood" },
              "A musician’s soul journeys through life and purpose after death.", 2020),
          new Movie("Inside Out", new String[] { "Animation", "Family", "Reflective", "FeelGood" },
              "Personified emotions navigate the mind of a young girl.", 2015),
          new Movie("Spirited Away", new String[] { "Animation", "Fantasy", "Classics", "Escapism" },
              "A girl becomes trapped in a spirit world run by mysterious beings.", 2001),
          new Movie("The Boy and the Heron", new String[] { "Animation", "Fantasy", "Modern", "Reflective" },
              "A boy journeys through a strange world to reconnect with his lost mother.", 2023),
          new Movie("Paddington 2", new String[] { "Family", "Comedy", "FeelGood", "Modern" },
              "A lovable bear spreads kindness while clearing his name from a false accusation.", 2017),
          new Movie("Good Will Hunting", new String[] { "Drama", "Inspired", "Classics" },
              "A troubled math prodigy learns about love, purpose, and identity.", 1997),
          new Movie("Whiplash", new String[] { "Drama", "Music", "Psychological", "Inspired" },
              "An ambitious drummer faces his abusive instructor in a battle of will.", 2014),
          new Movie("The Pursuit of Happyness", new String[] { "Drama", "Inspired", "Biopic", "Realism" },
              "A struggling salesman fights to build a better life for his son.", 2006),
          new Movie("Moneyball", new String[] { "Drama", "Biopic", "Competition", "Inspired" },
              "A baseball manager revolutionizes the game using data analytics.", 2011),
          new Movie("Ford v Ferrari", new String[] { "Action", "Biopic", "Competition", "Inspired" },
              "Car designers fight against odds to win the 1966 Le Mans race.", 2019),
          new Movie("The Imitation Game", new String[] { "Biopic", "Drama", "Inspired", "Historical" },
              "Alan Turing races to crack the Nazi Enigma code.", 2014),
          new Movie("Parasite", new String[] { "Drama", "Thriller", "Modern", "Realism" },
              "A poor family infiltrates a wealthy household with devastating results.", 2019),
          new Movie("The Social Network", new String[] { "Drama", "Biopic", "Modern", "Psychological" },
              "The rise of Facebook and the cost of ambition.", 2010),
          new Movie("12 Angry Men", new String[] { "Drama", "Classics", "Realism", "Psychological" },
              "Jurors deliberate the fate of a young defendant in a tense courtroom.", 1957),
          new Movie("Nomadland", new String[] { "Drama", "Realism", "Reflective", "Modern" },
              "A woman travels across America living as a modern-day nomad.", 2020),
          new Movie("Spotlight", new String[] { "Drama", "Biopic", "Realism", "Inspired" },
              "Journalists uncover systemic abuse within the Catholic Church.", 2015),
          new Movie("The Grand Budapest Hotel", new String[] { "Comedy", "Drama", "Modern", "Retro" },
              "A whimsical hotel manager navigates chaos and charm in pre-war Europe.", 2014),
          new Movie("Guardians of the Galaxy", new String[] { "Action", "Comedy", "Adventure", "Modern" },
              "A group of misfits band together to save the universe.", 2014),
          new Movie("Ferris Bueller’s Day Off", new String[] { "Comedy", "Classics", "FeelGood", "Retro" },
              "A high schooler skips school for one legendary day of fun.", 1986),
          new Movie("Everything Everywhere All at Once",
              new String[] { "Scifi", "Adventure", "Comedy", "Modern", "Philosophy" },
              "A multiverse-hopping mother discovers her true power and meaning.", 2022),
          new Movie("La La Land", new String[] { "Romance", "Music", "Drama", "Modern" },
              "Two artists pursue dreams and love in Los Angeles.", 2016) };

      List<Movie> selectedMovies = getMoviesFromPreference(genres, movies);// Get movie recommendations based on
                                                                           // user-preferred genres

      if (selectedMovies.isEmpty()) {// If no movies match the preferences
        System.out.println("No movies match your preferences.");// Print message
      } else {// If there are matching movies
        for (int i = 0; i < selectedMovies.size(); i++) {// Iterate through selected movies
          Movie m = selectedMovies.get(i);// Get the current movie
          System.out.print("\033[H\033[2J");// ANSI escape code to clear the console
          System.out.flush();// Flush the console output
          m.printMovie();// Print movie details
          System.out.println();
          System.out.println("Press Enter for more, or 'q' to quit:");// Prompt to continue or quit
          String next = scanner.nextLine();
          if ("q".equalsIgnoreCase(next)) {// If user chooses to quit
            System.out.println("Thank you for using the Movie Suggestor!");// Print goodbye message
            System.out.println("Goodbye!");// Print goodbye message
            break;
          } // If user chooses to quit
        } // Iterate through selected movies
      } // If there are matching movies

    } catch (Exception e) {// Catch block to handle exceptions
      e.printStackTrace();// Print stack trace for debugging
      System.out.print("Failed to get movies");// Print error message
      System.out.println("Please try again later.");// Prompt to try again later
    } // End of try-catch for movie suggestion process
    scanner.close();// Close the scanner
  }// End of main method

  public static double getPoints(String genre) {// Method to get points for a genre
    switch (genre) {// Switch statement to return points based on genre
      case "Drama":
        return 2.0;
      case "Horror":
        return 1.9;
      case "Romance":
        return 1.8;
      case "Scifi":
        return 1.7;
      case "Psychological":
        return 1.6;
      case "Biopic":
        return 1.5;
      case "Documentary":
        return 1.4;
      case "Fantasy":
        return 1.4;
      case "Action":
        return 1.3;
      case "Thriller":
        return 1.3;
      case "Adventure":
        return 1.2;
      case "Comedy":
        return 1.2;
      case "Family":
        return 1.1;
      case "Animation":
        return 1.1;
      case "FeelGood":
        return 1.1;
      case "SliceOfLife":
        return 1.0;
      case "Classics":
      case "Modern":
        return 1.0;
      case "Reflective":
        return 0.9;
      case "Music":
      case "Realism":
        return 0.8;
      case "Retro":
      case "Contemporary":
        return 0.7;
      case "Philosophy":
        return 0.6;
      default:
        return 0.5;
    }// End of switch statement
  }// End of getPoints method

  public static List<Movie> getMoviesFromPreference(List<String> genres, Movie[] movies) {// Method to get movies based
                                                                                          // on user-preferred genres
    double highestPoints = 0.0;// Variable to track the highest points among movies
    for (int i = 0; i < movies.length; i++) {// Iterate through each movie
      Movie movie = movies[i];// Get the current movie
      double moviePoints = 0.0;
      String[] movieGenres = movie.getGenres().toArray(new String[0]);
      for (int j = 0; j < movieGenres.length; j++) {// Iterate through each genre of the movie
        String mg = movieGenres[j];// Get the current movie genre
        if (genres.contains(mg)) {// If the genre matches user preferences
          moviePoints += getPoints(mg);// Add points for the matching genre
        } // If the genre matches user preferences
      } // Iterate through each genre of the movie
      if (moviePoints > highestPoints) {// If current movie has higher points than the highest recorded
        highestPoints = moviePoints;
      }
    } // Iterate through each movie

    List<Movie> selectedMovies = new ArrayList<>();// List to hold selected movies
    for (int i = 0; i < movies.length; i++) {// Iterate through each movie
      Movie movie = movies[i];// Get the current movie
      double moviePoints = 0.0;
      String[] movieGenres = movie.getGenres().toArray(new String[0]);
      for (int j = 0; j < movieGenres.length; j++) {// Iterate through each genre of the movie
        String mg = movieGenres[j];// Get the current movie genre
        if (genres.contains(mg)) {// If the genre matches user preferences
          moviePoints += getPoints(mg);// Add points for the matching genre
        } // If the genre matches user preferences
      } // Iterate through each genre of the movie
      if (moviePoints >= highestPoints - 2.0) {// If the movie's points are within 2.0 of the highest points
        selectedMovies.add(movie);// Add the movie to the selected list
      }
    } // Iterate through each movie

    if (selectedMovies.isEmpty()) {// If no movies match the preferences
      return selectedMovies;
    }

    Collections.shuffle(selectedMovies);// Shuffle the selected movies to add randomness
    return selectedMovies.subList(0, Math.min(3, selectedMovies.size()));// Return up to 3 movies from the selected list
  }// End of getMoviesFromPreference method
}// End of Main class
