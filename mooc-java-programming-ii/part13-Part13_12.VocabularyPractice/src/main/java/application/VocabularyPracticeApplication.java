package application;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class VocabularyPracticeApplication  extends Application {
    private Dictionary dictionary;

    public static void main(String[] args) {
        launch(VocabularyPracticeApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        dictionary = new Dictionary();
        BorderPane layout = new BorderPane();
        NewWordsView newWordsView = new NewWordsView(dictionary);
        PracticeView practiceView = new PracticeView(dictionary);

        HBox menu = new HBox();

        Button newWordsButton = new Button("Enter new words");
        Button practiceButton = new Button("Practice");

        menu.getChildren().addAll(newWordsButton, practiceButton);

        newWordsButton.setOnAction((event) -> {
            layout.setCenter(newWordsView.getView());
        });

        practiceButton.setOnAction((event) -> {
            layout.setCenter(practiceView.getView());
        });

        layout.setTop(menu);
        layout.setCenter(newWordsView.getView());
        Scene scene = new Scene(layout, 400, 300);

        stage.setTitle("Vocabulary Practice");
        stage.setScene(scene);
        stage.show();
    }
}
