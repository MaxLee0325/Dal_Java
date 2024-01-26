package csci2110.ass01;
/*Student name: Yongteng Li
  Student id: B00940715
  E-mail: yn201290@dal.ca
  Course: csci2110
  Professor: Srini
 */
public class Ball {
    private double dx, dy;

    public Ball(double dx, double dy){
        this.dx = dx;
        this.dy = dy;
    }

    public void setDx(double dx){
        this.dx = dx;
    }
    public void setDy(double dy){
        this.dy = dy;
    }

    public double getDx(){return dx;}
    public double getDy(){return dy;}

    public String toString(){
        return String.format("Ball is at (%f ,%f)", dx, dy);
    }
}
