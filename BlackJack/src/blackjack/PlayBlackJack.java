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
  Deck temp;
 public ArrayList<Player> positionsAtTable = new ArrayList<>();
 Dealer deal;
 int whichPlayer;
  public boolean stop = false;
public PlayBlackJack(int decks){
    numDecks = decks;
    temp = new Deck(numDecks);
         deal = new Dealer(false);
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
            positionsAtTable.add(play);
        }
    
    }
    public void dealerDraw(){
        Card deal1;
        deal1 = temp.removeCard(0);
        Card deal2 = temp.removeCard(0);
        deal.add(deal1);
        deal.add(deal2);
        System.out.print("The dealer has showing ");
        deal.show(deal1);
        
        
        
    }
    public void playerPlay(){
        whichPlayer = positionsAtTable.size() - 1;
        while(whichPlayer > 0){
            
            
            
            while(stop == false){
            printPlayerMenu();
            int choice = scan.nextInt();
            playerChoice(choice);
        }
            whichPlayer--;
    }
    }
    
    
    public void playerFirstChoice(int choice){
        switch(choice)
            {
            case 0:
                System.out.println("Bye!");
                stop = true;
                positionsAtTable.remove(whichPlayer);
                break;
            case 1:
               System.out.println("How much would you like to bet?");
               positionsAtTable.get(whichPlayer).bet = scan.nextDouble();
               positionsAtTable.get(whichPlayer).money = positionsAtTable.get(whichPlayer).money - positionsAtTable.get(whichPlayer).bet;
                 break;
         //   case 2:
                    
           //     break;
 
            
            
        /*    case 3:
              
                break;
            case 4:
               
                break;
             
            case 5:
                break;
            case 6:
            
                break;
            case 7:
             
            break;
          */   
            default:
                System.out.println("Sorry, invalid choice");
            }
    }
    public void playerChoice(int choice){
        switch(choice)
            {
            case 0:
             System.out.println( positionsAtTable.get(whichPlayer) + " has stood");
                stop = true;
                 break;
            case 1:
                 System.out.println(" The player has hit");
                        
                 if(positionsAtTable.get(whichPlayer).cardValue > 21){
                     
                 }
                    break;
                
        //    case 2:
                   
 
            
            
        /*    case 3:
              
                break;
            case 4:
               
                break;
             
            case 5:
                break;
            case 6:
            
                break;
            case 7:
             
            break;
          */   
            default:
                System.out.println("Sorry, invalid choice");
            }
    }
    public static void printFirstPlayerMenu()
    {
        System.out.println("\n   Menu   ");
        System.out.println("   ====");
        System.out.println("0: Quit");
        System.out.println("1: Bet)");
       // System.out.println("1: Hit");
     /*   System.out.println("3: ");
        System.out.println("4: ");
        System.out.println("5: ");
        System.out.println("6: ");
        System.out.println("7: ");
*/
        System.out.print("\nEnter your choice: ");

}
        public static void printPlayerMenu()
    {
        System.out.println("\n   Menu   ");
        System.out.println("   ====");
       // System.out.println("0: Quit");
        System.out.println("0: Stand)");
        System.out.println("1: Hit");
     /*   System.out.println("3: ");
        System.out.println("4: ");
        System.out.println("5: ");
        System.out.println("6: ");
        System.out.println("7: ");
*/
        System.out.print("\nEnter your choice: ");


    
    }
        public void winBet(){
            positionsAtTable.get(whichPlayer).money += 2*positionsAtTable.get(whichPlayer).bet;
            System.out.println(positionsAtTable.get(whichPlayer).nm + " has won");
        }
        public void loseBet(){
            System.out.println(positionsAtTable.get(whichPlayer).nm + " has lost");
            System.out.println(positionsAtTable.get(whichPlayer).nm + " now has" + positionsAtTable.get(whichPlayer).money +" dollars");
        }
}