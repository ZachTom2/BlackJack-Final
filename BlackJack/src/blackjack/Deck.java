/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author 2005988
 */

	
        public class Deck {
        public static ArrayList<Card> deck = new ArrayList <> ();
	final String[] SUITS = {"Hearts", "Diamonds", "Clubs","Spades"};
	final String[] RANKS = {"Two", "Three", "Four","Five","Six","Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};
	final int[] VALUES = {2,3,4,5,6,7,8,9,10,11};
        
        
    public Deck(int numDecks){
		//
                for(int i=0; i<numDecks; i++){
                createDecks();               

              }
        }
    public void createDecks(){
        instantiateNumbers();
        instantiateFaces();
    }
    public void instantiateNumbers(){
        for (int j =0; j< 9; j++){    
            for(int i = 0; i<4; i++){
                Card temp = new Card(RANKS[j],SUITS[i], VALUES[j]);
                deck.add(temp);
            }
        }
    }
    public void instantiateFaces(){
        for (int j =9; j< 12; j++){    
            for(int i = 0; i<4; i++){
                Card temp = new Card(RANKS[j],SUITS[i], VALUES[j]);
                deck.add(temp);
            }
        }
        for(int i=0; i< 4; i++){
            Card temp = new Card(RANKS[13],SUITS[i],11);
        }
    }
    public void shuffleDecks(){
        Collections.shuffle(deck);
    }

    /**
     *
     * @param loc
     * @return
     */
    public static Card removeCard(int loc){
        return deck.remove(loc);
    }
}