package main.sudoku.problemdomain;

import java.io.Serializable;

public class SudokuGame implements Serializable {
    private final GameState gameState;
    private final int [][] girdState;

    public static final int GRID_BOUNDARY =9;

    public SudokuGame(GameState gameState, int[][] girdState) {
        this.gameState = gameState;
        this.girdState = girdState;
    }

    public GameState getGameState() {
        return gameState;
    }

    public int[][] getCopyOfGridState() {
        return SudokuUtilities.copyToNewArray(girdState);
    }
}
