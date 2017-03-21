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
        System.out.print("The dealer now has");
        System.out.println(dealer.get(0));
        System.out.print("and ");
        System.out.println(dealer.get(1));
    }
    public void add(Card temp){
        dealer.add(temp);
    }
    public void show(Card temp){
        System.out.println(temp);
        
    }
}
