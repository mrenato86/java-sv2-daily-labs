package day01;

public class MovieMain {

    public static void main(String[] args) {
        Actor firstActor = new Actor("Robert", 1978);//>30
        Actor secondActor = new Actor("John", 2001);//<20
        Actor thirdActor = new Actor("Julia", 1981);//>30
        Actor fourthActor = new Actor("Chris", 1998);//==20
        Actor fifthActor = new Actor("Maria", 1991);//27

        Movie movie = new Movie("Bestest Movie Ever", 2018);
        movie.addActor(firstActor);
        movie.addActor(secondActor);
        movie.addActor(thirdActor);
        movie.addActor(fourthActor);
        movie.addActor(fifthActor);

        System.out.println(movie.actorsInTheirTwenties());
    }
}
