package game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            int matches = -1, m = -1, n = -1, k = -1, player1 = -1, player2 = -1;
            int v = -1;
            while(v == -1){
                try{
                    Scanner in = new Scanner(System.in);
                    System.out.println("Enter player1 (1 - HumanPlayer, 2 - RandomPlayer, 3 - SequentialPlayer): ");
                    v = 1;
                    player1 = in.nextInt();
                }catch (InputMismatchException e) {
                    System.out.println("Invalid parameters for the game, try again");
                    v = -1;

                }
            }
            v = -1;
            while(v == -1){
                try{
                    Scanner in = new Scanner(System.in);
                    System.out.println("Enter player2 (1 - HumanPlayer, 2 - RandomPlayer, 3 - SequentialPlayer: ");
                    v = 1;
                    player2 = in.nextInt();
                }catch (InputMismatchException e) {
                    System.out.println("Invalid parameters for the game, try again");
                    v = -1;

                }
            }
            v = -1;
            while(v == -1){
                try{
                    Scanner in = new Scanner(System.in);
                    System.out.println("Enter the number of matches: ");
                    v = 1;
                    matches = in.nextInt();
                }catch (InputMismatchException e) {
                    System.out.println("Invalid parameters for the game, try again");
                    v = -1;

                }
            }
            v = -1;
            while(v == -1){
                try{
                    Scanner in = new Scanner(System.in);
                    System.out.println("Enter the number of rows: ");
                    n = in.nextInt();
                    v = 1;
                }catch (InputMismatchException e) {
                    System.out.println("Invalid parameters for the game, try again");
                    v = -1;

                }
            }
            v = -1;
            while(v == -1){
                try{
                    Scanner in = new Scanner(System.in);
                    System.out.println("Enter the number of columns: ");
                    m = in.nextInt();
                    v = 1;
                }catch (InputMismatchException e) {
                    System.out.println("Invalid parameters for the game, try again");
                    v = -1;

                }
            }
            v = -1;
            while(v == -1){
                try{
                    Scanner in = new Scanner(System.in);
                    System.out.println("Enter the number of X/O in a row to win: ");
                    k = in.nextInt();
                    v = 1;
                }catch (InputMismatchException e) {
                    System.out.println("Invalid parameters for the game, try again");
                    v = 1;

                }
            }
            if (m != -1 & n != -1 & k != -1 & matches != -1) {
                Match.match(m, n, k, matches, player1, player2);
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid parameters for the game");
        }

    }
}
