package tictactoe;


import java.util.ArrayList;
import java.util.List;

public class Board {
    char[][] board;

    public Board() {
        board = putValuesInArray();
    }


    public static char[][] putValuesInArray() {
        char[][] plansza = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int o = 0; o < 3; o++) {
                plansza[i][o] = ' ';
            }
        }
        return plansza;
    }

    public void printBoard() {
        System.out.println("---------\n" +
                "| " + board[0][0] + " " + board[0][1] + " " + board[0][2] + " |\n" +
                "| " + board[1][0] + " " + board[1][1] + " " + board[1][2] + " |\n" +
                "| " + board[2][0] + " " + board[2][1] + " " + board[2][2] + " |\n" +
                "---------");
    }


    public void makeMove(int x, int y, char sign) {
        board[x][y] = sign;
        this.printBoard();
    }


    public boolean isFree(int x, int y) {
        return !(board[x][y] == 'X' || board[x][y] == 'O');
    }

    public boolean checkForWin() {
        if (this.checkDiagonals()) {
            System.out.println(board[1][1] + " wins");
            return true;
        } else {
            for (int i = 0; i < 3; i++) {
                if ((board[i][0] == board[i][1]) && (board[i][0] == board[i][2]) && (board[i][1] != ' ')) {
                    System.out.println(board[i][0] + " wins");
                    return true;
                }
                if ((board[0][i] == board[1][i]) && (board[1][i] == board[2][i]) && (board[1][i] != ' ')) {
                    System.out.println(board[0][i] + " wins");
                    return true;
                }
            }
            if (this.checkIfEnd()) {
                System.out.println("Draw");
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean checkDiagonals() {
        if ((board[0][0] == board[1][1]) && (board[1][1] == board[2][2]) && (board[1][1] != ' ')) {
            return true;
        } else return (board[0][2] == board[1][1]) && (board[1][1] == board[2][0] && (board[1][1] != ' '));
    }

    public boolean checkIfEnd() {
        for (int i = 0; i < 3; i++) {
            for (int o = 0; o < 3; o++) {
                if (isFree(i, o)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }

    public boolean calculateForWin() {
        if (this.checkDiagonals()) {
            return true;
        } else {
            for (int i = 0; i < 3; i++) {
                if ((board[i][0] == board[i][1]) && (board[i][0] == board[i][2]) && (board[i][1] != ' ')) {
                    return true;
                }
                if ((board[0][i] == board[1][i]) && (board[1][i] == board[2][i]) && (board[1][i] != ' ')) {
                    return true;
                }
            }
            return this.checkIfEnd();
        }
    }

    public void testMove(int x, int y, char sign) {
        board[x][y] = sign;
    }

    public List<Move> whichMovesCanBeMade(Board board) {
        List<Move> moves = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int o = 0; o < 3; o++) {
                if (board.isFree(i, o)) {
                    moves.add(new Move(i, o));
                }
            }
        }
        return moves;
    }

    public boolean winning(char x) {
        if (this.checkDiagonals()) {
            System.out.println(board[1][1] + " wins");
            return true;
        }
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == board[i][1]) && (board[i][0] == board[i][2]) && (board[i][1] != ' ')&&(board[i][1]==x)) {
                System.out.println(board[i][0] + " wins");
                return true;
            }
            if ((board[0][i] == board[1][i]) && (board[1][i] == board[2][i]) && (board[1][i] != ' ')&&(board[1][i]==x)) {
                System.out.println(board[0][i] + " wins");
                return true;
            }
        }
        return false;

    }


}
