package CaseTest;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;


public class CaseTest {
    private final String input;
    private String output;

    public CaseTest(String input, String output){
        this.input = input;
        this.output = output;
    }

    public String compare(){
        File text = new File(output);
        String target = "";
        try{
            Scanner read = new Scanner(text);
            while(read.hasNext()){
                target += read.nextLine();
            }
        }
        catch(FileNotFoundException e){
            System.out.println("No file found.");
        }
        if(input.equals(target.trim())){
            return "Test passed.";
        }
        else {
            return "Test Failed. \n Yours:\n" + input + "Expected: \n" + target;
        }
    }

}
