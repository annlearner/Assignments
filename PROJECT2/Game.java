package com.company;

public class Game {
  
  public Deck deck = new Deck();
  private Hand[]player;
  private Trick[]tricks;
  private int numberOfTricks;
  private boolean hearts = false;
  private boolean queenOfSpades = false;
  final int PLAYERS;
  
  public Game(int numberOfPlayers){
	  PLAYERS =  numberOfPlayers;
	  this.player= new Hand[numberOfPlayers];
	  this.tricks = new Trick[Deck.TOTALCARDS/PLAYERS];
	  for(int i = 0; i <= PLAYERS - 1; i++){
		  player[i] = new Hand(i,Deck.TOTALCARDS/PLAYERS);
	  }
  }
 
  
  
  public int GetNumberOfTricks(){
	return numberOfTricks; 
 }
  public boolean getHearts(){
	return hearts;
	 
 }
  public boolean GetQueenOfSpades(){
	return queenOfSpades;
	 
 }
  public void playAgame(){
	  int cardLeft = Deck.TOTALCARDS % player.length;
	  int beginer = 0;
	  Card[] cardsLeft = new Card[deck.TOTALCARDS % PLAYERS];
	  int cardSender = -1;
	  //judge whether to shuffle again
	  boolean flag = true;      
	  while(flag) {
	             flag = false;
	             deck.shuffle();
	             for (int i = deck.getCurrentSize() - 1; i >= deck.getCurrentSize() - cardsLeft.length; i--) {
	                 
	                 if (deck.getCard(i).equals(new Card(12, 3)) || deck.getCard(i).equals(new Card(2, 0)) ||
	                         deck.getCard(i).getSuit() == 2) flag = true;
	             }
	         }
	  //times for card sending
	  for(int i = 0; i <tricks.length ;i++){
		  for(int j = 0; j <player.length ;j++){
			  if(deck.getCard(0).equals(new Card(2,0))) {
				  beginer = j;
			  }
			  player[j].addCard(deck.removeCard(0));//remember
		  	 
		  }
	  }
	  //put all of the cardsLeft[i] in the Cardheap
	  for (int i = 0; i < cardsLeft.length; i++){
          cardsLeft[i] = deck.dealCard();
      }
	  for(int i = 0; i < player.length ;i++){
		  player[i].sort();
		  player[i].setShortest() ;
        
	      System.out.println("    player  "+ i + "  shortest = " + player[i].getShortest());
	      player[i].display();
	  }
	  for(int i = 0; i <tricks.length ;i++){
		  Trick trick = new Trick(PLAYERS);
		  Card card;
		  if(i == 0){
			  System.out.println();
              System.out.println();
              System.out.println("Output - second part: ");
              System.out.println();
              System.out.println();
              
             card = player[beginer].removeCard(player[beginer].find(2,0));
              player[beginer].setShortest();
              trick.update(beginer, card);
              System.out.print("player "+beginer+"     ");
              card.display();
              System.out.println();
              cardSender = (beginer + 1)%PLAYERS;//remember
              for(int j = 1; j < PLAYERS; j++){
            	 // System.out.print("playACard");
            	  //player[cardSender].playACard(this, trick).display();
            	card = player[cardSender].removeCard( player[cardSender].playAcards(this, trick));//remember
            	 player[cardSender].setShortest();
                 trick.update(cardSender, card);
                 updateHeartsAndQueen(card); 
                 System.out.print("player "+cardSender+"     ");
                 card.display();
                 System.out.println();
                 cardSender = (cardSender + 1)%PLAYERS;//remember   
              }  
                cardSender = trick.getWinner();
               // System.out.println(cardSender);
                for(int k = 0;k<cardsLeft.length;k++){
                    System.out.print("undelt card"+"    ");
                    cardsLeft[k].display();
                    System.out.println();//FIXME
                }
                tricks[numberOfTricks++] = trick;
		  }
		  else{
			  System.out.println();
			  System.out.println();
			  for(int j = 0; j < PLAYERS; j++){
				  
	            	card =  player[cardSender].playAcards(this, trick);//remember
	            	//System.out.println(player[cardSender].currentSize);
	            	player[cardSender].removeCard(card);
	            	 player[cardSender].setShortest();
	                 trick.update(cardSender, card);
				 	 updateHeartsAndQueen(card); 
	                 System.out.print("player "+cardSender+"     ");
	                 card.display();
	                 System.out.println();
	                 cardSender = (cardSender + 1)%PLAYERS;//remember   
	              }  
			  cardSender = trick.getWinner();
			  tricks[numberOfTricks++] = trick;
		  }
	  }
	
      for(int i=0;i<PLAYERS;i++){
          System.out.println("Player "+i+" score = "+computePoints(i));
      }
      System.out.println("Play another game (y/n)? ");
	  
  }
  void updateHeartsAndQueen(Card card){
	  if(card.getSuit() == 2 && !hearts){
		  System.out.println("Hearts is now broken");¢˜
		  hearts = true;
	  }
	  if(card.getSuit() == 3 &&card.getNum()==12){
		  queenOfSpades = true;
	  }
	  
  }
  int computePoints(int playerNum){
	  int points = 0;
	  for(int i = 0; i < tricks.length;i++){
		  //If a particular tricks winner equals this methodï¿½ï¿½s parameter value,
		  //loop through all cards in that trick.
		  if(tricks[i].getWinner() == playerNum){
			  for(int j = 0; j < tricks[i].getCurrentSize();j++){
				  if(tricks[i].getCard(j) == new Card(13,3)){
					  points += 13;
				  }
				  if(tricks[i].getCard(j).getSuit() == 2){
					  points += 1;
				  }
				  
			  }
			  
		  }
	  }
	return points;
	  
  }
}
