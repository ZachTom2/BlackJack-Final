/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 2005988
 */
public class PlayBlackJack {
Scanner scan = new Scanner(System.in);
public int numDecks;
public int numPlayers;
 public ArrayList<Player> positionsAtTable = new ArrayList<>();
public PlayBlackJack(int decks){
    numDecks = decks;
     Deck deck = new Deck(numDecks);
    
    
}
/**
     */
    public void initialization() {
        // TODO code application logic here
        //more stuff      
         Dealer deal = new Dealer(false);
         System.out.println("How many players are there?");
         numPlayers = scan.nextInt();
             addPlayers();             
         }
    public void addPlayers(numPlayers){
        for(int i = 0; i<numPlayers; i++){
            
        }
    
    }
    
    
    
}
