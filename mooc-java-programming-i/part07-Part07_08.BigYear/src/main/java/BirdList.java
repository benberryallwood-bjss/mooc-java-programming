import java.util.ArrayList;
import java.util.List;

public class BirdList {
    private List<Bird> birdList;

    public BirdList() {
        this.birdList = new ArrayList<>();
    }

    public void add(Bird bird) {
        this.birdList.add(bird);
    }

    public boolean addObservation(String birdName) {
        Bird bird = search(birdName);
        if (bird == null) {
            return false;
        }
        bird.addObservation();
        return true;
    }

    public Bird search(String birdName) {
        for (Bird bird : this.birdList) {
            if (bird.getName().equals(birdName)) {
                return bird;
            }
        }
        return null;
    }

    public String toString() {
        String output = "";
        for (int i = 0; i < this.birdList.size(); i++) {
            output += this.birdList.get(i);
            if (i < this.birdList.size() - 1) {
                output += "\n";
            }
        }
        return output;
    }
}
