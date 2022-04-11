package day02;

public class Movie {
    private String title;
    private int releaseDate;
    private String producer;

    public Movie(String title, int releaseDate, String producer) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.producer = producer;
    }

    public String getTitle() {
        return title;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public String getProducer() {
        return producer;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", releaseDate=" + releaseDate +
                ", producer='" + producer + '\'' +
                '}';
    }
}
