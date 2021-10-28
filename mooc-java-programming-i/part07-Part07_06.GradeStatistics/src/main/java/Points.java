import java.util.List;
import java.util.ArrayList;

public class Points {
    private List<Integer> points;
    private List<Integer> passingPoints;

    public Points() {
        this.points = new ArrayList<>();
        this.passingPoints = new ArrayList<>();
    }

    public void add(int point) {
        if (0 <= point && point <= 100) {
            this.points.add(point);
        }
        if (50 <= point && point <= 100) {
            this.passingPoints.add(point);
        }
    }

    private static double average(List<Integer> list) {
        int total = 0;
        for (int point : list) {
            total += point;
        }
        return 1.0 * total / list.size();
    }

    public double average() {
        return average(this.points);
    }

    public double averagePassing() {
        if (this.passingPoints.isEmpty()) {
            return -1;
        }
        return average(this.passingPoints);
    }

    public double passPercentage() {
        return 100.0 * this.passingPoints.size() / this.points.size();
    }

    private int grade(int index) {
        int point = this.points.get(index);

        if (point < 50) { return 0; }
        if (point < 60) { return 1; }
        if (point < 70) { return 2; }
        if (point < 80) { return 3; }
        if (point < 90) { return 4; }
        return 5;
    }

    public String gradeDistribution() {
        String output = "";

        for (int i = 5; i >= 0; i--) {

            output += i + ": ";

            for (int j = 0; j < this.points.size(); j++) {
                if (grade(j) == i) {
                    output += "*";
                }
            }

            output += "\n";

        }

        return output;
    }
}
