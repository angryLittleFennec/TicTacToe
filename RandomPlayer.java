package game;


import java.util.Random;

public class RandomPlayer implements Player {
    private final int n, m;

    public RandomPlayer(int m, int n) {
        this.m = m;
        this.n = n;
    }

    private final Random random = new Random();

    public Move makeMove(Position position, Cell cell) {
        Move move;
        do {
            move = new Move(random.nextInt(n), random.nextInt(m), cell);
        } while (!position.isValid(move));
        return move;
    }

}
