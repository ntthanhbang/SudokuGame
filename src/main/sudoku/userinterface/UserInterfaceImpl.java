package main.sudoku.userinterface;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import main.sudoku.problemdomain.Coordinates;

import java.awt.*;
import java.util.HashMap;

public class UserInterfaceImpl implements IUserInterfaceContract.View, EventHandler<KeyEvent> {

    private final Stage stage;
    private final Group root;

    //how do we keep track of 81 different text fiels?
    private HashMap<Coordinates, SudokuTextField> textFieldCoordinates;

    private IUserInterfaceContract.EventListener listener;

    private static final double WINDOW_WIDTH = 668;
    private static final double WINDOW_HEIGHT = 782;
    private static final double BOARD_PADDING = 50;
    private static final double BOARD_WIDTH_HEIGHT = 576;

    private static final Color WINDOW_BACKGROUND_COLOR = Color.rgb(i= 0, i1= 150, i2= 136);
    private static final Color BOARD_BACKGROUND_COLOR = Color.rgb(i= 224, i1= 242, i2= 241);
    private static final String Sudoku = "Sudoku";

    public UserInterfaceImpl(Stage stage) {
        this.stage = stage;
        this.root = new Group();
        this.textFieldCoordinates = new HashMap<>();
        initializeUserInterface();
    }
    private void initializeUserInterface() {
        drawBackground (root);
        drawTitle(root);
        drawSudokuBoard(root);
        drawTextFields (root);
        drawGridLines(root);
        stage.show();
    }

    private void drawBackground(Group root) {

    }

    private void drawTitle(Group root) {

    }

    private void drawSudokuBoard(Group root) {

    }

    private void drawTextFields(Group root) {
        final int xOrigin = 50;
        final int yOrigin = 50;

        final int xAndYDelta = 64;

        //O(n^2) Runtime Complexity
        for (int xIndex =0; xIndex < 9; xIndex++) {
            for (int yIndex =0; yIndex < 9; yIndex++) {
                int x = xOrigin + xIndex * xAndYDelta;
                int y = yOrigin + yIndex * xAndYDelta;

                SudokuTextField tile = new SudokuTextField(xIndex,yIndex);

                styleSudokuTile(tile, x, y);
            }
        }
    }

    private void styleSudokuTile(SudokuTextField tile, double x, double y) {
        Font numberFont = new Font (v=32);

        tile.setFont(numberFont);
        tile.setAlignment(Pos.CENTER);

        tile.setLayoutX(x);
        tile.setLayoutY(y);
        tile.setPrefHeight(64);
        tile.setPrefWidth(64);

        tile.setBackground(Background.EMPTY);
    }

    private void drawGridLines(Group root) {
        int xAndY = 114;
        int index = 0;
        while (index < 8) {
            int thickness;
            if (index == 2 || index == 5) {
                thickness = 3;
            } else {
                thickness = 2;
            }

            Rectangle verticalLine = getLine (
                    i= xAndY + 64 * index,
                    BOARD_PADDING,
                    BOARD_WIDTH_HEIGHT,
                    thickness
            );

            Rectangle horizontalLine = getLine (
                    BOARD_PADDING,
                    i= xAndY + 64 * index,
                    thickness,
                    BOARD_WIDTH_HEIGHT
            );

            root.getChildren().addAll (
                    verticalLine,
                    horizontalLine
            );

            index++;
        }
    }

    private Rectangle getLine (double x,
                               double y,
                               double height,
                               double width) {
        Rectangle line = new Rectangle();

        line.setX(x);
        line.setY(y);
        line.setWidth(width);
        line.setHeight(height);
        line.setFill(Color.BLACK);
        return null;
    }


    @Override
    public void handle(KeyEvent event) {

    }

    @Override
    public void setListener (IUserInterfaceContract.EventListener listener) {
        this.listener = listener;
    }

    @Override
    public void updateSquare (int x, int y, int input) {

    }
}
