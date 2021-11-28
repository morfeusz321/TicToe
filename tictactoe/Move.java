package tictactoe;

public class Move {
    protected int x;
    protected int y;
    protected int score;

    public Move(int x, int y, int score) {
        this.x = x;
        this.y = y;
        this.score = score;
    }
    public Move(int x, int y){
        this.x=x;
        this.y=y;
    }
}
