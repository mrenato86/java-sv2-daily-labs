package day01;

import java.time.LocalDate;

public class Human {
    private String name;
    private int yearOfBirth;

    public Human(String name, int yearOfBirth) {
        if (isNameValid(name) && isYearOfBirthValid(yearOfBirth)) {
            this.name = name;
            this.yearOfBirth = yearOfBirth;
        }
    }

    private boolean isYearOfBirthValid(int yearOfBirth) {
        if (LocalDate.now().getYear() - yearOfBirth > 120) {
            throw new IllegalArgumentException("Age must be below 120!");
        }
        return true;
    }

    private boolean isNameValid(String name) {
        if (name == null || name.split(" ").length != 2) {
            throw new IllegalArgumentException("Name must contain two parts!");
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }
}
