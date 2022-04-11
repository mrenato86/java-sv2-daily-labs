package day02;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Quiz {

    private String correctAnswers;
    private final Map<String, String> playerAnswers = new HashMap<>();
    private Map<String, Integer> playerPoint;

    public Quiz(Path path) {
        readResultsFromFile(path);
    }

    private void readResultsFromFile(Path path) {
        try (Scanner scanner = new Scanner(path)) {
            correctAnswers = scanner.nextLine();
            while (scanner.hasNextLine()) {
                putParsedEntry(scanner.nextLine());
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("File reading error!", ioe);
        }
    }

    private void putParsedEntry(String line) {
        String[] parts = line.split(" ");
        String answer = playerAnswers.containsKey(parts[0]) ? playerAnswers.get(parts[0]).concat(parts[1]) : parts[1];
        playerAnswers.put(parts[0], answer);
    }

    private void generatePlayerPoint() {
        Map<String, Integer> points = new HashMap<>();
        for (Map.Entry<String, String> entry : playerAnswers.entrySet()) {
            points.put(entry.getKey(), calculatePoint(entry.getValue()));
        }
        playerPoint = points;
    }

    private Integer calculatePoint(String answers) {
        int points = 0;
        for (int i = 0; i < correctAnswers.length(); i++) {
            if (correctAnswers.charAt(i) == answers.charAt(i)) {
                points += i + 1;
            } else if (answers.charAt(i) != 'X') {
                points -= 2;
            }
        }
        return points;
    }

    public String getWinner() {
        if (playerPoint == null) {
            generatePlayerPoint();
        }
        String winner = null;
        int maxPoint = 0;
        for (Map.Entry<String, Integer> entry : playerPoint.entrySet()) {
            if (entry.getValue() > maxPoint) {
                maxPoint = entry.getValue();
                winner = entry.getKey();
            }
        }
        if (winner == null) {
            throw new IllegalStateException("No winner found!");
        }
        return winner;
    }

    public boolean isCorrectAnswer(String player, int answerNumber) {
        return playerAnswers.get(player).charAt(answerNumber - 1) == correctAnswers.charAt(answerNumber - 1);
    }

    public String getCorrectAnswers() {
        return correctAnswers;
    }

    public Map<String, String> getPlayerAnswers() {
        return new HashMap<>(playerAnswers);
    }

}
