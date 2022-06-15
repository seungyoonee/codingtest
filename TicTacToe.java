import java.util.*;

public class TicTacToe {
    static String[] board;
    static String turn;

    static String checkWinner() {
        // check 8 ways of winning
        // 0 1 2
        // 3 4 5
        // 6 7 8
        for (int i = 0; i < 8; i++) {
            String line = null;

            switch (i) {
                case 0:
                line = board[0] + board[1] + board [2];
                break;
                case 1:
                line = board[3] + board[4] + board [5];
                break;
                case 2:
                line = board[6] + board[7] + board [8];
                break;
                case 3:
                line = board[0] + board[3] + board [6];
                break;
                case 4:
                line = board[1] + board[4] + board [7];
                break;
                case 5:
                line = board[2] + board[5] + board [8];
                break;
                case 6:
                line = board[0] + board[4] + board [8];
                break;
                case 7:
                line = board[2] + board[4] + board [6];
                break;
            }

            if (line.equals("OOO")) {
                return "O";
            }
            else if (line.equals("XXX")) {
                return "X";
            }
        }

        for (int i = 0; i < 9; i++) {
            if (i == 8) {
                return "draw";
            }
            else if (Arrays.asList(board).contains(String.valueOf(i))) {
                break;
            }
        }
        return null;
    }

    static void printBoard() {
        System.out.println(board[0] + " " + board[1] + " " + board[2]);
        System.out.println(board[3] + " " + board[4] + " " + board[5]);
        System.out.println(board[6] + " " + board[7] + " " + board[8]);
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        board = new String[9];
        turn = "O";
        String winner = null;

        for (int i = 0; i < 9; i++) {
            board[i] = String.valueOf(i);
        }

        printBoard();

        while (winner == null) {
            int input;
            
            try {
                input = scanner.nextInt();
                if (!(input >= 0 && input <= 8)) {
                    System.out.println("wrong number");
                    continue;
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("wrong number");
                continue;
            }

            
            if (board[input].equals(String.valueOf(input))) {
                board[input] = turn;
                if (turn.equals("O")) {
                    turn = "X";
                }
                else {
                    turn = "O";
                }
            }
            
            printBoard();
            winner = checkWinner();
        }
        
        System.out.println("who won?" + winner);
    }
}
