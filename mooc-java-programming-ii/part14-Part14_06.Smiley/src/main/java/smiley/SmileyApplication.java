package smiley;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SmileyApplication extends Application {

    public static void main(String[] args) {
        launch(SmileyApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane layout = new BorderPane();
        Canvas canvas = new Canvas(640, 480);

        GraphicsContext painter = canvas.getGraphicsContext2D();
        painter.setFill(Color.BLACK);

        painter.fillRect(160, 80, 80, 80);
        painter.fillRect(360, 80, 80, 80);
        painter.fillRect(80, 240, 80, 80);
        painter.fillRect(440, 240, 80, 80);
        painter.fillRect(160, 320, 280, 80);

        layout.setCenter(canvas);
        stage.setScene(new Scene(layout));
        stage.show();
    }

}
