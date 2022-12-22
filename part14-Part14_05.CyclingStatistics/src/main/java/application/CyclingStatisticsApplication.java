package application;

import java.util.Map;
import java.util.function.Consumer;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CyclingStatisticsApplication extends Application {
    public static void main(String[] args) {
        launch(CyclingStatisticsApplication.class);
    }

    @Override
    public void start(Stage stage) {
        final CyclingStatistics statistics = new CyclingStatistics("helsinki-cycling-statistics.csv");

        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        gridPane.add(new Label("Choose the examined location"), 0, 0);

        ObservableList<String> data = FXCollections.observableArrayList();
        data.addAll(statistics.locations());

        final ListView<String> list = new ListView<String>(data);
        gridPane.add(list, 0, 1);

        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Year / Month");
        yAxis.setLabel("Cyclists");

        final BarChart<String, Number> chart = new BarChart<String, Number>(xAxis, yAxis);
        chart.setLegendVisible(false);

        list.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String chosen = list.getSelectionModel().getSelectedItem();
                final Map<String, Integer> values = statistics.monthlyCyclists(chosen);
                chart.getData().clear();
                final XYChart.Series<String, Number> chartData = new XYChart.Series<String, Number>();

                values.keySet().stream().forEach(new Consumer<String>() {
                    @Override
                    public void accept(String time) {
                        chartData.getData().add(new XYChart.Data<String, Number>(time, values.get(time)));
                    }
                });

                chart.getData().add(chartData);
            }
        });

        gridPane.add(chart, 1, 0, 1, 2);

        stage.setScene(new Scene(gridPane));
        stage.show();
    }
}