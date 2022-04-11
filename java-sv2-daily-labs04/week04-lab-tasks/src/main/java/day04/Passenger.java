package day04;

public class Passenger {

    private String name;
    private String id;
    private int numOfPackage;

    public Passenger(String name, String id, int numOfPackage) {
        this.name = name;
        this.id = id;
        this.numOfPackage = numOfPackage;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getNumOfPackage() {
        return numOfPackage;
    }
}
