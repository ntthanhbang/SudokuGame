module com.example.sudokugame {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens main.sudoku.problemdomain to javafx.fxml;
    exports main.sudoku.problemdomain;
    exports;
    opens to
}