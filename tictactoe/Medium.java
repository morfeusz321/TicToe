package tictactoe;

import java.util.Random;

public class Medium extends Computer {
    protected char[][] temp;

    public Medium() {
        super();
        oppSign = checkOpponentSign();
    }

    @Override
    public void askForMove(Board board) {
        temp = deepCopy(board.board);
        System.out.println("Making move level " + '"' + "medium" + '"');
        if (makeWinningMove(board)) {
            board.setBoard(deepCopy(temp));
            board.printBoard();
        } else if (blockWinningMove(board)) {
            board.setBoard(deepCopy(temp));
            board.printBoard();
        } else {
            randomMove(board);
        }
    }

    public void randomMove(Board board) {
        Random random = new Random();
        int x = random.nextInt(3);
        int y = random.nextInt(3);
        if (board.isFree(x, y)) {
            board.makeMove(x, y, sign);
        } else {
            this.randomMove(board);
        }
    }

    public boolean makeWinningMove(Board board) {
        for (int i = 0; i < 3; i++) {
            for (int o = 0; o < 3; o++) {
                if (board.isFree(i, o)) {
                    board.testMove(i, o, sign);
                    if (board.calculateForWin()) {
                        temp[i][o] = sign;
                        return true;
                    }
                    board.setBoard(deepCopy(temp));
                }
            }
        }
        return false;
    }

    public char checkOpponentSign() {
        return sign == 'X' ? 'O' : 'X';
    }

    public boolean blockWinningMove(Board board) {
        checkOpponentSign();
        for (int i = 0; i < 3; i++) {
            for (int o = 0; o < 3; o++) {
                if (board.isFree(i, o)) {
                    board.testMove(i, o, oppSign);
                    if (board.calculateForWin()) {
                        temp[i][o] = sign;
                        return true;
                    }
                    board.setBoard(deepCopy(temp));
                }
            }
        }
        return false;
    }

    public char[][] deepCopy(char[][] some) {
        char[][] temp = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int o = 0; o < 3; o++) {
                temp[i][o] = some[i][o];
            }
        }
        return temp;
    }
}
