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
    public Dealer(){
           }
    public void draw(){
       dealer.add(Deck.removeCard(1));
        
    }
    public void showCards(){
        
    }
}
