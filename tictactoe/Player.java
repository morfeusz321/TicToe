package tictactoe;

import java.util.Scanner;

public class Player extends User{
    public Player() {
    }
    public void askForMove(Board board) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the coordinates: > ");
        try {
            int x = scanner.nextInt() - 1;
            int y = scanner.nextInt() - 1;
            if (x <= 2 && y <= 2) {
                if (board.isFree(x, y)) {
                    board.makeMove(x, y, sign);
                } else {
                    System.out.println("This cell is occupied! Choose another one!");
                    this.askForMove(board);
                }
            } else {
                System.out.println("Coordinates should be from 1 to 3!");
                askForMove(board);
            }
        } catch (Exception exception) {
            System.out.println("You should enter numbers!");
            askForMove(board);
        }
    }

    @Override
    public void setSign(char c) {
        super.setSign(c);
    }
}
