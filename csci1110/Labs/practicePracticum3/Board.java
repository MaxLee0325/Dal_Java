package csci1110.Labs.practicePracticum3;

public class Board {
    private GamePiece[][] grid;
    private int size;

    public Board(int size){
        this.size = size;
        this.grid = new GamePiece[size][size];
    }

    public boolean addPiece(GamePiece piece, int row, int col){
        if(grid[row][col] == null){
            grid[row][col] = piece;
            return true;
        }
        else return false;
    }

    public boolean movePiece(int startRow, int startCol, int endRow, int endCol){
        if(grid[startRow][startCol] != null && grid[endRow][endCol] == null){
            grid[endRow][endCol] = grid[startRow][startCol];
            grid[startRow][startCol] = null;
            return true;
        }
        else return false;
    }

    public GamePiece get(int row, int col){
        return grid[row][col];
    }

    public boolean contains(GamePiece piece){
        boolean isThere = false;
        for(int i = 0; i < size; i++){
            for(GamePiece j : grid[i]){
                if(j == piece){
                    isThere = true;
                }
            }
        }
        return isThere;
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j] != null) {
                    result += grid[i][j];
                } else {
                    result += " ";
                }
            }
            result += "\n";
        }
        return result;
    }
}