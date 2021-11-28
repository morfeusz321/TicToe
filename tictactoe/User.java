package tictactoe;

public abstract class User {
    char sign;
    protected char oppSign;
    public void askForMove(Board board){}
    public void setSign(char c){
        this.sign=c;
    }

    public void setOppSign(char oppSign) {
        this.oppSign = oppSign;
    }
}
