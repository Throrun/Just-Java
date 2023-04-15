package game_of_life;

public class main {
    public static void main(String[] args){
        int height=10, width=10;
        Board board = new Board(width,height);
        board.setLife(0,1);
        board.setLife(1,2);
        board.setLife(2,0);
        board.setLife(2,1);
        board.setLife(2,2);
        board.displayGrid();
        board.round();
        board.displayGrid();
        board.round();
        board.displayGrid();
        board.round();
        board.displayGrid();
        board.round();
        board.displayGrid();
        board.round();
        board.displayGrid();
        board.round();
        board.displayGrid();
        board.round();
        board.displayGrid();
    }

}
