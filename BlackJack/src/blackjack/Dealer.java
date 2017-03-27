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

//Initializes the dealer
public class Dealer {
    ArrayList<Card> dealer = new ArrayList();
    public int numberOfPoints=0;
    public boolean hitOnSoft;
    public boolean bust = false;
    public Dealer(boolean type){
    hitOnSoft = type;       
    
    }
    //Shows the initial hand
    public void showCards(){
        System.out.print("The dealer now has");
        System.out.println(dealer.get(0));
        System.out.print("and ");
        System.out.println(dealer.get(1));
    }
    //Adds a card to the dealer's hand;
    public void add(Card temp){
        dealer.add(temp);
    }
    //Prints out the specific card;
    public void show(Card temp){
        System.out.println(temp);
        
    }
     public int calculateValues(){
      for(int i = 0; i< dealer.size(); i++){
          numberOfPoints += dealer.get(i).value;
      }
      return numberOfPoints;
  }
}
