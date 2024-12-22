package sudoku.userinterface.logic;

import sudoku.computationlogic.GameLogic;
import sudoku.constants.GameState;
import sudoku.constants.Messages;
import sudoku.foundation.IStorage;
import sudoku.foundation.SudokuGame;
import sudoku.userinterface.UserInterface;

import java.io.IOException;

//Manage the logic controlling the UI w the backend
public class ControlLogic implements UserInterface.EventListener {
    private IStorage storage;
    private UserInterface.View view;

    public ControlLogic(IStorage storage, UserInterface.View view) {
        this.storage = storage;
        this.view = view;
    }

    @Override
    public void onSudokuInput(int x, int y, int input) {
        try {
            //Get prev game data from storage, copy to new board
            //-> Update new input of a square
            SudokuGame gameData = storage.getGameData();
            int[][] newGridState = gameData.getCopyOfGridState();
            newGridState[x][y] = input;

            gameData = new SudokuGame(
                    GameLogic.checkForCompletion(newGridState),
                    newGridState
            );

            //Update the game data in storage
            storage.updateGameData(gameData);
            //Show the new input on the screen
            view.updateSquare(x, y, input);

            if (gameData.getGameState() == GameState.COMPLETE)
                view.showDialog(Messages.GAME_COMPLETE);

        } catch (IOException e) {
            e.printStackTrace();
            view.showError(Messages.ERROR);
        }
    }

    //If player click the OK dialog -> Get new game
    @Override
    public void onDialogClick() {
        try {storage.updateGameData(GameLogic.getNewGame());
            view.updateBoard(storage.getGameData());
        } catch (IOException e) {
            view.showError(Messages.ERROR);
        }
    }
}
