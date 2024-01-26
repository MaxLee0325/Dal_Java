package Pods.PraPra;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.*;

public class Problem3 {
    public static void main(String [] args) {
        Scanner in = new Scanner(System.in);

        LinkedList<Student> arriving = new LinkedList<>();
        LinkedList<Student> waiting = new LinkedList<>();
        int consult = -1;
        int time = 0;
        Student currentStudent = null;

        int students = in.nextInt(); in.nextLine();

        for(int i = 0; i < students; i++){
            String info = in.nextLine();
            String[] detail = info.split("\\s+");
            Student student = new Student(detail[1], Integer.parseInt(detail[0]), Integer.parseInt(detail[2]), Integer.parseInt(detail[3]));
            arriving.add(student);
        }

        while(arriving.size() != 0 || waiting.size() != 0 || consult >= time){
            Student arrivingStudent = arriving.peek();

            if(arrivingStudent != null && arrivingStudent.getArrivingTime() == time){
                System.out.printf("%d: %s arrives.\n", arrivingStudent.getArrivingTime(), arrivingStudent.getName());
                waiting.add(arrivingStudent);
                arriving.remove();
            }

            if(consult == time){
                System.out.printf("%d: %s leaves.\n", consult, currentStudent.getName());
            }

            if(consult <= time && waiting.size() != 0){
                currentStudent = waiting.remove();
                consult = time + currentStudent.getDemandingTime();
                System.out.printf("%d: %s sees professor.\n", time, currentStudent.getName());
            }

            if(waiting.size() != 0){
                List<Student> temp = List.copyOf(waiting);
                for(Student i : temp){
                    if(time >= i.getLeavingTime()){
                        waiting.remove(i);
                        System.out.printf("%d: %s leaves due to lack of time.\n", time, i.getName());
                    }
                }
            }

            time ++;
        }

        in.close();
    }
}

