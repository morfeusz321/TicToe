package tictactoe;

import java.util.ArrayList;
import java.util.List;

public class Hard extends Medium{
    public Hard() {
        super();
    }
    @Override
    public void askForMove(Board board) {
        minimax(board);
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
    public List<Move> setMovesCanBeMade(Board board) {
        ArrayList<Move> moves=new ArrayList<>();
        for (int i=0; i < 3;i++){
            for (int o=0; o<3; o++){
                if(board.isFree(i,o)){
                    moves.add(new Move(i,o));
                }
            }
        }
        return moves;
    }
    public Move minimax(Board newBoard){
        List<Move> possibleMoves=setMovesCanBeMade(newBoard);
        if(newBoard.winning(sign)){
            return 10;
        }
        if(newBoard.winning(oppSign)){
            return -10;
        }
        if(possibleMoves.size()==0){
            return 0;
        }
    }
}
