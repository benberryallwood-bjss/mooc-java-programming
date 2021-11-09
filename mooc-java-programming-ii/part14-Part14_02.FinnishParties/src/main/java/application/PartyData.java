package application;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class PartyData {

    public static void addDataToLinechart(LineChart<Number, Number> lineChart) {
        Map<String, Map<Integer, Double>> data = parseDataFromFile();
        data.keySet().stream().forEach(party -> {
            XYChart.Series series = new XYChart.Series();
            series.setName(party);

            data.get(party).entrySet().stream().forEach(pair -> {
                series.getData().add(new XYChart.Data(pair.getKey(), pair.getValue()));
            });

            lineChart.getData().add(series);
        });
    }

    private static Map<String, Map<Integer, Double>> parseDataFromFile() {
        Map<String, Map<Integer, Double>> data = new HashMap<>();
        List<Integer> years = Arrays.asList(
                1968, 1972, 1976, 1980, 1984, 1988, 1992, 1996, 2000, 2004, 2008
        );

        try {
            Files.lines(Paths.get("partiesdata.tsv"))
                    .map(row -> Arrays.asList(row.split("\t")))
                    .filter(row -> !row.get(0).equals("Party"))
                    .forEach(row -> {
                        String party = row.get(0);
                        Map<Integer, Double> partyData = new HashMap<>();
                        for (int i = 1; i < row.size(); i++) {
                            if (row.get(i).equals("-")) {
                                continue;
                            }
                            partyData.put(years.get(i - 1), Double.valueOf(row.get(i)));
                        }

                        data.put(party, partyData);
                    });
//                    .forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + Arrays.toString(e.getStackTrace()));
        }

        return data;
    }

}
