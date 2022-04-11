package day05;

public class School {

    public static void main(String[] args) {
        Journal journal = new Journal();
        System.out.println(journal.addStudent("John Doe"));
        System.out.println(journal.addStudent("John"));
        System.out.println(journal.getNames());
    }
}
