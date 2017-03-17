/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;
import java.util.ArrayList;
/**
 *
 * @author 2005988
 */


public class Dealer {
    ArrayList<Card> dealer = new ArrayList();
    private int numberOfPoints=0;
    public boolean hitOnSoft;
    public Dealer(boolean type){
    hitOnSoft = type;       
    }
    public void initialDraw(){
        Card card1 = Deck.removeCard(0);
        Card card2 = Deck.removeCard(0);
        dealer.add(card1);
        dealer.add(card2);
        
        System.out.println("The first card the dealer has is" + dealer.get(0));
    }
    public void showCards(){
        System.out.println("The dealer now has" + dealer.get(0) + "\n" + "and " + dealer.get(1));
    }
    
}
