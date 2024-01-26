package csci1110.Summer0;
import java.util.*;

public class main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = Integer.parseInt(in.next());
        LinkedList<Piece> pieces = new LinkedList<>();
        LinkedList<Puzzle> puzzles = new LinkedList<>();

        for(int i = 0; i < num; i++){
            Piece piece = new Piece(Integer.parseInt(in.next()), in.next(), Integer.parseInt(in.next()));
            if(piece.getLeft() == 0){
                puzzles.add(new Puzzle(piece));
            }
            else pieces.add(piece);
        }

        for(Puzzle puzzle : puzzles){
            PuzzleSorter sort = new PuzzleSorter();
            Puzzle sorted = sort.sortPuzzle(puzzle, pieces);
            System.out.println(sorted.toString());
        }
    }
}
