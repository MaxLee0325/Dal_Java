package csci2110.ass01;
/*Student name: Yongteng Li
  Student id: B00940715
  E-mail: yn201290@dal.ca
  Course: csci2110
  Professor: Srini
 */
import java.util.Random;

public class Demo {
    public static void main(String[] args) {
        //objects instantiation
        Ball soccerBall;
        Field dalField;
        Player srini;
        Player max; //added a new player, which is me
        System.out.println("SOCCER GAME SETUP!");
        srini = new Player("Srini");
        max = new Player("Max");
        //give a reasonable initial value for field and ball
        dalField = new Field(0.0, 0.0, 500.0, 400.0);
        soccerBall = new Ball(100.0, 200.0);
        //print pre-game message
        System.out.println(srini + "\n" + max + "\n" + dalField + "\n" + soccerBall);
        System.out.println("\n");

        //kick the ball 20 times, use mod 2 to determine the player is srini or max to take turn
        for(int i = 0; i <  20; i++){
            //a random value between 0-1;
            double randomDegree = new Random().nextDouble();
            //get min and max for degree
            double minDegree = 0.0;
            double maxDegree = 360.0;
            //get a random value in the range
            double degree = minDegree + (maxDegree - minDegree) * randomDegree;
            //same steps to generate a random distance;
            double minDis = 0.0;
            double maxDis = 500.0;
            double randomDis = new Random().nextDouble();
            double pixelDis = minDis + (maxDis - minDis) * randomDis;
            //create a player object to use in the loop
            Player player;
            //use mod 2 to switch player
            if(i%2 == 0){
                player = srini;
            }
            else player = max;
            //kick and print the message
            player.kick(dalField, soccerBall, pixelDis, degree);
            System.out.printf("Kick %d:\n", i+1);
            System.out.println(player + " kicks the ball for a distance of " + pixelDis + " pixels at " + degree + " degrees");
            System.out.println(soccerBall);
            System.out.println("\n");
        }
    }
}
