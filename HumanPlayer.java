package game;

import java.util.Scanner;
import java.util.InputMismatchException;

public class HumanPlayer implements Player {
    private final Scanner in;

    public HumanPlayer(Scanner in) {
        this.in = in;
    }

    @Override
    public Move makeMove(Position position, Cell cell) {
        System.out.println();
        System.out.println("Current position");
        System.out.println(position);
        System.out.println("Enter you move for " + position.getTurn());
        Move move = new Move(in.nextInt() - 1, in.nextInt() - 1, position.getTurn());
        while(true){
            if(position.isValid(move)) {
                return move;
            } else {
                System.out.println("Your move isn't valid, Try again:  ");
                move = new Move(in.nextInt() - 1, in.nextInt() - 1, position.getTurn());
            }
        }
    }
}
