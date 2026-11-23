package Game.use_cases;

public interface GameInputBoundary {
    void execute(Move move);

    void undo();
}
