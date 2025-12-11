import java.io.BufferedReader; // Importing necessary classes for file reading
import java.io.FileReader;// Importing necessary classes for file reading
import java.io.IOException;// Importing necessary classes for exception handling
import java.util.HashMap; // Importing necessary classes for data structure
import java.util.Map;// Importing necessary classes for data structure

public class Auth { // Class to handle user authentication
    // Stores usernames and passwords
    private Map<String, String> users = new HashMap<>(); // Map to hold username and password pairs

    public Auth(String filePath) throws IOException { // Constructor that initializes the Auth object with user data
                                                      // from a file
        if (filePath == null || filePath.isEmpty()) { // Check if the file path is null or empty
            throw new IllegalArgumentException("File path cannot be null or empty");// Validate the file path
        } // Validate the file path
        loadUsers(filePath);// Load users from the specified file
    }

    private void loadUsers(String filePath) throws IOException {// Method to load users from a file
        BufferedReader reader = new BufferedReader(new FileReader(filePath)); // Create a BufferedReader to read the
                                                                              // file
        String line;// Variable to hold each line read from the file
        // Read each line from the file and split it into username and password

        while ((line = reader.readLine()) != null) {// Read lines until the end of the file
            String[] parts = line.split(":");// Split the line into parts using ':' as the delimiter
            // Check if the line has exactly two parts (username and password)
            if (parts.length == 2) {// If the line has two parts, add them to the users map
                users.put(parts[0].trim(), parts[1].trim());// Add the username and password to the users map
            } // If the line does not have two parts, it is ignored
        }
        reader.close();// Close the BufferedReader to release resources
    }

    public boolean login(String username, String password) {// Method to authenticate a user
        return users.containsKey(username) && users.get(username).equals(password); // Check if the username exists and
                                                                                    // the password matches
    }// End of login method
}// End of Auth class
