package csci1110.Summer0;

import java.util.LinkedList;

public class Puzzle {
    private LinkedList<Piece> pieces;
    private Piece end;
    public Puzzle(Piece piece){
        this.pieces = new LinkedList<>();
        pieces.add(piece);
        this.end = piece;
    };
    public void addPiece(Piece piece){
        this.pieces.add(piece);
        this.end = piece;
    }
    public int getRight(){return end.getRight();}

    public String toString(){
        String output = "";
        for(Piece i : pieces){
            output += i.getWord();
        }
        return output;
    }
}
