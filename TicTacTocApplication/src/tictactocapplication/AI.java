/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactocapplication;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Alaa
 */
class AI {
    public int pickSpot(TIcTacToe game)
    {
        ArrayList <Integer> choises = new ArrayList();
        for (int i =0 ; i < 9 ; i++)
        {
            if (game.board[i]=='-')
                choises.add(i+1);
        }
        Random rand = new Random();
        int choice = choises.get(Math.abs(rand.nextInt() % choises.size()));
        return choice;
    }
}
