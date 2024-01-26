package csci1110.A4.P3;

/*
Student name: Yongteng Li
Student id: B00940715
Email: yn201290@dal.ca
Course: csci1110 section03
Instructor: Yujie Tang
Date: 29 Mar 2023
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Teest {
    public static void main(String[] args) {
        var start  = System.nanoTime();
        Scanner in = null;
        try {
            File file = new File("/Users/maxlee/Downloads/Ass5DeathScript.txt");
            in = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Start");
        //read in the row and col of the map
        int row = in.nextInt();
        int col = in.nextInt(); in.nextLine();
        //create the earth object
        Earth earth = new Earth(row, col);
        //make a 2-D array of Ocean
        earth.setEarth();

        //read in the input line of the coordinates of the land
        String places = in.nextLine();
        String[] splitPlace = places.split(" ");
        //add the land blocks into the earth
        for(String i : splitPlace){
            earth.addLand(Integer.parseInt(i.split(",")[0]), Integer.parseInt(i.split(",")[1]));
        }

        //set the direction of the ocean blocks according to the input direction
        for(int i = 0; i < earth.getOceanList().size(); i++){
            earth.getOceanList().get(i).setDirection(in.next());
        }
        in.nextLine();

        //read in the number of bottles
        int bottleNum = Integer.parseInt(in.nextLine());
        //make a list of bottles
        LinkedList<Bottle> bottles = new LinkedList<>();
        System.out.println("Creatinh Bottle");
        for(int i = 0; i < bottleNum; i++){
            String name = "";
            //take the input as a newline
            String input = in.nextLine();
            //split the line
            String[] splitInput = input.split(" ");
            //when the splited part is not digit, add them together to make the name
            for(String x : splitInput){
                if(!Character.isDigit(x.charAt(0))){
                    name += x + " ";
                }
            }
            //use the information we get from the input line to create the bottle object
            Bottle bottle = new Bottle(Integer.parseInt(splitInput[0]), Integer.parseInt(splitInput[1]), name.trim());
            bottle.setMessage(in.nextLine());
            //add the bottles into the bottle arraylist
            bottles.add(bottle);
        }

        //print the information of each bottle
        for(Bottle i : bottles){
            System.out.println(i.toString());
        }

        //make a varable to keep track of the travel count
        int count = 0;
        //repeat updating the bottles' position until all the bottles are disabled
        //find out if all the bottles are disabled by counting the number of disabled bottles
        System.out.println("MOvingh bottle");
        while(bottles.stream().filter(x->!x.getState()).count() > 0) {
            for (Bottle i : bottles) {
                //if the bottles are on the land and not disabled, print the message and disable it
                if (i.getDirection(earth.getEarth()) == "X" && !i.getState()) {
                    System.out.printf("%d: %s at (%d, %d): LANDED! \n", count, i.getName(), i.getRow(), i.getCol());
                    System.out.printf("<<MESSAGE RECEIVED: %s>> \n", i.getMessage());
                    i.disable();
                }
                //if the bottles are not disabled, then we need to check repetition
                else if(!i.getState()){
                    //if the bottle repeated its route, print that it's stuck and disable it
                    if(i.getRecord().contains(i.getRow() + "," + i.getCol())){
                        System.out.printf("%d: %s at (%d, %d): <<NOW STUCK IN MID-OCEAN GYRE!>> \n", count, i.getName(), i.getRow(), i.getCol());
                        i.disable();
                    }
                    //if the bottle didn't repeat its route, print the coordinates and add the coordinates into the travle record
                    else {
                        System.out.printf("%d: %s at (%d, %d): In ocean, current taking it %s. \n", count, i.getName(), i.getRow(), i.getCol(), i.getDirection(earth.getEarth()));
                        i.addRecord(i.getRow(), i.getCol());
                        i.update(i.getDirection(earth.getEarth()));
                    }
                }
            }
            count++;
        }
        in.close();
        System.out.println("\n"+(System.nanoTime()-start)/1000000);
    }
}
