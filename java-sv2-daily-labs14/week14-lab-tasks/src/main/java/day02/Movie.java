package day02;

import java.util.ArrayList;
import java.util.List;

public class Movie {

    private final String title;
    private final int length;
    private final List<String> actors;

    public Movie(String title, int length, List<String> actors) {
        this.title = title;
        this.length = length;
        this.actors = new ArrayList<>(actors);
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public List<String> getActors() {
        return new ArrayList<>(actors);
    }
}
