package csci2110.labs.lab2;
import java.util.*;
public class GenericStackDemo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //create stack for strings and a stack for integers
        GenericStack<String> strStack = new GenericStack<>();
        GenericStack<Integer> intStack = new GenericStack<>();

        String strIn = in.next();
        while(!strIn.equals("quit")){
            strStack.push(strIn);
            strIn = in.next();
        }

        int intIn = in.nextInt();
        while(intIn != -1){
            intStack.push(intIn);
            intIn = in.nextInt();
        }

        //pop all string stack until empty
        System.out.println("String Stack Contents:");
        while(!strStack.isEmpty()){
            System.out.println(strStack.pop());
        }

        System.out.println();
        //pop all integer stack until empty
        System.out.println("Integer Stack Contents:");
        while(!intStack.isEmpty()){
            System.out.println(intStack.pop());
        }
    }
}
