package Game.use_cases;

public interface GameInputBoundary {
    public void execute(Move move);
    public void undo();
}
