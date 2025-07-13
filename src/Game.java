public class Game {
    private int secretNumber;

    public String checkGuess(int guess) {
        secretNumber = (int) (1 + Math.random() * 100);

        if (guess > secretNumber) {
            return "Больше";
        } else if (guess < secretNumber) {
            return "Меньше";
        }

        return "Угадал";
    }
}
