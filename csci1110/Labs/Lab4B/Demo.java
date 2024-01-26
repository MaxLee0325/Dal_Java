package csci1110.Labs.Lab4B;

import java.util.*;
public class Demo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int contactNum = Integer.parseInt(in.next());
        AddressBook book = new AddressBook();
        for(int i = 0; i < contactNum; i++){
            book.add(new Contact(in.next(), in.next(), in.next(), in.next()));
        }
        System.out.println(book.toString() + "\n");

        int deleteNum = book.deleteContact(in.next());
        System.out.println("Deleted contacts: " + deleteNum);
        System.out.println(book.toString() + "\n");
        book.add(new Contact(in.next(), in.next(), in.next(), in.next()));
        System.out.println(book.toString());
    }
}
