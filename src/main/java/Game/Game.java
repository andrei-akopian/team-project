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
        flipTurn();
    }
    private void flipTurn(){
        if (turn == 1){
            turn = 2;
        } else if (turn == 2){
            turn = 1;
        }
    }
    public Move undo(){
        Move undonemove = board.undo();
        if (undonemove != null) {
            flipTurn();
        }
        return undonemove;
    };
    public int getWinner(){
        return board.getWinner();
    }

    public Board getBoard(){
        return board.copy();
    }
}