package project2;

import java.util.ArrayList;

public class Deck extends GroupOfCards{ 
	
	final static int TOTALCARDS = 52;

	public Deck(){
		super(TOTALCARDS);//REMEMBER
		for(int i = 2; i <= 14; i++){
			for(int j = 0; j <= 3; j++){
				addCard(new Card(i,j));
				}
		}
	}
	
	public static void main(String args[]){
		
		Deck deck = new Deck();
		deck.shuffle();
		deck.display();
	}
	
	public void shuffle(){
		for(int i = getCurrentSize() - 1;i >= 0;i--){
	    	//use Math.random to pick an index in the unshuffled range
	    		//remove the card at that index
	    		//and then add it to the high end of the array.
			int index = (int) (Math.random()*i +1);
			super.addCard(removeCard(index));
		}
	     }
		

	public Card dealCard(){
		Card dealt = getCard(0);
	    removeCard(0);
		return dealt;
	}
	
     
}
