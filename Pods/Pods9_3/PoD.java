package Pods.Pods9_3;

/**
 * CSCI 1110
 * @author ASiegel
 */

import java.util.Scanner;

public class PoD
{

    public static void main( String [] args ) {

        Scanner in = new Scanner( System.in );

        LinkedList listOfPlayers = new LinkedList();

        final int LIST_SIZE = Integer.valueOf(in.nextLine());

        for (int i=0; i<LIST_SIZE; i++)
        {
            String newPlayer = in.nextLine();

            listOfPlayers.append(newPlayer);
        }

        String checkPlayerStatus = in.nextLine();

        if (listOfPlayers.contains(checkPlayerStatus))
        {
            System.out.println(checkPlayerStatus + " is on the team.");
        }
        else
        {
            System.out.println(checkPlayerStatus + " did not make the team.");
        }


        in.close();
        System.out.print("END OF OUTPUT");
    }
}
