package textstatistics;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Arrays;

public class TextStatisticsApplication extends Application {


    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane layout = new BorderPane();

        TextArea userInput = new TextArea("");

        Label letterCount = new Label("Letters: 0");
        Label wordCount = new Label("Words: 1");
        Label longestWord = new Label("The longest word is: ");

        userInput.textProperty().addListener((change, oldValue, newValue) -> {
            int numOfChars = newValue.length();
            String[] words = newValue.split(" ");
            int numOfWords = words.length;
            String longest = Arrays.stream(words)
                    .min((s1, s2) -> s2.length() - s1.length())
                    .get();
            letterCount.setText("Letters: " + numOfChars);
            wordCount.setText("Words: " + numOfWords);
            longestWord.setText("The longest word is: " + longest);
        });

        HBox textComponents = new HBox();
        textComponents.setSpacing(10);
        textComponents.getChildren().addAll(letterCount, wordCount, longestWord);

        layout.setCenter(userInput);
        layout.setBottom(textComponents);

        Scene scene = new Scene(layout);

        stage.setScene(scene);
        stage.show();
    }
}
