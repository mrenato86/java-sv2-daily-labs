package day01;

import java.util.ArrayList;
import java.util.List;

public class Movie {

    private String title;
    private int yearOfRelease;
    private List<Actor> actors = new ArrayList<>();

    public Movie(String title, int yearOfRelease) {
        this.title = title;
        this.yearOfRelease = yearOfRelease;
    }

    public void addActor(Actor actor) {
        actors.add(actor);
    }

    public int actorsInTheirTwenties() {
        int sum = 0;
        for (Actor actor : actors) {
            int delta = yearOfRelease - actor.getYearOfBirth();
            if (delta >= 20 && delta < 30)
                sum++;
        }
        return sum;
    }
}
