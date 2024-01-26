package csci2110.ass05;
/*
Student name: Yongteng Li
Student id: B00940715
Course: csci2110
Project: assignment 5
 */
public class Pair implements Comparable<Pair>{
    private final char l;
    private final double p;

    Pair(char l, double p){
        this.l = l;
        this.p = p;
    }

    public char getChar(){return l;}
    public double getP(){return p;}

    public String toString(){
        return " " + l + ": " + p;
    }

    /**
     * Compare the probability of this pair to the other input pair
     * @param p the object to be compared.
     * @return negative when this < that, zero when equal, positive when this > that
     */
    public int compareTo(Pair p){
        return Double.compare(this.getP(), p.getP());
    }
}
