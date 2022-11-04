package application;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class SavingsCalculatorApplication extends Application {
    public static void main(String[] args) {
        launch(SavingsCalculatorApplication.class);
    }

    @Override
    public void start(Stage window) {
        Label monthlySavingsLabel = new Label("Monthly savings");
        Slider monthlySavingsSlider = new Slider(25, 250, 25);
        final Label monthlySavingsValue = new Label("25.00");

        monthlySavingsSlider.setShowTickLabels(true);
        monthlySavingsSlider.setShowTickMarks(true);
        monthlySavingsSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue <? extends Number> observable, Number oldValue, Number newValue)
            {
                monthlySavingsValue.setText(String.format("%.2f", newValue));
            }
        });

        BorderPane monthlySavingsLayout = new BorderPane();
        monthlySavingsLayout.setLeft(monthlySavingsLabel);
        monthlySavingsLayout.setCenter(monthlySavingsSlider);
        monthlySavingsLayout.setRight(monthlySavingsValue);
        
        Label yearlyInterestRateLabel = new Label("Yearly interest rate");
        Slider yearlyInterestRateSlider = new Slider(0, 10, 10);
        final Label yearlyInterestRateValue = new Label("10.00");

        yearlyInterestRateSlider.setShowTickLabels(true);
        yearlyInterestRateSlider.setShowTickMarks(true);
        yearlyInterestRateSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue <? extends Number> observable, Number oldValue, Number newValue)
            {
                yearlyInterestRateValue.setText(String.format("%.2f", newValue));
            }
        });

        BorderPane yearlyInterestRateLayout = new BorderPane();
        yearlyInterestRateLayout.setLeft(yearlyInterestRateLabel);
        yearlyInterestRateLayout.setCenter(yearlyInterestRateSlider);
        yearlyInterestRateLayout.setRight(yearlyInterestRateValue);

        VBox sliders = new VBox(monthlySavingsLayout, yearlyInterestRateLayout);

        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        NumberAxis yAxis = new NumberAxis(0, 27500, 2500);

        xAxis.setLabel("Years");
        yAxis.setLabel("Amount ($)");

        LineChart<Number, Number> lineChart = new LineChart<Number, Number>(xAxis, yAxis);
        lineChart.setTitle("Savings Calculator");

        BorderPane mainLayout = new BorderPane();
        mainLayout.setTop(sliders);
        mainLayout.setCenter(lineChart);

        window.setScene(new Scene(mainLayout, 600, 480));
        window.show();
    }
}