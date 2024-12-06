package hangman;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Session {
    private final String wordToGuess;
    private final char[] currentState;
    private final int maxAttempts;
    private int mistakes;
    private final Set<Character> guessedLetters = new HashSet<>();

    public Session(String wordToGuess, int maxAttempts) {
        this.wordToGuess = wordToGuess;
        this.currentState = new char[wordToGuess.length()];
        Arrays.fill(this.currentState, '*');
        this.maxAttempts = maxAttempts;
        this.mistakes = 0;
    }

    public boolean makeGuess(char letter) {
        if (guessedLetters.contains(letter)) {
            return false;
        }

        guessedLetters.add(letter);
        boolean isCorrect = false;

        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == letter) {
                currentState[i] = letter;
                isCorrect = true;
            }
        }

        if (!isCorrect) {
            mistakes++;
        }
        return isCorrect;
    }

    public boolean isWon() {
        return wordToGuess.equals(new String(currentState));
    }

    public boolean isLost() {
        return mistakes >= maxAttempts;
    }

    public String getCurrentState() {
        return String.valueOf(currentState);
    }

    public int getMistakes() {
        return mistakes;
    }

    public int getMaxAttempts() {
        return maxAttempts;
    }

    public String getWordToGuess() {
        return wordToGuess;
    }
}

