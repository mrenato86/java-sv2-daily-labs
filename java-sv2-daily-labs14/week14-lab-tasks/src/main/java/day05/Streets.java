package day05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Streets {

    private final Map<String, List<Integer>> streets = new HashMap<>();

    public void readFromFile(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                String streetName = parts[0];
                int number = Integer.parseInt(parts[1]);
                streets.putIfAbsent(streetName, new ArrayList<>());
                streets.get(streetName).add(getLastNumber(streetName, number) + 2);
            }
        } catch (IOException | NumberFormatException e) {
            throw new IllegalStateException("Error during file reading: " + e.getMessage(), e);
        }
    }

    private int getLastNumber(String street, int number) {
        return streets.get(street).stream()
                .mapToInt(v -> v)
                .filter(v -> v % 2 == number)
                .max()
                .orElse(-number);
    }

    public long getCountOfEvenNumbersByStreet(String street) {
        return streets.get(street).stream()
                .filter(v -> v % 2 == 0)
                .count();
    }

    public long getCountOfOddNumbers() {
        return streets.values().stream()
                .flatMap(Collection::stream)
                .filter(v -> v % 2 != 0)
                .count();
    }

    public Map<String, List<Integer>> getStreets() {
        return new HashMap<>(streets);
    }

    public static void main(String[] args) {
        Streets streets = new Streets();
        streets.readFromFile(Path.of("src/main/resources/streets.txt"));
        System.out.println(streets.getStreets()); //Kossuth=[2, 4, 1, 3, 5, 7], Petofi=[1, 2, 4, 3, 6]
        System.out.println(streets.getCountOfEvenNumbersByStreet("Kossuth")); //2
        System.out.println(streets.getCountOfEvenNumbersByStreet("Petofi")); //3
        System.out.println(streets.getCountOfOddNumbers()); //6
    }

}
