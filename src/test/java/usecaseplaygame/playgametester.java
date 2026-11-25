package usecaseplaygame;

import Game.entities.Game;
import Game.entities.Board;
import Game.use_cases.GameOutputBoundary;
import Game.use_cases.GameOutputData;
import Game.use_cases.GameInteractor;
import Game.use_cases.Move;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class playgametester {
    @Test
    public void newBoardIsEmptyAndInBounds() {
        Board board = new Board();

        assertTrue(board.inBounds(0, 0));
        assertTrue(board.inBounds(board.BOARD_SIZE - 1, board.BOARD_SIZE - 1));
        assertFalse(board.inBounds(-1, 0));
        assertFalse(board.inBounds(0, board.BOARD_SIZE));
        assertTrue(board.tileIsEmpty(0, 0));
        assertEquals(0, board.getWinner());
    }

    @Test
    public void boardAcceptValidMoveAndRejectInvalidMoves() {
        Board board = new Board();
        Move firstMove = new Move(3, 4);

        assertTrue(board.makeMove(firstMove, 1));
        assertEquals(1, board.getTile(firstMove));
        assertFalse(board.tileIsEmpty(firstMove));
        assertFalse(board.makeMove(new Move(3, 4), 2));
        assertFalse(board.makeMove(new Move(-1, 0), 1));
        assertFalse(board.makeMove(new Move(0, 0), 0));
        assertEquals(1, board.getTile(firstMove));
        assertTrue(board.tileIsEmpty(0, 0));
        assertEquals(1, board.getMoveHistory().size());
    }

    @Test
    public void boardDetectsWins() {
        int[][] horizontalMoves = {{7, 3}, {7, 4}, {7, 5}, {7, 6}, {7, 7}};
        int[][] verticalMoves = {{3, 7}, {4, 7}, {5, 7}, {6, 7}, {7, 7}};
        int[][] diagonalMoves = {{3, 3}, {4, 4}, {5, 5}, {6, 6}, {7, 7}};
        int[][] antiDiagonalMoves = {{3, 7}, {4, 6}, {5, 5}, {6, 4}, {7, 3}};

        assertWinningMoves(horizontalMoves);
        assertWinningMoves(verticalMoves);
        assertWinningMoves(diagonalMoves);
        assertWinningMoves(antiDiagonalMoves);
    }

    @Test
    public void boardWinNotTooEarly() {
        Board board = new Board();

        for (int column = 2; column < 6; column++) {
            assertTrue(board.makeMove(new Move(7, column), 1));
        }

        assertEquals(0, board.getWinner());
        assertTrue(board.makeMove(new Move(7, 6), 1));
        assertEquals(1, board.getWinner());
    }

    @Test
    public void undoRemovesLastMoveAndClearsWinner() {
        Board board = new Board();
        Move[] moves = {
                new Move(6, 2),
                new Move(6, 3),
                new Move(6, 4),
                new Move(6, 5),
                new Move(6, 6)
        };
        for (Move move : moves) {
            assertTrue(board.makeMove(move, 1));
        }
        assertEquals(1, board.getWinner());

        Move undoneMove = board.undo();

        assertNotNull(undoneMove);
        assertEquals(6, undoneMove.row);
        assertEquals(6, undoneMove.column);
        assertTrue(board.tileIsEmpty(undoneMove));
        assertEquals(0, board.getWinner());
        assertEquals(4, board.getMoveHistory().size());
    }

    @Test
    public void undoOnEmptyBoardReturnsNull() {
        assertNull(new Board().undo());
    }

    @Test
    public void boardCopy() {
        Board original = new Board();
        Move move = new Move(2, 8);
        assertTrue(original.makeMove(move, 1));

        Board copy = original.copy();
        assertEquals(1, copy.getTile(move));
        assertEquals(1, copy.getMoveHistory().size());
        assertTrue(copy.makeMove(new Move(3, 8), 2));

        assertTrue(original.tileIsEmpty(3, 8));
        assertEquals(1, original.getMoveHistory().size());
        assertEquals(2, copy.getMoveHistory().size());
    }

    @Test
    public void gameAlternatesPlayers() {
        Game game = new Game();
        Move firstMove = new Move(0, 0);
        Move secondMove = new Move(0, 1);

        assertEquals(1, game.getTurn());
        game.playerInput(firstMove);
        assertEquals(2, game.getTurn());
        game.playerInput(secondMove);
        assertEquals(1, game.getTurn());

        Move undoneMove = game.undo();
        assertEquals(secondMove.row, undoneMove.row);
        assertEquals(secondMove.column, undoneMove.column);
        assertEquals(2, game.getTurn());
        assertTrue(game.getBoard().tileIsEmpty(secondMove));
        assertEquals(1, game.getBoard().getTile(firstMove));
    }

    @Test
    public void gameUndoOnEmptyBoard() {
        Game game = new Game();

        assertNull(game.undo());
        assertEquals(1, game.getTurn());
    }

    @Test
    public void interactorReturnsInfo() {
        RecordingOutputBoundary output = new RecordingOutputBoundary();
        GameInteractor interactor = new GameInteractor(output);

        interactor.execute(new Move(4, 5));
        interactor.execute(new Move(4, 6));

        assertEquals(2, output.results.size());
        assertOutput(output.results.get(0), 4, 5, 1, 0);
        assertOutput(output.results.get(1), 4, 6, 2, 0);
    }

    @Test
    public void interactorUndoRestoresPlayerTwoTurn() {
        RecordingOutputBoundary output = new RecordingOutputBoundary();
        GameInteractor interactor = new GameInteractor(output);

        interactor.execute(new Move(4, 5));
        interactor.execute(new Move(4, 6));
        interactor.undo();
        interactor.execute(new Move(5, 5));

        assertEquals(4, output.results.size());
        assertOutput(output.results.get(2), 4, 6, 0, 0);
        assertOutput(output.results.get(3), 5, 5, 2, 0);
    }

    @Test
    public void interactorReturnsWinner() {
        RecordingOutputBoundary output = new RecordingOutputBoundary();
        GameInteractor interactor = new GameInteractor(output);
        for (int column = 0; column < 5; column++) {
            interactor.execute(new Move(7, column));
            if (column < 4) {
                interactor.execute(new Move(8, column));
            }
        }

        assertEquals(9, output.results.size());
        GameOutputData winningMove = output.results.get(8);
        assertOutput(winningMove, 7, 4, 1, 1);
        interactor.undo();
        assertEquals(9, output.results.size());
    }

    private void assertWinningMoves(int[][] moves) {
        Board board = new Board();
        for (int[] position : moves) {
            assertTrue(board.makeMove(new Move(position[0], position[1]), 1));
        }
        assertEquals(1, board.getWinner());
    }

    private void assertOutput(GameOutputData output, int row, int column, int player, int winner) {
        assertEquals(row, output.getRow());
        assertEquals(column, output.getColumn());
        assertEquals(player, output.getPlayer());
        assertEquals(winner, output.getWinner());
    }

    private static class RecordingOutputBoundary implements GameOutputBoundary {
        private final List<GameOutputData> results = new ArrayList<>();

        @Override
        public void prepareView(GameOutputData gameOutputData) {
            results.add(gameOutputData);
        }
    }
}