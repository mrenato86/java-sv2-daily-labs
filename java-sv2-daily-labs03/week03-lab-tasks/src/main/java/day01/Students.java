package day01;

import java.util.ArrayList;
import java.util.List;

public class Students {

    private List<Integer> heights = new ArrayList<>();

    public void addHeight(int height) {
        heights.add(height);
    }

    public boolean isHeightsIncreasing() {
        for (int i = 1; i < heights.size(); i++) {
            if (heights.get(i) < heights.get(i - 1)) {
                return false;
            }
        }
        return true;
    }
}
