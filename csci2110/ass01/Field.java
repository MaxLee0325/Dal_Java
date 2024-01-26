package csci2110.ass01;
/*Student name: Yongteng Li
  Student id: B00940715
  E-mail: yn201290@dal.ca
  Course: csci2110
  Professor: Srini
 */
public class Field {
    private double xpos, ypos, length, width;

    public Field(double xpos, double ypos, double length, double width){
        this.xpos = xpos;
        this.ypos = ypos;
        this.length = length;
        this.width = width;
    }

    public double getXpos(){return xpos;}
    public double getYpos(){return ypos;}
    public double getLength(){return length;}
    public double getWidth(){return width;}

    public String toString(){
        return String.format("Field: [%f,%f]%f,%f", xpos, ypos, length, width);
    }
}
