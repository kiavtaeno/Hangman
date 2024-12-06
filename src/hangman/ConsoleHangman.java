package hangman;

import java.util.Scanner;

public class ConsoleHangman {
    private final Dictionary dictionary;
    private Session session;

    public ConsoleHangman(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    private String getRandomWord() {
        return dictionary.getRandomWord();
    }


    public void run() {
        Scanner scanner = new Scanner(System.in);


        String wordToGuess = dictionary.getRandomWord();
        session = new Session(wordToGuess, 5);

        System.out.println("Добро пожаловать в игру)))");
        System.out.println("Попробуйте угадать слово.");


        while (!session.isLost() && !session.isWon()) {
            System.out.println("\nТекущее слово: " + session.getCurrentState());
            System.out.println("Ошибки: " + session.getMistakes() + " из " + session.getMaxAttempts());
            System.out.print("Введите букву (или 'quit' для выхода): ");
            String input = scanner.nextLine().trim().toLowerCase();


            if (input.equals("quit")) {
                System.out.println("ха-ха, Вы сдались! Загаданное слово было: " + wordToGuess);
                break;
            }


            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                System.out.println("Пожаааалуйста, введите одну букву.");
                continue;
            }


            char guessedLetter = input.charAt(0);
            boolean guessedCorrectly = session.makeGuess(guessedLetter);


            if (guessedCorrectly) {
                System.out.println("Правильно!xD");
            } else {
                System.out.println("Ошибка!");
            }


            if (session.isWon()) {
                System.out.println("Поздравляю, вы выиграли вы крутой! Загаданное слово: " + wordToGuess);
                break;
            }
        }


        if (session.isLost()) {
            System.out.println("грустни, но Вы проиграли! Загаданное слово было: " + wordToGuess);
        }
    }

    public static void main(String[] args) {
        Dictionary dictionary = new SmallDictionary();
        ConsoleHangman hangman = new ConsoleHangman(dictionary);
        hangman.run();
    }
}

