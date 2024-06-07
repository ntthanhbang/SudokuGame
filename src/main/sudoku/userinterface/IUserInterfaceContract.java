package main.sudoku.userinterface;

public interface IUserInterfaceContract {
    interface EventListener {
        void onSudokuInput (int x, int y);
        void onDialogClick();
    }

    interface View {
        void setListener (IUserInterfaceContract.EventListener listener);
        void updateSquare (int x, int y, int input);
        void updateBoard (SudokuGame game);
        void showDiaglog (String Message);
        void showError (String Message);
    }
}
