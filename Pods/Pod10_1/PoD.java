package Pods.Pod10_1;

/**
 * CSCI 1110
 * @author ASiegel
 */

import java.util.Scanner;

public class PoD
{


    public static void main( String [] args )
    {
        Scanner in = new Scanner( System.in );

        LinkedList teamList = new LinkedList();

        final int TEAM_SIZE = Integer.valueOf(in.nextLine());

        for (int i=0; i<TEAM_SIZE; i++)
        {
            String newTeamMember = in.nextLine();
            teamList.append(newTeamMember);
        }

        while (in.hasNextInt())
        {
            int task = in.nextInt();

            if (task == 0)
            {
                teamList.removeHead();
            }
            else if (task == 1)
            {
                teamList.removeTail();
            }
        }


        System.out.println("FINAL TEAM:");
        System.out.println(teamList);

        in.close();

        System.out.print("END OF OUTPUT");
    }
}
