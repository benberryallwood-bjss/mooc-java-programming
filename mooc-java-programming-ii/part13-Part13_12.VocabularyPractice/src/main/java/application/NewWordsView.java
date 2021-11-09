package application;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class NewWordsView {
    private Dictionary dictionary;

    public NewWordsView(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public Parent getView() {
        GridPane layout = new GridPane();

        Label wordLabel = new Label("Word");
        TextField wordInput = new TextField();
        Label translationLabel = new Label("Translation");
        TextField translationInput = new TextField();
        Button addButton = new Button("Add the word pair");

        addButton.setOnAction((event) -> {
            String word = wordInput.getText();
            String translation = translationInput.getText();
            dictionary.add(word, translation);

            wordInput.clear();
            translationInput.clear();
        });

        layout.add(wordLabel, 0, 0);
        layout.add(wordInput, 0, 1);
        layout.add(translationLabel, 0, 2);
        layout.add(translationInput, 0, 3);
        layout.add(addButton, 0, 4);

        return layout;
    }
}
