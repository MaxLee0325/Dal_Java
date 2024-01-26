//package Pods.Pod10_3;
//
///**
// * CSCI 1110
// * @author ASiegel
// */
//
//import java.util.Scanner;
//
//public class PoD
//{
//
//
//    public static void main( String [] args )
//    {
//        Scanner in = new Scanner( System.in );
//
//        LinkedList teamList = new LinkedList();
//
//        final int TEAM_SIZE = Integer.valueOf(in.nextLine());
//
//        for (int i=0; i<TEAM_SIZE; i++)
//        {
//            String newTeamMember = in.nextLine();
//            teamList.addFirst(newTeamMember);
//        }
//
//        int newPosition = Integer.parseInt(in.nextLine());
//        String newAddition = in.nextLine();
//
//        ListIterator iterator = teamList.listIterator();
//        for (int i=1;i<newPosition; i++)
//        {
//            iterator.next();
//        }
//
//        // Add element
//        iterator.add(newAddition);
//
//
//        System.out.println("FINAL TEAM:");
//        System.out.println(teamList);
//
//        in.close();
//
//        System.out.print("END OF OUTPUT");
//    }
//}
