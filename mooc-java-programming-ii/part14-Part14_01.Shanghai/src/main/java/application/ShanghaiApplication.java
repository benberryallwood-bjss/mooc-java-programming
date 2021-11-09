package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.stage.Stage;

public class ShanghaiApplication extends Application {

    public static void main(String[] args) {
        launch(ShanghaiApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        NumberAxis xAxis = new NumberAxis(2006, 2018, 1);
        NumberAxis yAxis = new NumberAxis();

        xAxis.setLabel("Year");
        yAxis.setLabel("Ranking");

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Shanghai Rankings of The University of Helsinki");
        lineChart.getData().add(ShanghaiRankingData.getHelsinkiSeries());

        Scene scene = new Scene(lineChart, 640, 480);

        stage.setTitle("Shanghai");
        stage.setScene(scene);
        stage.show();
    }
}
