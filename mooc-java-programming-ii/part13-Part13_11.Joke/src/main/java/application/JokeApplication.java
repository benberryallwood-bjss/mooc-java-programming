package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class JokeApplication extends Application {


    public static void main(String[] args) {
        launch(JokeApplication.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        BorderPane layout = new BorderPane();
        layout.setPrefSize(300, 180);

        HBox buttons = new HBox();
        buttons.setPadding(new Insets(20, 20, 20, 20));
        buttons.setSpacing(10);

        Button jokeButton = new Button("Joke");
        Button answerButton = new Button("Answer");
        Button explanationButton = new Button("Explanation");

        buttons.getChildren().addAll(jokeButton, answerButton, explanationButton);
        layout.setTop(buttons);

        StackPane jokeLayout = createLayout("What do you call a bear with no teeth?");
        StackPane answerLayout = createLayout("A gummy bear.");
        StackPane explanationLayout = createLayout("explanation...");

        jokeButton.setOnAction((event) -> layout.setCenter(jokeLayout));
        answerButton.setOnAction((event) -> layout.setCenter(answerLayout));
        explanationButton.setOnAction((event) -> layout.setCenter(explanationLayout));

        layout.setCenter(jokeLayout);

        Scene view = new Scene(layout);

        window.setTitle("Joke");
        window.setScene(view);
        window.show();
    }

    private StackPane createLayout(String text) {
        StackPane layout = new StackPane();
        layout.setPrefSize(300, 180);
        layout.getChildren().add(new Label(text));
        layout.setAlignment(Pos.CENTER);

        return layout;
    }
}
