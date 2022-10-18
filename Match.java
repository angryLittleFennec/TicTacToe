package game;

//import game.HumanPlayer;
//import game.RandomPlayer;
//import game.MNKBoard;

import java.util.Scanner;

public class Match {

    public static void match(int m, int n, int k, int winNum, int players1, int players2){
        int numWin1 = 0;
        int numWin2 = 0;
        int result;
        int i = 0;
        Player player1 = null, player2 = null;
        if (players1 == 1) {
            player1 = new HumanPlayer(new Scanner(System.in));
        } else if (players1 == 2) {
            player1 = new RandomPlayer(m, n);
        } else if (players1 == 3) {
            player1 = new SequentialPlayer(m, n, k);
        }


        if (players2 == 1) {
            player2 = new HumanPlayer(new Scanner(System.in));
        } else if (players2 == 2) {
            player2 = new RandomPlayer(m, n);
        } else if (players2 == 3) {
            player2 = new SequentialPlayer(m, n, k);
        }

        while (true) {
            Board MNKBoard= new MNKBoard(m,n,k);
            if (i % 2 == 0) {
                final TwoPlayerGame game = new TwoPlayerGame(MNKBoard, player1, player2);
                result = game.play(true);
                switch (result) {
                    case 1:
                        System.out.println("First player won");
                        numWin1++;
                        break;
                    case 2:
                        System.out.println("Second player won");
                        numWin2++;
                        break;
                    case 0:
                        System.out.println("Draw");
                        break;
                    default:
                        throw new AssertionError("Unknown result " + result);
                }

                System.out.println("Game " + (i + 1) + " result: " + result);
            } else {
                final TwoPlayerGame game = new TwoPlayerGame(MNKBoard, player2, player1);
                result = game.play(true);
                switch (result) {
                    case 1:
                        System.out.println("First player won");
                        numWin2++;
                        break;
                    case 2:
                        System.out.println("Second player won");
                        numWin1++;
                        break;
                    case 0:
                        System.out.println("Draw");
                        break;
                    default:
                        throw new AssertionError("Unknown result " + result);
                }
            }
            if (numWin1 == winNum || numWin2 == winNum){
                if (numWin1 == winNum) {
                    System.out.println("Winner is player 1");
                } else {
                    System.out.println("Winner is player 2");
                }
                break;
            }
            i++;
        }
    }
}