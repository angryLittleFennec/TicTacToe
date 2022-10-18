package game;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class MNKBoard implements Board, Position {
    private static final Map<Cell, String> CELL_TO_STRING = Map.of(
            Cell.E, ".",
            Cell.X, "X",
            Cell.O, "0"
    );

    protected Cell[][] field;
    private Cell turn;
    int row, column, numsInRow;

    public MNKBoard(int m, int n, int k) {
        this.column = m;
        this.row = n;
        this.numsInRow = k;
        field = new Cell[n][m];
        for (Cell[] row : field) {
            Arrays.fill(row, Cell.E);
        }
        turn = Cell.X;
    }


    public Cell getTurn() {
        return turn;
    }

    @Override
    public Position getPosition() {
        return this;
    }

    @Override
    public GameResult makeMove(Move move) {
        if (!isValid(move)) {
            return GameResult.LOSE;
        }

        field[move.getRow()][move.getCol()] = move.getValue();
        if (checkWin(move.getRow(), move.getCol())) {
            return GameResult.WIN;
        }

        if (checkDraw()) {
            return GameResult.DRAW;
        }

        turn = turn == Cell.X ? Cell.X : Cell.O;
        return GameResult.UNKNOWN;
    }


    public boolean checkWin(int a, int b) {
        return checkCol(a, b) || checkD(a, b) || checkRow(a, b);
    }

    public boolean checkD(int a, int b) {
        int d1 = 0;
        int d2 = 0;
        int d3 = 0;
        int d4 = 0;
        for (int i = 1; i < numsInRow; i++) {
            if (a - i >= 0 && b - i >= 0 && field[a - i][b - i] == turn) {
                d1++;
            } else {
                break;
            }
        }
        if (d1 + 1 >= numsInRow) {
            return true;
        }

        for (int i = 1; i < numsInRow; i++) {
            if (a + i < row && b + i < column && field[a + i][b + i] == turn) {
                d2++;
            } else {
                break;
            }
        }
        if (d2 + 1 >= numsInRow || d1 + d2 + 1 >= numsInRow) {
            return true;
        }

        for (int i = 1; i < numsInRow; i++) {
            if (a - i >= 0 && b + i < column && field[a - i][b + i] == turn) {
                d3++;
            } else {
                break;
            }
        }
        if (d3 + 1 >= numsInRow) {
            return true;
        }

        for (int i = 1; i < numsInRow; i++) {
            if (a + i < row && b - i >= 0 && field[a + i][b - i] == turn) {
                d4++;
            } else {
                break;
            }
        }
        return d3 + d4 + 1 >= numsInRow;
    }

    public boolean checkRow(int a, int b) {
        int r0 = 0;
        int r1 = 0;
        for (int i = 0; i < numsInRow; i++) {
            if (b + i < column && field[a][b + i] == turn) {
                r0++;
            } else {
                break;
            }
        }
        for (int i = 0; i < numsInRow; i++) {
            if (b - i >= 0 && field[a][ b - i] == turn) {
                r0++;
            } else {
                break;
            }
        }
        turn = turn == Cell.X ? Cell.O : Cell.X;
        return r0 + r1 - 1 >= numsInRow;
    }

    public boolean checkCol(int a, int b) {
        int c0 = 0;
        int c1 = 0;
        for (int i = 0; i < numsInRow; i++) {
            if (a + i < row && field[a + i][b] == turn) {
                c0++;
            } else {
                break;
            }
        }
        for (int i = 0; i < numsInRow; i++) {
            if (a - i >= 0 && field[a - i][b] == turn) {
                c1++;
            } else {
                break;
            }
        }
        return c0 + c1 - 1 >= numsInRow;
    }
    private boolean checkDraw() {
        int count = 0;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                if (field[r][c] == Cell.E) {
                    count++;
                }
            }
        }
        if (count == 0) {
            return true;
        }
        return false;
    }

    public boolean isValid(final Move move) {
        return 0 <= move.getRow() && move.getRow() < row
                && 0 <= move.getCol() && move.getCol() < column
                && field[move.getRow()][move.getCol()] == Cell.E
                && turn == move.getValue();
    }

    @Override
    public Cell getCell(int row, int column) {
        return field[row][column];
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("   ");
        for (int c = 0; c < column; c++) {
            if (c < 9) {
                sb.append(c + 1).append("  ");
            } else {
                sb.append(c + 1).append(" ");
            }
        }
        sb.append(System.lineSeparator());
        for (int r = 0; r < row; r++) {
            if (r < 9) {
                sb.append(r + 1).append("  ");
            } else {
                sb.append(r + 1).append(" ");
            }
            for (int i = 0; i < column; i++){
                sb.append(CELL_TO_STRING.get(field[r][i])).append("  ");
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}