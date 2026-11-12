package Game;

public class Game {
    private int turn;
    private final Board board;

    public Game(){
        board = new Board();
        turn = 1;
    }
    public int getTurn(){
        return turn;
    }
    public void playerInput(Move move){
        board.makeMove(move, turn);
        if (turn == 1){
            turn = 2;
        } else if (turn == 2){
            turn = 1;
        }
    }
    public void undo(){
        board.undo();
    };
    public int getWinner(){
        return board.getWinner();
    }

    public Board getBoard(){
        return board.copy();
    }
}