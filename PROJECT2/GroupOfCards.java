package project2;

import java.util.ArrayList;

public class GroupOfCards {
	//understand the currentSize, it is the length not the index
	 private int currentSize;
	 private Card[] cards;
	
	public GroupOfCards(int number) {
		this.cards = new Card[number];
	}
	public Card removeCard(Card card1) {
		for(int i = 0; i < cards.length ; i++){
			if(cards[i].equals(card1)){
				for(int j = i; j < cards.length - 1 ; j++){
				    cards[j] = cards[j + 1];
				}
			break;// for speed
			}
		}
		 cards[currentSize - 1] = null;//delete the last one in the array
		 currentSize -= 1;
		return card1;
	}
	
   public int getCurrentSize(){
		return currentSize;
    	}
      
   public Card getCard(int i){
		return cards[i];
    	}
       
   public void addCard(Card card1){
    	   cards[currentSize] = card1;
    	   currentSize++;
       }
       
   public Card removeCard(int index){
    	  Card res = cards[index];
    	  for(int i = index; i < currentSize - 1; i++){
    	  cards[i] = cards[i + 1];
    	  }
    	  cards[currentSize - 1] = null;
    	  currentSize = currentSize - 1;
    	  
		return res;
       }
      
   public void display(){
    	  for(int i = 0; i < currentSize; i++){
        	 cards[i].display(); 
        	 System.out.println();
        	  }
      }
}
