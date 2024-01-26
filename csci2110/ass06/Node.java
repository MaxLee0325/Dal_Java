package csci2110.ass06;

import java.util.LinkedList;

public class Node {
    private String nodeName;
    private LinkedList<Node> to;
    private LinkedList<Node> from;
    private int topNum;
    private boolean taken;

    public Node(String nodeName){
        taken = false;
        to = new LinkedList<>();
        from = new LinkedList<>();
        this.nodeName = nodeName;
    }

    public String getName(){return nodeName;}
    public boolean getTaken(){return taken;}
    public void addTo(Node node){
        to.add(node);
    }

    public void addFrom(Node node){
        from.add(node);
    }

    public LinkedList<Node> getFrom(){return from;}
    public LinkedList<Node> getTo(){return to;}

    public void setTopNum(int in){topNum = in;}
    public void take(){taken = true;}
    public int getTopNum(){return topNum;}
}
