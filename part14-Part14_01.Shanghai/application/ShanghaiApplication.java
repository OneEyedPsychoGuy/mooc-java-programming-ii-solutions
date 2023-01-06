package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class ShanghaiApplication extends Application {
    public static void main(String[] args) {
        Application.launch(ShanghaiApplication.class);
    }

    @Override
    public void start(Stage window) {
        NumberAxis xAxis = new NumberAxis(2006, 2018, 2);
        NumberAxis yAxis = new NumberAxis(0, 100, 10);

        xAxis.setLabel("Year");
        yAxis.setLabel("Ranking");

        LineChart<Number, Number> lineChart = new LineChart<Number, Number>(xAxis, yAxis);
        lineChart.setTitle("University of Helsinki, Shanghai ranking");

        XYChart.Series<Number, Number> data = new XYChart.Series<Number, Number>();
        data.getData().add(new XYChart.Data<Number, Number>(2007, 73));
        data.getData().add(new XYChart.Data<Number, Number>(2008, 68));
        data.getData().add(new XYChart.Data<Number, Number>(2009, 72));
        data.getData().add(new XYChart.Data<Number, Number>(2010, 72));
        data.getData().add(new XYChart.Data<Number, Number>(2011, 74));
        data.getData().add(new XYChart.Data<Number, Number>(2012, 73));
        data.getData().add(new XYChart.Data<Number, Number>(2013, 76));
        data.getData().add(new XYChart.Data<Number, Number>(2014, 73));
        data.getData().add(new XYChart.Data<Number, Number>(2015, 67));
        data.getData().add(new XYChart.Data<Number, Number>(2016, 56));
        data.getData().add(new XYChart.Data<Number, Number>(2017, 56));

        lineChart.getData().add(data);

        window.setScene(new Scene(lineChart, 640, 480));
        window.show();
    }
}