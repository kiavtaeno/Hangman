package hangman;

import java.util.Random;

public class SmallDictionary implements Dictionary {
    private final String[] words = {"hello", "world", "java", "hangman", "T-Bank"};

    @Override
    public String getRandomWord() {
        Random random = new Random();
        return words[random.nextInt(words.length)];
    }
}
