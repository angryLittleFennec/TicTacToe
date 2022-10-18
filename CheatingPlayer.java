package game;

import java.util.Scanner;

public class CheatingPlayer implements Player {
    private int row, column;
    public CheatingPlayer(int m, int n, int k) {
        this.row = m;
        this.column = n;
    }
    @Override
    public Move makeMove(Position position, Cell cell) {
        final MNKBoard board = (MNKBoard) position;
        Move first = null;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                final Move move = new Move(r, c, position.getTurn());
                if (position.isValid(move)) {
                    if (first == null) {
                        first = move;
                    } else {
                        board.makeMove(move);
                    }
                }
            }
        }
        return first;
    }
}
