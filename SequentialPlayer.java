package game;

public class SequentialPlayer implements Player {
    private int row, column;
    public SequentialPlayer(int m, int n, int k) {
        this.row = m;
        this.column = n;
    }
    @Override
    public Move makeMove(Position position, Cell cell) {
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                final Move move = new Move(r, c, position.getTurn());
                if (position.isValid(move)) {
                    return move;
                }
            }
        }
        throw new AssertionError("No valid moves");
    }
}
