package csci1110.Summer0;

import java.util.LinkedList;

public class PuzzleSorter {
    private Puzzle puzzle;
    private LinkedList<Piece> pieces;
    public PuzzleSorter(){}

    public Puzzle getPuzzle(){return puzzle;}
    public LinkedList<Piece> getPieces(){return pieces;}

    public Puzzle sortPuzzle(Puzzle puzzle, LinkedList<Piece> pieces){
        while(puzzle.getRight() != -1){
            for(Piece j : pieces){
                if(puzzle.getRight() + j.getLeft() == -1){
                    puzzle.addPiece(j);
                    break;
                }
            }
        }
        return puzzle;
    }
}
