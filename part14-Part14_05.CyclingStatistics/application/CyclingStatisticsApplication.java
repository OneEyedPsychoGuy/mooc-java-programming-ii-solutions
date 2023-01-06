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
        Application.launch(CyclingStatisticsApplication.class);
    }

    @Override
    public void start(Stage stage) {
        CyclingStatistics stats = new CyclingStatistics("helsinki-cycling-statistics.csv");

        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        gridPane.add(new Label("Choose the examined location"), 0, 0);

        ObservableList<String> data = FXCollections.observableArrayList();
        data.addAll(stats.locations());

        ListView<String> list = new ListView<>(data);
        gridPane.add(list, 0, 1);

        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Year / Month");
        yAxis.setLabel("Cyclists");

        BarChart<String, Number> chart = new BarChart<>(xAxis, yAxis);
        chart.setLegendVisible(false);

        list.setOnMouseClicked(event -> {
            String chosen = list.getSelectionModel().getSelectedItem();
            Map<String, Integer> values = stats.monthlyCyclists(chosen);
            chart.getData().clear();

            XYChart.Series<String, Number> chartData = new XYChart.Series<>();
            values.keySet().stream().forEach(time -> chartData.getData().add(new XYChart.Data<>(time, values.get(time))));
            chart.getData().add(chartData);
        });

        gridPane.add(chart, 1, 0, 1, 2);

        stage.setScene(new Scene(gridPane));
        stage.show();
    }
}