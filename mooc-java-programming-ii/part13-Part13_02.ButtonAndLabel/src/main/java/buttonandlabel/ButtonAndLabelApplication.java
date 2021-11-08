package buttonandlabel;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ButtonAndLabelApplication extends Application {


    public static void main(String[] args) {
        launch(ButtonAndLabelApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Label helloLabel = new Label("Hello");
        Button helloButton = new Button("Hello");

        FlowPane componentGroup = new FlowPane();
        componentGroup.getChildren().add(helloLabel);
        componentGroup.getChildren().add(helloButton);

        Scene scene = new Scene(componentGroup);

        stage.setScene(scene);
        stage.show();
    }
}
