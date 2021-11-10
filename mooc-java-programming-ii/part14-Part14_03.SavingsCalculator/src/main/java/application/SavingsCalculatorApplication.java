package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SavingsCalculatorApplication extends Application {

    public static void main(String[] args) {
        launch(SavingsCalculatorApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane layout = new BorderPane();
        ApplicationComponents components = new ApplicationComponents();
        VBox sliders = components.getSliders();
        LineChart lineChart = components.getLineChart();

        layout.setPadding(new Insets(20, 20, 20, 20));

        layout.setTop(sliders);
        layout.setCenter(lineChart);

        Scene scene = new Scene(layout, 640, 480);

        stage.setTitle("Savings Calculator");
        stage.setScene(scene);
        stage.show();
    }
}
