package csci2110.labs.lab1;

public class Circle {
    //instance variables
    private double xpos, ypos, radius;

    //constructor
    public Circle(double xpos, double ypos, double radius){
      this.xpos = xpos;
      this.ypos = ypos;
      this.radius = radius;
    }

    //getters
    public double getXpos(){return xpos;}
    public double getYpos(){return ypos;}
    public double getRadius(){return radius;}

    //setters
    public void setCenter(double xpos, double ypos){
        this.xpos = xpos;
        this.ypos = ypos;
    }
    public void setRadius(double radius){this.radius = radius;}

    //method contains(Circle c) that returns true if the specified circle is completely inside this circle
    public boolean contains(Circle c){
            return Math.sqrt(Math.pow(c.getYpos()-ypos, 2) + Math.pow(c.getXpos() - xpos, 2)) + c.getRadius() < radius;
    }

    //method touches(Circle c) that returns true if the specified circle touches this circle
    public boolean touches(Circle c){
                //case 1, circles touch from outside
            return Math.sqrt(Math.pow(c.getYpos()-ypos, 2) + Math.pow(c.getXpos() - xpos, 2)) - c.radius == radius ||
               //case 2, circles touch from inside
                Math.sqrt(Math.pow(c.getYpos()-ypos, 2) + Math.pow(c.getXpos() - xpos, 2)) + c.radius == radius;
    }
}
