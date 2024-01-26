package csci2110.labs.lab1;

public class Rectangle2 {
    //instance variables
    private int xpos, ypos, width, height;

    //constructors
    public Rectangle2() {
    }

    public Rectangle2(int xpos, int ypos, int width, int height) {
        this.xpos = xpos;
        this.ypos = ypos;
        this.width = width;
        this.height = height;
    }

    //setters and getters
    public void setX(int xpos) {
        this.xpos = xpos;
    }

    public void setY(int ypos) {
        this.ypos = ypos;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getX() {
        return xpos;
    }

    public int getY() {
        return ypos;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    //other methods: moveTo changes xpos and ypos and resize changes
    //width and height
    public void moveTo(int xpos, int ypos) {
        this.xpos = xpos;
        this.ypos = ypos;
    }

    public void resize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    //toString method
    public String toString() {
        return "[xpos= " + xpos + "," + "ypos= " + ypos + "] width: " + width + ",height: " + height;
    }

    //contains method: returns true if a point (px, py) is contained within this rectangle //contains also returns true if the point touches the rectangle
    public boolean contains(int px, int py) {
        return (px > xpos && px < xpos + width && py > ypos && py < ypos + height);
    }

    //contains method: returns true if another rectangle r is contained within this rectangle //returns true if the rectangle touches the boundaries
    //it uses the point contains method
    public boolean contains(Rectangle2 r) {
        return (this.contains(r.getX(), r.getY()) && this.contains(r.getX() + r.getWidth(), r.getY() + r.getHeight()));
    }

    //touches method: returns true if any sides overlaps
    public boolean touches(Rectangle2 r) {
                //case 1, when the upper side touches
        return (((r.getY() == ypos + this.getHeight() || r.getY() + r.getHeight() == ypos + this.getHeight()) && (r.getX() + r.getWidth() >= xpos) && (r.getX() <= xpos + this.getWidth())) ||
                //case 2, when the lower side touches
                ((r.getY() == ypos || r.getY() + r.getHeight() == ypos) && (r.getX() + r.getWidth() >= xpos) && (r.getX() <= xpos + this.getWidth())) ||
                //case 3, when the left side touches
                ((r.getX() +r.getWidth() == xpos || r.getX() == xpos) && (r.getY() + r.getHeight() >= ypos) && (r.getY() <= ypos + this.getHeight())) ||
                //case 4, when the right side touches
                ((r.getX() == xpos + this.getWidth() || r.getX() + r.getWidth() == xpos + this.getWidth()) && (r.getY() + r.getHeight() >= ypos) && (r.getY() <= ypos + this.getHeight())));
    }
}