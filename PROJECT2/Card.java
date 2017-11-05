package project2;

public class Card {
	/**
	 * @param num
	 * @param suit
	 */
	public Card(int num, int suit) {
		this.num = num;
		this.suit = suit;
	}

    private int num;
    private int suit;
	String word;
	
	public int getNum(){
		return num;
	}
	public int getSuit(){
		return suit;
	}
	private String replace(int input){
		switch(input){
		case 0:
			word = "clubs"; 
			break;
		case 1:
			word = "diamonds";
			break;
		case 2:
			word = "hearts"; 
			break;
		case 3:
			word = "spades";
			break;
		case 11:
			word = "Jack";
			break;
		case 12:
			word = "Queen";
			break;
		case 13:
			word = "King";
			break;
		case 14:
			word = "Ace";
			break;
		}
		return word;
	}
	
	public boolean equals(Card other){
        return this.num == other.num ? (this.suit==other.suit ? true : false) : false;
    }
	
	
    public void display(){
		if(num == 11 || num == 12|| num == 13 || num == 14){
		System.out.print(replace(num)+" of "+ replace(suit));
	    }else{
	    System.out.print(num+" of "+ replace(suit));	
	    }
    }
		}
