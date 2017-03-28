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
public class Player {
    //instance variables
    public double money;
    public String nm;
    public double bet;
    public int cardValues;
     ArrayList<Card> playerHand = new ArrayList();
     public boolean busted=false;
   
     public Player(double initialMoney, String name){
        money = initialMoney;
        nm = name;  
    }
     //A toString method to return the name and the amount of money the player has
   public String toString(){
       return nm + " has " + money +" Dollars";
   }
   public double getMoney(){
       return money;
   }
   //Adds a card to the player's hand
   public void addCard(Card temp){
        playerHand.add(temp);
    }
   //Shows the initial cards
   public void initialDraw(){
       System.out.println(nm + " has showing " + playerHand.get(0) + " and "+ playerHand.get(1));
   }
   //Calculates the total value of the cards in the hand
  public int calculateValues(){
      cardValues = 0;
      for(int i = 0; i< playerHand.size(); i++){
          cardValues += playerHand.get(i).value;
      }
      return cardValues;
  }
           
}
