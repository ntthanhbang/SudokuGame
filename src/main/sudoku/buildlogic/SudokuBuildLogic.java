package sudoku.buildlogic;

import main.sudoku.userinterface.IUserInterfaceContract;
import main.sudoku.problemdomain.SudokuGame;
import main.sudoku.problemdomain.IStorage;
import sudoku.computationlogic.GameLogic;
import sudoku.persistence.LocalStorageImpl;
import sudoku.userinterface.logic.ControlLogic;

import java.io.IOException;

public class SudokuBuildLogic {
    public static void build(IUserInterfaceContract.View userInterface) throws IOException {
        SudokuGame initialState;
        IStorage storage= new LocalStorageImpl();

        try {
            //will throw if no game data is found in local storage
            initialState = storage.getGameData();
        } catch (IOException e) {
            initialState= GameLogic.getNewGame();
            storage.updateGameData(initialState);
        }
        IUserInterfaceContract.EventListener uiLogic = new ControlLogic(storage, userInterface);
        userInterface.setListener(uiLogic);
        userInterface.updateBoard(initialState);
    }
}
