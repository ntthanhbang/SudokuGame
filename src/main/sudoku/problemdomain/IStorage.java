package main.sudoku.problemdomain;

import java.io.IOException;

import main.sudoku.problemdomain.SudokuGame;

public interface IStorage  {
    void updateGameData (SudokuGame game) throws IOException;
    SudokuGame getGameData () throws IOException;
}
