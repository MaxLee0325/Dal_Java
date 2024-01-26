package csci1110.Labs.Lab4A.P1;

import java.util.*;
public class StudentDemo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Student student1 = new Student(in.next(), Integer.parseInt(in.next()));
        Student student2 = new Student(in.next(), Integer.parseInt(in.next()));
        System.out.println(student1.toString());
        System.out.println(student2.toString());
        if(student1.getStudentID() == student2.getStudentID()){
            System.out.println(student1.getName() + " is the same as " + student2.getName() + " is true");
        }
        else System.out.println(student1.getName() + " is the same as " + student2.getName() + " is false");
    }
}
