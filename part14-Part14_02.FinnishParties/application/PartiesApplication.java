package application;

import java.util.Map;
import java.util.function.Consumer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class PartiesApplication extends Application {
    public static void main(String[] args) {
        Application.launch(PartiesApplication.class);
    }

    private Map<String, Map<Integer, Double>> readData() {
        Map<String, Map<Integer, Double>> values = new HashMap<String, Map<Integer, Double>>();

        try(BufferedReader fileReader = new BufferedReader(new FileReader(new File("partiesdata.tsv")))) {           
            String[] years = fileReader.readLine().split("\t");
            String partyRow;

            while((partyRow = fileReader.readLine()) != null) {
                Map<Integer, Double> yearData = new HashMap<Integer, Double>();
                String[] partyRowArray = partyRow.split("\t");

                for(int i = 1; i < partyRowArray.length; i++) {
                    if(!partyRowArray[i].equals("-")) {
                        yearData.put(Integer.valueOf(years[i]), Double.valueOf(partyRowArray[i]));
                    }
                }

                values.put(partyRowArray[0], yearData);
            }
        } catch(IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return values;
    }

    @Override
    public void start(Stage window) {
        NumberAxis xAxis = new NumberAxis(1968, 2008, 4);
        NumberAxis yAxis = new NumberAxis(0, 30, 5);

        xAxis.setLabel("Year");
        yAxis.setLabel("Relative support (%)");

        LineChart<Number, Number> lineChart = new LineChart<Number, Number>(xAxis, yAxis);
        lineChart.setTitle("Relative support of the parties");

        Map<String, Map<Integer, Double>> values = this.readData();

        values.keySet().stream().forEach(party -> {
                XYChart.Series<Number, Number> data = new XYChart.Series<Number, Number>();
                data.setName(party);

                values.get(party)
                    .entrySet()
                    .stream()
                    .forEach(pair -> data.getData().add(new XYChart.Data<Number, Number>(pair.getKey(), pair.getValue())));

                lineChart.getData().add(data);
        });

        window.setScene(new Scene(lineChart, 640, 480));
        window.show();
    }
}