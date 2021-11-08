package notifier;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NotifierApplication extends Application {


    public static void main(String[] args) {
        launch(NotifierApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        TextField userInput = new TextField("");
        Button copyButton = new Button("Update");
        Label copiedText = new Label("");

        copyButton.setOnAction((event) -> {
            copiedText.setText(userInput.getText());
        });

        VBox componentGroup = new VBox();
        componentGroup.setSpacing(10);
        componentGroup.getChildren().addAll(userInput, copyButton, copiedText);

        Scene viewport = new Scene(componentGroup);

        stage.setScene(viewport);
        stage.show();
    }
}
