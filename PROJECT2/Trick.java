package project2;

public class Trick extends GroupOfCards{
	 private int winner;
	 private Card winningCard;
	 private  boolean hearts = false;
	 private  boolean queen = false; 
       
	public Trick(int players) {
		super(2*players - 1);
		winningCard = null;

	}
	
	public int getWinner(){
    	   return winner;
       }
       
	public Card getWinningCard(){
    	   return winningCard;
       }
       
	public boolean getHearts(){
    	   return hearts;
       }
	public boolean getQueen(){
    	   return queen;
       }
	public void update(int playerNum, Card card){
		// remember to add 
    	   addCard(card);
    	   if(isWinner(card)){
    		   winner = playerNum;
    		   winningCard = card;
    	   }
    	   if(card.getSuit() == 2){
    		   hearts = true;
    	   }
    	   if(card.getSuit() == 3 && card.getNum() == 12){
    		   queen = true;
    	   }
       }
      //false means less; vice versa.we can say "winner" is a bad situation
	public boolean isWinner(Card card){
    	//should return true unless the previous winning card is not null
    	 if( winningCard == null){
    		 return true;
    	 }  
    	  //and the current card is not in the suit being played 
    	 if( card.getSuit() != winningCard.getSuit()){
    		 return false;
    	 }
    	  //or its number is less than the winning card¡¯s Number
    	 if( card.getNum() < winningCard.getNum()){
    		 return false;
    	 }
    	  return true;
      }
}
