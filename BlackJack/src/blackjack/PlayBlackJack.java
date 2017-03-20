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
     Deck temp = new Deck(numDecks);
    
    
}
/**
     */
    public void initialization() {
        // TODO code application logic here
        //more stuff      
         Dealer deal = new Dealer(false);
         System.out.println("How many players are there?");
         numPlayers = scan.nextInt();
             addPlayers(numPlayers);             
         }
    public void addPlayers(int n){
        for(int i = 0; i<n; i++){
            System.out.println("What is your name?");
            String temp = scan.nextLine();
            System.out.println("How much money would you like to deposit");
            double t = scan.nextDouble();
            Player play = new Player(t ,temp);
        }
    
    }
    
    
    
}
