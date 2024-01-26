package csci2110.labs.lab2;

import java.util.*;
import java.io.*;
public class Exercise3{
    public static void main(String[] args)throws IOException{
        //TODO: Create stack1 to hold StudentRecord Objects
        GenericStack<StudentRecord> students = new GenericStack<>();
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the filename to read from: ");
        String filename = keyboard.nextLine();

        File file = new File(filename);
        Scanner inputFile = new Scanner(file);

        StringTokenizer token;
        while (inputFile.hasNext()){
            String line = inputFile.nextLine();
            token = new StringTokenizer(line, " ");
            String firstName = token.nextToken();
            String lastName = token.nextToken();
            String IDString = token.nextToken();
            //convert String IDString to an Integer Object IDNum Integer IDNum = Integer.valueOf(IDString);
            //TODO: Create a StudentRecord Object with the first name, last name //and ID number, push it into stack1
            StudentRecord student = new StudentRecord(firstName, lastName, Integer.parseInt(IDString));
            students.push(student);
        }
        inputFile.close();
        //TODO: Continue with remaining steps
        GenericStack<String> lastNames = new GenericStack<>();
        //pop the last names from students list and push the last names into a new list
        while(!students.isEmpty()){
            lastNames.push(students.pop().getLastName());
        }

        while(!lastNames.isEmpty()){
            System.out.println(lastNames.pop());
        }

    }
}
