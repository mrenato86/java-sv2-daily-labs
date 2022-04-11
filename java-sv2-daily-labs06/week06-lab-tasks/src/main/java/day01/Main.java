package day01;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        PositiveNumberContainer pnc = new PositiveNumberContainer();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Numbers: ");
        double number;
        while (scanner.hasNextDouble() && (number = scanner.nextDouble()) > 0.) {
            pnc.addNumber(number);
        }
        System.out.println("Numbers so far:");
        System.out.println(pnc);
    }
}

