package csci2110.ass01;
/*Student name: Yongteng Li
  Student id: B00940715
  E-mail: yn201290@dal.ca
  Course: csci2110
  Professor: Srini
 */
public class Player {
    private String name;
    //EPSILON value is created for the convenience of double comparison

    public Player(String name){
        this.name = name;
    }

    public void kick(Field f, Ball b, double d, double r) {
        double dx = b.getDx();
        double dy = b.getDy();
        double xpos = f.getXpos();
        double ypos = f.getYpos();
        double radian = Math.toRadians(r);
        double newDx = dx + d * (Math.cos(radian));
        double newDy = dy + d * (Math.sin(radian));
        //case 1, new position inside the field
        if (newDx >= xpos && newDx <= (xpos + f.getLength()) &&      //dx inside
                newDy >= ypos && newDy <= (ypos + f.getWidth())) {   //dy inside
            b.setDx(newDx);
            b.setDy(newDy);
        }
        //case 2, new position to the right of the field
        else if (newDx >= (xpos + f.getLength()) && newDx <= (xpos + 2 * f.getLength()) &&  //dx to the right
                newDy >= ypos && newDy <= (ypos + f.getWidth())) {                         //dy inside
            b.setDx(dx);
            b.setDy(newDy);
        }
        //case 3, new position below the field
        else if(xpos <= newDx && newDx <= (xpos + f.getLength()) &&  //dx inside
                newDy <= ypos && newDy >= (ypos - f.getWidth())) {   //dy to the below
            b.setDx(newDx);
            b.setDy(dy);
        }
        //case 4, new position to the left of the field
        else if(newDx <= xpos && newDx >= (xpos - f.getLength()) &&    //dx to the left
                newDy >= ypos && newDy <= (ypos + f.getWidth())) {     //dy inside
            b.setDx(dx);
            b.setDy(newDy);
        }
        //case 5, new position above the field
        else if(xpos <= newDx && newDx <= (xpos + f.getLength()) &&                       //dx inside
                newDy >= (ypos + f.getWidth()) && newDy <= (ypos + 2 * f.getWidth())) {   //dy to the above
            b.setDx(newDx);
            b.setDy(dy);
        }
        //other case, which means the ball may bounce more than once
        else{
            b.setDx(dx);
            b.setDy(dy);
        }
    }

    public String toString(){
        return String.format("Player %s", name);
    }
}
