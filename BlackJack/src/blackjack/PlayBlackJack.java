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
  public boolean stop = false;

  
  //Initializes the game
  public PlayBlackJack(int decks){
    numDecks = decks;
    temp = new Deck(numDecks);
         deal = new Dealer(false);
         
    
    
}
 
//This makes the players and adds them to the table.
    public void addPlayers(int n){
        for(int i = 0; i<n; i++){
            System.out.println("What is your name?");
            String temp = scan.next();

            System.out.println("How much money would you like to deposit?");
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
        
        
        
    }
      public void firstThing(){
         for(int i = positionsAtTable.size()-1; i >= 0; i --){
             printFirstPlayerMenu();
           int choice = scan.nextInt();
             playerFirstChoice(choice,i);
             if(stop==true){
                 break;
             }   
      }
      }
      public void addPeople(){
              System.out.println("How many players are there?");
         numPlayers = scan.nextInt();
             addPlayers(numPlayers);  
          
             
             
      }
      public void playersDraw(){
           for(int i = positionsAtTable.size()-1; i >= 0; i --){
            playerDraw(i);
        }
                    dealerDraw();
      }
      
public void mainProcess(){
    for(int i = positionsAtTable.size()-1; i >= 0; i --) {
                    stop= false;
                        while(stop == false  && positionsAtTable.get(i).busted == false){
                          printPlayerMenu();
                          int choice  = scan.nextInt();
                          playerChoice(choice, i); 
                        }
                    }
                        boolean bust = true;
                    for(int j = 0; j<positionsAtTable.size(); j++){
                        if(positionsAtTable.get(j).busted == false){
                            bust = false;
                        }
                        
                    }
                    if(bust = false){
                    dealerPlay();
                    determineOutcomes();
                    }
                    }
      //This is what the game runs to play blackjack
    public void playBlackJack(){
        addPeople();
        while(positionsAtTable.size() > 0){
        firstThing();
        if(stop == false){
        playersDraw();     
        mainProcess();
                  
        }
        
        }
         }
        
        
    
    
    //This is what the dealer does in blackjack
    public void dealerPlay(){
        int choice=0;
        if(deal.hitOnSoft == true){
           choice = 1;
                                   
        }
         dealerChoice(choice);
        
        
        
    }
            
            
            
            //The dealer options, whether hit or stand on soft 17
            public void dealerChoice(int choice){
        switch(choice)
            {
            //stand on soft 17;
            case 0:
               System.out.println("The dealer has flipped over a " +deal.dealer.get(1));
                if(deal.calculateValues()< 17){
                   while(deal.calculateValues() < 17){
                       Card cardDrawn;
                        cardDrawn = temp.removeCard(0);
                        deal.add(cardDrawn);
                        System.out.println(cardDrawn);
                        deal.calculateValues();
                        if(dealCheckAce() == true&&deal.calculateValues()>21){
                            deal.numberOfPoints -= 10;
                        }
                         if(deal.calculateValues() > 21){
                            dealerBust();
                        
                   }
                         else{
                             System.out.println("The dealer has stood");
                         }
                    }

                break;
               }
            case 1:
                 System.out.println("The dealer has " + deal.dealer.get(1));     
                if(deal.calculateValues() <= 17){
                   while(deal.calculateValues() < 17 || (deal.calculateValues() == 17 && (deal.dealer.get(0).value==11 || deal.dealer.get(1).value == 11))){
                       int initialValues = deal.calculateValues();
                       Card cardDrawn;
                        cardDrawn = temp.removeCard(0);
                        deal.add(cardDrawn);
                        System.out.println(cardDrawn);
                        deal.calculateValues();
                        if(dealCheckAce() == true &&deal.calculateValues()>21){
                            deal.numberOfPoints -= 10;
                        }
                        if(deal.calculateValues() > 21){
                            dealerBust();
                        }
                    }
                    }

                    
                    break;
        }
            }
            
    //This takes the answer of the first choice and 
    public void playerFirstChoice(int choice, int loc){
        switch(choice)
            {
            case 0:
                System.out.println("Bye!");
                stop = true;
                System.out.println(positionsAtTable.get(loc));
                positionsAtTable.remove(loc);
                break;  
            case 1:
               System.out.println("How much would you like to bet?");
               positionsAtTable.get(loc).bet = scan.nextDouble();
               positionsAtTable.get(loc).money = positionsAtTable.get(loc).money - positionsAtTable.get(loc).bet;
                 break;

            default:
                System.out.println("Sorry, invalid choice");
            }
    }
    //This takes the answer of the player and actually modifies the player
    public void playerChoice(int choice, int loc){
        switch(choice)
            {
            case 0:
             System.out.println( positionsAtTable.get(loc).nm + " has stood");
                stop = true;
                positionsAtTable.get(loc).busted = false;
                 break;
            case 1:
                 System.out.println(" The player has hit");
                        Card cardDrawn;
                        cardDrawn = temp.removeCard(0);
                        positionsAtTable.get(loc).addCard(cardDrawn);
                        System.out.println(cardDrawn);
                        
                    int val =     positionsAtTable.get(loc).calculateValues();
                    //modifies the hand so the player doesn't bust
                    if(val > 21 && checkAce(loc) == true){
                        positionsAtTable.get(loc).cardValues-= 10;
                    }
                    if(val > 21){
                        bust(loc);
                        stop = true;
                    }
                    break;
            }
    }

    //This is the repeating question that a player is given
    public static void printFirstPlayerMenu()
    {
        System.out.println("\n   Menu   ");
        System.out.println("   ====");
        System.out.println("0: Quit");
        System.out.println("1: Bet");
        System.out.print("\nEnter your choice: ");

}
    //This prints out the initial choice a player is given
        public static void printPlayerMenu()
    {
        System.out.println("\n   Menu   ");
        System.out.println("   ====");
        System.out.println("0: Stand");
        System.out.println("1: Hit ");
        System.out.println("Enter your choice: ");


    
    }
        //Modifies the player's money and prints that the player has won and how much money the player has 
        public void winBet(int loc){
            positionsAtTable.get(loc).money += 2*positionsAtTable.get(loc).bet;
            System.out.println(positionsAtTable.get(loc).nm + " has won ," + positionsAtTable.get(loc).nm + " now has " + positionsAtTable.get(loc).money + " dollars.");
        }
        //Prints out that you lost and removes the cards from the player's hand
        public void loseBet(int loc){
            System.out.println(positionsAtTable.get(loc).nm + " has lost");
            System.out.println(positionsAtTable.get(loc).nm + " now has " + positionsAtTable.get(loc).money +" dollars");
             int j = 0;
           while( j < positionsAtTable.get(loc).playerHand.size()){
                positionsAtTable.get(loc).playerHand.remove(j);
                j++;
           }
              
            }
        
        //prints out a special message if the player busted
        public void bust(int loc){
          
            
            System.out.println(positionsAtTable.get(loc).nm + " has busted");
            System.out.println(positionsAtTable.get(loc).nm + " now has " + positionsAtTable.get(loc).money +" dollars");
           int j = 0;
           positionsAtTable.get(loc).busted = true;
           while( j < positionsAtTable.get(loc).playerHand.size()){
                positionsAtTable.get(loc).playerHand.remove(j);
                j++;
            }
         
               
            }
        //prints out the message for blackjack
            public void blackJack(int loc){
                positionsAtTable.get(loc).money += 3*positionsAtTable.get(loc).bet;
                System.out.println(positionsAtTable.get(loc).nm + " has gotten blackjack and now has " + positionsAtTable.get(loc).money);
                
                
            }
         
            //Checks if there is an ace in the hand
         public boolean checkAce(int loc){
            boolean ace = false;
            for(int i = 0; i< positionsAtTable.get(loc).playerHand.size(); i ++){
               Card temp = positionsAtTable.get(loc).playerHand.get(i);
                if(temp.value == 11);
                ace = true;
            }
            
            
            return ace;

    }
              //Checks if there is an ace in the hand
           public boolean dealCheckAce(){
            boolean ace = false;
            for(int i = 0; i< deal.dealer.size(); i ++){
               Card temp =deal.dealer.get(i);
                if(temp.value == 11);
                ace = true;
            }
            
            
            return ace;

    }
           //Says that the dealer has busted;
           public void dealerBust(){
               System.out.println("The dealer has busted");
               deal.bust = true;
           }
           //Determines the final outcomes
           public void determineOutcomes(){
                if(deal.bust == false){
               for(int i = 0; i < positionsAtTable.size(); i++){
                
                   if(positionsAtTable.get(i).busted==false ){
                      outComes( compareHands(i), i);
                   }
               }
               
               }
                else if(deal.bust == true){
                      
               for(int i = 0; i < positionsAtTable.size(); i++){
                if(positionsAtTable.get(i).busted==false ){
                    winBet(i);
                }
               }
             }
                
           }
            public void outComes(int choice, int loc){
        switch(choice)
            {
            case 0:
                if(positionsAtTable.get(loc).cardValues == 21 && positionsAtTable.get(loc).playerHand.size() == 2){
                    blackJack(loc);
                }
                else{
                winBet(loc);
                }
                break;
            case 1:
                loseBet(loc);
                 break;
            case 2:
                push(loc);
                break;
                
        }
            }
            public int compareHands(int loc){
               int compare;
                if(positionsAtTable.get(loc).cardValues > deal.calculateValues() ){
                   compare = 0;
                }
                else if(positionsAtTable.get(loc).cardValues < deal.calculateValues()){
                    compare = 1;
                }
                else{
                    compare  =2;
                    
                }
                
                return compare;
            }
            public void push(int loc){
                System.out.println("The dealer and " + positionsAtTable.get(loc).nm + "have pushed");
                positionsAtTable.get(loc).money += positionsAtTable.get(loc).bet;
}
}







        

        
        
