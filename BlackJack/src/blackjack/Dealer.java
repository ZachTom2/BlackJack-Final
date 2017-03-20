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
    public void showCards(){
        System.out.println("The dealer now has" + dealer.get(0) + "\n" + "and " + dealer.get(1));
    }
    public void add(Card temp){
        dealer.add(temp);
    }
    
}
