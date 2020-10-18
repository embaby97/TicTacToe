/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactocapplication;

import java.util.Scanner;
/**
 *
 * @author Alaa
 */
public class TicTacTocApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        boolean doYouWantToPlay = true;
        while (doYouWantToPlay)
        {
            System.out.println("welcome\n"
                                +"must pick charecter you want to be and which charcter i will be\n");
            System.out.println("Enter a single charcter thatwill represent you on the board");
            char playerToken = sc.next().charAt(0);
            System.out.println("Enter a single charcter thatwill represent AI on the board");
            char aiToken = sc.next().charAt(0);
            TIcTacToe game = new TIcTacToe(playerToken , aiToken);
            AI ai = new AI();
            System.out.println();
            System.out.println("pick number from board");
            game.printIndexBoard();
            System.out.println();
            while(game.gameOver().equals("notOver"))
            {
                if (game.currentMarker == game.userMarker)
                {
                    System.out.println("Its your turn Enter a spot for your token");
                    int spot= sc.nextInt();
                    while (!game.playTurn(spot)){
                        System.out.println("Try again. " + spot + " is invalid");
                        spot= sc.nextInt();
                    }
                    System.out.println("You picked. " + spot );
                }
                else {
                System.out.println("Its my turn");
                int aiSpot = ai.pickSpot(game);
                game.playTurn(aiSpot);
                System.out.println("I picked. " + aiSpot + "!");
                }
                System.out.println();
                game.printBoard();
            }
            System.out.println(game.gameOver());
            System.out.println("Do you want to play again Enter Y / anything else");
            char response = sc.next().charAt(0);
            if (response=='Y' || response=='y' )
                doYouWantToPlay=true;
            else 
                doYouWantToPlay=false;
            
        }
        
    }
    
}
