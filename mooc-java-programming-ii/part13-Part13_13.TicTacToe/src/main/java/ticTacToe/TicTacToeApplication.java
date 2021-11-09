package ticTacToe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TicTacToeApplication extends Application {
    private boolean canPlay;
    private String currentTurn;

    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }

    @Override
    public void init() {
        canPlay = true;
        currentTurn = "X";
    }

    @Override
    public void start(Stage stage) throws Exception {
        init();
        BorderPane layout = new BorderPane();

        Label turnInfo = new Label("Turn: " + currentTurn);
        Button buttonOne = new Button(" ");
        Button buttonTwo = new Button(" ");
        Button buttonThree = new Button(" ");
        Button buttonFour = new Button(" ");
        Button buttonFive = new Button(" ");
        Button buttonSix = new Button(" ");
        Button buttonSeven = new Button(" ");
        Button buttonEight = new Button(" ");
        Button buttonNine = new Button(" ");

        turnInfo.setFont(Font.font("Monospaced", 40));
        buttonOne.setFont(Font.font("Monospaced", 40));
        buttonTwo.setFont(Font.font("Monospaced", 40));
        buttonThree.setFont(Font.font("Monospaced", 40));
        buttonFour.setFont(Font.font("Monospaced", 40));
        buttonFive.setFont(Font.font("Monospaced", 40));
        buttonSix.setFont(Font.font("Monospaced", 40));
        buttonSeven.setFont(Font.font("Monospaced", 40));
        buttonEight.setFont(Font.font("Monospaced", 40));
        buttonNine.setFont(Font.font("Monospaced", 40));

        GridPane gameGrid = new GridPane();
        gameGrid.add(buttonOne, 0, 0);
        gameGrid.add(buttonTwo, 0, 1);
        gameGrid.add(buttonThree, 0, 2);
        gameGrid.add(buttonFour, 1, 0);
        gameGrid.add(buttonFive, 1, 1);
        gameGrid.add(buttonSix, 1, 2);
        gameGrid.add(buttonSeven, 2, 0);
        gameGrid.add(buttonEight, 2, 1);
        gameGrid.add(buttonNine, 2, 2);

        buttonOne.setOnAction((event) -> {
            if (!(buttonOne.getText().equals(" ") && canPlay)) {
                return;
            }
            buttonOne.setText(currentTurn);

            if (buttonTwo.getText().equals(currentTurn) && buttonThree.getText().equals(currentTurn) ||
                    buttonFive.getText().equals(currentTurn) && buttonNine.getText().equals(currentTurn) ||
                    buttonFour.getText().equals(currentTurn) && buttonSeven.getText().equals(currentTurn)) {
                canPlay = false;
                turnInfo.setText("The end!");
                return;
            }

            currentTurn = currentTurn.equals("X") ? "O" : "X";
            turnInfo.setText("Turn: " + currentTurn);
        });

        buttonTwo.setOnAction((event) -> {
            if (!(buttonTwo.getText().equals(" ") && canPlay)) {
                return;
            }
            buttonTwo.setText(currentTurn);

            if (buttonOne.getText().equals(currentTurn) && buttonThree.getText().equals(currentTurn) ||
                    buttonFive.getText().equals(currentTurn) && buttonEight.getText().equals(currentTurn)) {
                canPlay = false;
                turnInfo.setText("The end!");
                return;
            }

            currentTurn = currentTurn.equals("X") ? "O" : "X";
            turnInfo.setText("Turn: " + currentTurn);
        });

        buttonThree.setOnAction((event) -> {
            if (!(buttonThree.getText().equals(" ") && canPlay)) {
                return;
            }
            buttonThree.setText(currentTurn);

            if (buttonOne.getText().equals(currentTurn) && buttonTwo.getText().equals(currentTurn) ||
                    buttonSeven.getText().equals(currentTurn) && buttonFive.getText().equals(currentTurn) ||
                    buttonSix.getText().equals(currentTurn) && buttonNine.getText().equals(currentTurn)) {
                canPlay = false;
                turnInfo.setText("The end!");
                return;
            }

            currentTurn = currentTurn.equals("X") ? "O" : "X";
            turnInfo.setText("Turn: " + currentTurn);
        });

        buttonFour.setOnAction((event) -> {
            if (!(buttonFour.getText().equals(" ") && canPlay)) {
                return;
            }
            buttonFour.setText(currentTurn);

            if (buttonOne.getText().equals(currentTurn) && buttonSeven.getText().equals(currentTurn) ||
                    buttonFive.getText().equals(currentTurn) && buttonSix.getText().equals(currentTurn)) {
                canPlay = false;
                turnInfo.setText("The end!");
                return;
            }

            currentTurn = currentTurn.equals("X") ? "O" : "X";
            turnInfo.setText("Turn: " + currentTurn);
        });

        buttonFive.setOnAction((event) -> {
            if (!(buttonFive.getText().equals(" ") && canPlay)) {
                return;
            }
            buttonFive.setText(currentTurn);

            if (buttonFour.getText().equals(currentTurn) && buttonSix.getText().equals(currentTurn) ||
                    buttonOne.getText().equals(currentTurn) && buttonNine.getText().equals(currentTurn) ||
                    buttonSeven.getText().equals(currentTurn) && buttonThree.getText().equals(currentTurn)) {
                canPlay = false;
                turnInfo.setText("The end!");
                return;
            }

            currentTurn = currentTurn.equals("X") ? "O" : "X";
            turnInfo.setText("Turn: " + currentTurn);
        });

        buttonSix.setOnAction((event) -> {
            if (!(buttonSix.getText().equals(" ") && canPlay)) {
                return;
            }
            buttonSix.setText(currentTurn);

            if (buttonFour.getText().equals(currentTurn) && buttonFive.getText().equals(currentTurn) ||
                    buttonThree.getText().equals(currentTurn) && buttonNine.getText().equals(currentTurn)) {
                canPlay = false;
                turnInfo.setText("The end!");
                return;
            }

            currentTurn = currentTurn.equals("X") ? "O" : "X";
            turnInfo.setText("Turn: " + currentTurn);
        });

        buttonSeven.setOnAction((event) -> {
            if (!(buttonSeven.getText().equals(" ") && canPlay)) {
                return;
            }
            buttonSeven.setText(currentTurn);

            if (buttonEight.getText().equals(currentTurn) && buttonNine.getText().equals(currentTurn) ||
                    buttonOne.getText().equals(currentTurn) && buttonFour.getText().equals(currentTurn) ||
                    buttonFive.getText().equals(currentTurn) && buttonThree.getText().equals(currentTurn)) {
                canPlay = false;
                turnInfo.setText("The end!");
                return;
            }

            currentTurn = currentTurn.equals("X") ? "O" : "X";
            turnInfo.setText("Turn: " + currentTurn);
        });

        buttonEight.setOnAction((event) -> {
            if (!(buttonEight.getText().equals(" ") && canPlay)) {
                return;
            }
            buttonEight.setText(currentTurn);

            if (buttonSeven.getText().equals(currentTurn) && buttonNine.getText().equals(currentTurn) ||
                    buttonTwo.getText().equals(currentTurn) && buttonFive.getText().equals(currentTurn)) {
                canPlay = false;
                turnInfo.setText("The end!");
                return;
            }

            currentTurn = currentTurn.equals("X") ? "O" : "X";
            turnInfo.setText("Turn: " + currentTurn);
        });

        buttonNine.setOnAction((event) -> {
            if (!(buttonNine.getText().equals(" ") && canPlay)) {
                return;
            }
            buttonNine.setText(currentTurn);

            if (buttonSeven.getText().equals(currentTurn) && buttonEight.getText().equals(currentTurn) ||
                    buttonOne.getText().equals(currentTurn) && buttonFive.getText().equals(currentTurn) ||
                    buttonThree.getText().equals(currentTurn) && buttonSix.getText().equals(currentTurn)) {
                canPlay = false;
                turnInfo.setText("The end!");
                return;
            }

            currentTurn = currentTurn.equals("X") ? "O" : "X";
            turnInfo.setText("Turn: " + currentTurn);
        });

        layout.setPadding(new Insets(20, 20, 20, 20));
        gameGrid.setAlignment(Pos.CENTER);
        gameGrid.setHgap(10);
        gameGrid.setVgap(10);

        layout.setTop(turnInfo);
        layout.setCenter(gameGrid);

        Scene scene = new Scene(layout, 400, 500);
        stage.setTitle("Tic Tac Toe");
        stage.setScene(scene);
        stage.show();
    }

}
