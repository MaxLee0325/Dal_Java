package csci2110.ass06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Exercise1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);

        // Prompt the user for the file name containing user information
        System.out.print("Enter a file name for the user list: ");
        String fileName = in.nextLine();

        // Open the specified file for reading
        Scanner fileIn = new Scanner(new File(fileName));

        // Create a HashMap to store User objects using their usernames as keys
        HashMap<String, User> users = new HashMap<>();

        // Read user information from the file and populate the HashMap
        while (fileIn.hasNextLine()) {
            String line = fileIn.nextLine();
            // Split the line into parts using one or more spaces
            String[] split = line.split("\\s+");
            // Extract relevant information from the split array
            String password = split[split.length - 1];
            String userName = split[split.length - 2];
            String actualName = "";
            // Concatenate the parts to form the actual name
            for (int i = 0; i < split.length - 2; i++) {
                actualName += split[i] + " ";
            }
            // Trim any trailing spaces from the actual name
            actualName = actualName.trim();
            // Create a User object and add it to the HashMap
            User user = new User(actualName, userName, password);
            users.put(userName, user);
        }

        // Prompt the user for login information
        System.out.print("Login: ");
        String inputName = in.nextLine();

        // Validate the entered username
        while (!users.containsKey(inputName)) {
            System.out.print("User not exist, enter your user name again:");
            inputName = in.nextLine();
        }

        // Prompt the user for password with a maximum of 3 attempts
        for (int i = 0; i < 3; i++) {
            System.out.print("Password: ");
            String password = in.nextLine();

            // Check if the entered password is correct
            if (users.get(inputName).getPassword().equals(password)) {
                System.out.printf("Login successful\nWelcome %s", users.get(inputName).getActualName());
                break; // Exit the loop if login is successful
            }

            // Handle incorrect password attempts
            if (i == 2)
                System.out.println("Wrong password. Please contact the administrator!");
            else
                System.out.printf("Wrong password, you have %d more attempts!\n", 2 - i);
        }
    }
}
