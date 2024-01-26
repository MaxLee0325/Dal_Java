package Pods.PraPra1;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int studentNum = in.nextInt();
        LinkedList<Student> students = new LinkedList<>();
        for(int i = 0; i < studentNum; i++){
            Student student = new Student(in.nextInt(), in.next());
            students.add(student);
        }
        int time = 0;
        int meetingEnd = 0;
        Student currStudent = null;

        List<Student> waiting = List.copyOf(students);

        while(!students.isEmpty() || time >= meetingEnd){

            for(Student i : students){
                if(i.getArrivalTime() == time) {
                    System.out.println(i.getArrivalTime() + i.getName() + " arrives");

                    waiting.remove(i);

                    if (currStudent == null) {
                        currStudent = i;
                        meetingEnd = time + 15;
                    }
                }
            }






            time++;
        }



    }
}
