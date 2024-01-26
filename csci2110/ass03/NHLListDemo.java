package csci2110.ass03;
/**
 * Student name: Yongteng Li
 * Student id: B00940715
 * Course id: csci2110
 * File description: the NHLListDemo class has the main method of the task, it takes in the input txt file of a bunch of player records, and then do the data analysis and finally output the result in another txt file
 */
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class NHLListDemo {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the filename to read from: ");
        //input file
        String fileName = in.nextLine();
        File txt = new File(fileName);
        Scanner readInput = new Scanner(txt);
        //output file
        File outPut = new File("nhlstatsoutput.txt");
        PrintWriter out = new PrintWriter(outPut);
        NHLStats recordList = new NHLStats(out);
        //add records to the list
        while(readInput.hasNext()){
            PlayerRecord record = new PlayerRecord(readInput.next(), readInput.next(), readInput.next(), readInput.nextInt(), readInput.nextInt(), readInput.nextInt(), readInput.nextInt(), readInput.nextInt(), readInput.nextInt());
            recordList.add(record);
        }
        in.close();
        readInput.close();
        //print the information to the file
        out.println("Players with highest points and their teams:");
        recordList.getMostPoints();
        out.println();
        out.println("Most aggressive players, their teams and their positions:");
        recordList.getMostAggressive();
        out.println();
        out.println("Most valuable players and their teams:");
        recordList.getMVP();
        out.println();
        out.println("Most promising players and their teams:");
        recordList.getPromising();
        out.println();
        out.println("Teams that had the most number of penalty minutes:");
        recordList.getMostAggressiveTeam();
        out.println();
        out.println("Teams that had the most number of game winning goals:");
        recordList.getMostWinningTeam();
        out.close();
    }
}
