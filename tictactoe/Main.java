package tictactoe;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Board board = new Board();
        List<User> users = askForInput(new Scanner(System.in));
        User player1 = users.get(0);
        User player2 = users.get(1);
        player1.setSign('X');
        player2.setSign('O');
        player1.setOppSign('O');
        player2.setOppSign('X');
        board.printBoard();
        while (true) {
            player1.askForMove(board);
            if (board.checkForWin()) {
                break;
            }
            player2.askForMove(board);
            if (board.checkForWin()) {
                break;
            }
        }
    }

    public static List<User> askForInput(Scanner scanner) {
        System.out.print("Input command: > ");
        List<User> users = new ArrayList<>();
        String line = scanner.nextLine();
        Scanner scanner1 = new Scanner(line);
        String temp = scanner1.next();
        try {
            if (temp.equals("start")) {
                String[] name = scanner1.nextLine().split(" ");
                for (int i = 1; i < 3; i++) {
                    if (name[i].equals("user")) {
                        users.add(new Player());
                    } else if (name[i].equals("easy")) {
                        users.add(new Computer());
                    } else if (name[i].equals("medium")) {
                        users.add(new Medium());
                    }else if(name[i].equals("hard")){
                        users.add(new Hard());
                    } else {
                        System.out.println("Bad parameters!");
                        return askForInput(new Scanner(System.in));
                    }
                }
            } else if (temp.equals("exit")) {
                System.exit(1);
            } else {
                System.out.println("Bad parameters!");
                askForInput(new Scanner(System.in));
            }
        } catch (Exception e) {
            System.out.println("Bad parameters!");
            askForInput(new Scanner(System.in));
        }
        return users;
    }
}
