package application;

import javafx.geometry.Insets;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class ApplicationComponents {
    private Slider monthlySavingsSlider;
    private Slider interestRateSlider;
    private Label monthlySavingsDisplay;
    private Label interestRateDisplay;
    private LineChart<Number, Number> lineChart;

    public ApplicationComponents() {
        monthlySavingsSlider = new Slider();
        interestRateSlider = new Slider();
        monthlySavingsDisplay = new Label("" + (int) monthlySavingsSlider.getValue());
        interestRateDisplay = new Label("" + Math.round(interestRateSlider.getValue() * 100 / 100));

        monthlySavingsSlider.setMin(25);
        monthlySavingsSlider.setMax(250);
        monthlySavingsSlider.setBlockIncrement(1);
        monthlySavingsSlider.setShowTickLabels(true);
        monthlySavingsSlider.setShowTickMarks(true);
        monthlySavingsSlider.setMinorTickCount(4);

        interestRateSlider.setMin(0);
        interestRateSlider.setMax(10);
        interestRateSlider.setBlockIncrement(0.1);
        interestRateSlider.setShowTickLabels(true);
        interestRateSlider.setShowTickMarks(true);
        interestRateSlider.setMajorTickUnit(1);
        interestRateSlider.setMinorTickCount(4);
    }

    public VBox getSliders() {
        VBox sliders = new VBox();
        BorderPane monthlySavingsLayout = new BorderPane();
        BorderPane interestRateLayout = new BorderPane();

        monthlySavingsLayout.setLeft(new Label("Monthly savings"));
        monthlySavingsLayout.setCenter(monthlySavingsSlider);
        monthlySavingsLayout.setRight(monthlySavingsDisplay);

        interestRateLayout.setLeft(new Label("Yearly interest rate"));
        interestRateLayout.setCenter(interestRateSlider);
        interestRateLayout.setRight(interestRateDisplay);

        monthlySavingsSlider.setOnMouseDragged((event) -> {
            monthlySavingsDisplay.setText("" + (int) monthlySavingsSlider.getValue());
        });
        interestRateSlider.setOnMouseDragged((event) -> {
            interestRateDisplay.setText("" + Math.round(interestRateSlider.getValue() * 10) / 10.0);
        });

        monthlySavingsSlider.setOnMouseReleased((event) -> {
            monthlySavingsDisplay.setText("" + (int) monthlySavingsSlider.getValue());
            updateLineChart();
        });
        interestRateSlider.setOnMouseReleased((event) -> {
            interestRateDisplay.setText("" + Math.round(interestRateSlider.getValue() * 10) / 10.0);
            updateLineChart();
        });

        sliders.setSpacing(10);
        sliders.setPadding(new Insets(15, 15, 15, 15));

        sliders.getChildren().addAll(monthlySavingsLayout, interestRateLayout);
        return sliders;
    }

    private void updateLineChart() {
        XYChart.Series<Number, Number> monthlySavingsSeries = lineChart.getData().get(0);
        XYChart.Series<Number, Number> withInterestSeries = lineChart.getData().get(1);
        double currentValue = 0;
        for (int year = 0; year < 31; year++) {
            double monthlySavings = year * 12 * monthlySavingsSlider.getValue();
            monthlySavingsSeries.getData().get(year)
                    .setYValue(monthlySavings);
            withInterestSeries.getData().get(year)
                    .setYValue(currentValue);
            currentValue += 12 * monthlySavingsSlider.getValue();
            currentValue *= (1 + (interestRateSlider.getValue() / 100));
        }
    }

    public LineChart<Number, Number> getLineChart() {
        NumberAxis xAxis = new NumberAxis(0, 30, 5);
        NumberAxis yAxis = new NumberAxis();
        lineChart = new LineChart<Number, Number>(xAxis, yAxis);

        xAxis.setLabel("Years");
        yAxis.setLabel("Amount Saved (£)");

        XYChart.Series<Number, Number> monthlySavingsSeries = new XYChart.Series<>();
        monthlySavingsSeries.setName("Monthly Savings Only");
        for (int year = 0; year < 31; year++) {
            monthlySavingsSeries.getData().add(
                    new XYChart.Data<Number, Number>(year, year * 12 * monthlySavingsSlider.getValue())
            );
        }
        lineChart.getData().add(monthlySavingsSeries);

        XYChart.Series<Number, Number> withInterestSeries = new XYChart.Series<>();
        withInterestSeries.setName("Monthly Savings Plus Interest");
        for (int year = 0; year < 31; year++) {
            withInterestSeries.getData().add(new XYChart.Data<Number, Number>(
                    year, year * 12 * monthlySavingsSlider.getValue() * (1 + interestRateSlider.getValue() / 100)

            ));
        }
        lineChart.getData().add(withInterestSeries);

        return lineChart;
    }
}
