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
    
    public double money;
    public String nm;
    public double bet;
    public int cardValues;
     ArrayList<Card> playerHand = new ArrayList();
    public Player(double initialMoney, String name){
        money = initialMoney;
        nm = name;  
    }
   public String toString(){
       return nm + "has" + money +"Dollars";
   }
   public double getMoney(){
       return money;
   }
   public void addCard(Card temp){
        playerHand.add(temp);
    }
   public void initialDraw(){
       System.out.println(nm + " has showing" + playerHand.get(0) + playerHand.get(1));
   }
  public int calculateValues(){
      for(int i = 0; i< playerHand.size(); i++){
          cardValues += playerHand.get(i).value;
      }
      return cardValues;
  }
           
}
