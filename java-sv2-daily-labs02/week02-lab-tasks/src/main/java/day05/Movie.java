package day05;

import java.util.ArrayList;
import java.util.List;

public class Movie {

    private String title;
    private int releaseDate;
    private double avgRating;
    private List<Integer> allRating;

    public Movie(String title, int releaseDate) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.allRating = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public double getAvgRating() {
        return avgRating;
    }

    public double rateMovie(int rating){
        allRating.add(rating);
        return this.avgRating = calculateAvg();

    }

    private double calculateAvg() {
        double sum=0;
        for(int rate : allRating)
            sum += rate;
        return sum/allRating.size();
    }

}
