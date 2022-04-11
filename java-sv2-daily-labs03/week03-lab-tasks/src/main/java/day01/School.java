package day01;

public class School {

    public static void main(String[] args) {

        Students students = new Students();
        students.addHeight(150);
        students.addHeight(170);
        students.addHeight(180);
        students.addHeight(180);
        students.addHeight(181);
        System.out.println(students.isHeightsIncreasing());

        students.addHeight(160);
        System.out.println(students.isHeightsIncreasing());

    }

}
