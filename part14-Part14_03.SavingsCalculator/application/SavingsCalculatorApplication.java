package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class SavingsCalculatorApplication extends Application {
    public static void main(String[] args) {
        Application.launch(SavingsCalculatorApplication.class);
    }

    private void updateSavings(double monthlySavings, double interestRate,  XYChart.Series<Number, Number> monthlySavingsSeries, XYChart.Series<Number, Number> yearlyInterestSeries) {
        monthlySavingsSeries.getData().clear();
        yearlyInterestSeries.getData().clear();

        double savings = 0.0;
        double interest = 0.0;

        for(int year = 0; year <= 30; year++) {
            monthlySavingsSeries.getData().add(new XYChart.Data<Number, Number>(year, savings));
            yearlyInterestSeries.getData().add(new XYChart.Data<Number, Number>(year, interest));

            savings += monthlySavings * 12;
            interest = (interest + monthlySavings * 12) * (1.0 + interestRate / 100.0);
        }
    };

    @Override
    public void start(Stage window) {
        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        NumberAxis yAxis = new NumberAxis(0, 125000, 25000);

        xAxis.setLabel("Years");
        yAxis.setLabel("Amount ($)");

        LineChart<Number, Number> lineChart = new LineChart<Number, Number>(xAxis, yAxis);
        lineChart.setTitle("Savings Calculator");
        lineChart.setAnimated(false);
        lineChart.setLegendVisible(false);

        XYChart.Series<Number, Number> monthlySavingsSeries = new XYChart.Series<Number, Number>();
        XYChart.Series<Number, Number> yearlyInterestSeries = new XYChart.Series<Number, Number>();
        lineChart.getData().add(monthlySavingsSeries);
        lineChart.getData().add(yearlyInterestSeries);

        Label monthlySavingsLabel = new Label("Monthly savings");
        Slider monthlySavingsSlider = new Slider(25, 250, 125);
        Label monthlySavingsValue = new Label(monthlySavingsSlider.getValue() + "");

        monthlySavingsSlider.setShowTickLabels(true);
        monthlySavingsSlider.setShowTickMarks(true);
        
        Label yearlyInterestRateLabel = new Label("Yearly interest rate");
        Slider yearlyInterestRateSlider = new Slider(0, 10, 5);
        Label yearlyInterestRateValue = new Label(yearlyInterestRateSlider.getValue() + "");

        yearlyInterestRateSlider.setShowTickLabels(true);
        yearlyInterestRateSlider.setShowTickMarks(true);

        monthlySavingsSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            monthlySavingsValue.setText(String.format("%.2f", newValue));
            this.updateSavings(monthlySavingsSlider.getValue(), yearlyInterestRateSlider.getValue(), monthlySavingsSeries, yearlyInterestSeries);
        });

        yearlyInterestRateSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            yearlyInterestRateValue.setText(String.format("%.2f", newValue));
            this.updateSavings(monthlySavingsSlider.getValue(), yearlyInterestRateSlider.getValue(), monthlySavingsSeries, yearlyInterestSeries);
        });

        BorderPane monthlySavingsLayout = new BorderPane();
        monthlySavingsLayout.setLeft(monthlySavingsLabel);
        monthlySavingsLayout.setCenter(monthlySavingsSlider);
        monthlySavingsLayout.setRight(monthlySavingsValue);

        BorderPane yearlyInterestRateLayout = new BorderPane();
        yearlyInterestRateLayout.setLeft(yearlyInterestRateLabel);
        yearlyInterestRateLayout.setCenter(yearlyInterestRateSlider);
        yearlyInterestRateLayout.setRight(yearlyInterestRateValue);

        VBox sliders = new VBox(monthlySavingsLayout, yearlyInterestRateLayout);

        BorderPane mainLayout = new BorderPane();
        mainLayout.setTop(sliders);
        mainLayout.setCenter(lineChart);

        window.setScene(new Scene(mainLayout, 640, 480));
        window.show();
    }
}