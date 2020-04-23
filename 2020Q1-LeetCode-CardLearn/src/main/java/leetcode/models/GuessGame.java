package leetcode.models;

import java.util.Random;

public class GuessGame {
    private Random random = new Random();
    private int number;
    public GuessGame() {
        number = random.nextInt(1000);
    }

    public int guess(int num) {
        if (num == number) return 0;
        return num > number ? 1 : -1;
    }
}
