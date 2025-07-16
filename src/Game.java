public class Game {
    private final int secretNumber = (int) (1 + Math.random() * 100);

    public String checkGuess(int guess) {
        if (guess > secretNumber) {
            return "Больше";
        } else if (guess < secretNumber) {
            return "Меньше";
        }

        return "Угадал";
    }
}
