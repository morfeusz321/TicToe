package tictactoe;

import java.util.Random;
import java.util.Scanner;

public class Computer extends User{
    public Computer() {
    }

    public void askForMove(Board board) {
        Random random = new Random();
        int x = random.nextInt(3);
        int y = random.nextInt(3);
        if (board.isFree(x, y)) {
            System.out.println("Making move level "+'"'+"easy"+'"');
            board.makeMove(x, y, sign);
        } else {
            this.askForMove(board);
        }
    }

    @Override
    public void setSign(char c) {
        super.setSign(c);
    }
}

