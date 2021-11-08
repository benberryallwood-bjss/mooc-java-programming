package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GreeterApplication extends Application {


    public static void main(String[] args) {
        launch(GreeterApplication.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        // inputView components
        Label promptText = new Label("Enter your name and start.");
        TextField nameInput = new TextField("");
        Button startButton = new Button("Start");

        // inputView layout
        GridPane inputLayout = new GridPane();

        inputLayout.add(promptText, 0, 0);
        inputLayout.add(nameInput, 0, 1);
        inputLayout.add(startButton, 0, 2);

        // inputLayout styling
        inputLayout.setPrefSize(300, 180);
        inputLayout.setAlignment(Pos.CENTER);
        inputLayout.setVgap(10);
        inputLayout.setHgap(10);
        inputLayout.setPadding(new Insets(20, 20, 20, 20));

        Scene inputView = new Scene(inputLayout);

        // greetingView
        Label greeting = new Label("");

        StackPane greetingLayout = new StackPane();
        greetingLayout.setPrefSize(300, 180);
        greetingLayout.setAlignment(Pos.CENTER);
        greetingLayout.getChildren().add(greeting);

        Scene greetingView = new Scene(greetingLayout);

        startButton.setOnAction((event) -> {
            greeting.setText("Welcome " + nameInput.getText() + "!");
            window.setScene(greetingView);
        });

        window.setTitle("Greeter");
        window.setScene(inputView);
        window.show();
    }
}
