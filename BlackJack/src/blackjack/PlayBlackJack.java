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
 int secondThing;
  public boolean stop = false;

  
  //Initializes the game
  public PlayBlackJack(int decks){
    numDecks = decks;
    temp = new Deck(numDecks);
         deal = new Dealer(false);
         System.out.println("How many players are there?");
         numPlayers = scan.nextInt();
             addPlayers(numPlayers);             
             
    
    
}
 
//This makes the players and adds them to the table.
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
    //This adds two cards to the dealer's hand
    public void dealerDraw(){
        Card deal1;
        deal1 = temp.removeCard(0);
        Card deal2 = temp.removeCard(0);
        deal.add(deal1);
        deal.add(deal2);
        System.out.print("The dealer has showing ");
        deal.show(deal1);
        
        
        
    }
    //This adds two cards to the player's hand
      public void playerDraw(int i){
        Card play1;
        play1 = temp.removeCard(0);
        Card play2 = temp.removeCard(0);
        positionsAtTable.get(i).addCard(play1);
        positionsAtTable.get(i).addCard(play2);
           positionsAtTable.get(i).initialDraw();
        positionsAtTable.get(i).calculateValues();
        if(positionsAtTable.get(i).cardValues == 21 ){
            blackJack(i);
        }
        
        
        
    }
      //This is what the game runs to play blackjack
    public void playBlackJack(){
       
 
        while(positionsAtTable.size() > 0){
            
         for(int i = positionsAtTable.size()-1; i >= 0; i --){
             printFirstPlayerMenu();
           int choice = scan.nextInt();
             playerFirstChoice(choice,i);
             
                     
         }
         for(int i = positionsAtTable.size()-1; i >= 0; i --){
            playerDraw(i);
            positionsAtTable.get(i).initialDraw();
        }
                    dealerDraw();
        
                    for(int i = positionsAtTable.size()-1; i >= 0; i --) {
                    stop= false;
                        while(stop == false){
                          printPlayerMenu();
                           positionsAtTable.get(i).initialDraw();
                          int choice  = scan.nextInt();
                          playerChoice(choice, i); 
                        }
                    }
                    dealerPlay();
                    determineOutcomes();
        
        
        
        
        }
    
    }
    //This takes the answer of
    public void playerFirstChoice(int choice, int loc){
        switch(choice)
            {
            case 0:
                System.out.println("Bye!");
                stop = true;
                positionsAtTable.remove(loc);
                break;
            case 1:
               System.out.println("How much would you like to bet?");
               positionsAtTable.get(loc).bet = scan.nextDouble();
               positionsAtTable.get(loc).money = positionsAtTable.get(loc).money - positionsAtTable.get(loc).bet;
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
    //This takes the answer of the player and actually modifies the player
    public void playerChoice(int choice, int loc){
        switch(choice)
            {
            case 0:
             System.out.println( positionsAtTable.get(loc) + " has stood");
                stop = true;
                 break;
            case 1:
                 System.out.println(" The player has hit");
                        Card cardDrawn;
                        cardDrawn = temp.removeCard(0);
                        positionsAtTable.get(loc).addCard(cardDrawn);
                    int val =     positionsAtTable.get(loc).calculateValues();
                    if(val > 21){
                        bust(loc);
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
    //This is the repeating question that a player is given
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
    //This prints out the initial choice a player is given
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
        //Modifies the player's money and prints that the player has won and how much money the player has 
        public void winBet(int loc){
            positionsAtTable.get(loc).money += 2*positionsAtTable.get(whichPlayer).bet;
            System.out.println(positionsAtTable.get(whichPlayer).nm + " has won ," + positionsAtTable.get(whichPlayer).nm + "now has " + positionsAtTable.get(whichPlayer).money + " dollars.");
        }
        //Prints out that you lost and removes the cards from the player's hand
        public void loseBet(int loc){
            System.out.println(positionsAtTable.get(loc).nm + " has lost");
            System.out.println(positionsAtTable.get(loc).nm + " now has" + positionsAtTable.get(loc).money +" dollars");
             int j = 0;
           while( j < positionsAtTable.get(loc).playerHand.size()){
                positionsAtTable.get(loc).playerHand.remove(j);
                j--;
           }
              
            }
        
        //prints out a special message if the player busted
        public void bust(int loc){
          
            
            System.out.println(positionsAtTable.get(loc).nm + " has busted");
            System.out.println(positionsAtTable.get(loc).nm + " now has" + positionsAtTable.get(loc).money +" dollars");
           int j = 0;
           while( j < positionsAtTable.get(loc).playerHand.size()){
                positionsAtTable.get(loc).playerHand.remove(j);
                j--;
            }
         
               
            }
        //prints out the message for blackjack
            public void blackJack(int loc){
                System.out.println(positionsAtTable.get(loc).nm + "Has gotten blackjack");
                
                
            }
         }






        

        
        
