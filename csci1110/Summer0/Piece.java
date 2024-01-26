package csci1110.Summer0;

public class Piece {
    private int left;
    private String word;
    private int right;

    public Piece(int left, String word, int right){
        this.left = left;
        this.word = word;
        this.right = right;
    }

    public int getLeft(){return left;}
    public int getRight(){return right;}
    public String getWord(){return word;}
}
