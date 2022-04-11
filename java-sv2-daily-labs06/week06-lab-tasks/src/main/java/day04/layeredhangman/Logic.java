package day04.layeredhangman;

public class Logic {

    private final String wordToFind;
    private String wordFound;
    private int chances;

    public Logic(String wordToFind, int chances) {
        this.wordToFind = wordToFind;
        this.wordFound = "_".repeat(wordToFind.length());
        this.chances = chances;
    }

    public String getWordToFind() {
        return wordToFind;
    }

    public String getWordFound() {
        return wordFound;
    }

    public int getChances() {
        return chances;
    }

    public boolean isRightGuess(String guess) {
        if (wordToFind.contains(guess)) {
            wordFound = updateWordFound(wordToFind, wordFound, guess);
            return true;
        }
        chances--;
        return false;
    }

    public boolean won() {
        return wordFound.equals(wordToFind);
    }

    public boolean hasMoreChances() {
        return chances > 0;
    }

    private String updateWordFound(String wordToFind, String status, String guess) {
        char[] chars = status.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (wordToFind.charAt(i) == guess.charAt(0)) {
                chars[i] = guess.charAt(0);
            }
        }
        return new String(chars);
    }
}
