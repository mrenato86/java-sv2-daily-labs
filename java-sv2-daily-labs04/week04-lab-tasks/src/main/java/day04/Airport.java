package day04;

public class Airport {

    public static void main(String[] args) {
        Plane plane = new Plane(5);
        Passenger firstPassenger = new Passenger("Jack", "F23", 4);
        Passenger secondPassenger = new Passenger("Jill", "J23", 5);
        Passenger thirdPassenger = new Passenger("Joe", "F26", 1);
        Passenger fourthPassenger = new Passenger("Pete", "H23", 2);
        Passenger fifthPassenger = new Passenger("Julia", "L21", 2);
        Passenger plusPassenger = new Passenger("Plus", "P6", 2);

        plane.addPassenger(firstPassenger);
        plane.addPassenger(secondPassenger);
        plane.addPassenger(thirdPassenger);
        plane.addPassenger(fourthPassenger);


        System.out.println(plane.getPassengers().size()); //4
        System.out.println(plane.addPassenger(fifthPassenger));//true
        System.out.println(plane.getPassengers().size());//5

        System.out.println(plane.addPassenger(plusPassenger));//false
        System.out.println(plane.getPassengers().size());//5

        System.out.println(plane.numberOfPackages());//14

    }
}
