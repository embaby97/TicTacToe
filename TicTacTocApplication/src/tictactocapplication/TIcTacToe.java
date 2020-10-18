/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactocapplication;

/**
 *
 * @author Alaa
 */
public class TIcTacToe {
    
    
    protected char [] board;
    protected char userMarker;
    protected char aiMarker;
    protected char winner;
    protected char currentMarker;

    public TIcTacToe(char playerToken , char aiToken)
    {
        this.userMarker=playerToken;
        this.aiMarker=aiToken;
        this.winner='-';
        this.board= setBoard();
        this.currentMarker = playerToken;
    }

    private static char[] setBoard() {
        char []board = new char[9];
        for (int i =0 ;i < board.length ; i++)
        {
            board[i]='-';
        }
        return board;
    }
    public boolean playTurn(int spot)
    {
        boolean isValid = withinRange(spot) && !isSpotTaken(spot);
        if (isValid)
        {
            board[spot-1] = currentMarker;
            currentMarker= (currentMarker==userMarker) ? aiMarker : userMarker;
        }
        return (isValid);
    }

    private boolean withinRange(int spot) {
     return spot>0 && spot<= board.length;   
    }

    private boolean isSpotTaken(int spot) {
         return board[spot-1] !='-';
    }
    public void printBoard()
    {
        System.out.println();
        for (int i =0 ; i < board.length ; i++)
        {
            if (i % 3 ==0 && i !=0 )
            {
                System.out.println();
                System.out.println("---------------");
            }
            System.out.print(" | "+ board[i]);
        }
        System.out.println();
    }
    
    public void printIndexBoard()
    {
        System.out.println();
        for (int i =0 ; i < board.length ; i++)
        {
            if (i % 3 ==0 && i !=0 )
            {
                System.out.println();
                System.out.println("---------------");
            }
            System.out.print(" | "+ (i+1));
        }
        System.out.println();
    }
    
    
    
    public boolean isThereAWinner(){
    boolean diagonalsAndMiddels = (rightDi() || leftDi() || middleRow() ||secondCol()) && board[4] != '-';
    boolean topAndFirst = (topRow()||firstCol() )&& board[0] != '-';
    boolean bottomAndTherd = (bottomRow() || thirdCol())&& board[8]!='-';
    if (diagonalsAndMiddels)
        {
            this.winner=board[4];
        }
    else if (topAndFirst)
        {
            this.winner=board[0];
        }
    else if (bottomAndTherd)
        {
            this.winner=board[8];
        }
    return diagonalsAndMiddels || topAndFirst || bottomAndTherd;
    }

    private boolean rightDi() {
        return board[0]==board[4]&&board[4]==board[8];    }

    private boolean leftDi() {
        return board[2]==board[4]&&board[4]==board[6];
    }

    private boolean middleRow() {
        return board[3]==board[4]&&board[4]==board[5];
    }

    private boolean topRow() {
        return board[0]==board[1]&&board[1]==board[2];
    }

    private boolean firstCol() {
        return board[0]==board[3]&&board[3]==board[6];   
    }
    private boolean secondCol() {
        return board[1]==board[4]&&board[4]==board[7];   
    }
    private boolean bottomRow() {
        return board[6]==board[7]&&board[7]==board[8];    }

    private boolean thirdCol() {
        return board[2]==board[5]&&board[5]==board[8];
    }
    
    public boolean isTheBoardFilled()
    {
        for (int i =0 ; i < board.length ; i++)
        {
            if (board[i]=='-')
                return false;
        }
        return true;
    }
    
    public String gameOver(){
    boolean didSomeoneWin = isThereAWinner();
    if (didSomeoneWin)
    {
        return "we have a winner ! the winner is "+this.winner+" 's";
    }
    else if (isTheBoardFilled())
        return "Draw: Game Over!";
    else
        return "notOver";
    }
    
    
    
    
}
