package Game;

public interface GameInputBoundary {
    public void execute(Move move);
    public void undo();
}
