import java.util.Scanner;
import java.util.Random;

public class TicTacToe {

    static char[][] board = {
        {'-', '-', '-'},
        {'-', '-', '-'},
        {'-', '-', '-'}
    };

    static boolean isHumanTurn = true;
    static boolean gameOver = false;

    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();

    static boolean isValidMove(int row, int col) {
        return (row >= 0 && row < 3 &&
                col >= 0 && col < 3 &&
                board[row][col] == '-');
    }

    static void humanMove() {
        System.out.print("Enter row and col (0-2): ");
        int row = sc.nextInt();
        int col = sc.nextInt();

        if (isValidMove(row, col)) {
            board[row][col] = 'X';
        } else {
            System.out.println("Invalid move");
        }
    }

    static void computerMove() {
        while (true) {
            int slot = rand.nextInt(9) + 1;
            int row = (slot - 1) / 3;
            int col = (slot - 1) % 3;

            if (isValidMove(row, col)) {
                board[row][col] = 'O';
                break;
            }
        }
    }

    static boolean checkWin(char ch) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == ch && board[i][1] == ch && board[i][2] == ch)
                return true;
            if (board[0][i] == ch && board[1][i] == ch && board[2][i] == ch)
                return true;
        }

        if (board[0][0] == ch && board[1][1] == ch && board[2][2] == ch)
            return true;
        if (board[0][2] == ch && board[1][1] == ch && board[2][0] == ch)
            return true;

        return false;
    }

    static boolean isDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-')
                    return false;
            }
        }
        return true;
    }

    static void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        while (!gameOver) {

            printBoard();

            if (isHumanTurn) {
                humanMove();

                if (checkWin('X')) {
                    printBoard();
                    System.out.println("Human wins");
                    gameOver = true;
                }

            } else {
                computerMove();

                if (checkWin('O')) {
                    printBoard();
                    System.out.println("Computer wins");
                    gameOver = true;
                }
            }

            if (!gameOver && isDraw()) {
                printBoard();
                System.out.println("Draw");
                gameOver = true;
            }

            isHumanTurn = !isHumanTurn;
        }
    }
}