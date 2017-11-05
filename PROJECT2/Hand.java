package com.company;

import java.util.ArrayList;

//hand:different players trick:every playing circle
public class Hand extends GroupOfCards{
private	int maximumNumber;
private	int shortest;
private	final int NUM;
	public Hand(int playerNum, int numberOfcardss){
		super(numberOfcardss);//remember
		this.NUM = playerNum;
	}
	
	public void sort(){//remember
		
		for(int unsorted = getCurrentSize() ;unsorted > 0; unsorted--){
			int max = Integer.MIN_VALUE;
			int index = 0;
			for(int j = 0; j < unsorted; j++){
				int sum = getCard(j).getNum() +  getCard(j).getSuit() * 13;
				if(max < sum){
					index = j;
					max = sum;
				}
			}
			addCard(removeCard(index));
		}
	}
	public void setShortest(){
    	int numberOfClubs = 0;
    	int numberOfDiamonds = 0;
    	int numberOfSpades = 0;
    	shortest = 0;
    	
		for(int i = 0; i < getCurrentSize(); i++){
		
			if(getCard(i).getSuit() == 0){
			 numberOfClubs++;
			}
			if(getCard(i).getSuit() == 1){
				numberOfDiamonds++;
			}
			if(getCard(i).getSuit() == 3){
				 numberOfSpades++;
				
			}
			
	}
//		System.out.println(numberOfSpades);
//		
//		System.out.println(numberOfDiamonds);
//		System.out.println(numberOfClubs);
		if(numberOfDiamonds < numberOfClubs && numberOfDiamonds != 0 ){
			shortest = 1;
		}
		
		if(numberOfSpades < numberOfClubs && numberOfSpades < numberOfDiamonds && numberOfSpades!= 0 && !find()){
			shortest = 3;
		}
		//if there is no club in the hand, set the shortest in Diamonds or Spades;
		if(numberOfClubs == 0 && shortest == 0){
			shortest = numberOfDiamonds < numberOfSpades? 1:3;
		}
	}
    
	public boolean find(){
    	for(int i = 0; i < getCurrentSize(); i++){
    		if(getCard(i).getNum() == 12|| getCard(i).getNum() ==13|| getCard(i).getNum() ==14 ){
				return false;
    	}
    		}
    	return true;
    }
    
	public int getShortest(){
    	
		return shortest;
		
	}
	public Card playAcards(Game game,Trick trick){
    	int index;
    	//System.out.println("?????"+trick.getgetCurrentSize()());
    	//If the current size of the trick is zero (you are the first hand), 
    	if(trick.getCurrentSize() == 0){
    		//let a local integer called index equal the highest cards in your shortest suit
    		if(!game.GetQueenOfSpades() && !game.getHearts()){
    			
    	  //shortest != 0 a.only heart? b.
    			//System.out.println(getShortest());
    			index = findLowest(getShortest());
    			//System.out.println("0000"+"findLowest(getShortest())"+index);
    		    if(index == -1) 
    			//System.out.println("1111" );
    		        index =findLowest(game,2);
                if(index == -1)  
                    index = findLowest(game);
    			// i am the last one 
    			//a.there is bad cards b.there is not bad cards
        		//b.there is not bad cards
    		}
    		else{
				index =findLowest(game); //FIXME heart is broken, 
    		}
       }else if ((trick.getCurrentSize() == game.PLAYERS - 1)
    				  && !trick.getHearts() && !trick.getQueen()
    				  && (index = findLastHigh(trick.getWinningCard().getSuit())) >= 0);
       else if((index = findLastHigh(trick.getWinningCard().getSuit()))>=0);
        
       
       else if((index = findMiddleHigh(game,trick.getWinningCard().getSuit()))>=0);
       
      
       else if((index = find(12,3))>=0);
       else if((index = find(14,3))>=0);
       else if((index = find(13,3))>=0);
       else if((index = findHighest(2))>=0); //FIXME
       else {
    	   //System.out.println("55555" );
           index = findHighest();
       }
    	 // System.out.println("333");
    	//System.out.println("play a cards" + index);
		return getCard(index);
 }
	public int findLowest(int suit){
		//System.out.println("11111");
    	Card lowest = new Card(Integer.MAX_VALUE,suit);
    	int index = -1;
    	//to record how many heart are in the cards
    	int invalid = 0;
    	for(int i = 0; i < getCurrentSize(); i++){
			if(getCard(i).getSuit() == suit && lowest.getNum() > getCard(i).getNum()){
				lowest = getCard(i);
				index = i;
				}else{
				invalid++;	
				}
    	}
    	if(invalid != getCurrentSize()){
    		return index;	
    	}else{
    		return -1;
    		}
	 }
	public int findCount(int suit){
    	int count = 0;
    	for(int i = 0; i <= getCurrentSize(); i++){
    		if(getCard(i).getSuit() == suit){
    			count++; 
    		}
    		return count;
    	}
		return -1;
    }
	public int find(int num, int suit){
    	//System.out.println("MMMMMM" );
    	for(int i = 0; i < getCurrentSize(); i++){
    		if(getCard(i).getNum() == num || getCard(i).getSuit() == suit){
				return i;
    	}
    	}
    	return -1;
    }
	public int findHighest(int suit){ 
    	//System.out.println("8888" );
    	Card highest = new Card(Integer.MIN_VALUE,suit);
    	int index = -1;
//    	int invalid = 0;
    	for(int i = 0; i < getCurrentSize(); i++){
			if(getCard(i).getSuit() == suit && highest.getNum() < getCard(i).getNum()){
				highest = getCard(i);
				index = i;
            }

    	}

    		return index;
 //   		}
	 }

			
		

	public int findLowest(Game game){

	   Card lowest = new Card(Integer.MAX_VALUE,-1);
	   int index = -1;
	    for(int i=0;i<getCurrentSize();i++){
	        if(getCard(i).getNum()<lowest.getNum()){
	            index = i;
	            lowest = getCard(i);
            }
        }
        return index;
   }
    public int findLowest(Game game,int suit){

        Card lowest = new Card(Integer.MAX_VALUE,-1);
        int index = -1;
        for(int i=0;i<getCurrentSize();i++){
            if(getCard(i).getSuit()!=suit&&getCard(i).getNum()<lowest.getNum()){
                index = i;
                lowest = getCard(i);
            }
        }
        return index;
    }
	
	   
  
   
	   

	//return the highest cards 
	//in the suit led when there are no bad cardss in the trick.
	public int findLastHigh(int suit){
	  // System.out.println("6666" );
        Card highest = new Card(Integer.MIN_VALUE,suit);
	   Card inValidHigh = new Card(Integer.MIN_VALUE,3);
   	int index = -1;
   	int indexInvalid = -1;
   	int invalid = 0;
   	for(int i = 0; i < getCurrentSize(); i++){
			if(getCard(i).getSuit() == suit && highest.getNum() < getCard(i).getNum()){
				if(suit == 3 ){
					if(getCard(i).getNum() == 12){
					inValidHigh = getCard(i);
					indexInvalid = i;
					}else{
						highest = getCard(i);
						index = i;
					}
				}
				highest = getCard(i);
				index = i;
				}
   	}
   	if(inValidHigh != new Card(Integer.MIN_VALUE,3) || highest != new Card(Integer.MIN_VALUE,3)){
   		return index;	
   	}
   	if(inValidHigh != new Card(Integer.MIN_VALUE,3) || highest == new Card(Integer.MIN_VALUE,3)){
   		return indexInvalid;	
   	}
   		return index;
   		}
	 

	   
	public int findHightestBelow(Card winnercards ){
	   int res = -1;

	   for(int i = 0; i <= getCurrentSize(); i++){
		   if(getCard(i).getSuit() == winnercards.getSuit() && getCard(i).getNum() < winnercards.getNum()){
			   res = i;
			   return res;
		   }
		  
	   }
	return res;
	   	
   }
   
	public int findMiddleHigh(Game game, int suit){
	   //System.out.println("7777" );
	   Card highest = new Card(Integer.MIN_VALUE,suit);
	   Card inValidHigh = new Card(Integer.MIN_VALUE,3);
   	int index = -1;
   	int invalid = 0;
   	for(int i = 0; i < getCurrentSize(); i++){
			if(getCard(i).getSuit() == suit && highest.getNum() < getCard(i).getNum()){
				if(suit == 3 || !game.GetQueenOfSpades() ){
					if(getCard(i).getNum() == 12){
					inValidHigh = getCard(i);
					}else{
						highest = getCard(i);
					}
				}
				highest = getCard(i);
				index = i;
				}
   	}
   	if(inValidHigh != new Card(Integer.MIN_VALUE,3) || highest != new Card(Integer.MIN_VALUE,3)){
   		return highest.getNum();	
   	}
   	if(inValidHigh != new Card(Integer.MIN_VALUE,3) || highest == new Card(Integer.MIN_VALUE,3)){
   		return inValidHigh.getNum();	
   	}
   		return highest.getNum();
   	}
	   
  
	public int findHighest(){
	   Card highest = new Card(Integer.MIN_VALUE,-1);
	   int index = -1;
   	for(int i = 0; i < getCurrentSize(); i++){
   		//System.out.println("find highest"+highest.getNum() +"  "+ cards[i].getNum());
			if(highest.getNum() < getCard(i).getNum()){
				highest = getCard(i);
				index = i;
   	}
   		}
	return index;
	 }
   }


