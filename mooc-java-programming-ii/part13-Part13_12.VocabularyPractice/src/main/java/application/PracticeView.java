package application;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class PracticeView {
    private Dictionary dictionary;
    private String word;
    private String translation;

    public PracticeView(Dictionary dictionary) {
        this.dictionary = dictionary;
        word = dictionary.getRandomWord();
        translation = dictionary.translate(word);
    }

    public Parent getView() {
        GridPane layout = new GridPane();

        Label instructionLabel = new Label("Translate the word '" + word + "'");
        TextField translationInput = new TextField();
        Button checkButton = new Button("Check");
        Label feedback = new Label("");

        checkButton.setOnAction((event) -> {
            if (translationInput.getText().equals(translation)) {
                feedback.setText("Correct!");
            } else {
                feedback.setText("Incorrect! The translation of the word '" + word + "' is '" + translation + "'");
                return;
            }
            translationInput.clear();
            updateWordAndTranslation();
            instructionLabel.setText("Translate the word '" + word + "'");
        });

        layout.add(instructionLabel, 0, 0);
        layout.add(translationInput, 0, 1);
        layout.add(checkButton, 0, 2);
        layout.add(feedback, 0, 3);

        return layout;
    }

    private void updateWordAndTranslation() {
        word = dictionary.getRandomWord();
        translation = dictionary.translate(word);
    }
}
