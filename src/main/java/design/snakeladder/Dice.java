package design.snakeladder;

public class Dice {
    int diceCount;

    public Dice(int diceCount) {
        this.diceCount = diceCount;
    }

    public int getDiceValue() {
        return ((int) (Math.random() * (6 * diceCount - diceCount))) + 1;
    }
}
