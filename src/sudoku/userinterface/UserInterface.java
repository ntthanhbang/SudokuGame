package sudoku.userinterface;

import sudoku.foundation.SudokuGame;

public interface UserInterface {
    //Controller
    interface EventListener {
        void onSudokuInput(int x, int y, int input);
        void onDialogClick();
    }

    //Presenter
    interface View {
        void setListener(UserInterface.EventListener listener);
        void updateSquare(int x, int y, int input);

        void updateBoard(SudokuGame game);
        void showDialog(String message);
        void showError(String message);
    }
}
