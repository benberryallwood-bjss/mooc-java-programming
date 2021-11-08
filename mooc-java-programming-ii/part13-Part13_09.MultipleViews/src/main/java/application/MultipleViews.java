package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleViews extends Application {

    public static void main(String[] args) {
        launch(MultipleViews.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        Button firstViewButton = new Button("To the first view!");
        Button secondViewButton = new Button("To the second view!");
        Button thirdViewButton = new Button("To the third view!");

        BorderPane firstLayout = new BorderPane();
        firstLayout.setTop(new Label("First view!"));
        firstLayout.setCenter(secondViewButton);

        VBox secondLayout = new VBox();
        secondLayout.setSpacing(10);
        secondLayout.getChildren().addAll(thirdViewButton, new Label("Second view!"));

        GridPane thirdLayout = new GridPane();
        thirdLayout.add(new Label("Third view!"), 0, 0);
        thirdLayout.add(firstViewButton, 1, 1);

        Scene firstView = new Scene(firstLayout);
        Scene secondView = new Scene(secondLayout);
        Scene thirdView = new Scene(thirdLayout);

        firstViewButton.setOnAction((event) -> {
            window.setScene(firstView);
        });

        secondViewButton.setOnAction((event) -> {
            window.setScene(secondView);
        });

        thirdViewButton.setOnAction((event) -> {
            window.setScene(thirdView);
        });

        window.setTitle("Multiple Views");
        window.setScene(firstView);
        window.show();
    }
}
