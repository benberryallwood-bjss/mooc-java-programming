package application;

import javafx.scene.chart.XYChart;

import java.util.HashMap;
import java.util.Map;

public class ShanghaiRankingData {
    public static XYChart.Series getHelsinkiSeries() {
        XYChart.Series helsinkiSeries = new XYChart.Series();
//        helsinkiSeries.setName("Helsinki");

        Map<Integer, Integer> helsinkiData = getHelsinkiData();
        helsinkiData.forEach((year, ranking) ->
                helsinkiSeries.getData().add(new XYChart.Data(year, ranking))
        );

        return helsinkiSeries;
    }

    private static Map<Integer, Integer> getHelsinkiData() {
        Map<Integer, Integer> helsinkiData = new HashMap<>();

        helsinkiData.put(2007, 73);
        helsinkiData.put(2008, 68);
        helsinkiData.put(2009, 72);
        helsinkiData.put(2010, 72);
        helsinkiData.put(2011, 74);
        helsinkiData.put(2012, 73);
        helsinkiData.put(2013, 76);
        helsinkiData.put(2014, 73);
        helsinkiData.put(2015, 67);
        helsinkiData.put(2016, 56);
        helsinkiData.put(2017, 56);

        return helsinkiData;
    }
}
