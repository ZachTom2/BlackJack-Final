/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author 2005988
 */
// Constructor for the card class
public class Card {
    public String type;
	public String suit;
	public int value;
	public int[] ace = new int[2]; 
	public Card(String t, String s, int val){
		type = t;
		suit = s;
		value = val;
	}
    @Override
    //Prints out the current card
	public String toString() {
		return "the person has " + type + " of " + suit + " which has a point value of" + value;
	}
}
