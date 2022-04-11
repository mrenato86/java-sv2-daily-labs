package day05;

public class MovieMain {

    public static void main(String[] args) {
        Movie movie = new Movie("Good Movie", 1996);
        Viewer viewer = new Viewer();

        movie.rateMovie(5);
        movie.rateMovie(4);
        movie.rateMovie(2);
        movie.rateMovie(4);
        movie.rateMovie(3);

        viewer.watchMovie(movie,5);

        System.out.println(movie.getAvgRating());
    }
}
